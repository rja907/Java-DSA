package classDemos;

import java.util.HashMap;

public class Sample {

	public static String appendTest(int n)
	{
		String retVal = "";
		long start = System.currentTimeMillis();
		for(int i = 1; i <= n; i++)
		{
			retVal += "Hi";
		}
		long end = System.currentTimeMillis();
		System.out.println("String time : " + (end - start));
		return retVal;
	}
	public static String appendTestFaster(int n)
	{
		StringBuffer sb = new StringBuffer();
		long start = System.currentTimeMillis();
		for(int i = 1; i <= n; i++)
		{
			sb.append("Hi");
		}
		long end = System.currentTimeMillis();
		System.out.println("String Buffer time : " + (end - start));
		return sb.toString();
	}
	public static int boyerMoorePatternMatching(String str, String pattern)
	{
		int index = -1;
		HashMap<Character, Integer> patternMap = new HashMap<>();
		int n = str.length();
		int m = pattern.length();
		int i = 0;
		for(int j = 0; j < m; j++)
		{
			patternMap.put(pattern.charAt(j), j);
		}
		while(i < n - m)
		{
			int j = m - 1;
			while(j >= 0)
			{
				if(str.charAt(i + j) != pattern.charAt(j))
				{
					Character mismatch = str.charAt(i + j); 
					if(!patternMap.containsKey(mismatch))
					{
						i = i + j + 1;
					}
					else
					{
						int psi = patternMap.get(mismatch);
						if (j > psi) {
							i = i + j - psi;
						} else {
							i = i + 1;
						}
					}
					break;
				}
				j--;
			}
			if(j == -1)
			{
				index = i;
				break;
			}
		}
		return index;
	}
	public static int bruteForcePatternMatching(String str, String pattern)
	{
		int i = 0;
		int n = str.length();
		int p = pattern.length();
		int retVal = -1;
		while(i < n - p)
		{
			int j = 0;
			while(j < p)
			{
				if(str.charAt(i + j) != pattern.charAt(j))
				{
					break;
				}
				j++;
			}
			if(j == p)
			{
				retVal = i;
				break; 
			}
			i++;
		}
		
		return retVal;
	}
	public static void main(String[] args) {
		appendTestFaster(100000);
		appendTest(100000);
		
		//System.out.println(bruteForcePatternMatching("abcdabc","dab"));
	}

}
