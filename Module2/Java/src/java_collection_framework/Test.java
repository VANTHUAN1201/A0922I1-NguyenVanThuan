package java_collection_framework;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("-------MENU-------");
            System.out.println("1. Hiển thị DS sản phẩm.");
            System.out.println("2. Thêm sản phẩm.");
            System.out.println("3. Sửa thông tin sản phẩm.");
            System.out.println("4. Xóa sản phẩm.");
            System.out.println("5. Tìm kiếm sản phẩm theo tên.");
            System.out.println("6. Tìm kiếm sản phẩm theo id sản phẩm.");
            System.out.println("7. Sắp xếp sản phẩm theo giá tăng dần.");
            System.out.println("8. Sắp xếp sản phẩm theo giá tăng dần.");
            System.out.println("9.Thoát.");
            System.out.println("Nhập lựa chọn!");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1:
                    System.out.println("------------------DANH SÁCH SẢN PHẨM-------------");
                    manager.displayProduct();
                    break;
                case 2:
                    System.out.println("Nhập id sản phẩm cần thêm: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tên sản phẩm cần thêm: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhập giá sản phẩm cần thêm:");
                    int price = Integer.parseInt(scanner.nextLine());
                    manager.add(new Product(id, name, price));
                    System.out.println("Danh sách sản phẩm sau khi thêm:");
                    manager.displayProduct();
                    break;
                case 3:
                    System.out.println("Nhập id sản phẩm cần sửa: ");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tên sản phẩm cần sửa: ");
                    name = scanner.nextLine();
                    System.out.println("Nhập giá sản phẩm cần sửa:");
                    price = Integer.parseInt(scanner.nextLine());
                    manager.editProduct(id, name, price);
                    manager.displayProduct();
                    break;
                case 4:
                    System.out.println("Nhập id sản phẩm cần xóa: ");
                    id = Integer.parseInt(scanner.nextLine());
                    String result = manager.removeProduct(id) ? "Sản phẩm xóa thành công": "kh tiìm thấy sản phẩm";
                    System.out.println(result);
                    System.out.println("Danh sách sản phẩm sau khi xóa:");
                    manager.displayProduct();
                    break;
                case 5:
                    System.out.println("Nhập vào tên sản phẩm muốn tìm kiếm:");
                    name = scanner.nextLine();
                    manager.findByName(name);
                    break;
                case 6:
                    System.out.println("Nhập vào id sản phẩm muốn tìm kiếm:");
                    id = Integer.parseInt(scanner.nextLine());
                    manager.findById(id);
                    break;
                case 7:
                    manager.sortByPriceIncrease();
                    System.out.println("------------------DANH SÁCH SẢN PHẨM-------------");
                    break;
                case 8:

                    System.out.println("------------------DANH SÁCH SẢN PHẨM-------------");
                    break;
                case 9:
                    System.exit(0);
            }
        }while (true);
    }
}
