/**
 * @author chadrobbins - cerobbins@dmacc.edu
 * CIS 175 - Spring 2022
 * Sep 9, 2022
 */
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Chad Robbins - cerobbins
 * CIS175 - Fall 2021
 * Sep 9, 2022
 */
@Entity
@Table(name="Books")
public class ListBooks {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name= "Title")
	private String name;
	@Column(name= "Author")
	private String author;
	@Column(name= "Genre")
	private String genre;
	@Column(name= "PageCount")
	private int pageCount;
	
	/**
	 * Default no-arg constructor
	 */
	public ListBooks() {
		super();
	}
	
	/**
	 * Full constructor
	 * @param name
	 * @param author
	 * @param genre
	 * @param pageCount
	 */
	public ListBooks(String name, String author, String genre, int pageCount) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.pageCount = pageCount;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	/**
	 * Print method
	 * @return string with all fields
	 */
	public String returnBookDetails() {
		return this.id + ": " + this.name + " by " + this.author + ": " + this.genre + ": " + this.pageCount + " pages.";
	}
}
