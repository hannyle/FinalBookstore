package fi.hh.server.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.server.Bookstore.domain.User;
import fi.hh.server.Bookstore.domain.UserRepository;
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
		public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
			return (args) -> {
				log.info("save a couple of books");
				
				crepository.save(new Category("Horror"));
				crepository.save(new Category("Romantic"));
				crepository.save(new Category("Thriller"));
				
				
				repository.save(new Book("Title 1", "Author 1", 1999, "12121", 5, crepository.findByCategoryName("Horror").get(0)));
				//repository.save(new Book());	
				// Create users: admin/admin user/user
				User user1 = new User("user", "$2a$06$Y5B/lHICNa.rkUkPd5wBiusAnIoRRy0uyZuL7YzYSY6777eM/q8tW", "USER");
				User user2 = new User("admin", "$2a$06$fHSgh0YAj8/FFyyYkTlY/eyHGPO31ft.H3RS7kt1Zph7JqcYoInvq", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
				
				
				log.info("fetch all books");
				for (Book thisBook : repository.findAll()) {
					log.info(thisBook.toString());
				}

			};
	
	
	
	
	
	}
}
