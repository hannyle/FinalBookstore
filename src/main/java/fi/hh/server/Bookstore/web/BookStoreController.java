package fi.hh.server.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.server.Bookstore.domain.Book;
import fi.haagahelia.course.domain.Student;
import fi.hh.server.Bookstore.domain.*;
import fi.hh.server.Bookstore.domain.BookRepository;

@Controller
public class BookStoreController {
	@Autowired
	private BookRepository repository; 
	
	@Autowired
	private CategoryRepository crepository;
	
	//Show all books
	
    @RequestMapping(value="/booklist")
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
 // RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    

    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }     
 
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	repository.delete(id);
        return "redirect:./booklist";
    }  
    
    @RequestMapping(value = "/edit/{id}")
    public String addBook(@PathVariable("id") Long id, Model model){
    	model.addAttribute("book", repository.findOne(id));
    	return "editbook";
    }
}