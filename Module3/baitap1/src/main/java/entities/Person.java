package entities;

import java.sql.Date;

public class Person {
    int id;
    String name;
    Date bod;
    String hhId;

    public Person(int id, String name, Date bod, String hhId) {
        this.id = id;
        this.name = name;
        this.bod = bod;
        this.hhId = hhId;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBod() {
        return bod;
    }

    public void setBod(Date bod) {
        this.bod = bod;
    }

    public String getHhId() {
        return hhId;
    }

    public void setHhId(String hhId) {
        this.hhId = hhId;
    }
}
