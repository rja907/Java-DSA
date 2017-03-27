package classDemos;

import java.util.ArrayList;
import java.util.Scanner;

import helperClasses.*;

public class Tree {
	
	private class Node
	{
		int data;
		ArrayList<Node> children;
		
		public Node(int value, ArrayList<Node> children)
		{
			this.data = value;
			this.children = children;
		}

		public String toString()
		{
			String retVal = "";
			retVal += "Node : "+this.data +"\tChildren - [ ";
			for(Node d : children)
			{
				retVal += d.data +" ";
			}
			retVal += "]\n";
			for(int i = 0; i < this.children.size(); i++)
			{
				retVal += this.children.get(i).toString();
			}
			return retVal;
		}
		
		
		public int sumOfNodesAndChildren()
		{
			int retVal = this.data;
			for(Node child : this.children)
			{
				retVal += child.data;
			}
			return retVal;
		}
	}
	
	
	//Tree data members
	private Node root;
	private int size;
	
	//Constructor
	public Tree()
	{
		Scanner s = new Scanner(System.in);
		this.root = this.takeInput(s, null, 0);
	}
	//Last parameter is only for informative purpose, can be ignored if creates confusion
	private Node takeInput(Scanner scn, Node parentNode, int ithChild)
	{
		if(parentNode == null)
		{
			System.out.println("Enter the data for root node : ");
		}
		else
		{
			System.out.println("Enter the data for " +ithChild + "th child of "+parentNode.data + " node : ");
		}
		
		Integer val = scn.nextInt();
		
		System.out.println("Enter the number of children of node "+val + " : ");
		int no = scn.nextInt();
		Node newNode = new Node(val,  new ArrayList<Node>());
		this.size++;
		
		for(int i = 1; i <= no; i++)
		{
			newNode.children.add(takeInput(scn, newNode, i));
		}
		
		return newNode;
		
	}

	//Helpers
	public int size()
	{
		return this.size;
	}
	public boolean isEmpty()
	{
		return this.size == 0;
	}
	public int root()
	{
		return this.root.data;
	}
	
	
	public void display()
	{
		System.out.println(this);
	}
	public String toString()
	{
		return this.root.toString();
	}

	//Pre order
	public void preOrderTraversal()
	{
		this.preOrderHelper(this.root);
		System.out.println("END");
	}
	private void preOrderHelper(Node node)
	{
		System.out.print(node.data + " ");
		for(Node child : node.children)
		{
			preOrderHelper(child);
		}
	}

	//Post order
	public void postOrderTraversal()
	{
		postOrderHelper(this.root);
		System.out.println("END");
	}
	private void postOrderHelper(Node node)
	{
		for(Node child : node.children)
		{
			postOrderHelper(child);
		}
		System.out.print(node.data+" ");
	}
	
	//Level order
	public void levelOrderTraversal()
	{
		GenericQueue<Node> queue = new GenericQueue<Node>(this.size);
		queue.enqueue(this.root);
		while(!queue.isEmpty())
		{
			Node dequeuedItem = queue.dequeue();
			System.out.print(dequeuedItem.data + " ");
			for(Node child : dequeuedItem.children)
			{
				queue.enqueue(child);
			}
		}
		System.out.println("END");
	}

	//Maximum data node
	public int findMax()
	{
		return findMaxHelper(this.root);
	}
	private int findMaxHelper(Node node)
	{
		int retVal = node.data;
		for(Node child : node.children)
		{
			//Find max in children
			int childMax = findMaxHelper(child);
			if(childMax > retVal)
			{
				retVal = childMax;
			}
		}
		return retVal;
	}

	//Count - useful if we had not taken size property in tree
	public int count()
	{
		return countHelper(this.root);
	}
	private int countHelper(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int val = 1;
		for(Node child : node.children)
		{
			val += countHelper(child);
		}
		return val;
	}

	//Number of nodes greater than X
	public int noOfNodesGreaterThanX(int x)
	{
		return noOfNodesGreaterThanXHelper(this.root,x);
	}
	private int noOfNodesGreaterThanXHelper(Node node, int x)
	{
		int val = 0;
		if(node == null)
		{
			return val;
		}
		if(node.data > x)
		{
			val = 1;
		}
		for(Node child : node.children)
		{
			val += noOfNodesGreaterThanXHelper(child, x);
		}
		return val;
	}

	//Node with maximum sum
	public int nodeWithMaximumSum()
	{
		return maxSumOfNodes(this.root).data;
	}
	private Node maxSumOfNodes(Node node) {
		Node retVal = node;

		for (Node child : node.children) {
			Node maxOfChild = this.maxSumOfNodes(child);
			if (maxOfChild.sumOfNodesAndChildren() > retVal.sumOfNodesAndChildren()) {
				retVal = maxOfChild;
			}
		}

		return retVal;
	}

	//Height of a tree
	public int height()
	{
		return this.heightHelper(this.root);
	}
	public int heightHelper(Node node)
	{
		int max = -1;
		for(Node child : node.children)
		{
			int heightChild = heightHelper(child);
			if(heightChild > max)
			{
				max = heightChild;
			}
		}
		return max + 1;
	}
	
	//Print all nodes at depth k
	public void printAtDepthK(int k)
	{
		if(isEmpty())
		{
			return;
		}
		printAtDepthKHelper(this.root, k);
	}
	private void printAtDepthKHelper(Node node, int k)
	{
		if(k == 0)
		{
			System.out.print(node.data + " ");
			return;
		}
		for(Node child : node.children)
		{
			printAtDepthKHelper(child, k - 1);
		}
	}
	
}
 