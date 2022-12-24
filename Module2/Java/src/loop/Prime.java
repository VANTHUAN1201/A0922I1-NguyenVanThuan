package loop;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        int so,dem=0,n=2;
        Scanner nhap=new Scanner(System.in);
        System.out.println("Nhập vào số nguyên tố cần in ra:");
        so=nhap.nextInt();
        System.out.println(so+" số nguyên tố đầu tiên là:");
        while (dem<so){
            int d=0;
            for (int i = 2; i <=Math.sqrt(n) ; i++) {
                if (n%i==0){
                    d++;
                }
            }
            if (d==0 && n>1){
                System.out.print(n+" ");
                n++;
                dem++;
            }else {
                n++;
            }
        }


    }
}
