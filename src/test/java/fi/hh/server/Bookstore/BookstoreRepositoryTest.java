package fi.hh.server.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.server.Bookstore.*;
import fi.hh.server.Bookstore.domain.*;
import fi.hh.server.Bookstore.web.*;

@RunWith(SpringRunner.class)
@DataJpaTest

public class BookstoreRepositoryTest {
	 @Autowired
	    private BookRepository repository;
	 
	 @Test
	    public void createNewBook() {
	    	Book book1 = new Book("Harry Potter", "JKRowling", 2000, "H123", 20, new Category("Thriller"));
	    	Book book2 = new Book("Call of the wild", "Jack London", 1903, "C456", 25, new Category("Thriller"));
	    	repository.save(book1);
	    	repository.save(book2);
	    	assertThat(book1.getId()).isNotNull();
	    }    
	 
	 @Test
	    public void findByTitleShouldReturnBook() {
	        List<Book> books = (List<Book>)repository.findAll();
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getTitle()).isEqualTo("Title 1");
	    }
	    
	    
}
