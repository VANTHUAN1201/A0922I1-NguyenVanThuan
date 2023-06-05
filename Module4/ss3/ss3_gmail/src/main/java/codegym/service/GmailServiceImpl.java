package codegym.service;

import codegym.model.Gmail;
import codegym.repository.GmailRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GmailServiceImpl implements IGmailService {
    @Autowired
    GmailRepoImpl gmailRepo;
    @Override
    public List<Gmail> findAll() {
        return gmailRepo.findAll();
    }

    @Override
    public boolean update(Gmail gmail) {
        return gmailRepo.update(gmail);
    }

    @Override
    public Gmail findGmail() {
        return gmailRepo.findGmail();
    }
}
