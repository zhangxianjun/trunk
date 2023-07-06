package team.flint.trunk.test;

import team.flint.trunk.utils.HttpKit;

import java.util.Map;

/**
 * HTTP API 单元测试
 */
public class TestApi {

    /**
     * GET请求
     */
    public static String get(String url) {
        // 设置头部文件

        return HttpKit.get(url);
    }

    /**
     * POST请求
     */
    public static String post(String url, Map<String, String> params) {
        return HttpKit.post(url, params);
    }
}
