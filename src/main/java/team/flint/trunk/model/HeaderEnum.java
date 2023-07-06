package team.flint.trunk.model;

public enum HeaderEnum {

    TOKEN("token", "token"),

    LANGUAGE("Accept-Language", "语言:zh-CN, en-US"),

    CURRENCY("currency", "币种");

    private final String key;

    private final String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    HeaderEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
