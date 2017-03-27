package stackProblems;

import queueProblems.*;
import shared.IStack;
import shared.QueueEmptyException;
import shared.QueueFullException;
import shared.StackEmptyException;
import shared.StackFullException;

public class StackUsingTwoQueues<T> implements IStack<T>{
	private Queue<T> queue1;
	private Queue<T> queue2;
	
	//Constructor
	public StackUsingTwoQueues(int capacity)
	{
		queue1 = new Queue<T>(capacity);
		queue2 = new Queue<T>(capacity);
	}

	@Override
	public void push(T item) throws StackFullException {
		if(queue1.isFull())
		{
			throw new StackFullException("Stack is full!");
		}
		while(!queue1.isEmpty())
		{
			try
			{
				queue2.enqueue(queue1.dequeue());
			}
			catch(QueueEmptyException qEEx) //Never reached
			{
				//Not of our interest
			}
			catch(QueueFullException qFEx)  //Never reached
			{
				//Not of our interest
			}
		}
		try
		{
			queue1.enqueue(item);
		}
		catch(QueueFullException ex)
		{
			throw new StackFullException("Stack is full!");
		}
		
		while(!queue2.isEmpty())
		{
			try
			{
				queue1.enqueue(queue2.dequeue());
			}
			catch(QueueEmptyException qEEx) //Never reached
			{
				//Not of our interest
			}
			catch(QueueFullException qFEx)  //Never reached
			{
				//Not of our interest
			}
		}
	}

	@Override
	public T pop() throws StackEmptyException {
		try
		{
			T retVal = queue1.dequeue();
			return retVal;
		}
		catch(QueueEmptyException ex)
		{
			throw new StackEmptyException("Stack is empty!");
		}
	}

	@Override
	public T top() throws StackEmptyException {

		try
		{
			 T retVal = queue1.front();
			 return retVal;
		}
		catch(QueueEmptyException ex)
		{
			throw new StackEmptyException("Stack is empty");
		}
	}
	
	@Override
	public int getSize() {
		return queue1.getSize();
	}
	
	public boolean isFull()
	{
		return queue1.isFull();
	}
	
	public String toString()
	{
		return queue1.toString();
	}
}
