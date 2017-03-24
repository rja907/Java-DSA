package classDemos;

import java.util.Scanner;

public class PowerCalculator {

	public static int power(int x,int n)
	{
		if(n == 1)
		{
			return x;
		}
		return x * power(x, n-1);
	}
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter a number: ");
		int x = s.nextInt();
		System.out.println("Enter power : ");
		int n = s.nextInt();
		System.out.println(x+" raised to power "+n+" is : "+power(x,n));
	}

}
