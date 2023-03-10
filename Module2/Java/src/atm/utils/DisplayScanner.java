package atm.utils;

import atm.controllers.CardController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayScanner {
    public static final String REGEX_NAME = "[A-Za-z]+";
    public static final String REGEX_NUMBER = "[0-9]+";
    public static final String REGEX_ID = "[0-9]{6}";
    static Scanner scanner = new Scanner(System.in);

    public static List<String> getDataFromConsole(String data) {
        String[] inputData = data.split(",");
        List<String> result = new ArrayList<>();
        for (String s : inputData) {
            if (s.equals("NAME")) {
                result.add(checkValid(s, REGEX_NAME));
                continue;
            }
            if (s.equals("ID_PERSON")) {
                result.add(checkValid(s, REGEX_ID));
                continue;
            }
            if (s.equals("CODE")) {
                result.add(checkValidCode(s, REGEX_ID));
                continue;
            }
            if (s.equals("BALANCE") || s.equals("MAX_MONEY")) {
                result.add(checkValid(s, REGEX_NUMBER));
            }
        }
        return result;
    }

    private static String checkValidCode(String s, String regex) {
        List<String> codeLists = CardController.findAllCode();
        boolean flag = true;
        while (true) {
            System.out.printf(flag ? "Input %s: " : "Input %s again: ", s);
            String input = scanner.next().trim();
            // kiểm tra regex và input có trùng với mã account ko
            if (codeLists.contains(input)){
                flag = false;
                continue;
            }
            if (input.matches(regex)) {
                return input;
            }
            flag = false;
        }
    }
    private static String checkValid(String s, String regex) {
        boolean flag = true;
        while (true) {
            System.out.printf(flag ? "Input %s: " : "Input %s again: ", s);
            String input = scanner.next().trim();
            if (input.matches(regex)) {
                return input;
            }
            flag = false;
        }
    }
}
