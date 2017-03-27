package linkedListClasses;

public class LinkedList<T extends Comparable<T>> {
	private class Node
	{
		T data;
		Node next;
		
		Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		
		public String toString()
		{
			return this.data.toString();
		}
	}

	//Linked List Data members
	private Node head;
	private Node tail;
	private int size;
	
	//Constructors
	public LinkedList()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public LinkedList(Node head, Node tail)
	{
		this.head = head;
		this.tail = tail;
	//	this.size = 0;
	}
	
	//Helpers
	private boolean isEmpty()
	{
		return this.size == 0;
	}
	public int getSize()
	{
		return this.size;
	}
	public T getFirst()
	{
		if(this.isEmpty())
		{
			return null;
		}
		else
		{
			return this.head.data;
		}
			
	}
	
	//Insertion in linked list
	public void addLast(T value)
	{
		Node newNode = new Node(value, null);
		if(this.isEmpty())
		{
			addFirst(value);
			return;
		}
		else
		{
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.size++;
	}
	public void addFirst(T value)
	{
		Node newNode = new Node(value, this.head);
		this.head = newNode;
		if(this.isEmpty())
		{
			this.tail = newNode;
		}
		this.size++;
	}
	public void addAt(int index, T value)
	{
		if(index == 0)
		{
			addFirst(value);
		}
		else if(index == this.size)
		{
			addLast(value);
		}
		else if(index > this.size)
		{
			//throw some error - Invalid index
			System.out.println("Invalid index");
		}
		else
		{
			Node temp = this.head;
			for(int i = 0; i < index - 1; i++)
			{
				temp = temp.next;
			}
			Node newNode = new Node(value,temp.next);
			temp.next = newNode;
			this.size++;
		}
	}
	public void insertionRecursiveAtI(T value, int index)
	{
		if(index < 0 || index >= this.size)
		{
			//throw some error
			System.out.println("Invalid index!");
		}
		else if(index == 0)
		{
			this.addFirst(value);
		}
		else if(index == this.size)
		{
			this.addLast(value);
		}
		else
		{
			insertionRecursiveHelper(this.head, index, value);
		}
	}
	private void insertionRecursiveHelper(Node start, int index, T value)
	{
		if(index == 1)
		{
			Node newNode = new Node(value,start.next);
			start.next = newNode;
			this.size++;
			return;
		}
		insertionRecursiveHelper(start.next, index - 1, value);
	}
	
	//Deletion in Linked List
	public T deleteFirst()
	{
		if(this.isEmpty())
		{
			//Nothing to delete
			return null;
		}
		T retVal = this.head.data;
		Node newHead = this.head.next;
		this.head = newHead;
		this.size--;
		if(isEmpty())
		{
			this.tail = null;
		}
		return retVal;
	}
	public void deleteLast()
	{
		if(this.isEmpty())
		{
			//Nothing to delete
			return;
		}
		else if(this.size == 1)
		{
			deleteFirst();
		}
		else
		{
			Node temp = this.head;
			for(int i = 1; i <= this.size - 2; i++)
			{
				temp = temp.next;
			}
			temp.next = null;
			this.tail = temp;
			this.size--;
		}
	}
	public void deleteAt(int index)
	{
		if(index == 0)
		{
			deleteFirst();
		}
		else if(index == this.size - 1)
		{
			deleteLast();
		}
		else if(index >= this.size)
		{
			System.out.println("Invalid index!");
		}
		else
		{
			Node temp = this.head;
			for(int i = 1; i < this.size - 2; i++)
			{
				temp = temp.next;
			}
			temp.next = temp.next.next;
			this.size--;
		}
	}
	public void deletionRecursiveAtI(int index)
	{
		if(index < 0 || index >= this.size)
		{
			System.out.println("Invalid index!");
		}
		else if(index == 0)
		{
			this.deleteFirst();
		}
		else if(index == this.size - 1)
		{
			this.deleteLast();
		}
		else
		{
			deletionRecursiveHelper(this.head, index);
		}
	}
	private void deletionRecursiveHelper(Node start, int index)
	{
		if(index == 1)
		{
			start.next = start.next.next;
			this.size--;
			return;
		}
		deletionRecursiveHelper(start.next, index - 1);
	}
	
	//Print a linked list
	public String toString()
	{
		String retVal = "";
		if(isEmpty())
		{
			retVal += "List is Empty";
		}
		else
		{
			retVal += "Linked List : ";
			Node temp = this.head;
			while(temp != null)
			{
				retVal += temp.data + " ";
				temp = temp.next;
			}
			retVal += "END";
		}
		return retVal;
	}
	public void display()
	{
		System.out.println(this);
	}
	public void displayIth(int index)
	{
		if(this.isEmpty())
		{
			return;
		}
		else
		{
			Node temp = this.head;
			for(int i = 0; i < index; i++)
			{
				temp = temp.next;
			}
			System.out.println(index+"ith element : "+ temp.data);
		}
	}

	//Find an element
	public T find(T value) throws Exception
	{
		if(this.isEmpty())
		{
			throw new Exception("");
		}
		else
		{
			return findHelper(this.head, value);
		}
	}
	private T findHelper(Node start, T value)
	{
		
		return findHelper(start.next, value);
	}

}
