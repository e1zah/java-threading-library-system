package oosd3;

import java.util.ArrayList;

public class Library {
	
	//instance variable stores a collection of book objs
	private ArrayList<Book> books;
	
	public Library()
	{
		//creates an empty arraylist for book objs
		books = new ArrayList<>();
	}
	
	//A method called findBookIndex that searches the Book collection for a book using the
	//given an ISBN (String) as a parameter and returns the index (int) of the collection
	//where the book is located or -1 if not found.
	public synchronized int findBookIndex(String isbn)
	{
		int index =0; 
		for (Book b : books)
		{
			if(b.getIsbn().equals(isbn))
			{
				return index;
			}
			index++;
		}
		return -1;
	
	}
	
	//A method called loanBook which loans a Book by removing it from the collection
	//using the given index (int) parameter and returns it (Book). It returns null if the book
	//is not in the collection
	
	public synchronized Book loanBook(int index)
	{
		if(index >=0 && index< books.size())
		{
			Book loanedBook = books.remove(index);
			
			//removed book is returned 
			return loanedBook;
		}
		//returns null if the book is not in the collection	
		return null;
	}
	
	public synchronized void addBook(Book book)
	{
		books.add(book);
	}
	
	//A method called returnBook which adds the given Book (parameter) back into the
	//collection.
	
	public synchronized void returnBook(Book book)
	{
		//add a book to the arraylist
		books.add(book);
		
		System.out.println(book.getIsbn() +" is returned");
	}

	public static void main(String[]args)
	{
		//create a library
		Library library = new Library();
		
		//create Book
		Book book1 = new Book("Joe", "Bloggs", "Ab11228", 2023);
		
	library.addBook(book1);
	
	Member member1 = new Member("Hannah", library, "Ab11228");
	Member member2 = new Member("Jake", library, "Ab11228");
	
	member1.start();
	member2.start();

	}
}

//holds a collections of books with the arraylist
//synchronization = thread safety