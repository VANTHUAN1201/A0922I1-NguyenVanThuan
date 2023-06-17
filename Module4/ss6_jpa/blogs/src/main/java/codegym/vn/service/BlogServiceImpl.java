package codegym.vn.service;

import codegym.vn.entity.Blog;
import codegym.vn.repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository repository;

    @Override
    public boolean create(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        if (repository.existsById(blog.getId())){
            repository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return false;
    }

    @Override
    public List<Blog> findBlogByName(String name) {
        return repository.findBlogByNameContaining(name);
    }
}
