package exceptionDemos;

public class ExceptionsDemoCase3 {
	
	//Please do not change this code as I have written the output according to these line numbers shown on left side.
	
	//Best solution
	
	public static void divideCase3(int a, int b) throws Exception
	{
		if(b == 0)
		{
			throw new Exception("Denominator is zero!");
		}
		else
		{
			int r = a/b;
			System.out.println(r);
			System.out.println("I am done");
		}
	}
	
	public static void main(String[] args) {
		
		int a = 4;
		int b = 0;
		try
		{
			divideCase3(a, b);
			System.out.println("I will not be printed if exception occurs");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("Good bye");
	}
	
	//Case 1 - In this case Exception will be thrown by line - 11 => it will search for appropriate handler in divideCase1 function
	// then it will search in main and find there
	
	//If you dont change the code then -
		//Lines executed - 23, 24, 25, 26, 27, 9, 10, 11, 30, 31, 32, 33, 34
		//Lines not executed - 28, 13, 14, 15, 16, 17, 18
}
