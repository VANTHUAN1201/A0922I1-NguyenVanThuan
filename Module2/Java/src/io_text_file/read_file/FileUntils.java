package io_text_file.read_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntils {

    public static final String BLANK = "";
    public static final String DELIMITER = ",";

    public  List<Country> readToFile(String path){
        List<Country> countries=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(BLANK)) {
                    continue;
                }
                String[] result = line.split(DELIMITER);
                Country country = new Country(result);
                countries.add(country);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
