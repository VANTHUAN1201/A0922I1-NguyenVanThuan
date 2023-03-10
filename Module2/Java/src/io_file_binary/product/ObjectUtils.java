package io_file_binary.product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectUtils {
    public static void writeObject(String path, List<Product> list) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))){
            stream.writeObject(list);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readFileObject(String path) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path))){
            return (List<Product>)stream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public static void disPlay(String path,List<Product> list){
        writeObject(path,list);
        readFileObject(path).forEach(System.out::println);
    }
//    public void editProduct(List<Product> list, int index, String name,String production, int price,String describe){
//        Product product = null;
//        for (Product product1 :list){
//            if (product1.getId() == index){
//                product = product1;
//                break;
//            }
//        }if (product == null){
//            System.out.println("Không tìm thấy sản phẩm!");
//        }else {
//            product.setName(name);
//            product.setProduction(production);
//            product.setPrice(price);
//            product.setDescribe(describe);
//        }
//    }
}