package pkg_book;

import java.io.Serializable;

public class Book implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int isbn;
	private String title;
	private String author;
	private String Publisher;
	private int edition;
	private String subject;
	private int available_quantity;
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubsisher() {
		return Publisher;
	}
	public void setPubsisher(String Publisher) {
		this.Publisher = Publisher;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getAvailable_quantity() {
		return available_quantity;
	}
	public void setAvailable_quantiry(int available_quantiry) {
		this.available_quantity = available_quantiry;
	}
    
	public Book(int isbn, String title, String author, String Publisher, int edition, String subject,int available_quantiry) 
	{
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.Publisher = Publisher;
		this.edition = edition;
		this.subject = subject;
		this.available_quantity = available_quantiry;
	}
	public Book() 
	{
		super();
	}
	@Override
	public String toString() 
	{
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", pubsisher=" + Publisher
				+ ", edition=" + edition + ", subject=" + subject + ", available_quantiry=" + available_quantity + "]";
	}
	
	
	
}









