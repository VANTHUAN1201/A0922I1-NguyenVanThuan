package codegym.vn.repository;

import codegym.vn.entity.Music;

import java.util.List;

public interface IMusicRepository<T> {
    void create(Music music);
    void update(Music music);
    Music findById(int id);
    List<Music> findAll();
    void deleteById(int id);
}
