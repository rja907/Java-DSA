package linkedList;

public class LinkedListClient {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//list.addLast(7);
		list.addLast(6);
		list.addLast(5);
		list.addLast(4);
	//	list.addLast(4);
		list.addLast(5);
		list.addLast(16);
		list.display();
		
		list.mergeSort();
		list.display();
		try 
		{
			System.out.println(list.find(44));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//list.deleteLast();
		//list.display();
		
		//list.deleteFirst();
		//list.display();
		
		//System.out.println(list.getSize());
		
		
		//list.displayIth(2);
		//list.insertionRecursiveAtI(45, 2);
		//list.insertionRecursiveAtI(687, 2);
		//list.display();
		
	    //list.deletionRecursiveAtI(2);
		//list.display();
		
		//System.out.println("Mid point : "+list.midPoint());
		//list.selectionSort();
		//list.display();
		
		
		//list.reverse();
		//list.display();
		
		//System.out.println("Mid : " +list.findMid());
		
		//list.printReverse();
		//System.out.println();
		
		//System.out.println("Last Ith : "+list.findLastIth(1));
	
		//list.appendLastNToFront(3);
		//list.display();
		
		//list.reverseIteratively();
		//list.display();
		
		//System.out.println(list.checkPalindrome());
	}

}
