package classDemos;

import java.util.Scanner;

public class AllFiboLessThanN {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = s.nextInt();
		
		int prev = 0, current = 1, sum = 0;
		
		while(sum <= n)
		{
			System.out.print(sum+ " ");
			sum = prev + current;
			prev = current;
			current = sum;
		}
	}

}
