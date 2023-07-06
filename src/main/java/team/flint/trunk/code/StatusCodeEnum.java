package team.flint.trunk.code;

public enum StatusCodeEnum implements IStatusCode {
    CLIENT_ERROR(4000, "客户端提示性错误"),
    SERVER_ERROR(5000, "服务端提示性错误");

    private final int code;

    private final String message;

    StatusCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
