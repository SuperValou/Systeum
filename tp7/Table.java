

public class Table 
{
	int _taille;
	Object _baguettes[];
	int nbPhiloATable = 0;
	
	Table(int t) 
	{
		_taille = t;
		_baguettes = new Object[_taille];
		for (int i = 0; i < _taille; i++) 
		{
			_baguettes[i]= new Object();
		}
	}
	
	void prendreBaguettes(int i) throws InterruptedException 
	{
		synchronized(this) // wait doit être dans un bloc synchronized
		{
			while (nbPhiloATable==_taille-1) // while au lieu de if, pour revérifier la condition apres le réveil.
			{
				this.wait();
			}
			nbPhiloATable++;
		}
		synchronized (_baguettes[i]) // garanti l'accès exclusif à cet objet
		{
			Thread.sleep(100);
			System.out.println("J'ai la baguette "+ i);
			synchronized (_baguettes[(i+1)%_taille])
			{
				Thread.sleep(100);
				System.out.println("J'ai aussi la baguette "+ (i+1)%_taille +", haha.");
			}
		}
		System.out.println("Du coup, moi, le philosophe "+i+", je mange !");
		Thread.sleep(5000);
		synchronized(this) 
		{
			nbPhiloATable--;
			notify();
		}
	}


	void prendreBaguettes2(int i) throws InterruptedException 
	{
		if(i%2==1){
			synchronized (_baguettes[i]) // garanti l'accès exclusif à cet objet
			{
				Thread.sleep(100);
				System.out.println("J'ai la baguette "+ i);
				synchronized (_baguettes[(i+1)%_taille])
				{
					Thread.sleep(100);
					System.out.println("J'ai aussi la baguette "+ (i+1)%_taille +", haha.");
				}
			}
		}
		else if(i%2==0){
			synchronized (_baguettes[(i+1)%_taille]) // garanti l'accès exclusif à cet objet
			{
				Thread.sleep(100);
				System.out.println("J'ai la baguette "+ (i+1)%_taille);
				synchronized (_baguettes[i])
				{
					Thread.sleep(100);
					System.out.println("J'ai aussi la baguette "+ i+", haha.");
				}
			}
		}
		System.out.println("Du coup, moi, le philosophe "+i+", je mange !");
		Thread.sleep(5000);
		
	}


}
