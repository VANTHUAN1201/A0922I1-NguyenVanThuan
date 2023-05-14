package entities;

import repos.PersonRepo;

import java.sql.Date;

public class House {
    private String id;
    private String hhName;
    private Date hhDate;
    private String address;
    private PersonRepo personRepo = new PersonRepo();

    public House(String id, String hhName, Date hhDate, String address) {
        this.id = id;
        this.hhName = hhName;
        this.hhDate = hhDate;
        this.address = address;
    }


    public House() {
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
}
