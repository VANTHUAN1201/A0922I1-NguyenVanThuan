package stack_queue;

import java.util.Scanner;
import java.util.TreeMap;

public class CountChar {
    public static void main(String[] args) {
        TreeMap<String,Integer> treeMap=new TreeMap<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi cần đếm từ: " );
        String str=scanner.nextLine();
        String[] arrayStrings=str.split(" ");
        for(int i=0; i<arrayStrings.length; i++) {
            if(treeMap.containsKey(arrayStrings[i])) {
                int newValue=treeMap.get(arrayStrings[i]);
                treeMap.put(arrayStrings[i],++newValue);
                }else {
                    treeMap.put(arrayStrings[i],1);
            }
        }
        System.out.println(treeMap);

    }
}
