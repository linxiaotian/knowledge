package week03.netty.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HttpResponseFilterImpl implements HttpResponseFilter {

    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("gateway", "gateway");
    }

}
