package exception;

import java.util.Scanner;
public class TestTriangle {
    public static void checkTriangleEdges(double a, double b, double c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Lỗi.Tam giác không hợp lệ!");
        } else {
            System.out.println("Tam giác hợp lệ!");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.print("Nhap vao canh thu nhat: ");
            int a = sc.nextInt();
            System.out.print("Nhap vao canh thu hai: ");
            int b = sc.nextInt();
            System.out.print("Nhap vao canh thu ba: ");
            int c = sc.nextInt();
            try {
                checkTriangleEdges(a,b,c);
            }catch (IllegalTriangleException e){
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Sai. không đúng định dạng");
        }
    }
}
