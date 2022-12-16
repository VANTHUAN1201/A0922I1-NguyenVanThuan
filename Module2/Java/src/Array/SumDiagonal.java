package Array;

import java.util.Scanner;

public class SumDiagonal {
    public static void main(String[] args) {
        int soDong;
        int sum=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số dòng ma trận vuông: ");
        soDong = scanner.nextInt();

        int [][] a = new int[soDong][soDong];
        for (int i = 0; i < soDong; i++){
            for (int j = 0; j < soDong; j++){
                System.out.print("Nhập phần tử thứ ["+ i +","+ j +"]: ");
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i <soDong ; i++) {
            for (int j = 0; j <soDong ; j++) {
                System.out.print(a[i][j]+"  ");
                if (i==j){
                    sum+=a[i][j];
                }
            }
            System.out.println("\n");
        }
        System.out.println("Tổng đường chéo của ma trận vuông là: "+ sum    );
    }
}
