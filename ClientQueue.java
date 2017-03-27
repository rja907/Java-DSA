package clients;

import queueProblems.*;
import shared.QueueEmptyException;
import shared.QueueFullException;
import shared.StackEmptyException;

public class ClientQueue {

	public static void main(String[] args) {
		
		//---------------------------- Queue using array ---------------------
		/*QueueUsingArrays queue = new QueueUsingArrays(4);
		try
		{
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			queue.enqueue(5);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println(queue);
		try
		{
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.front());
		//	System.out.println(queue.dequeue());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println(queue);*/
		
		
		//----------------------------Queue using dynamic arrays---------------------
		QueueUsingDA queueDA = new QueueUsingDA(3);
		queueDA.enqueue(1);
		queueDA.enqueue(2);
		queueDA.enqueue(3);
		queueDA.enqueue(4);
		queueDA.enqueue(5);
		queueDA.enqueue(6);
		System.out.println(queueDA);
		try
		{
			System.out.println(queueDA.dequeue());
			System.out.println(queueDA.dequeue());
			//System.out.println(queueDA.dequeue());
			System.out.println("Front : "+queueDA.front());
			queueDA.enqueue(1);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println(queueDA);
		
		//-------------Reverse a queue---------------
		/*QueueUsingArrays qA = new QueueUsingArrays(4);
		try
		{
			qA.enqueue(1);
			qA.enqueue(2);
			qA.enqueue(3);
			qA.enqueue(4);
			qA.dequeue();
			qA.enqueue(5);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println(qA);
		qA.reverse();
		System.out.println(qA);*/
		
		//---------------Generic Queue---------------
		/*Queue<Integer> q = new Queue<Integer>(4);
		try
		{
			q.enqueue(4);
			q.enqueue(8);
			q.enqueue(1);
			q.enqueue(5);
			q.enqueue(2);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println(q);*/
		
		
		//----------------------------- Queue using two stacks-----------------\\
		/*QueueUsingTwoStacks<Integer> qS = new QueueUsingTwoStacks<Integer>(4);
		try
		{
			qS.enqueue(1);
			qS.enqueue(2);
			qS.enqueue(3);
			qS.enqueue(4);
			qS.enqueue(5);
		}
		catch(QueueFullException qFx)
		{
			System.out.println(qFx.getMessage());
		}
		System.out.println(qS);
		try
		{
			System.out.println(qS.dequeue());
			System.out.println(qS.dequeue());
			System.out.println(qS.front());
			System.out.println(qS.dequeue());
			System.out.println(qS.dequeue());
			System.out.println(qS.dequeue());
		}
		catch(QueueEmptyException qEx)
		{
			System.out.println(qEx.getMessage());
		}*/
		
		//----------------------------------- Queue using linked list-----------------------------//
		
	/*	QueueUsingLinkedList<Integer> qList = new QueueUsingLinkedList<Integer>();
		qList.enqueue(3);
		qList.enqueue(4);
		qList.enqueue(5);
		qList.enqueue(6);
		qList.display();
		try {
			System.out.println(qList.dequeue());
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}
		qList.display();
		try {
			System.out.println(qList.front());
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}
		qList.display();*/
		
	}

}
