package classDemos;

import java.util.HashMap;

public class Trie {
	private class Node
	{
		Character data;
		boolean isTerminal;
		HashMap<Character, Node> children;
		
		Node(Character data, boolean isTerminal)
		{
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();
		}
	}

	private Node root;
	private int size;
	
	public Trie()
	{
		root = new Node('\0',false);
		this.size = 0;
	}

	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size == 0;
	}

	public boolean contains(String word)
	{
		Node temp = this.root;
		for(int i = 0; i < word.length(); i++)
		{
			Node child = temp.children.get(word.charAt(i));
			if(child == null)
			{
				return false;
			}
			temp = child;
		}
		return temp.isTerminal;
	}

	public void addWord(String word)
	{
		this.addWord(root, word);
	}
	private void addWord(Node node, String word)
	{
		if(word.length() == 0)
		{
			if(!node.isTerminal)
			{
				node.isTerminal = true;
				this.size++;
			}
			return;
		}
		Node child = node.children.get(word.charAt(0));
		if(child == null)
		{
			child = new Node(word.charAt(0), false);
			node.children.put(word.charAt(0), child);
		}
		addWord(child, word.substring(1));
	}
	
	public void removeWord(String word)
	{
		removeWord(root, word);
	}
	private void removeWord(Node node, String word)
	{
		if(word.length() == 0)
		{
			if(node.isTerminal)
			{
				node.isTerminal = false;
				this.size--;
			}
			return;
		}
		Node child = node.children.get(word.charAt(0));
		if(child == null)
		{
			//word to be removed not found;
			return;
		}
		removeWord(child, word.substring(1));
		if(!child.isTerminal && child.children.size() == 0)
		{
			node.children.remove(word.charAt(0)); 
		}
	}
}
