package codegym.vn.service;

import codegym.vn.entity.Music;
import codegym.vn.repository.IMusicRepository;

import java.util.List;

public interface IMusicService extends IMusicRepository<Music> {
    void create(Music music);
    void update(Music music);
    Music findById(int id);
    List<Music> findAll();
    void deleteById(int id);
}
