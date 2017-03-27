package classDemos;

import shared.BSTEmptyException;
import helperClasses.*;

public class BinarySearchTree {
	private class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;
	private int size;
	
	//Constructor
	public BinarySearchTree()
	{	
		this.root = null;
		this.size = 0;
	}
	public BinarySearchTree(int[] arr)
	{
		this.root = constructTree(arr, 0, arr.length - 1);
	}
	private Node constructTree(int[] arr, int si, int li)
	{
		if(si > li)
		{
			return null;
		}
		int mid = (si + li)/2;
		
		Node newNode = new Node(arr[mid], null, null);
		this.size++;
		newNode.left = constructTree(arr, si, mid - 1);
		newNode.right = constructTree(arr, mid + 1, li);
		
		return newNode;
	}
	
	//Helpers
	public int getSize()
	{
		return this.size;
	}
	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
	//Update methods
	public void addElement(int value)
	{
		this.root = this.addHelper(root, value);
	}
	private Node addHelper(Node node, int value)
	{
		if(node == null)
		{
			this.size++;
			return new Node(value, null, null);
		}
		if(node.data > value)
		{
			node.left = addHelper(node.left, value);
			return node;
		}
		else if(node.data < value)
		{
			node.right = addHelper(node.right, value);
			return node;
		}
		else // data already exists
		{
			//do nothing
			return node;
		}
	}
	
	public void removeElement(int value) throws BSTEmptyException
	{
		if(isEmpty())
		{
			throw new BSTEmptyException("Tree is empty!");
		}
		this.root = removeElementHelper(this.root, value);
	}
	private Node removeElementHelper(Node node, int val)
	{
		if(node == null)
		{
			return null;
		}
		if(node.data < val)
		{
			node.right = removeElementHelper(node.right, val);
			return node;
		}
		else if(node.data > val)
		{
			node.left = removeElementHelper(node.left, val);
			return node;
		}
		else
		{
			this.size--;
			//Case - 1 Leaf node
			if(node.left == null && node.right == null)
			{
				return null;
			}
			else if(node.left == null)
			{
				return node.right;
			}
			else if(node.right == null)
			{
				return node.left;
			}
			else
			{
				Node temp = node.left;
				while(temp.right != null)
				{
					temp = temp.right;
				}
				node.data =temp.data;
				node.left = removeElementHelper(node.left, temp.data);
				return node;
			}
		}
	}
	
	public int getRootElement() throws BSTEmptyException
	{
		if(isEmpty())
		{
			throw new BSTEmptyException("Tree is empty!");
		}
		else
		{
			return this.root.data;
		}
	}
	
	public boolean searchElement(int value) throws BSTEmptyException
	{
		if(this.isEmpty())
		{
			throw new BSTEmptyException("Tree is empty!");
		}
		return searchElementHelper(this.root, value);
	}
	private boolean searchElementHelper(Node node, int value)
	{
		if(node == null)
		{
			return false;
		}
		if(node.data == value)
		{
			return true;
		}
		else if(node.data > value)
		{
			return searchElementHelper(node.left, value);
		}
		else
		{
			return searchElementHelper(node.right, value);
		}
	}
	
	public void levelOrderTraversal()
	{
		if(this.isEmpty())
		{
			return;
		}
		GenericQueue<Node> queue = new GenericQueue<Node>(this.size);
		queue.enqueue(this.root);
		
		while(!queue.isEmpty())
		{
			Node dequeuedNode = queue.dequeue();
			System.out.print(dequeuedNode.data + " ");
			if(dequeuedNode.left != null)
			{
				queue.enqueue(dequeuedNode.left);
			}
			if(dequeuedNode.right != null)
			{
				queue.enqueue(dequeuedNode.right);
			}
		}
		System.out.println("END");
	}

	public int successor(int data) {
		Node retVal = null;
		Node temp = this.root;

		while (temp != null) {
			if (data > temp.data) {
				temp = temp.right;
			} else if (data < temp.data) {
				retVal = temp;
				temp = temp.left;
			} else {
				// reached
				if (temp.right != null) {
					retVal = temp.right;

					while (retVal.left != null) {
						retVal = retVal.left;
					}
				}

				break;
			}
		}

		return retVal != null ? retVal.data : -1;
	}
	
	//Print elements in range K1 - K2
	public void printInRange(int k1, int k2)
	{
		int smaller = k1 < k2 ? k1 : k2;
		int larger = k2 > k1 ? k2 : k1;
		printInRangeHelper(root, smaller, larger);
	}
	private void printInRangeHelper(Node node, int k1, int k2)
	{
		if(node == null)
		{
			return;
		}
		else if(node.data < k1)
		{
			printInRangeHelper(node.right, k1, k2);
		}
		else if(node.data > k2)
		{
			printInRangeHelper(node.left, k1, k2);
		}
		else
		{
			printInRangeHelper(node.left, k1, k2);
			if(node.data >= k1 && node.data <= k2)
			{
				System.out.print(node.data + " ");
			}
			printInRangeHelper(node.right, k1, k2);
		}
	}
}
