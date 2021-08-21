package week03.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.util.concurrent.EventExecutorGroup;
import week03.netty.filter.HttpRequestFilter;
import week03.netty.filter.HttpRequestFilterImpl;
import week03.netty.router.HttpRouter;
import week03.netty.router.HttpRouterImpl;

import java.util.ArrayList;
import java.util.List;

public class HttpInitializer extends ChannelInitializer<SocketChannel> {

    private EventExecutorGroup logicGroup;

    public HttpInitializer(EventExecutorGroup logicGroup) {
        this.logicGroup = logicGroup;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new HttpServerCodec());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        HttpInBoundHandle httpInBoundHandle = new HttpInBoundHandle();
        HttpRequestFilter requestFilter = new HttpRequestFilterImpl();
        httpInBoundHandle.setRequestFilter(requestFilter);
        HttpRouter httpRouter = new HttpRouterImpl();
        httpInBoundHandle.setHttpRouter(httpRouter);
        List<String> businessUrls = new ArrayList<>();
        businessUrls.add("http://localhost:8801");
        businessUrls.add("http://localhost:8801");
        httpInBoundHandle.setBusinessUrls(businessUrls);
        p.addLast(logicGroup, httpInBoundHandle);
    }
}