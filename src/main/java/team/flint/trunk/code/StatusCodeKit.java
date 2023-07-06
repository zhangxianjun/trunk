package team.flint.trunk.code;

/**
 * 构造业务错误码数据
 */

public class StatusCodeKit {

    /**
     * 错误信息
     */
    private static String build(IStatusCode ic, String message) {
        StatusCode body = new StatusCode(ic.getCode(), message);
//        return JSONKit.serialization(body);
        return "";
    }


    /**
     * 国际化错误信息
     * @param ic
     * @param key
     * @return
     */
    public static String buildByI18nKey(IStatusCode ic, String key) {
        // 错误代码
//        String i18n = MessageUtils.message(String.valueOf(key));
        return build(ic, "");
    }

    /**
     *
     * @param key
     * @return
     */
    public static String buildClient(String key) {
        return buildByI18nKey(StatusCodeEnum.CLIENT_ERROR, key);
    }

    public static String buildServer(String key) {
        return buildByI18nKey(StatusCodeEnum.SERVER_ERROR, key);
    }
}
