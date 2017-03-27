package queueProblems;

import linkedListClasses.*;
import shared.IQueue;
import shared.QueueEmptyException;
import shared.QueueFullException;

public class QueueUsingLinkedList<T extends Comparable<T>> implements IQueue<T> {
	
	private LinkedList<T> list;
	
	//Constructor
	public QueueUsingLinkedList()
	{
		list = new LinkedList<T>();
	}
	
	@Override
	public void enqueue(T item){
		list.addLast(item);
	}

	@Override
	public T dequeue() throws QueueEmptyException {	
		if(list.getSize() == 0)
		{
			throw new QueueEmptyException("Queue is empty");
		}
		else
		{
			return list.deleteFirst();
		}
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public T front() throws QueueEmptyException {
		if(list.getSize() == 0)
		{
			throw new QueueEmptyException("Queue is empty");
		}
		else
		{
			return list.getFirst();
		}
	}
	
	public void display()
	{
		list.display();
	}
}
