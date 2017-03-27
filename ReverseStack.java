package stackProblems;

public class ReverseStack {

	public static <T> GenericStack<T> reverse(GenericStack<T> stack)
	{
		GenericStack<T> stackRev = new GenericStack<T>(stack.getSize());
		
		while(!stack.isEmpty())
		{
			stackRev.push(stack.pop());
		}
		return stackRev;
		
	}
	public static void main(String[] args) {
		GenericStack<Integer> stack = new GenericStack<Integer>(5);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		System.out.println(stack);
		stack = reverse(stack);
		System.out.println(stack);
	}
	

}
