package access_modifier.circle;

import access_modifier.circle.Circle;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        double r;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập vào bán kính: ");
        r=scanner.nextDouble();
        Circle circle1=new Circle(r);

        System.out.println("Diện tích là: "+circle1.getArea());
    }
}
