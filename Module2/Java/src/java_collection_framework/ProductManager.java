package java_collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java_collection_framework.Product;

public class ProductManager {
    private static final List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "dell 23485",25000000));
        list.add(new Product(2, "asus vivo book 6",18000000));
        list.add(new Product(3, "hpenvy 55566",15000000));
        list.add(new Product(4, "samsung galaxy book 521",21000000));
        list.add(new Product(5, "hp envy555",16500000));
        list.add(new Product(6, "acer nitro 51515",13500000));
        list.add(new Product(7, "acer nitro 1555",14000000));
        list.add(new Product(8, "acer nitro 1525",14200000));
        list.add(new Product(9, "dell gaming 525252",22000000));
        list.add(new Product(10, "dell gaming 424242",26000000));
        list.add(new Product(11, "dell gaming 85827",25500000));
        list.add(new Product(12, "dell gaming 73524",25800000));
    }
    public void add(Product product){
        list.add(product);
    }
    public void findByName(String nameInput){
        Product product = null;
        for (Product product1 : list){
            if (product1.getNameProduct().equals(nameInput)) {
                product = product1;
                System.out.println("Sản phẩm: " + nameInput + " " + product1.toString());
            }
        }if (product == null)
            System.out.println("Không tìm thấy sản phẩm!");
    }
    public void findById(int id){
        Product product = getById(id);
        if (product!= null){
            System.out.println("Sản phẩm có id=  " + id + " là: " + product.toString());
        }else {
            System.out.println("Không tìm thấy sản phẩm!");
        }

    }
    public Product getById(int id){
        return list.stream().filter(i -> id == i.getIdProduct()).findFirst().orElse(null);
    }
    public boolean removeProduct(int id){
        Product product = getById(id);
        if (product!= null){
            list.remove(product);
            return true;
        }
        return false;
    }

    public void displayProduct(){
        for (Product product :list){
            System.out.println(product.toString());
        }
    }
    public void editProduct(int id, String nameProduct, int price){
        Product product = null;
        for (Product product1 :list){
            if (product1.getIdProduct() == id){
                product = product1;
                break;
            }
        }if (product == null){
            System.out.println("Không tìm thấy sản phẩm!");
        }else {
            product.setNameProduct(nameProduct);
            product.setPrice(price);
        }
    }
    public void sortByPriceIncrease() {
        list.sort(((o1, o2) -> {
            return o1.getPrice() - o2.getPrice();
        }));
        list.forEach(System.out::println);
    }

    public void sortByPriceDecrease() {
        list.sort(((o1, o2) -> {
            return o2.getPrice() - o1.getPrice();
        }));
        list.forEach(System.out::println);
    }
}
