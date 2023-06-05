package codegym.repository;

import codegym.model.Gmail;

import java.awt.*;
import java.util.List;

public interface IGmailRepo {
    List<Gmail> findAll();
    boolean update(Gmail gmail);
    Gmail findGmail();

}
