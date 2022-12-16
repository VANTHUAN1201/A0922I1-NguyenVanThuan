package Array;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArr {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] a=new int[5];
        int [] b=new int[5];
        int [] c=new int[10];
        for (int i = 0; i < 5; i++) {
            System.out.printf("a[%d] = ", i);
            a[i] = scanner.nextInt();
        }
        for (int j = 0; j < 5; j++) {
            System.out.printf("b[%d] = ", j);
            b[j] = scanner.nextInt();
        }
        for (int k = 0; k < a.length ; k++) {
            c[k]=a[k];
        }
        for (int i = 0; i < b.length ; i++) {
            c[i+a.length]=b[i];
        }
        System.out.println("Mảng a:"+ Arrays.toString(a));
        System.out.println("Mảng b:"+ Arrays.toString(b));
        System.out.println("Mảng c sau khi gộp a và b là: "+Arrays.toString(c));
    }
}
