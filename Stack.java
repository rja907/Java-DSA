package stackProblems;

import shared.*;

public class Stack<T> implements IStack<T> {

	private T[] data;
	private int top;
	
	//Constructor
	public Stack(int capacity)
	{
		this.data = (T[]) new Object[capacity];
		this.top = -1;
	}
	
	//Push
	public void push(T item) throws StackFullException {
		if(this.isFull())
		{
			throw new StackFullException("Stack is full");
		}
		else
		{
			this.top++;
			this.data[this.top] = item;
		}
	}
	
	//Pop
	public T pop() throws StackEmptyException {
		T retVal = null;
		if(this.isEmpty())
		{
			throw new StackEmptyException("Stack is empty");
		}
		else
		{
			retVal = this.data[this.top];
			this.top--;
		}
		return retVal;
	}
	
	//Top
	public T top() throws StackEmptyException {
		T retVal = null;
		if(this.isEmpty())
		{
			throw new StackEmptyException("Stack is empty!");
		}
		else
		{
			retVal = this.data[this.top];
		}
		return retVal;
	}
	
	//Display
	public void display() {
		for(int i = this.top; i >=0; i--)
		{
			System.out.print(this.data[i] + " ");
		}
		System.out.println("END");
	}
	
	//Size
	public int getSize() {
		return this.top + 1;
	}
	
	//Check empty
	public boolean isEmpty() {
		boolean retVal = false;
		if(this.top == -1)
		{
			retVal = true;
		}
		return retVal;
	}
	
	//Check full
	public boolean isFull() {
		boolean retVal = false;
		if(this.top == this.data.length - 1)
		{
			retVal = true;
		}
		return retVal;
	}
	
	public String toString()
	{
		String retVal = "";
		for(int i = this.top; i >= 0; i--)
		{
			retVal += this.data[i] + " ";
		}
		retVal += "END \n";
		return retVal;
	}
}