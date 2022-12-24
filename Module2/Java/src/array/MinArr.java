package array;

import java.util.Arrays;

public class MinArr {
    public static void main(String[] args) {
        int [] a={2,5,56,6,4,5,68,5854,844,1,4,6,4};
        System.out.println(Arrays.toString(a));
        int min=a[0];
        for (int i = 1; i < a.length ; i++) {
            if (a[i]<min){
                min=a[i];
            }
        }
        System.out.println("Phần tử nhỏ nhất trong mảng là: "+min);
    }
}
