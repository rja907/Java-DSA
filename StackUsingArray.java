package stackProblems;

import shared.*;

public class StackUsingArray implements IStackInt{
	protected int top;
	protected int[] data;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public StackUsingArray()
	{
		this.top = -1;
		this.data = new int[DEFAULT_CAPACITY];
	}
	
	public StackUsingArray(int capacity)
	{
		this.top = -1;
		this.data = new int[capacity];
	}
	
	public void push(int item) throws StackFullException
	{
		if(this.isFull())
		{
			throw new StackFullException("Stack is full!");
		}
		else
		{
			top++;
			this.data[this.top] = item;
		}
	}
	
	public int pop() throws StackEmptyException
	{
		int retVal = -1;
		if(isEmpty())
		{
			throw new StackEmptyException("Stack is empty!");
		}
		else
		{
			retVal = this.data[top];
			top--;
		}
		return retVal;
	}
	
	public int top() throws StackEmptyException
	{
		int retVal = -1;
		if(isEmpty())
		{
			throw new StackEmptyException("Stack is empty!");
		}
		else
		{
			retVal = this.data[top];
		}
		return retVal;
	}
	
	public int getSize()
	{
		return this.top + 1;
	}

	protected boolean isEmpty()
	{
		boolean retVal = false;
		if(this.top == -1)
		{
			retVal = true;
		}
		return retVal;
	}
	
	protected boolean isFull()
	{
		boolean retVal = false;
		if(this.top == this.data.length- 1)
		{
			retVal = true;
		}
		return retVal;
	}

	@Override 
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = this.top; i >= 0; i--)
		{
			sb.append(this.data[i] + " ");
		}
		return sb.toString();
	}
}
