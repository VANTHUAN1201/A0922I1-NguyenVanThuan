package utils;

import entities.HouseDao;

import java.util.HashMap;
import java.util.Map;

public class Valid {
    public static Map<String, String> getValidate(HouseDao house){
        Map<String, String> error = new HashMap<>();
        if (!house.getHhName().matches("[A-Za-z\\s]+")){
            error.put("name","Must be characters!");
        }

        return error;
    }
}
