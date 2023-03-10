package atm.controllers;

import atm.models.ATM;
import atm.models.Card;
import atm.models.CreditCard;
import atm.utils.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CardController {
    static List<Card> repo = ReadWriteFile.readFromFile();
// tạo biến đếm tự động tăng
    public String idCount(){
//        int id = repo.stream().map(i-> Integer.parseInt(i.getCode())).max(Integer::compareTo).get();
        int id = 0;
        for(Card c: repo){
            id = Math.max(id, Integer.parseInt(c.getId()));
        }
        return String.valueOf(++id);
    }

    public void add(List<String> data) {
        if (data.size() == 4) {
            ReadWriteFile.writeToFile(new ATM(idCount(), data));
        } else {
            ReadWriteFile.writeToFile(new CreditCard(idCount(), data));
        }
    }
// update khi thanh toán
    public void updateATM(int money, Card card) {
        repo.remove(card);
        ATM c = (ATM) card;
        repo.add(new ATM(c.getId(), c.getCode(), c.getName(), c.getIdPerson(), c.getBalance() - money));
        ReadWriteFile.writeToFile(repo);
    }

    public void updateCreditCard(int money, Card card) {
        repo.remove(card);
        CreditCard c = (CreditCard) card;
        repo.add(new CreditCard(c.getId(), c.getCode(), c.getName(), c.getIdPerson(), c.getBalance() - money, c.getMax_money()));
        ReadWriteFile.writeToFile(repo);
    }

    public boolean remove(String code) {
        Card a = findByCode(code);
        if (a != null){
            repo.remove(a);
            ReadWriteFile.writeToFile(repo);
            return true;
        }
        return false;
    }

    public List<Card> findAll() {
        return repo;
    }
// các mã code của account
    public static List<String> findAllCode() {
//        return repo.stream().map(Card::getCode).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        for (Card c: repo){
            list.add(c.getCode());
        }
        return list;
    }

    public Card findByCode(String code) {
//        return repo.stream().filter(i -> i.getCode().contains(code)).findFirst().orElse(null);
        Card card = null;
        for(Card c: repo){
            if (c.getCode().equals(code)){
                card = c;
            }
        }
        return card;
    }

    // tìm kiếm theo tên hoặc CCCD
    public List<Card> findByNameOrIdPerson(String data) {
//        List<Card> list = repo.stream().filter(i -> i.getName().contains(data)).collect(Collectors.toList());
//        list.addAll(repo.stream().filter(i -> i.getIdPerson().contains(data)).collect(Collectors.toList()));
        List<Card> list = new ArrayList<>();
        for (Card c: repo){
            if (c.getName().contains(data) || c.getIdPerson().contains(data)){
                list.add(c);
            }
        }
        return list;
    }
}
