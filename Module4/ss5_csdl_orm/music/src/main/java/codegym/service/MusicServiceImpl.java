package codegym.service;

import codegym.entity.Music;
import codegym.repository.IMusicRepository;
import codegym.repository.MusicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService{
    @Autowired
    IMusicRepository repository;
    @Override
    public void create(Music music) {
        repository.create(music);
    }

    @Override
    public void update(Music music) {
        repository.update(music);
    }

    @Override
    public Music findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Music> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
