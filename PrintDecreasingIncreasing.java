package classDemos;

import java.util.Scanner;

public class PrintDecreasingIncreasing {

	public static void printDecreasingIncreasing(int n)
	{
		if(n == 0)
		{
			System.out.print(n+" ");
			return;
		}
		System.out.print(n+" ");
		printDecreasingIncreasing(n-1);
		System.out.print(n+" ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner s = new Scanner(System.in);
			System.out.println("Enter a number : ");
			int n = s.nextInt();
			printDecreasingIncreasing(n);
	}

}
