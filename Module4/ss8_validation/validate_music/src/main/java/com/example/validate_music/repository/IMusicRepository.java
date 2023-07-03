package com.example.validate_music.repository;

import com.example.validate_music.model.Music;
import org.springframework.data.repository.CrudRepository;

public interface IMusicRepository extends CrudRepository<Music,Integer> {
}
