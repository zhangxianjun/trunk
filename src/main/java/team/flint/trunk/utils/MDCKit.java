package team.flint.trunk.utils;

import org.slf4j.MDC;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zxj
 * @date: 2023/6/24 09:40
 * Description: .
 */

public class MDCKit {
    /**
     * 事件名字
     */
    public static final String X_EVENT_NAME = "X_EVENT_NAME";
    /**
     * 用户ID
     */
    public static final String X_USER_ID = "X_USER_ID";
    /**
     * 事件ID
     */
    public static final String X_EVENT_ID = "X_EVENT_ID";

    /**
     * 保存MDC
     * @param eventName
     * @param userId
     */
    public static void saveMDC(String eventName, Long userId) {
        MDC.put(X_EVENT_NAME, eventName);
        MDC.put(X_USER_ID, String.valueOf(userId));
        MDC.put(X_EVENT_ID, IDKit.buildUUID());
    }

    public static void removeMDC() {
        MDC.remove(X_EVENT_NAME);
        MDC.remove(X_USER_ID);
        MDC.remove(X_EVENT_ID);
    }


    private MDCKit() {

    }
}
