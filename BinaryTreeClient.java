package classDemos;

public class BinaryTreeClient {

	public static void main(String[] args) {
		
		//Input - 1 true 2 true 4 false false true 5 false false true 3 true 6 false false false
		//Input - 1 true 2 true 5 false true 8 false true 9 false false false true 3 true 6 false false false
		//Input - 1 true 2 true 4 false false true 5 false false true 3 true 6 false false true 7 false false
		 BinaryTree btree = new BinaryTree();
		//btree.inorderTraversal();
		//btree.preorderTraversal();
		//btree.postorderTraversal();
		//System.out.println("Size : "+btree.getSize());
		
		//btree.levelorderTraversal();
		
		//System.out.println(btree.searchElement(4));
		//btree.getMirror();
		btree.levelorderTraversal();
		//int[] pre = {1,2,4,5,3,6};
		//int[] in = {4,2,5,1,6,3};
		//int[] post = {4,5,2,6,3,1};
		//BinaryTree btree = new BinaryTree(post, in, 1);
		
		//btree.inorderTraversal();
		//btree.preorderTraversal();
		//btree.postorderTraversal();
		
		System.out.println(btree.diameter());
		
	}

}
