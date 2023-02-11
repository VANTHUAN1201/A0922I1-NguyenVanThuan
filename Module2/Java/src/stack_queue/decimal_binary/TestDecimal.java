package stack_queue.decimal_binary;

import java.util.Scanner;

public class TestDecimal {
    public static void main(String[] args) {
        DecimalToBinary convert = new DecimalToBinary();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Decimal want to swap to Binary: ");
        int decimal = scanner.nextInt();
        convert.convertBinary(decimal);
    }
}
