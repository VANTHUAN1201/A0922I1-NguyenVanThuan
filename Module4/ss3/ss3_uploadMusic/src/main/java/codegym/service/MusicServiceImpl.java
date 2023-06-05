package codegym.service;

import codegym.model.Music;
import codegym.repository.MusicRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService{
    @Autowired
    MusicRepoImpl musicRepo;
    @Override
    public List<Music> findAll() {
        return musicRepo.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepo.save(music);
    }
}
