package queueProblems;

import shared.IQueueInt;
import shared.QueueEmptyException;
import shared.QueueFullException;

public class QueueUsingArrays implements IQueueInt{
	protected int[] data;
	protected int front;
	protected int size;
	
	public QueueUsingArrays(int capacity)
	{
		this.data = new int[capacity];
		this.front = 0;
		this.size= 0;
	}
	
	public void enqueue(int item) throws QueueFullException
	{
		if(isFull())
		{
			throw new QueueFullException("Queue is Full!");
		}
		else
		{
			int availableIndex = (front + size) % data.length;
			this.data[availableIndex] = item;
			this.size++;
		}
	}
	
	public int dequeue() throws QueueEmptyException
	{
		if(isEmpty())
		{
			throw new QueueEmptyException("Queue is empty!");
		}
		else
		{
			int retVal = this.data[this.front];
			front = (front + 1) % data.length;
			this.size--;
			return retVal;
		}
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int front() throws QueueEmptyException
	{
		if(isEmpty())
		{
			throw new QueueEmptyException("Queue is empty!");
		}
		else
		{
			int retVal = this.data[this.front];
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

	public void reverse()
	{
		int i = this.front;
		int j = (this.front + this.size - 1) % this.data.length;
		
		int count = 1;
		while(count <= this.size/2)
		{
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			
			i = (i + 1) % this.data.length;
			j = (j - 1 + this.data.length) % this.data.length;
			
			count++;
		}
		
	}
}
 