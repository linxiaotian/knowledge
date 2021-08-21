package week03.netty.router;

import java.util.*;

public class HttpRouterImpl implements HttpRouter {

    private static final Map<String,List<String>> routeMappingMap = new HashMap<>();

    static {
        List<String> businessUrls = new ArrayList<>();
        businessUrls.add("http://localhost:8801");
        businessUrls.add("http://localhost:8802");
        routeMappingMap.put("/server01", businessUrls);
    }

    @Override
    public String randomRoute(String uri) {
        List<String> businessUrls = routeMappingMap.get(uri);
        int randomIndex = new Random().nextInt(businessUrls.size());
        return businessUrls.get(randomIndex);
    }

}
