package service;

import entities.Person;
import repos.PersonRepo;

import java.util.List;

public class PersonService {

    PersonRepo repo = new PersonRepo();

    public List<Person> findAll(){
        return repo.findAll();
    }

    public int countPersonInHouse(String id){
        return repo.countPersonInHouse(id);
    }

    public String findByIdHH(String id) {
        return repo.findByIdHH(id);
    }
}
