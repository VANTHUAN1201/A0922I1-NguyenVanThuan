package com.example.validate_music.service;

import com.example.validate_music.model.Music;

import java.util.List;

public interface IMusicService {
    boolean create(Music music);
    boolean update(Music music);
    Music findById(int id);
    boolean delete(int id);
    List<Music> findAll();
}
