package atm.utils;

import atm.models.ATM;
import atm.models.Card;
import atm.models.CreditCard;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWriteFile {
    private static final String BLANK = "";
    private static final String DELIMITER = ",";
    private static final String PATH = "D:\\CodeGym\\Module1\\Module2\\java\\src\\atm\\card.csv";

    public static void writeToFile(Card item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
            writer.write(item.toStringFile());
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(List<Card> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
            for (Card item : list) {
                writer.write(item.toStringFile());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Card> readFromFile() {
        List<Card> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(BLANK)) {
                    continue;
                }
                String[] result = line.split(DELIMITER);
                if (result.length == 5) {
                    ATM item = new ATM(Arrays.asList(result));
                    list.add(item);
                } else {
                    CreditCard item = new CreditCard(Arrays.asList(result));
                    list.add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
