package IntroduceJava;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập vào tên của bạn:");
        String name=input.nextLine();
        System.out.println("Xin chào "+name);

    }
}
