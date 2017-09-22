package fi.hh.server.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.hh.server.Bookstore.domain.*;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByCategoryName(String categoryName);
    
}