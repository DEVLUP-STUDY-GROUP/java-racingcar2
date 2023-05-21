package step02;

public enum ExceptionMessage {
    INPUT_VALUE_EMPTY("input value is null or empty"),
    CANNOT_PARSE_NUMERIC("cannot parse none numeric value"),
    DIVIDE_BY_ZERO("cannot divide by zero"),
    NOT_ARITHMETIC_SYMBOL("not an operator symbol");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
