package classDemos;

import java.util.Comparator;
import java.util.ArrayList;

import shared.*;
public class Heap<K extends Comparable<K>,V> implements PriorityQueue<K, V>{

	private class HeapNode
	{
		K key;
		V value;
		HeapNode(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		public String toString()
		{
			return "[" + key + "\t" + value + "]";
		}
	}
	private class NormalComparator implements Comparator<HeapNode>
	{
		public int compare(HeapNode o1, HeapNode o2) {
			return o1.key.compareTo(o2.key);
		}
	}
	private class ReverseComparator implements Comparator<HeapNode>
	{
		public int compare(HeapNode o1, HeapNode o2) {
			return o2.key.compareTo(o1.key);
		}
	}
	
	private ArrayList<HeapNode> data;
	private Comparator<HeapNode> comparator;
	
	public Heap(boolean isMin)
	{
		data = new ArrayList<HeapNode>();
		if(isMin)
		{
			comparator = new ReverseComparator();
		}
		else
		{
			comparator = new NormalComparator();
		}
	}
	
	public void add(K key, V value) {
		HeapNode newNode = new HeapNode(key, value);
		data.add(newNode);
		upHeapify(data.size() - 1);
	}

	public V remove() {
		if(isEmpty())
		{
			//throw exception
			return null;
		}
		else
		{
			V retVal = data.get(0).value;
			swap(0, data.size() - 1);
			data.remove(this.size() - 1);
			downHeapify(0);
			return retVal;
		}
	}

	public V get() {
		if(isEmpty())
		{
			//throw exception
			return null;
		}
		else
		{
			return data.get(0).value;
		}
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	private void swap(int i, int j)
	{
		HeapNode temp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, temp);
	}
	
	private void upHeapify(int ci)
	{
		if(ci == 0)
		{
			return;
		}
		int pi = (ci - 1)/2;
		if(comparator.compare(data.get(pi), data.get(ci)) < 0)
		{
			swap(pi, ci);
			upHeapify(pi);
		}
	}

	private void downHeapify(int pi)
	{
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int maxIndex = pi;
		if(lci < this.size() && comparator.compare(data.get(lci), data.get(maxIndex)) > 0)
		{
			maxIndex = lci;
		}
		if(rci < this.size() && comparator.compare(data.get(rci), data.get(maxIndex)) > 0)
		{
			maxIndex = rci;
		}
		if(maxIndex != pi)
		{
			swap(pi, maxIndex);
			downHeapify(maxIndex);
		}
	}
	
	public String toString()
	{
		return data.toString();
	}
}
