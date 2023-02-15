package io_text_file.read_file;

import java.util.ArrayList;
import java.util.List;

public class TestCountry {
    public static void main(String[] args) {
        FileUntils fileUntils=new FileUntils();
        List<Country> list=new ArrayList<>();
        List<Country> list1=fileUntils.readToFile("D:\\CodeGym\\Module1\\Module2\\Java\\src\\io_text_file\\read_file\\country.csv");
        list1.forEach(System.out::println);

    }
}
