package codegym.repository;

import codegym.entity.Music;

import java.util.List;

public interface IMusicRepository {
    void create(Music music);
    void update(Music music);
    Music findById(int id);
    List<Music> findAll();
    void deleteById(int id);
}
