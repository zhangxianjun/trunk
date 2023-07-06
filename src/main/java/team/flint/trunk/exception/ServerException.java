package team.flint.trunk.exception;

/**
 * 服务端异常
 */

public class ServerException extends RuntimeException {
    protected String message;
    public ServerException(String message) {
        super(message);
        this.message = message;
    }
}
