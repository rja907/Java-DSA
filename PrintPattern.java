package classDemos;

import java.util.Scanner;

public class PrintPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of rows : ");
		int n = s.nextInt();
		
		int row = 1,col = 1;
		int value = 1;
		
		while(row <= n)
		{ 
			col = 1;
			while(col <= row)
			{
				System.out.print(value);
				value = value + 1;
				col = col + 1;
			}
			System.out.println();
			row = row + 1;
		}
	}	

}
