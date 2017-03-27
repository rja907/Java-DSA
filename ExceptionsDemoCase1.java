package exceptionDemos;

public class ExceptionsDemoCase1 {
	
	//Please do not change this code as I have written the output according to these line numbers shown on left side.
	
	public static void divideCase1(int a, int b)
	{
		int r = a/b;
		System.out.println(r);
	}
	public static void main(String[] args) {
		
		int a = 4;
		int b = 0;
		divideCase1(a, b);
		System.out.println("Good bye");
	}
	
	//Case 1 - In this case Exception will be thrown by line - 9 => it will search for appropriate handler in divideCase1 function
	// but it will not find, then it will search for appropriate handler in main function, it will not find there also => JVM will 
	//ultimately handle the exception
	
	//If you dont change the code then -
		//Lines executed - 14,15,16,9
		//Lines not executed - 10,17
}
