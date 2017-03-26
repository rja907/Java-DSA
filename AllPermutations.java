package classDemos;

import java.util.ArrayList;

public class AllPermutations {

	public static ArrayList<String> returnAllPermutations(String str)
	{
		if(str.length() == 1)
		{
			ArrayList<String> al = new ArrayList<String>();
			al.add(str);
			return al;
		}
		ArrayList<String> current = new ArrayList<String>();
		for(int i = 0; i <str.length(); i++)
		{
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i+1,str.length());
			ArrayList<String> rosPermutations = returnAllPermutations(ros);
			
			for(int j = 0; j < rosPermutations.size(); j++)
			{
				current.add(cc+ rosPermutations.get(j));
			}
		}
		return current;
	}
	
	public static void printAllPermutations(String str, String outputSoFar)
	{
		if(str.length() == 0)
		{
			System.out.println(outputSoFar);
			return;
		}
		for(int i = 0; i <str.length(); i++)
		{
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i+1,str.length());
			printAllPermutations(ros, outputSoFar + cc);
		}
	}
	
	public static void main(String[] args) {
		/*ArrayList<String> retVal = returnAllPermutations("abcd");
		System.out.println(retVal);*/
		
		printAllPermutations("abcd","");
	}

}
