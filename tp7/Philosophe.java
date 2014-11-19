
public class Philosophe extends Thread 
{
	int _id;
	Table _table;
	
	Philosophe (int i, Table t) 
	{
		_id = i;
		_table = t;
	}
	
	public void run() 
	{
		try 
		{
			while(true) 
			{
				System.out.println("Moi, philosophe"+_id+", je desire manger !");
				_table.prendreBaguettes2(_id);
				System.out.println("Ah, moi, le philosophe "+_id+", j'ai bien mangé.");
				System.out.println("Je pense... donc je suis "+_id);
				Thread.sleep(5000);
			}
		}
		 catch (InterruptedException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
}
