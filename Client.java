package classDemos;

public class Client {

	public static int fib(int n)
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		int val1 = fib(n-1);
		int val2 = fib(n-2);
		return val1 + val2;
	}
	public static int fib2(int n, int[] storage)
	{
		if(storage[n] == 0)
		{
			if(n == 0 || n == 1)
			{
				storage[n] = n;
				return storage[n];
			}
			int retVal = 0;
			int val1 = fib2(n-1, storage);
			int val2 = fib2(n-2, storage);
			retVal = val1 + val2;
			storage[n] = retVal;
		}
		return storage[n];
	}
	
	public static int editDistance(String str1, String str2)
	{
		if(str1.length() == 0)
		{
			return str2.length();
		}
		else if(str2.length() == 0)
		{
			return str1.length();
		}
		if(str1.charAt(0) == str2.charAt(0))
		{
			return editDistance(str1.substring(1), str2.substring(1));
		}
		else
		{
			int replacementCost = 1 + editDistance(str1.substring(1), str2.substring(1));
			int additionCost = 1 + editDistance(str1.substring(1), str2);
			int removalCost = 1 + editDistance(str1, str2.substring(1));
			
			return Math.min(replacementCost, Math.min(additionCost, removalCost));
		}
	}
	public static int editDistance(String str1, String str2, int[][] storage)
	{
		if(str1.length() == 0)
		{
			return str2.length();
		}
		else if(str2.length() == 0)
		{
			return str1.length();
		}
		if(storage[str1.length()][str2.length()] != 0)
		{
			return storage[str1.length()][str2.length()];
		}
		else
		{
			int rv = 0;
			if(str1.charAt(0) == str2.charAt(0))
			{
				rv =  editDistance(str1.substring(1), str2.substring(1));
			}
			else
			{
				int replacementCost = 1 + editDistance(str1.substring(1), str2.substring(1), storage);
				int additionCost = 1 + editDistance(str1.substring(1), str2, storage);
				int removalCost = 1 + editDistance(str1, str2.substring(1), storage);
				
				rv = Math.min(replacementCost, Math.min(additionCost, replacementCost));
			}
			storage[str1.length()][str2.length()] = rv;
			return rv;
		}
	}
	
	public static int lcs(String str1, String str2)
	{
		if(str1.length() == 0 || str2.length() == 0)
		{
			return 0;
		}
		if(str1.charAt(0) == str2.charAt(0))
		{
			return 1 + lcs(str1.substring(1), str2.substring(1));
		}
		else
		{
			int factor1 = lcs(str1, str2.substring(1));
			int factor2 = lcs(str1.substring(1), str2);
			return Math.max(factor1, factor2);
		}
	}
	
	public static void main(String[] args) {

	}

}
