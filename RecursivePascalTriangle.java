package classDemos;
import java.util.Scanner;

public class RecursivePascalTriangle {

	public static void printARow(int row, int col, int value)
	{
		if(col > row)
		{
			return;
		}
		System.out.print(value+ " ");
		value = value * (row - col)/ (col + 1);
		printARow(row, col+1, value);
	}
	
	public static void printPascal(int row)
	{
		if(row <0 )
		{
			return;
		}
		printPascal(row - 1);
		printARow(row,0,1);
		System.out.println();
	}
	
	public static void printPascal(int tr, int row, int col, int value)
	{
		if(row > tr)
		{
			return;
		}
		if(col > row){
			System.out.println();
			printPascal(tr, row + 1, 0, 1);
			return;
		}
		System.out.print(value + " ");
		value = value * (row - col)/ (col + 1);
		printPascal(tr, row, col + 1 , value);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of rows : ");
		int n = s.nextInt();
		//printPascal(n-1);
		printPascal(n - 1, 0, 0, 1);
	}

}
