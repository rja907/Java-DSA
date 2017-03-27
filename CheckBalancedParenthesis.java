package stackProblems;

public class CheckBalancedParenthesis {

	public static boolean checkBalancedParenthesis(String expr)
	{
		boolean retVal = true;
		GenericStack<Character> stack = new GenericStack<Character>(20);
		for(int i = 0; i < expr.length(); i++)
		{
			char cc = expr.charAt(i);
			if(cc == '[' || cc == '{' || cc == '(')
			{
				stack.push(cc);
			}
			else if(cc == ']' || cc == '}' || cc == ')')
			{
				if(!stack.isEmpty())
				{
					char charAtTop = stack.pop();
					if((cc =='[' && charAtTop != ']') || (cc == '{' && charAtTop != '}') || (cc == '(' && charAtTop != ')'))
					{
						retVal = false;
						break;
					}
				}
				else //Closing brackets are more
				{
					retVal = false;
					break;
				}
			}
		}
		if(!stack.isEmpty()) //opening brackets are more
		{
			retVal = false;
		}
		return retVal;
	}
	public static void main(String[] args) {
		String expr = "[[{a}]]]";
		System.out.println(checkBalancedParenthesis(expr));
	}

}
