package codegym.service;

import codegym.model.Gmail;

import java.util.List;

public interface IGmailService {
    List<Gmail> findAll();
    boolean update(Gmail gmail);
    Gmail findGmail();
}
