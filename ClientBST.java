package classDemos;

import shared.BSTEmptyException;

public class ClientBST {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.addElement(8);
		tree.addElement(3);
		tree.addElement(11);
		tree.addElement(2);
		tree.addElement(6);
		tree.addElement(14);
		tree.addElement(9);
     	tree.levelOrderTraversal();
     	
     

	}

}
