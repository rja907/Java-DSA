package queueProblems;

import stackProblems.*;
import shared.*;
public class QueueUsingTwoStacks<T> implements IQueue<T>{
	private Stack<T> stack1;
	private Stack<T> stack2;
	
	//Constructor
	public QueueUsingTwoStacks(int capacity)
	{
		stack1 = new Stack<T>(capacity);
		stack2 = new Stack<T>(capacity);
	}

	@Override
	public void enqueue(T item) throws QueueFullException {
		if(isFull())
		{
			throw new QueueFullException("Queue is full!");
		}
		while(!stack1.isEmpty())
		{
			try
			{
				stack2.push(stack1.pop());
			}
			catch(StackEmptyException sEx) //Will never be reached
			{
				//Not of our interest
			}
			catch(StackFullException sFx) //Will never be reached
			{
				//Not of our interest
			}
		}
		try
		{
			stack1.push(item);
		}
		catch(StackFullException sFx)
		{
			//Not of our interest
		}
		
		while(!stack2.isEmpty())
		{
			try
			{
				stack1.push(stack2.pop());
			}
			catch(StackEmptyException sEx) //Will never be reached
			{
				//Not of our interest
			}
			catch(StackFullException sFx) //Will never be reached
			{
				//Not of our interest
			}
		}
	}

	@Override
	public T dequeue() throws QueueEmptyException {
		try
		{
			T retVal = stack1.pop();
			return retVal;
		}
		catch(StackEmptyException ex)
		{
			throw new QueueEmptyException("Queue is empty!");
		}
	}

	@Override
	public int getSize() {
		return stack1.getSize();
	}

	@Override
	public T front() throws QueueEmptyException {
		try
		{
			T retVal = stack1.top();
			return retVal;
		}
		catch(StackEmptyException ex)
		{
			throw new QueueEmptyException("Queue is empty!");
		}
	}
	
	public boolean isFull()
	{
		return stack1.isFull();
	}

	public String toString()
	{
		return stack1.toString();
	}
}
