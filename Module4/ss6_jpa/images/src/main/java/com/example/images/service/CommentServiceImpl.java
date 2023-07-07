package com.example.images.service;

import com.example.images.entity.Comment;
import com.example.images.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class CommentServiceImpl implements CommentService{
   @Autowired
   private CommentRepository repository;
    @Override
    public boolean create(Comment comment) {
        comment.setDate();
        repository.save(comment);
        return true ;
    }

    @Override
    public boolean update(Comment comment) {
        if (repository.existsById(comment.getId())){
            comment.setLikes(comment.getLikes()+1);
            repository.save(comment);
        }
        return false;
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public Comment findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
