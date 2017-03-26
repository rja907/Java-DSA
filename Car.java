package carDemos;

public class Car {

	private String name;
	private int speed;
	public final String color;
	
	private static String manufacturerName = "Maruti";
	
	public static final int maxSpeedLimit = 150;
	
	public Car(String n, int s, String c)
	{
		this.name = n;
		this.speed = s;
		this.color = c;
	}
	public String getManufacturerName()
	{
		return manufacturerName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int s)
	{
		if(s > 150)
		{
			//throw error somehow
		}
		speed = s;
	}
	public void startCar()
	{
		System.out.println("Car started!");
		speed = 10;
	}
	
	public void accelerate(int s)
	{
		speed += s;
	}
	
	public void decelerate(int s)
	{
		speed -= s;
	}
	
	public void stopCar()
	{
		System.out.println("Car stopped!");
		speed = 0;
	}
	
	public void displayMe()
	{
		System.out.println("Name : " + name + " Speed : "+speed);
	}
	
}

