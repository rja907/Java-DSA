package queueProblems;

import shared.IQueue;


public class GenericQueue<T> implements IQueue<T> {
	private T[] data;
	private int front;
	private int size;
	
	public GenericQueue(int capacity)
	{
		this.data = (T[])new Object[capacity];
		this.front = 0;
		this.size= 0;
	}
	
	public void enqueue(T item)// throws QueueFullException
	{
		if(isFull())
		{
			//throw new QueueFullException("Queue is Full!");
		}
		else
		{
			int availableIndex = (front + size) % data.length;
			this.data[availableIndex] = item;
			this.size++;
		}
	}
	
	public T dequeue()//throws QueueEmptyException
	{
		if(isEmpty())
		{
			//throw new QueueEmptyException("Queue is empty!");
			return null;
		}
		else
		{
			T retVal = this.data[this.front];
			front = (front + 1) % data.length;
			this.size--;
			return retVal;
		}
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public T front() //throws QueueEmptyException
	{
		if(isEmpty())
		{
			//throw new QueueEmptyException("Queue is empty!");
			return null;
		}
		else
		{
			T retVal = this.data[this.front];
			return retVal;
		}
	}
	
	public boolean isFull()
	{
		boolean retVal = false;
		if(this.size == this.data.length)
		{
			retVal = true;
		}
		return retVal;
	}
	
	public boolean isEmpty()
	{
		boolean retVal = false;
		if(this.size == 0)
		{
			retVal = true;
		}
		return retVal;
	}
	
	public String toString()
	{
		String retVal = "";
		int count = 1;
		int index = this.front;
		while(count <= this.size)
		{
			retVal += this.data[index] + " ";
			index = (index + 1) % data.length;
			count++;
		}
		retVal += "END \n";
		return retVal;
	}
	
}