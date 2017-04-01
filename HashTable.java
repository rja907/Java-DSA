package classDemos;

import java.util.ArrayList;

import shared.*;


public class HashTable<K,V> implements Map<K, V>{

	private class HTNode
	{
		K key;
		V value;
		HTNode(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			HTNode othernode = (HTNode)obj;
			return this.key.equals(othernode.key);
		}
		
		public String toString()
		{
			return "{ " + this.key + ", " + this.value + " }";
		}
	}

	private ArrayList<LinkedList<HTNode>> bucket;
	private int size;
	public static final int DEFAULT_CAPACITY = 10;
	
	public HashTable()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public HashTable(int capacity)
	{
		bucket = new ArrayList<>();
		for(int i = 0; i < capacity; i++)
		{
			bucket.add(null);
		}
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void put(K key, V value) {
		int bucketIndex = hashFunction(key);
		LinkedList<HTNode> linkedList = this.bucket.get(bucketIndex);
		
		HTNode htNode = new HTNode(key, value); 
		if(linkedList == null)
		{
			LinkedList<HTNode> newList = new LinkedList<HTNode>();
			newList.addLast(htNode);
			bucket.set(bucketIndex, newList);
			this.size++;
		}
		else
		{
			try 
			{
				int findIndex = linkedList.find(htNode);
				linkedList.getElementAt(findIndex).value = htNode.value;
			} 
			catch (Exception e)
			{
				linkedList.addLast(htNode);
				this.size++;
			}
		}
		
		double loadFactor = (this.size/ this.bucket.size()) * (1.0);
		if(loadFactor > 0.75)
		{
			this.reHash();
		}
	}

	public V getValue(K key) {
		int bucketIndex = hashFunction(key);
		LinkedList<HTNode> linkedList = this.bucket.get(bucketIndex);
		
		HTNode htNode = new HTNode(key, null); //Just to search
		if(linkedList == null)
		{
			return null;
		}
		try 
		{
			int findIndex = linkedList.find(htNode);
			return linkedList.getElementAt(findIndex).value;
		} 
		catch (Exception e) //Element not found in the list
		{
			return null;
		}
	}

	public V remove(K key) {
		
		int bucketIndex = hashFunction(key);
		LinkedList<HTNode> linkedList = this.bucket.get(bucketIndex);
		
		HTNode htNode = new HTNode(key, null); //Just to search
		if(linkedList == null)
		{
			return null;
		}
		try 
		{
			int findIndex = linkedList.find(htNode);
			V retVal = linkedList.getElementAt(findIndex).value;
			linkedList.deleteAt(findIndex);
			this.size--;
			return retVal;
		} 
		catch (Exception e)
		{
			return null;
		}
	}
	 
	private int hashFunction(K key)
	{
		return Math.abs(key.hashCode() % this.bucket.size());
	}
	
	private void reHash()
	{
		ArrayList<LinkedList<HTNode>> temp = bucket;
		this.bucket = new ArrayList<LinkedList<HTNode>>();
		for(int i = 0; i < 2 * temp.size(); i++)
		{
			bucket.add(null);
		}
		this.size = 0;
		for (int i = 0; i < temp.size(); i++) {
			LinkedList<HTNode> linkedList = temp.get(i);

			while (linkedList != null && !linkedList.isEmpty()) {
				try {
					HTNode node = linkedList.deleteFirst();
					this.put(node.key, node.value);
				} catch (Exception ex) {
					// nothing to do here
				}
			}
		}
	}

	public String toString()
	{
		return this.bucket.toString();
	}
}
