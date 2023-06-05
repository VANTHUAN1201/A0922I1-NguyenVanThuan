package codegym.repository;

import codegym.model.Yte;

import java.util.List;

public interface IYteRepo {
    List<Yte> findAll();
    void save(Yte yte);
}
