package classDemos;


public class FactorialCalculation {

	public static int factorial(int n)
	{
		if(n == 0)
		{
			return 1;
		}
		return n * factorial(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long fact = factorial(4);
		System.out.println(fact);
	}

}
