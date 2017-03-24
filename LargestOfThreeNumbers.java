package classDemos;

import java.util.Scanner;

public class LargestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//Taking Input
		System.out.println("Enter three numbers : ");
		int first = s.nextInt();
		int second = s.nextInt();
		int third = s.nextInt();
		
		if(first >= second && first >= third)
		{
			System.out.println(first+ " is largest");
		}
		else if(second >= first && second >= third)
		{
			System.out.println(second + " is largest");
		}
		else
		{
			System.out.println(third + " is largest");
		}
		
		s.close();
	}

}
