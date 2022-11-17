package bridge.utils;

public class InputValidator {
    private static final String NOT_NUMBER_INPUT_FOR_BRIDGE_LENGTH = "[ERROR] 다리 길이는 숫자만 입력하실 수 있습니다.";
    private static final String OUT_OF_RANGE_INPUT_FOR_BRIDGE_LENGTH = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static void intInputValidation(String input) {
        String numberStringFormat = "\\d{1,2}";
        if (!input.matches(numberStringFormat)) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_FOR_BRIDGE_LENGTH);
        }

        int length = Integer.parseInt(input);
        if (length < 3 || length > 20) {
            throw new IllegalArgumentException(OUT_OF_RANGE_INPUT_FOR_BRIDGE_LENGTH);
        }
    }
}
