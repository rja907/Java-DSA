package classDemos;

import java.util.Comparator;

class Car implements Comparable<Car>
{
	int price;
	int speed;
	Car(int p, int s)
	{
		price = p;
		speed = s;
	}
	public String toString()
	{
		return "Price : "+price + " Speed : " +speed;
	}
	
	public int compareTo(Car o) {
		return this.price - o.price;
	}
}

class Car2
{
	int price;
	int speed;
	Car2(int p, int s)
	{
		price = p;
		speed = s;
	}
	public String toString()
	{
		return "Price : "+price + " Speed : " +speed;
	}
}

class PriceComparator implements Comparator<Car2>
{
	public int compare(Car2 o1, Car2 o2) {
		return o1.price - o2.price;
	}
	
}
class SpeedComparator implements Comparator<Car2>
{
	public int compare(Car2 o1, Car2 o2) {
		return o1.speed - o2.speed;
	}
}

public class Sample {
	public static void main(String[] args)
	{
		//Cars can only be compared according to price now. 
		//If we want cars to be compared on some other criteria, we will have to modify compareTo function 
		Car c1 = new Car(10000, 200);
		Car c2 = new Car(20000, 100);
		if(c1.compareTo(c2) > 0)
		{
		//	System.out.println(c1 + " is greater");
		}
		else
		{
	//		System.out.println(c2 + " is greater");
		}
		Car2 c3 = new Car2(10000, 200);
		Car2 c4 = new Car2(20000, 100);
		if(new SpeedComparator().compare(c3, c4) > 0)
		{
			System.out.println(c1 + " is greater");
		}
		else
		{
			System.out.println(c2 + " is greater");
		}
		if(new PriceComparator().compare(c3, c4) > 0)
		{
			System.out.println(c1 + " is greater");
		}
		else
		{
			System.out.println(c2 + " is greater");
		}
	}
}	
