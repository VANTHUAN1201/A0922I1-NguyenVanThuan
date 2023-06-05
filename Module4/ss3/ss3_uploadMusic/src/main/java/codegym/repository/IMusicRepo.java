package codegym.repository;

import codegym.model.Music;

import java.util.List;

public interface IMusicRepo {
    List<Music> findAll();
    void save(Music music);
}
