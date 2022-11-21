package pkg_book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;


public class BookManager implements Serializable
{
	ObjectOutputStream oos_book = null;
	ObjectInputStream ois_book = null;
	
	File book_file=new File("Books.data");
	
	ArrayList<Book> book_list =null;
	
	@SuppressWarnings("unchecked")
	public BookManager()
	{
		book_list = new ArrayList<Book>();
		
		if(book_file.exists())
		{
			try 
			{
				ois_book = new ObjectInputStream(new FileInputStream(book_file));
				book_list = (ArrayList<Book>) ois_book.readObject();
			} 
			catch (ClassNotFoundException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void listBookBySubject(String subject)
	{
		for(Book book:book_list)
		{
			if(book.getSubject().equals(subject))
				System.out.println(book);
		}
	}
	
	public void addABooks(Book book)
	{
		book_list.add(book);
    }
       
	public void viewAllBooks()
	{
		for(Book book:book_list)
			System.out.println(book);
	}
	
	public Book searchBookByIsbn(int search_isbn)
	{
		for(Book book:book_list)	
		{
			if(book.getIsbn() == search_isbn)
				return book;
		}
		return null;
	}
	
	public boolean deleteBook(int delete_isbn)
	{
		ListIterator<Book> book_iterator = (ListIterator<Book>) book_list.listIterator(); // type Casting
	    while(book_iterator.hasNext())
	    {
	    	Book book = book_iterator.next();
	    	if (book.getIsbn() == delete_isbn)
	    	{
	    		book_list.remove(book);
	    		return true;
	    	}
	    }
	    return false;
	}
	
	public boolean updateBook(int update_isbn, String title,String author,String pubsisher, int edition,String subject,int available_quantiry)
	{
		ListIterator<Book> book_iterator = (ListIterator<Book>) book_list.listIterator(); // type Casting
	    while(book_iterator.hasNext())
	    {
	    	Book book = book_iterator.next();
	    	if (book.getIsbn() == update_isbn)
	    	{
	    		book.setAuthor(author);
	    		book.setAvailable_quantiry(available_quantiry);
	    		book.setEdition(edition);
	    		book.setPubsisher(pubsisher);
	    		book.setSubject(subject);
	    		book.setTitle(title);
	    		return true;
	    	}
	    }
	    return false;
	}
	
	public void writeToFile()
	{
		try {
			oos_book = new ObjectOutputStream(new FileOutputStream(book_file));
			oos_book.writeObject(book_list);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}












