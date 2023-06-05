package codegym.service;

import codegym.model.Yte;

import java.util.List;

public interface IYteService {
    List<Yte> findAll();
    void save(Yte yte);
}
