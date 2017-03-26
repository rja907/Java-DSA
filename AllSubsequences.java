package classDemos;

import java.util.ArrayList;

public class AllSubsequences {

	public static String[]  returnAllSubsequences(String str)
	{
		if(str.length() == 0)
		{
			return new String[] {""};
		}
		char cc = str.charAt(0);
		String[] smaller = returnAllSubsequences(str.substring(1));
		String[] larger = new String[smaller.length * 2];
		int i = 0;
		for(i = 0; i < smaller.length; i++)
		{
			larger[i] = smaller[i];
		}
		int j = 0;
		for(; i <larger.length;i++)
		{
			larger[i] = cc+ smaller[j];
			j++;
		}
		return larger;
	}
	
	public static void printAllSubsequences(String str, String outputSoFar)
	{
		if(str.length() == 0)
		{
			System.out.print(outputSoFar +" ");
			return;
		}
		char cc = str.charAt(0);
		printAllSubsequences(str.substring(1),outputSoFar + "");
		printAllSubsequences(str.substring(1), outputSoFar + cc);
	}
	
	public static void main(String[] args) {

		/*String[] ret = returnAllSubsequences("abcd");
		for(String val : ret)
		{
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println(ret.length);*/
		
		String str = "abc";
		printAllSubsequences(str, "");
		
	}

}
