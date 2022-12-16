package Array;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        int count=0;
        String str="nguyenvanthuan";
        char k;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Chuổi cho trước: "+str);
        System.out.println("Nhập vào kí tự muốn đếm số lần xuất hiện:");
        k=scanner.next().charAt(0);
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i)==k){
                count++;
            }
        }
        System.out.print(" kí tự '"+k+"' xuất hiện trong chuỗi "+count+ " lần.");
    }
}
