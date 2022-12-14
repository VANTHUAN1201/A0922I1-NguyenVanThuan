package Loop;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class Draw {
    public static void main(String[] args) {
        int chon;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("-----MENU:------");
            System.out.println("Bài 1. In hình chữ nhật");
            System.out.println("Bài 2. In hình tam giác vuông, có cạnh góc vuông ở botton-left");
            System.out.println("Bài 3. In hình tam giác vuông, có cạnh góc vuông ở top-left");
            System.out.println("Bài 4. Thoát");
            System.out.println("Mời chọn bài:");
            chon=sc.nextInt();
            switch (chon){
                case 1:
                    for (int i = 0; i <4 ; i++) {
                        for (int j = 0; j <=8; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j <=i ; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    for (int i = 7; i >=0; i--) {
                        for (int j = 0; j <=i ; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 4:
                    System.out.print("Bạn đã thoát chương trình");
                    break;
            }
        }while(chon!=4);
    }
}
