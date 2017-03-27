package shared;

public interface IQueueInt {
	 void enqueue(int item) throws QueueFullException;
	 int dequeue() throws QueueEmptyException;
	 int getSize();
	 int front() throws QueueEmptyException;
}
