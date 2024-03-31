package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String NOT_INTEGER_MESSAGE = "[ERROR] 입력 값은 정수여야 합니다.";

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readCarNames() throws IOException {
        System.out.println(READ_CAR_NAME_MESSAGE);
        String input = bufferedReader.readLine();
        return splitByComma(input);
    }

    public static List<String> splitByComma(final String input) {
        String[] split = input.split(",", -1);
        return Arrays.asList(split);
    }

    public static int readAttemptNumber() throws IOException {
        try {
            System.out.println(READ_ATTEMPT_NUMBER_MESSAGE);
            String input = bufferedReader.readLine();
            return parse(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAttemptNumber();
        }
    }

    public static int parse(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE, e);
        }
    }

}
