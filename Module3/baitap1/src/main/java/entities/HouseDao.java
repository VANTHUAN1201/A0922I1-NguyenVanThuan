package entities;

import repos.PersonRepo;
import service.PersonService;

import java.sql.Date;

public class HouseDao {
    private String id;
    private String hhName;
    private Date hhDate;
    private String address;
    private int count;
    private String infoPersonInHouse;
    private PersonService repo = new PersonService();

    public HouseDao(String id, String hhName, Date hhDate, String address) {
        this.id = id;
        this.hhName = hhName;
        this.hhDate = hhDate;
        this.address = address;
        this.count = repo.countPersonInHouse(id);
        this.infoPersonInHouse = repo.findByIdHH(id);
    }


    public HouseDao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHhName() {
        return hhName;
    }

    public void setHhName(String hhName) {
        this.hhName = hhName;
    }

    public Date getHhDate() {
        return hhDate;
    }

    public void setHhDate(Date hhDate) {
        this.hhDate = hhDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getInfoPersonInHouse() {
        return infoPersonInHouse;
    }

    public void setInfoPersonInHouse(String infoPersonInHouse) {
        this.infoPersonInHouse = infoPersonInHouse;
    }
}
