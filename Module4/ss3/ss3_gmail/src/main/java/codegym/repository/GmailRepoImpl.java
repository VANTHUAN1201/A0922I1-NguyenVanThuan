package codegym.repository;

import codegym.model.Gmail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GmailRepoImpl implements IGmailRepo{
    private static List<Gmail> gmailList=new ArrayList<>();
    static {
        gmailList.add(new Gmail( 5, "English",true, "King, Asgard"));
    }
    @Override
    public List<Gmail> findAll() {
        return gmailList;
    }

    @Override
    public boolean update(Gmail gmail) {
        gmailList.add(gmail);
        gmailList.remove(0);
        return true;
    }

    @Override
    public Gmail findGmail() {
        return gmailList.get(0);
    }
}
