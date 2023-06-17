package codegym.vn.repo;

import codegym.vn.entity.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog,Integer> {
    List<Blog> findBlogByNameContaining(String name);
}
