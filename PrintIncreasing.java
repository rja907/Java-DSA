package classDemos;

import java.util.Scanner;

public class PrintIncreasing {

	public static void printIncreasing(int n)
	{
		if(n == 0)
		{
			return;
		}
		printIncreasing(n-1);
		System.out.println(n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner s = new Scanner(System.in);
			System.out.println("Enter a number : ");
			int n = s.nextInt();
			printIncreasing(n);
	}

}
