package atm.view;


import atm.controllers.CardController;
import atm.models.Card;
import atm.utils.DisplayScanner;
import atm.models.ATM;
import atm.models.CreditCard;

import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        CardController cardController = new CardController();
        while (true) {
            System.out.println("----------------");
            System.out.println("1. Add new");
            System.out.println("2. Remove"); // xóa, chưa làm chức năng kiểm tra số dư credit card
            System.out.println("3. Display all"); // hiển thị all
            System.out.println("4. Pay debit"); // thanh toán
            System.out.println("5. Find by name or id_person"); // tìm kiếm theo tên người/ CCCD
            System.out.println("6. Transfer"); // chuyển khoản
            System.out.print("Input your choice: ");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("1. ATM");
                    System.out.println("2. Credit card");
                    System.out.print("Input your choice: ");
                    String yourChoice = scanner.next();
                    if (yourChoice.equals("1")) {
                        // hàm nhận dữ liệu từ bàn phím, có thể tự viết lại theo cách khác
                        List<String> data = DisplayScanner.getDataFromConsole(ATM.getInfo());
                        cardController.add(data);
                        break;
                    } else if (yourChoice.equals("2")) {
                        List<String> data = DisplayScanner.getDataFromConsole(CreditCard.getInfo());
                        cardController.add(data);
                    } else {
                        System.out.println("Not match");
                    }
                    break;
                case 2:
                    System.out.print("Input code account you want to remove: ");
                    String id = scanner.next();
                    if (cardController.remove(id.trim())) {
                        System.out.println("Remove successfully");
                    }
                    break;
                case 3:
                    cardController.findAll().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Input code account (ATM/Credit Card): ");
                    String code = scanner.next();
                    Card account = cardController.findByCode(code);
                    if (account == null) {
                        System.out.println("account is not exist");
                        break;
                    }
                    System.out.print("Input money, you want to pay: ");
                    int payMoney = Integer.parseInt(scanner.next().trim());
                    if (account instanceof ATM){
                        if (((ATM) account).getBalance() < payMoney){
                            System.out.println("Not enough money to pay");
                        }
                        cardController.updateATM(payMoney, account);
                    }else {
                        if (((CreditCard)account).getMax_money() < payMoney){
                            System.out.println("Not enough money to pay");
                        }
                        cardController.updateCreditCard(payMoney, account);
                    }
                    break;
                case 5:
                    System.out.print("Input code account (ATM/Credit Card): ");
                    String inputData = scanner.next();
                    cardController.findByNameOrIdPerson(inputData);
                    break;
                case 6:
                    System.out.print("Input code transfer_account: ");
                    String transferCodeAccount = scanner.next();
                    System.out.print("Input code source_account: ");
                    String sourceCodeAccount = scanner.next();
                    Card transferAccount = cardController.findByCode(transferCodeAccount);
                    Card sourceAccount = cardController.findByCode(sourceCodeAccount);
                    if (transferAccount == null || sourceAccount == null) {
                        System.out.println("account is not exist");
                        break;
                    }
                    System.out.print("Input money, you want to transfer: ");
                    int transferMoney = Integer.parseInt(scanner.next().trim());
                    if (transferAccount instanceof ATM){
                        if (((ATM) transferAccount).getBalance() < transferMoney){
                            System.out.println("Not enough money to pay");
                        }
                        cardController.updateATM(transferMoney, transferAccount);
                        if (sourceAccount instanceof ATM){
                            cardController.updateATM(- transferMoney, sourceAccount);
                        } else {
                            cardController.updateCreditCard(- transferMoney, sourceAccount);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
