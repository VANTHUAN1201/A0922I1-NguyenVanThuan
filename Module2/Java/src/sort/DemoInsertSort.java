package sort;

import java.util.Arrays;

public class DemoInsertSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    System.out.println(arr[j]+" < "+arr[j-1]+" thực hiện đổi chổ.");
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {

                    System.out.println(arr[j]+" > "+arr[j-1]+" dừng kiểm tra");
                    System.out.println("Danh sách lúc này là: "+ Arrays.toString(arr));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[]={1,52,5,85,6,5,7,987,1,4};
        System.out.println("Danh sách ban đầu: "+ Arrays.toString(a));
        insertionSort(a);
        System.out.println("Danh sách sau khi sắp xếp: "+ Arrays.toString(a));
    }
}
