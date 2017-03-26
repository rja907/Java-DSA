package classDemos;

import java.util.Scanner;

import java.util.ArrayList;

public class Keypad {

	public static ArrayList<String> keypad(String str)
	{
		if(str.length() == 1)
		{
			String currentCharCode = kpCode(str.charAt(0));
			ArrayList<String> current = new ArrayList<String>();
			for(int i = 0; i < currentCharCode.length(); i++)
			{
				current.add(currentCharCode.substring(i, i+1));
			}
		}
		ArrayList<String> smaller = keypad(str.substring(1));
		String currentCharCode = kpCode(str.charAt(0));
		ArrayList<String> current = new ArrayList<String>();
		for(int i = 0; i < currentCharCode.length(); i++)
		{
			for(int j = 0; j < smaller.size();j++)
			{
				current.add(currentCharCode.charAt(i) + smaller.get(j));
			}
		}
		return current;
	}
	
	public static String kpCode(char c)
	{
		String retVal ="";
		switch(c)
		{
		case '1':
			retVal ="abc";
			break;
		case '2':
			retVal ="def";
			break;
		case '3':
			retVal ="ghi";
			break;
		case '4':
			retVal ="jkl";
			break;
		case '5':
			retVal ="mno";
			break;
		case '6':
			retVal ="pqr";
			break;
		case '7':
			retVal ="stu";
			break;
		case '8':
			retVal ="vwx";
			break;
		case '9':
			retVal ="yz";
			break;
		default : 
			break;
		
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the numbers : ");
		String str = s.nextLine();
		
		ArrayList<String> retList = keypad(str);
		for(String val : retList)
		{
			System.out.println(val);
		}
	}

}
