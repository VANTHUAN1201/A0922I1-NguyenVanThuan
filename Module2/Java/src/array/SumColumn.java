package array;

import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        int soDong, soCot, cotMuonTinh, sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số dòng: ");
        soDong = scanner.nextInt();
        System.out.print("Nhập vào số cột: ");
        soCot = scanner.nextInt();
        int [][] Arr = new int[soDong][soCot];
        for (int i = 0; i < soDong; i++){
            for (int j = 0; j < soCot; j++){
                System.out.print("Nhập phần tử thứ ["+ i +","+ j +"]: ");
                Arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(Arr[i][j] + "\t");
            }
            System.out.println("\n");
        }
        do {
            System.out.print("Nhập vào cột muốn tính tổng: ");
            cotMuonTinh = scanner.nextInt();
            if (cotMuonTinh > soCot){
                System.out.println("Không có cột muốn tính, vui lòng nhập lại!");
            }
        }while (cotMuonTinh > soCot ||cotMuonTinh<0);
        for (int k = 0; k < Arr.length; k++){
            for (int l = 0; l < Arr[k].length; l++){
                if (cotMuonTinh == l){
                    sum += Arr[k][l];
                }
            }
        }
        System.out.println("Tổng số cột muốn tính là: "+sum);
    }
}
