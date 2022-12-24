package introduce_java;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int so;
        do {
            System.out.println("Nhập vào số cần đọc - số nguyên k âm có 3 chữ số:");
            so = input.nextInt();
        } while (so > 999 || so <= 0);
        int donvi=so%10;
        so=so/10;
        int chuc=so%10;
        int tram=so/10;
        switch (tram){
            case 1:
                System.out.print("Một trăm ");
                break;
            case 2:
                System.out.print("Hai trăm ");
                break;
            case 3:
                System.out.print("Ba trăm ");
                break;
            case 4:
                System.out.print("Bốn trăm ");
                break;
            case 5:
                System.out.print("Năm trăm ");
                break;
            case 6:
                System.out.print("Sáu trăm ");
                break;
            case 7:
                System.out.print("Bảy trăm ");
                break;
            case 8:
                System.out.print("Tám trăm ");
                break;
            case 9:
                System.out.print("Chín trăm ");
                break;
        }
        switch (chuc){
            case 0:
                if(donvi!=0){
                    System.out.print("Lẻ");
                }
                break;
            case 1:
                System.out.print("Mười  ");
                break;
            case 2:
                System.out.print("Hai mươi");
                break;
            case 3:
                System.out.print("Ba mươi ");
                break;
            case 4:
                System.out.print("Bốn mươi ");
                break;
            case 5:
                System.out.print("Năm mươi ");
                break;
            case 6:
                System.out.print("Sáu mươi ");
                break;
            case 7:
                System.out.print("Bảy mươi ");
                break;
            case 8:
                System.out.print("Tám mươi ");
                break;
            case 9:
                System.out.print("Chín mươi ");
                break;
        }
        switch (donvi){
            case 1:
                System.out.print("Một");
                break;
            case 2:
                System.out.print("Hai");
                break;
            case 3:
                System.out.print("Ba");
                break;
            case 4:
                System.out.print("Bốn");
                break;
            case 5:
                System.out.print("Năm");
                break;
            case 6:
                System.out.print("Sáu");
                break;
            case 7:
                System.out.print("Bảy");
                break;
            case 8:
                System.out.print("Tám");
                break;
            case 9:
                System.out.print("Chín ");
                break;
        }
    }
}
