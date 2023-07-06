package team.flint.trunk.utils;


import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * 网络访问
 */
public class HttpKit {

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * 发送GET 请求
     *
     * @param url 请求URL
     * @return HTTP 响应
     */
    public static String get(String url) {
        Request request = new Request.Builder().url(url).build();
        return request(request);
    }

    /**
     * 发送POST 请求
     *
     * @param url    请求URL
     * @param params 请求参数
     * @return HTTP 响应
     */
    public static String post(String url, Map<String, String> params) {
        FormBody.Builder formBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formBuilder.add(entry.getKey(), entry.getValue());
        }
        RequestBody requestBody = formBuilder.build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        return request(request);
    }

    private static String request(Request request) {
        String body = "";
        try {
            Response response = okHttpClient.newCall(request).execute();
            body = response.body() != null ? response.body().string() : "";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return body;
    }
}
