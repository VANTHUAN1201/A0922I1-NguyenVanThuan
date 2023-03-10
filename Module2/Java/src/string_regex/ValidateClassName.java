package string_regex;

public class ValidateClassName {
    public static void main(String[] args) {
        final String className="[CAP]\\d{4}[GHIKLM]";
        System.out.println("C0318G".matches(className));
        System.out.println("M0318G".matches(className));
        System.out.println("P0323A".matches(className));
    }
}
