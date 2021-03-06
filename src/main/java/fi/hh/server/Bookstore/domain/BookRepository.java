package fi.hh.server.Bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import fi.hh.server.Bookstore.domain.*;



public interface BookRepository extends CrudRepository<Book, Long>{
	 List<Book> findByTitle(String title);
}
