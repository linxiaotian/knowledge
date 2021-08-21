package week03.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import week02.OkHttpUtils;
import week03.netty.filter.HttpRequestFilter;
import week03.netty.filter.HttpResponseFilter;
import week03.netty.filter.HttpResponseFilterImpl;
import week03.netty.router.HttpRouter;
import week03.netty.router.HttpRouterImpl;

import java.util.concurrent.*;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

@Slf4j
public class HttpOutBoundHandle {

    private HttpResponseFilter responseFilter = new HttpResponseFilterImpl();

    private HttpRouter httpRouter = new HttpRouterImpl();

    private static ExecutorService executorService;

    static {
        int cores = Runtime.getRuntime().availableProcessors();
        executorService = new ThreadPoolExecutor(cores, cores * 2, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
    }


    public void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx, HttpRequestFilter filter) throws ExecutionException {
        filter.filter(fullRequest);
        final String serviceUrl = httpRouter.randomRoute(fullRequest.uri());
        if (ctx.executor().inEventLoop() && serviceUrl.contains("8801")) {
            log.info("inEventLoop executorLoop.....");
//            Future<String> future = ctx.executor().submit(() -> getServiceResult(serviceUrl));
//            String result = null;
//            try {
//                result = future.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            String result = getServiceResult(serviceUrl);
            handleResponse(fullRequest, ctx, result);
        } else {
            log.info("not inEventLoop executorService .....");
            Future<String> future = executorService.submit(() -> getServiceResult(serviceUrl));
            String result = null;
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handleResponse(fullRequest, ctx, result);
        }

    }

    private String getServiceResult(String url) {
        return OkHttpUtils.getOkHttp(url);
    }

    private void handleResponse(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, final String result) {
        FullHttpResponse response = null;
        try {

            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(result.getBytes()));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", result.getBytes().length);
            response.headers().set("Gateway-set", fullRequest.headers().get("Gateway-set"));
            responseFilter.filter(response);

        } catch (Exception e) {
            e.printStackTrace();
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            exceptionCaught(ctx, e);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    //response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(response);
                }
            }
            ctx.flush();
            //ctx.close();
        }

    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
