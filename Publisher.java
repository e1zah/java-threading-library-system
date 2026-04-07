package oosd3;

public class Publisher extends Thread {
	
	//stpres instance variable for thread to use
	private Repository repository;
	
	public Publisher(Repository repository)
	{
		this.repository =repository;
	}
	
	public void run()
	{
		
		while(true) {
		repository.getValue();//calls method in repository
			
		
	}

}
	
	
}
//reads number and -> counter
