package oosd3;


//Repository class acts as the shared class b/w counter+ publisher
public class Repository {
	
	//stores number shared b/w threads
	private int value;
	
	// if num is available trye = num
	private boolean num = false;
	
	
	//one thread at a time
	public synchronized void setValue(int value)
	{
		try
		{
			while(num) {//waits to see if a num is available
				wait(); //releases lock and waits, puts current thread to sleep
			}
		
			//stores a new value
		this.value = value;
		
		//sees if num is available
		num = true;
		notifyAll();//wakes up the object
	} catch (InterruptedException e) {
        e.printStackTrace();
    }
		
	}

	public synchronized void getValue()
	{

		try
		{
			while(!num) {
				wait();//pause + release
			}
			
			System.out.println("Published: " + value);

	        //mark the repository as empty
		num = false;
		notifyAll  ();//wakes up a thread that is waiting
		

	} catch (InterruptedException e) {
        e.printStackTrace();
    }
        // Return the number retrieved from the repository
		
	}
	
}

//stores a single inetger
