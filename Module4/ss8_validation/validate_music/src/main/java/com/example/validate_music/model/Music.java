package com.example.validate_music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue
    private int id;

//    @NotBlank(message = "Not empty")
//    @Size(max = 800,message = "so big")
//    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "Not a special symbol")
    private String name;

//    @NotBlank(message = "Not empty")
//    @Size(max = 300,message = "so big")
//    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "Not a special symbol")
    private String singer;

//    @NotBlank(message = "Not empty")
//    @Size(max = 1000,message = "so big")
//    @Pattern(regexp = "^[a-zA-Z0-9,]+$",message = "Not a special symbol")
    private String kind;


    private String link;

    public Music() {
    }

    public Music(int id, String name, String singer, String kind, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kind = kind;
        this.link = link;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
