package clients;

import java.util.Stack;

import shared.*;
import stackProblems.*;

public class ClientStack {

	public static void main(String[] args) {
		
		//------------------------------------ Stack for Ints---------------
		/*StackUsingArray s = new StackUsingArray(4);
		
		try
		{
			s.push(4);
			s.push(42);
			s.push(43);
			s.push(44);
			s.push(67);
		}
		catch(StackFullException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println(s);
		System.out.println("Size : "+s.getSize());
		try
		{
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
		}
		catch(StackEmptyException ex)
		{
			System.out.println(ex.getMessage());
		}
		*/
		
		//------------------------------------ Generic Stack------------------
		/*Stack<String> stack = new Stack<String>(5);
		try {
			stack.push("aaa");
			stack.push("b");
			stack.push("d");
			stack.push("c");
			stack.push("r");
			stack.push("s");
		} catch (StackFullException e) {
			System.out.println(e.getMessage());
		}
		stack.display();
		
		try {
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} 
		catch (StackEmptyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(stack.getSize());*/
		
		//------------------------------------ Stack using dynamic array---------------
		/*StackUsingDA sDA = new StackUsingDA(3);
		sDA.push(5);
		sDA.push(6);
		sDA.push(7);
		sDA.push(8);
		sDA.push(9);
		
		System.out.println(sDA);*/
		
		//-----------------------------------Stack using two queues-----------------------------
		
	/*	StackUsingTwoQueues<Integer> sQ = new StackUsingTwoQueues<Integer>(4);
 		try
 		{
 			sQ.push(1);
 			sQ.push(2);
 			sQ.push(3);
 			sQ.push(4);
 			sQ.push(5);
 		}
 		catch(StackFullException sFx)
 		{
 			System.out.println(sFx.getMessage());
 		}
 		catch(Exception ex)
 		{
 			System.out.println(ex.getMessage());
 		}
 		System.out.println(sQ);
 		
 		try
 		{
 			System.out.println(sQ.pop());
 			System.out.println(sQ.pop());
 			System.out.println("Top : "+sQ.top());
 		}
 		catch(StackEmptyException sEx)
 		{
 			System.out.println(sEx.getMessage());
 		}
 		catch(Exception ex)
 		{
 			System.out.println(ex.getMessage());
 		}
 		System.out.println(sQ);*/
		
		StackUsingLinkedList<Integer> sList = new StackUsingLinkedList<Integer>();
		sList.push(4);
		sList.push(3);
		sList.push(2);
		sList.push(1);
		sList.push(0);
		sList.push(-1);
		sList.display();
		try {
			System.out.println(sList.pop());
		} catch (StackEmptyException e) {
			e.printStackTrace();
		}
		sList.display();
	}

}
