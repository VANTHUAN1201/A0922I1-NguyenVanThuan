package array;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
        public static void main(String[] args) {
            int [] arr = {10, 4, 6, 7, 8, 9,8,7,0};
            System.out.println(Arrays.toString(arr));
            Scanner scanner = new Scanner(System.in);
            int k;
            int vt;
            System.out.println("Nhập vào giá trị muốn chèn: ");
            k = scanner.nextInt();
            System.out.println("Nhập vào vị trí chèn: ");
            vt = scanner.nextInt();
            if (vt <= -1 || vt >= arr.length-1){
                System.out.println("k thể chèn phần tử vào mảng.");
            }
            for (int i = arr.length-1; i > vt; i--){
                arr[i] = arr[i-1];
            }
            arr[vt] = k;
            System.out.println(Arrays.toString(arr));
        }
}
