package classDemos;

abstract class Bank
{
	private int crr;
	private int repoRate;
	
	public Bank()
	{
		crr = 25;
		repoRate = 10;
		System.out.println("Bank : ctor");
	}
	public void commonInformation()
	{
		System.out.println("All india banks association meeting on : 8th oct, 2016");
		System.out.println("Blah blah");
	}
	
	public final int getCrr()
	{
		return crr;
	}
	
	public final int getRepoRate()
	{
		return repoRate;
	}
	
	public abstract int roI();
	
}
class ICICI extends Bank
{
	private int rate;

	public ICICI()
	{
		 rate = 8;	
		 System.out.println("ICICI : ctor");
	}
	@Override
	public int roI() {
		return rate;
	}
	
}

class HDFC extends Bank
{

	//Not allowed to override final methods
	/*public int getRepoRate()
	{
		return 0;
	}*/
	private int rate;
	
	public HDFC()
	{
		 rate = 9;	
		 System.out.println("HDFC : ctor");
	}
	
	@Override
	public int roI() {
		return rate;
	}
	
}
public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICICI obj = new ICICI();
		
		System.out.println(obj.roI());
		obj.commonInformation();
		System.out.println(obj.getCrr());
	}

}
