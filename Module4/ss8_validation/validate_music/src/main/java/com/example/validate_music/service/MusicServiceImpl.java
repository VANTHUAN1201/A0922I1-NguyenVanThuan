package com.example.validate_music.service;

import com.example.validate_music.model.Music;
import com.example.validate_music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService{
    @Autowired
    IMusicRepository repository;
    @Override
    public boolean create(Music music) {
        repository.save(music);
        return true;
    }

    @Override
    public boolean update(Music music) {

        if (repository.existsById(music.getId())){
            repository.save(music);
            return true;
        }
        return false;
    }

    @Override
    public Music findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Music> findAll() {
        return (List<Music>) repository.findAll();
    }
}
