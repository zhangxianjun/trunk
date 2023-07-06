package team.flint.trunk.interfaces;

/**
 * 消息队列
 */

public interface IHttp {

    /**
     * 立即发送消息
     */
    String sendMessage(String topic, String key, String content);

    /**
     * 发送延迟消息
     */
    String sendDelayMessage(String topic, String key, long time, String content);
}
