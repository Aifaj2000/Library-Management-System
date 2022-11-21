package pkg_main;

import java.util.Scanner;

import pkg_book.Book;
import pkg_book.BookManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transaction.BookTransactionManager;

public class Main 
{
	public static void main(String[] args)
	{
		int choice;
        
       Scanner sc =new Scanner(System.in);
       
       BookManager bm=new BookManager();
       StudentManager sm=new StudentManager();
       BookTransactionManager btm=new BookTransactionManager();
       
       do
       {
    	   System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if you want to Exit");
    	   choice =sc.nextInt();
    	   
    	   if(choice == 1) // if user is Student
    	   {
    		   System.out.println("Enter Your Roll Number");
    		   int rollNo = sc.nextInt();
    		   try 
    		   {
    		   Student s=sm.get(rollNo);
    		   if(s==null)
    			   throw new StudentNotFoundException();
    		   int student_choice;
    		   do 
    		   {
    			   System.out.println("Enter 1 to View All Book\nEnter 2 to Search Book"
    			   + " By isbn\nEnter 3 to Search Book By Subject\nEnter 4 to Issue a Book\nEnter 99 to Exist");
    			   student_choice=sc.nextInt();
    			   switch(student_choice) 
    			   {
    			       case 1:
    				       System.out.println("All the Book Records are");
    				       bm.viewAllBooks();
    			           break;
    			       case 2:
    			    	   System.out.println("Please Enter ISBN To Search Book");
    			    	   int search_isbn =sc.nextInt();
    			    	   Book book = bm.searchBookByIsbn(search_isbn);
    			    	   if(book == null)
    			    		   System.out.println("No Book with this ISBN Exists in Our Library");
    			    	   else
    			    		   System.out.println(book);
    			    	   break;
    			       case 3:
    			    	   System.out.println("Enter the Subject to Serach");
    			    	   sc.nextLine();
    			    	   String search_subject =sc.nextLine();
    			    	   bm.listBookBySubject(search_subject);
    			    	   break;
    			       case 4:
    			    	   System.out.println("Enter the ISBN to Issue a Book");
    			    	   int issue_isbn = sc.nextInt();
    			    	   book = bm.searchBookByIsbn(issue_isbn);
    			    	  try { 
    			    	   if(book == null) {
    			    		   throw new BookNotFoundException();
    			    	   }
    			    	   if(book.getAvailable_quantity() > 0)
    			    	   {
    			    		   if(btm.issueBook(rollNo, issue_isbn))
    			    		   {
    			    			   book.setAvailable_quantiry(book.getAvailable_quantity() - 1);
    			    			   System.out.println("Book Has Been Issued");
    			    		   }
    			    	   }
    			    	   else
    			    	   {
    			    		   System.out.println("The Book has Been Issued");
    			    	   }
    			    	  }
    			    	   catch(BookNotFoundException bnfe)
    			    	   {
    			    		   System.out.println(bnfe);
    			    	   }
    			    	   
    			    	   break;
    			    	   
    			       case 5:
    			    	   System.out.println("Please Enter the ISBN to Issue a Book");
    			    	   int return_isbn = sc.nextInt();
    			    	   book = bm.searchBookByIsbn(return_isbn);
    			    	   if(book != null) 
    			    	   {
    			    		  if(btm.returnBook(rollNo, return_isbn))
    			    		  {
    			    			  book.setAvailable_quantiry(book.getAvailable_quantity() + 1);
    			    			  System.out.println("Thank Tou for Returning the Book");
    			    		  }
    			    		  else
    			    			  System.out.println("Could Not Return the Book");
    			    	   }
    			    	   else
    			    		   System.out.println("Bookk with this ISBN Does not Exists");
    			    	   break;
    			       case 99:
    			    	   System.out.println("Thank You For Using Library");
    			    	   break;
    			       default:
    			    	   System.out.println("Invalid Choice");
	 
    			   }
    		   }
    		   while(student_choice !=99);
    		   }
    		   catch(StudentNotFoundException snfe)
    		   {
    			   System.out.println(snfe);
    		   }
    			   
    	   }
    	   else if(choice == 2) // user is Librarian
    	   {
    		   int lib_choice;
    		   do{
    		   System.out.println("Enter 11 to View all Student\nEnter 12 to print a Student by Roll Number"
    		  		+ "\nEnter 13 to Regester a Student\nEnter 14 to Update a Student\nEnter 15 to Delete a Student");
    		   System.out.println("Enter 21 to View all Books\nEnter 22 to print a Book by ISBN"
      		  		+ "\nEnter 23 to Add a New Book\nEnter 24 to Update a Book\nEnter 25 to Delete a Book");
    		  System.out.println("Enter 31 to View all Transactions");
      		  System.out.println("Enter 99 to Exit");
      		  lib_choice = sc.nextInt();
      		  switch(lib_choice) {
      		  case 11: // view all students
      			  System.out.println("All the Student Records");
      			  sm.viewAllStudent();
      			  break;
      		  case 12: // search a student based on roll number
      			  System.out.println("Enter Roll Number to Fetch Student's Records");
      			  int get_rollNo = sc.nextInt();
      			  Student student = sm.get(get_rollNo);
      			  if(student == null)
      			  {
      				  System.out.println("No Records Matches this Roll Number");
      			  }
      			  else
      				  System.out.println(student);
      			  break;
      		  case 13: // Adding a Student
      			  System.out.println("Enter Student Details to Add");
      			  String name;
      			  String emailId;
      			  String phoneNumber;
      			  String address;
      			  String dob;
      			  int rollno;
      			  int std;
      			  String division;
      			  sc.nextLine();
      			  System.out.println("Name");
      			  name =sc.nextLine();
      			  System.out.println("EmailId");
    			  emailId =sc.nextLine();
    			  System.out.println("Phone Number");
      			  phoneNumber =sc.nextLine();
      			  System.out.println("Address");
    			  address =sc.nextLine();
    			  System.out.println("Date of Birth");
      			  dob =sc.nextLine();
      			  System.out.println("Roll Number as Integer");
    			  rollno =sc.nextInt();
    			  System.out.println("Standard as Integer");
      			  std =sc.nextInt();
      			  sc.nextLine();
      			  System.out.println("Division");
    			  division =sc.nextLine();
    			  
    			  student = new Student(name,emailId,phoneNumber,address,dob,rollno,std,division);
    			  sm.addAStudent(student);;
    			  System.out.println("Student is Added");
    			  break;
      	      case 14: // Update a Student
      	    	  System.out.println("Enter The Roll Number to Modify the Records");
      	    	  int modify_rollNo;
      	    	  modify_rollNo = sc.nextInt();
      	    	  student = sm.get(modify_rollNo);
      	    	  try {
					if(student == null)
						  throw new StudentNotFoundException();
					  
					  sc.nextLine();
					  System.out.println("Name");
					  name =sc.nextLine();
					  
					  System.out.println("EmailId");
					  emailId =sc.nextLine();
					  
					  System.out.println("Phone Number");
					  phoneNumber =sc.nextLine();
					  
					  System.out.println("Address");
					  address =sc.nextLine();
					  
					  System.out.println("Date of Birth");
					  dob =sc.nextLine();
					  
					  System.out.println("Roll Number as Integer");
					  rollno =sc.nextInt();
					  
					  System.out.println("Standard as Integer");
					  std =sc.nextInt();
					  
					  sc.nextLine();
					  
					  System.out.println("Division");
					  division =sc.nextLine();
					  
					  sm.updateStudent(modify_rollNo, name, emailId, phoneNumber, address, dob, std, division);
					  System.out.println("Studentt Record is Updated");
				} 
      	    	  catch (StudentNotFoundException snfe) 
      	    	  {
					System.out.println(snfe);
				  }
      	    	  break;
      	    	  
      		  case 15: // to Delete Student
      			  System.out.println("Enter The Roll Number to Delete the Records");
    	    	  int delete_rollNo;
    	    	  delete_rollNo = sc.nextInt();
    	    	  if(sm.deleteStudent(delete_rollNo))
    	    		  System.out.println("Student Record is Removed");
    	    	  else
    	    		  System.out.println("No Records with Given Roll Number Exists");
    	    	  break;
      		  case 21: //  view all books
      			  bm.viewAllBooks();
      			  break;
      		  case 22: // search a Book by ISBN
      			  int search_isbn;
      			  System.out.println("Enter ISBN of the Book to Search");
      			  search_isbn=sc.nextInt();
      			  Book book=bm.searchBookByIsbn(search_isbn);
      			  if(book == null)
      				  System.out.println("No Book with this ISBN Exists in our Library ");
      			  else
      				  System.out.println(book);
      			  
      			  break;
      		  case 23: // Add a Book
      			  System.out.println("Please Enter Book Details to Add");
      			  int isbn;
      			  String title;
      			  String author;
      			  String Publisher;
      			  int edition;
      			  String subject;
      			  int available_quantiry;
      			 
      			  System.out.println("ISBN");
      			  isbn = sc.nextInt();
      			  
      			  sc.nextLine();
      			  
      			  System.out.println("Title");
      			  title = sc.nextLine();
      			  
      			  System.out.println("Author");
     			  author = sc.nextLine();
      			  
     			  System.out.println("Publisher");
     			  Publisher = sc.nextLine();
      			  
     			  System.out.println("Edition");
    			  edition = sc.nextInt();
    			  
    			  sc.nextLine();
    			  
    			  System.out.println("Subject");
     			  subject = sc.nextLine();
     			  
     			  System.out.println("Quantity");
     			  available_quantiry = sc.nextInt();
     			  
     			  book = new Book(isbn,title,author,Publisher,edition,subject,available_quantiry);
     			  bm.addABooks(book);
      			  System.out.println("A Book Record is Added");
      			  break;
      			  
      		  case 24: // update a record of book
      			  System.out.println("Please Enter the ISBN to update the record");
      			  int update_isbn;
      			  update_isbn=sc.nextInt();
      			  try
      			  {
      				  book = bm.searchBookByIsbn(update_isbn);
      				  if(book == null)
      					  throw new BookNotFoundException();
      				 
          			  System.out.println("Enter Book Details to Modify");
          			  sc.nextLine();
          			  
          			  System.out.println("Title");
          			  title = sc.nextLine();
          			  
          			  System.out.println("Author");
         			  author = sc.nextLine();
          			  
         			  System.out.println("Publisher");
         			  Publisher = sc.nextLine();
          			  
         			  System.out.println("Edition");
        			  edition = sc.nextInt();
        			  
        			  sc.nextLine();
        			  
        			  System.out.println("Subject");
         			  subject = sc.nextLine();
         			  
         			  System.out.println("Quantity");
         			  available_quantiry = sc.nextInt();
         			  
         			  bm.updateBook(update_isbn, title, author, Publisher, edition, subject, available_quantiry);
         			  
      			  }
      			  catch(BookNotFoundException bnfe)
      			  {
      				  System.out.println(bnfe);
         			  
      			  }
     			  break;
     			  
      		  case 25: // delete a record of book
      			  System.out.println("Please Enter the ISBN to Delete the Record ");
      			  int delete_isbn;
    			  delete_isbn=sc.nextInt();
    			  try
    			  {
    				  book = bm.searchBookByIsbn(delete_isbn);
    				  if(book == null)
    					  throw new BookNotFoundException();
    				  bm.deleteBook(delete_isbn);
    				  System.out.println("Book Record is Deleted");
    			  }
    			  catch(BookNotFoundException bnfe)
    			  {
    				  System.out.println(bnfe);
    			  }
    			  break;
    			  
      		  case 31: //To view all Transaction
      			  System.out.println("All The Transaction Are");
      			  btm.showAll();
      			  	  
      		  case 99:
      			System.out.println("Thank You For Using Library");
		    	   break;
		      default:
		    	   System.out.println("Invalid Choice");
    	    	  
      			  
      		  }
      		  
    		 }while(lib_choice !=99);
         }
    	   
    	 
       }
       while(choice != 3);
       sm.writeToFile();
       bm.writeToFile();
       btm.writeToFile();
       sc.close();
	}

}














