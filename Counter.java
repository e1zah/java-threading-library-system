package oosd3;

public class Counter extends Thread{
	
	private Repository repository;
	
	public Counter(Repository repository)
	{
		this.repository=repository;
	}

	
	public void run()
	{
		int count = 0;
		
		//infinite loop
		while(true)
		{
			repository.setValue(count);
			count++;
			
		
	}
}
}

//thread that produces numbers 
// repository -> infintie loop
//stores number -> publisher