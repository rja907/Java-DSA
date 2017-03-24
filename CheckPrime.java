package classDemos;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter number : ");
		int n = s.nextInt();
		
		int i = 2;
		boolean flag = false;
		while(i < n)
		{
			if(n % i == 0)
			{
				flag = true;
				break;
			}
			i = i + 1; 
		}
		if(flag == true)
		{
			System.out.println(n+" is not Prime");
		}
		else
		{
			System.out.println(n + " is prime");
		}
	}

}
