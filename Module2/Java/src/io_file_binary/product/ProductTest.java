package io_file_binary.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        List<Product> list=new ArrayList<>();
        list.add(new Product(1,"iphone6","apple",5000000,"iphone ......"));
        list.add(new Product(2,"iphone6plus","apple",5500000,"iphone ......"));
        list.add(new Product(3,"iphone7","apple",6200000,"iphone ......"));
        list.add(new Product(4,"iphone7plus","apple",6800000,"iphone ......"));
        list.add(new Product(5,"iphone14","apple",32000000,"iphone ......"));
        list.add(new Product(6,"iphonex","apple",9000000,"iphone ......"));
        list.add(new Product(7,"iphone11","apple",9800000,"iphone ......"));
        list.add(new Product(8,"iphone12","apple",14000000,"iphone ......"));
        Scanner sc=new Scanner(System.in);
        int select;
        String path="D:\\CodeGym\\Module1\\Module2\\Java\\src\\io_file_binary\\product\\product.dat";
        do {
            System.out.println("------MENU--------");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Tìm kiếm danh sách sản phẩm");
            System.out.println("3. Thêm mới sản phẩm");
            System.out.println("4. Sửa thông tin sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("-------------------------------");
            System.out.println("Nhập lựa chọn của bạn!");
            select=sc.nextInt();
            switch (select){
                case 1:  System.out.println("------------------DANH SÁCH SẢN PHẨM-------------");
//                  ObjectUtils.writeObject(path,products);
                    ObjectUtils.readFileObject(path).forEach(System.out::println);
                    System.out.println("-------------------------------");
                    break;
                case 2:  System.out.println("------------------SẢN PHẨM TÌM KIẾM ĐƯỢC-------------");
                    System.out.println("Nhập vào tên sản phẩm cần tìm:");
                    String str=sc.next();
                    Product pr=null;
                    for (Product product :list){
                        if (product.getName().equals(str)){
                            pr=product;
                            System.out.println(pr.toString());
                        }
                    }
                    if (pr==null){
                        System.out.println("không tìm thấy sản phẩm.");
                    }
                    System.out.println("-------------------------------");
                    break;
                case 3:
                    System.out.println("Nhập id sản phẩm: ");
                    int id=sc.nextInt();
                    System.out.println("Nhập tên sản phẩm: ");
                    String name=sc.next();
                    System.out.println("Nhập hãng sản xuất: ");
                    String production=sc.next();
                    System.out.println("Nhập giá sản phẩm: ");
                    int price=sc.nextInt();
                    System.out.println("Nhập mô tả sản phẩm: ");
                    String describe=sc.next();
                    list.add(new Product(id,name,production,price,describe));
                    System.out.println("Thêm sản phẩm thành công!");
                    ObjectUtils.disPlay(path,list);
                    System.out.println("-------------------------------");
                    break;
                case 4:
                    System.out.println("Nhập id sản phẩm cần chỉnh sửa.");
                    int index=sc.nextInt();
                    System.out.println("Nhập lại tên sản phẩm: ");
                    String name1=sc.next();
                    System.out.println("Nhập lại hãng sản xuất: ");
                    String production1=sc.next();
                    System.out.println("Nhập lại giá sản phẩm: ");
                    int price1=sc.nextInt();
                    System.out.println("Nhập lại mô tả sản phẩm: ");
                    String describe1=sc.next();
                case 5:
                    System.exit(0);
            }
        }while (true);
    }

}
