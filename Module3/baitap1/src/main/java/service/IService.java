package service;

import java.util.List;

public interface IService <E> {

    List<E> findAll(String searchName, String index);

    E findById(String id);

    void save(E e);

    boolean delete(String id);

    int pages();
}
