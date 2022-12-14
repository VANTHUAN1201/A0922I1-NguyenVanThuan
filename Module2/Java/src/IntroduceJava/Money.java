package IntroduceJava;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner nhap=new Scanner(System.in);
        double vnd;
        double usd;
        do{
            System.out.println("Nhập vào số tiền cần quy đổi (usd)(>0):");
            usd= nhap.nextDouble();
        }while (usd<=0);
        vnd=usd*23000;
        System.out.println(usd+" usd = "+vnd+" vnd");
    }
}
