package team.flint.trunk.exception;

/**
 * 业务处理异常
 */

public class ClientException extends RuntimeException {

    protected String message;

    public ClientException(String message){
        super(message);
        this.message = message;
    }
}
