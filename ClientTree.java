package classDemos;

public class ClientTree {

	public static void main(String[] args) {
		
		//Input - 1 3 2 2 5 0 6 0 3 1 7 0 4 3 8 0 9 0 10 0
		//Input - 1 3 2 0 3 0 4 1 5 0
		//Input - 1 3 2 2 5 0 6 0 3 1 8 1 9 0 4 0
		//Input - 1 3 2 2 5 2 9 0 10 0 6 0 3 0 4 2 7 2 11 0 12 0 8 0
		Tree tree = new Tree();
	//	tree.display();
		
	//	System.out.println("Root : "+tree.root());
		tree.preOrderTraversal();
		tree.postOrderTraversal();
	//	tree.levelOrderTraversal();
		
	//	System.out.println("Max : "+tree.findMax());
	//	System.out.println( "No of nodes : "+tree.count());
		
	//	System.out.println(tree.noOfNodesGreaterThanX(5));
		
	//	System.out.println(tree.nodeWithMaximumSum());
	//	System.out.println(tree.sumOfAllNodes());
		
	//	System.out.println(tree.countLeafNodes());
		
		//GenericTree<Integer> tree2 = new GenericTree<Integer>();
		//System.out.println(tree.checkIfIdentical(tree2));
		
		//Peform null checking before printing the result as null may also be returned
		//System.out.println(tree.valueJustGreaterThanN(5));
		
		//System.out.println("Height of tree : " + tree.height());
		
	//	tree.printAtDepthK(2);
	}

}
