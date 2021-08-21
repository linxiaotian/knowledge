package week03.netty.utils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class OkHttpUtils {

    public static String getOkHttp(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        String result = null;
        try {
            Response response = call.execute();
            result = Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String result = OkHttpUtils.getOkHttp("http://localhost:8801");
        System.out.println(result);
    }

}
