package codegym.service;

import codegym.model.Yte;
import codegym.repository.YteRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YteServiceImpl implements IYteService {
    @Autowired
    YteRepoImpl musicRepo;
    @Override
    public List<Yte> findAll() {
        return musicRepo.findAll();
    }

    @Override
    public void save(Yte yte) {
        musicRepo.save(yte);
    }
}
