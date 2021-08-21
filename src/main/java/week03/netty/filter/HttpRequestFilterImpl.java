package week03.netty.filter;

import io.netty.handler.codec.http.FullHttpRequest;

public class HttpRequestFilterImpl implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest) {
        String uri = fullRequest.uri();
        if (uri.contains("server")) {
            fullRequest.headers().set("Gateway-set", "set");
        }
    }

}
