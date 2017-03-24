package classDemos;

import java.util.Scanner;

public class PrintDecreasing {

	public static void printDecreasing(int n)
	{
		if(n == 0)
		{
			return;
		}
		System.out.println(n);
		printDecreasing(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner s = new Scanner(System.in);
			System.out.println("Enter a number : ");
			int n = s.nextInt();
			printDecreasing(n);
	}

}
