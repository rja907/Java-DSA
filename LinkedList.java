package linkedList;

public class LinkedList<T extends Comparable<T>> {
	private class Node implements Comparable<Node>
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
		
		public int compareTo(Node other){
			return this.data.compareTo(other.data);
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
	private LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
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
	private Node getNodeAtI(int i)
	{
		if(i < 0 || i >= this.size)
		{
			System.out.println("Invalid index"); //Instead some exception should be thrown
			return null;
		}
		else
		{
			Node temp = this.head;
			for(int k = 0; k < i; k++)
			{
				temp = temp.next;
			}
			return temp;
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
	public void deleteFirst()
	{
		if(this.isEmpty())
		{
			//Nothing to delete
			return;
		}
		Node newHead = this.head.next;
		this.head = newHead;
		this.size--;
		if(isEmpty())
		{
			this.tail = null;
		}
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
	public int find(T value) throws Exception
	{
		if(this.isEmpty())
		{
			throw new Exception("List is empty");
		}
		else
		{
			return findHelper(this.head, value, 0);
		}
	}
	private int findHelper(Node node, T value, int index)
	{
		if(node == null)
		{
			return -1;
		}
		if(node.data.equals(value))
		{
			return index;
		}
		else
		{
			return findHelper(node.next, value, index + 1);
		}
	}
	
	//Mid point of Linked list
	public T midPoint()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			Node temp = this.head;
			for(int i = 0; i < this.size/2; i++)
			{
				temp = temp.next;
			}
			return temp.data;
		}
	}
	
	//Swap two elements
	public void swap(int first, int second)
	{
		Node temp1 = this.head;
		Node temp2 = this.head;
		int i = 0, j = 0;
		while(i <first && temp1.next!= null)
		{
			temp1 = temp1.next;
			 i++;
		}
		while(j <second && temp2.next!= null)
		{
			temp2 = temp2.next;
			j++;
		}
		
		T temp = temp1.data;
		temp1.data = temp2.data;
		temp2.data = temp;
	}

	//Selection sort
	public void selectionSort()
	{
		int i = 0, j = 0;
		int minIndex;
		T minElem;
		Node temp1 = this.head;
		while(i < this.size - 1)
		{
			Node temp2 = temp1.next;
			j = i + 1;
			minElem = temp1.data;
			minIndex = i;
			while(j < this.size)
			{
				if(temp2.data.compareTo(minElem) < 0)
				{
					minElem = temp2.data;
					minIndex = j;
				}
				temp2 = temp2.next;
				j++;
			}
			swap(i,minIndex);
			temp1 = temp1.next;
			i++;
		}
	}

	//Reverse a linked list
	public void reverse()
	{
		if(this.isEmpty())
		{
			return;
		}
		reverseHelper(this.head, null);
	}
	private void reverseHelper(Node current, Node prev)
	{
		//Base case
		if(current == null)
		{
			this.head = prev;
			return;
		}
		
		if(prev == null)
		{
			this.tail = current;
		}
		Node next = current.next;
		current.next = prev;
		prev = current;
		current = next;
		
		reverseHelper(current, prev);
	}

	//Find last ith
	public T findLastIth(int i)
	{
		if(i <= 0 || i >= this.size)
		{
			System.out.println("Invalid index!");
			return null;
		}
		else
		{
			Node temp1 = this.head;
			Node temp2 = this.head;
			int j = 1;
			while(j < i)
			{
				temp2 = temp2.next;
				j++;
			}
			while(temp2.next != null)
			{
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			return temp1.data;
		}
	}

	public LinkedList<T> mergeTwoSortedLists(LinkedList<T> other){
		LinkedList<T> retVal = new LinkedList<T>();
		Node thisTemp = this.head, otherTemp = other.head;
		
		while(thisTemp != null && otherTemp != null){
			if(thisTemp.compareTo(otherTemp) <= 0){
				retVal.addLast(thisTemp.data);
				thisTemp = thisTemp.next;
			}
			else{
				retVal.addLast(otherTemp.data);
				otherTemp = otherTemp.next;
			}
		}
		
		while(thisTemp != null){
			retVal.addLast(thisTemp.data);
			thisTemp = thisTemp.next;
		}
		
		while(otherTemp != null){
			retVal.addLast(otherTemp.data);
			otherTemp = otherTemp.next;
		}
		
		return retVal;
	}

	public void mergeSort(){
		LinkedList<T> sorted = this.mergeSortHelper();
		
		this.head = sorted.head;
		this.tail = sorted.tail;
		this.size = sorted.size;
	}
	
	private LinkedList<T> mergeSortHelper(){
		if(this.getSize() == 1){
			return this;
		}
		
		Node mid = this.midPointNode();
		Node midNext = mid.next;
		
		mid.next = null;
		
		LinkedList<T> fHalf = new LinkedList<>(this.head, mid, (this.getSize() + 1)/ 2);
		LinkedList<T> sHalf = new LinkedList<>(midNext, this.tail, this.getSize() / 2);
		
		fHalf = fHalf.mergeSortHelper();
		sHalf = sHalf.mergeSortHelper();
		
		LinkedList<T> sorted = fHalf.mergeTwoSortedLists(sHalf);
		return sorted;
	}
	
	private Node midPointNode() {
		Node slow = this.head, fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
}


