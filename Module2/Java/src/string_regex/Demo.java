package string_regex;

public class Demo {
    public static void main(String[] args) {
        final String SDT = "0[1-9]\\d{8}";
        final String CCCD = "\\d{12}";
        final String BSX = "43-[A-Z][1-9]-((\\d{4})|(\\d{3}.\\d{2}))";
        final String EMAIL = "\\w+@\\w+.[A-Za-z]{2,3}";
        final String DATE = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";

//        System.out.println("43-H1-1234".matches(BSX));
//        System.out.println("43-H1-12345".matches(BSX));
//        System.out.println("43-H1-123.45".matches(BSX));
//        System.out.println("43-H1-12.345".matches(BSX));
        System.out.println("aaaa".matches(EMAIL));
        System.out.println("aaaa@bbb.ccccc".matches(EMAIL));
        System.out.println("aaaa@bbb.ccc".matches(EMAIL));
        System.out.println("aaaa@bbb.c".matches(EMAIL));
        System.out.println("aaaa@111.11".matches(EMAIL));
        System.out.println("aaaa@aa.aa.a".matches(EMAIL));
    }

}
