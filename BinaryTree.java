package classDemos;

import java.util.Scanner;
import helperClasses.*;

public class BinaryTree {
	
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
		
		public String toString()
		{
			return data + " ";
		}
	}
	
	private class Pair
	{
		int height;
		int diameter;
		
		Pair(int h, int d)
		{
			height = h;
			diameter = d;
		}
	}
	
	//Data members - 
	private Node root;
	private int size;
	
	//Constructor
	public BinaryTree()
	{
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s, null);
	}
	
	private Node takeInput(Scanner scn, Node parentNode)
	{
		if(parentNode == null)
		{
			System.out.println("Enter the value of root node : ");
		}
		else
		{
			System.out.println("Enter the value of node : ");
		}
		
		int val = scn.nextInt();
		Node newNode = new Node(val, null, null);
		this.size++;
		
		System.out.println("Is left child of "+newNode.data + " present ?");
		if(scn.nextBoolean())
		{
			newNode.left = takeInput(scn, newNode);
		}
		System.out.println("Is right child of "+newNode.data + " present ?");
		if(scn.nextBoolean())
		{
			newNode.right = takeInput(scn, newNode);
		}
		return newNode;
	}

	public BinaryTree(int[] one, int[] two, int type)
	{
		if(type == 0)
		{
			this.root = buildPre_InHelper(one, 0, one.length - 1, two, 0, two.length - 1);
		}
		else
		{ 
			this.root = buildPost_InHelper(one, 0, one.length - 1, two, 0, two.length - 1);
		}
		this.size = one.length;
	}
	
	//Helpers
	public int getSize()
	{
		return this.size;
	}
	public int getNoOfElements()
	{
		return sizeHelper(root);
	}
	private int sizeHelper(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int val = 1;
		
		int leftSize = sizeHelper(node.left);
		int rightSize = sizeHelper(node.right);
		
		val += leftSize + rightSize;
		return val;
	}
	public int height()
	{
		 return this.heightHelper(root);
	}
	private int heightHelper(Node node)
	{
		if(node == null)
		{
			return -1;
		}
		int leftHeight = heightHelper(node.left);
		int rightHeight = heightHelper(node.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	
	//Traversals
	public void inorderTraversal()
	{
		System.out.print("Inorder : ");
		inorderTraversalHelper(this.root);
		System.out.println("END");
	}
	private void inorderTraversalHelper(Node node)
	{
		if(node == null)
		{
			return;
		}
		inorderTraversalHelper(node.left);
		System.out.print(node.data + " ");
		inorderTraversalHelper(node.right);
	}

	public void preorderTraversal()
	{
		System.out.print("Preorder : ");
		preorderTraversalHelper(this.root);
		System.out.println("END");
	}
	private void preorderTraversalHelper(Node node)
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.data + " ");
		preorderTraversalHelper(node.left);
		preorderTraversalHelper(node.right);
	}

	public void postorderTraversal()
	{
		System.out.print("Postorder : ");
		postorderTraversalHelper(this.root);
		System.out.println("END");
	}
	private void postorderTraversalHelper(Node node)
	{
		if(node == null)
		{
			return;
		}
		postorderTraversalHelper(node.left);
		postorderTraversalHelper(node.right);
		System.out.print(node.data + " ");
	}

	public void levelorderTraversal()
	{
		GenericQueue<Node> queue = new GenericQueue<Node>(this.size);
		System.out.print("Level order : ");
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

	//Search a node
	public boolean searchElement(int value)
	{
		return searchElementHelper(this.root, value);
	}
	private boolean searchElementHelper(Node node, int val)
	{
		if(node == null)
		{
			return false;
		}
		else if(node.data == val)
		{
			return true;
		}
		else if(searchElementHelper(node.left,val))
		{
			return true;
		}
		else if(searchElementHelper(node.right, val))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Mirror the tree
	public void getMirror()
	{
		getMirrorHelper(this.root);
	}
	private void getMirrorHelper(Node node)
	{
		if(node == null)
		{
			return;
		}
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		getMirrorHelper(node.left);
		getMirrorHelper(node.right);
	}
	
	private Node buildPre_InHelper(int[] pre, int fIPre, int lIpre, int[] in, int fIIn, int lIIn)
	{
		//Base case
		if(fIIn > lIIn || fIPre > lIpre)
		{
			return null;
		}
		
		int val = pre[fIPre];
		Node newNode = new Node(val,null,null);
		//Search val in inorder array
		int index = -1;
		for(int i = fIIn; i <= lIIn; i++)
		{
			if(in[i] == val)
			{
				index = i;	
				break;
			}
		}
		int ii = index - fIIn;
		
		newNode.left = buildPre_InHelper(pre, fIPre + 1, fIPre + ii, in, fIIn,index - 1);
		newNode.right = buildPre_InHelper(pre, fIPre + ii + 1, lIpre, in, index + 1, lIIn);
		return newNode;
	}

	private Node buildPost_InHelper(int[] post, int postSi, int postEi, int[] in, int inSi, int inEi)
	{
		if(postSi > postEi || inSi > inEi)
		{
			return null;
		}
		int val = post[postEi];
		Node newNode = new Node(val, null, null);
		int index = -1;
		for(int i = inSi; i <= inEi; i++)
		{
			if(in[i] == val)
			{
				index = i;
				break;
			}
		}
		int gap = inEi - index;
		newNode.right = buildPost_InHelper(post, postSi, postEi - 1, in, index + 1, inEi);
		newNode.left = buildPost_InHelper(post, postSi, postEi - 1 - gap, in, inSi, index - 1);
		return newNode;
	}

	//Diameter
	public int diameter()
	{
		//return this.diameter(root);
		return this.diameter2(root).diameter;
	}
	private int diameter(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int factor1 = diameter(node.left);
		int factor2 = diameter(node.right);
		int factor3 = heightHelper(node.left) + heightHelper(node.right) + 2;
		
		return Math.max(factor1, Math.max(factor2, factor3));
	}

	private Pair diameter2(Node node)
	{
		if(node == null)
		{
			return new Pair(-1, -1);
		}
		Pair lPair = diameter2(node.left);
		Pair rPair = diameter2(node.right);
		
		int factor1 = lPair.diameter;
		int factor2 = rPair.diameter;
		int factor3 = lPair.height + rPair.height + 2;
		
		//retVal height 
		int height = Math.max(lPair.height, rPair.height) + 1;
		int diameter = Math.max(factor1, Math.max(factor2, factor3));
				
		Pair retVal = new Pair(height, diameter );
		return retVal;
		
	}
}	





