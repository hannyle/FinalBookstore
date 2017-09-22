package fi.hh.server.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.server.Bookstore.domain.*;
import fi.hh.server.Bookstore.domain.BookRepository;
import fi.hh.server.Bookstore.domain.Category;
import fi.hh.server.Bookstore.domain.Book;
import fi.hh.server.Bookstore.domain.CategoryRepository;


@SpringBootApplication


public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
		@Bean
		public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
			return (args) -> {
				log.info("save a couple of books");
				
				crepository.save(new Category("Horror"));
				crepository.save(new Category("Romantic"));
				crepository.save(new Category("Thriller"));
				
				
				//repository.save(new Book("Title 1", "Author 1", 1999, "12121", 5, crepository.findByCategoryName("Horror").get(0)));
				//repository.save(new Book());	
				
				
				
				log.info("fetch all books");
				for (Book thisBook : repository.findAll()) {
					log.info(thisBook.toString());
				}

			};
	
	
	
	
	
	}
}
