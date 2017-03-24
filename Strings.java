package classDemos;

public class Strings {
	
	public static void printAllCharsInDiffLines(String s)
	{
		int i = 0;
		while(i < s.length())
		{
			System.out.println(s.charAt(i));
			i = i + 1;
		}
	}
	
	public static boolean checkPalindrome(String str)
	{
		boolean isPalindrome = true;
		int i = 0, j = str.length() - 1;
		while(i <= j)
		{
			if(str.charAt(i) != str.charAt(j))
			{
				isPalindrome = false;
				break;
			}
			i = i + 1;
			j = j - 1;
		}
		
		return isPalindrome;
	}

	public static void printAllSubstrings(String str)
	{
		for(int i = 0; i < str.length(); i++){
			for(int j = i + 1; j <= str.length(); j++){
				System.out.println(str.substring(i, j));
			}
		}
	}
	
	public static String reverseString(String str)
	{
		StringBuilder sb = new StringBuilder();
		int i = str.length() - 1;
		while(i >= 0)
		{
			sb.append(str.charAt(i));
			i = i -1;
		}
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcd";
		//1. Print in different lines
		//printAllCharsInDiffLines(str);
		
		//2.  Print all substrings
		printAllSubstrings(str);
		
		//3. Check Palindrome
		boolean result = checkPalindrome(str);
		if(result == true)
		{
			System.out.println("It is a palindrome!");
		}
		else
		{
			System.out.println("Not a palindrome!");
		}
		
		//4. Reverse a string
		str = reverseString(str);
		System.out.println(str);
		
	}	

}
