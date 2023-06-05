package codegym.repository;

import codegym.model.Yte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class YteRepoImpl implements IYteRepo {
    private static List<Yte> yteList;
    static {

        }
    @Override
    public List<Yte> findAll() {
        return yteList;
    }

    @Override
    public void save(Yte yte) {
        yteList.add(yte);
    }
}
