package exceptionDemos;

public class ExceptionsDemoCase2 {
	
	//Please do not change this code as I have written the output according to these line numbers shown on left side.
	
	public static void divideCase2(int a, int b)
	{
		try
		{
			System.out.println("I am gonna divide these!");
			int r = a/b;
			System.out.println(r);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("I am done");
	}
	
	public static void main(String[] args) {
		
		int a = 4;
		int b = 0;
		divideCase2(a, b);
		System.out.println("Good bye");
	}
	
	//Case 1 - In this case Exception will be thrown by line - 12 => it will search for appropriate handler in divideCase1 function
	// and it will find the apt handler
	
	//If you dont change the code then -
		//Lines executed - 24, 25, 26, 11, 12, 17, 19, 27
		//Lines not executed - 13
	
	//But there is a problem - Exception handling is not the work of divide function
}
