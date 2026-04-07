package oosd3;

public class Main {
	
	public static void main(String[]args)
	{
		//object created
		Repository repository = new Repository();
		
		//both use the same objects
		//creates threads 
		Counter counter = new Counter(repository);
		Publisher publisher = new Publisher(repository);
		
		counter.start();
		publisher.start();
	}

}

//shared space