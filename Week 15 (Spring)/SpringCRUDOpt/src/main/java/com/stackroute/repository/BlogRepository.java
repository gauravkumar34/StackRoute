package com.stackroute.repository;

/* Add annotation to declare this class as a Repository class.
This interface should extend CRUD Repository
* */

import com.stackroute.domain.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository  extends CrudRepository<Blog, Integer> {
}
