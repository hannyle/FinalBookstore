package fi.hh.server.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long categoryId;
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {}

	
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}


	public Long getCategorytId() {
		return categoryId;
	}

	public void setCategorytId(Long categorytId) {
		this.categoryId = categorytId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [categorytId=" + categoryId + ", categoryName=" + categoryName + ", books=" + books + "]";
	}
	
		
}
