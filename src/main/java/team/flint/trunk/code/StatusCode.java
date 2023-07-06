package team.flint.trunk.code;

/**
 * 错误码格式
 */

public class StatusCode {
    /**
     * 返回码
     */
    protected int code;
    /**
     * 返回信息
     */
    protected String message;

    protected StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
