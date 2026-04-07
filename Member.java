package oosd3;

public class Member extends Thread{
	
	//library instance variable
	private Library library;
	
	//hardcoded isbn
	private String isbn = "Ab11228";
	
	public Member(String name,Library library, String isbn)
	{
		super(name);
		this.library = library;
		this.isbn = isbn;
	}
	
	public void run()
	{
		//calls the libray methos "" with the isbn
		//returns posiyion, if not found -1
		int index = library.findBookIndex(isbn);
		
		//If index is valid removes the book from the library and returns it.
		Book book = library.loanBook(index);
		
		if( book != null)
		{
			System.out.println(getName() + "book loaned" + book);
			
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		
		library.returnBook(book);
		System.out.println(getName() + "book returned" + book);
	
		}else {
		System.out.println(getName() + "book cannot be loaned");
	}

}
	}
