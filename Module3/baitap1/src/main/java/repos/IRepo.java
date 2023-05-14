package repos;

import java.util.List;

public interface IRepo <E> {

    List<E> findAll(String searchName, String index);

    E findById(String id);

    void create(E e);

    void update(E e);

    boolean delete(String id);


    int countItem();
}
