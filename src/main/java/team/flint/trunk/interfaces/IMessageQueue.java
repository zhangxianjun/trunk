package team.flint.trunk.interfaces;

/**
 * 消息队列
 */

public interface IMessageQueue {

    /**
     * 立即发送消息
     */
    public String sendMessage(String topic, String key, String content);

    /**
     * 发送延迟消息
     */
    public String sendDelayMessage(String topic, String key, long time, String content);
}
