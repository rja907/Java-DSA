package stackProblems;

import shared.IStack;
import shared.StackEmptyException;
import linkedListClasses.*;

public class StackUsingLinkedList<T extends Comparable<T>> implements IStack<T>{

	private LinkedList<T> list;
	
	
	//Constructor
	public StackUsingLinkedList() {
		list = new LinkedList<T>();
	}
	
	@Override
	public void push(T item) // throws StackFullException 
	{
		list.addLast(item);
	}

	@Override
	public T pop() throws StackEmptyException {
		if(list.getSize() == 0)
		{
			throw new StackEmptyException("Stack is empty!");
		}
		else
		{
			T retVal = list.deleteFirst();
			return retVal;
		}
	}

	@Override
	public T top() throws StackEmptyException {
		if(list.getSize() == 0)
		{
			throw new StackEmptyException("Stack is empty!");
		}
		else
		{
			return list.getFirst();
		}
	}

	@Override
	public int getSize() {
		return list.getSize();
	}
	
	public void display()
	{
		list.display();
	}
	
}
