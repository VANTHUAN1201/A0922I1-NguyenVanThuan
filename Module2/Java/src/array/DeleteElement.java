package array;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        int array[] = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập phần tử array[" + i + "] = ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Danh sách ban đầu: "+Arrays.toString(array));
        System.out.println("Nhập vào số cần xóa:");
        int so=scanner.nextInt();
        System.out.println("Danh sách sau khi xóa: ");
        for (int i = 0; i <array.length ; i++) {
            if(array[i]==so){
                for (int j = i; j < n; j++) {
                    array[i]=array[i+1];
                }
            }else {
                System.out.println( array[i]+" ");
            }

        }
    }
}


