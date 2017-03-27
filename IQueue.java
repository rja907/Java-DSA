package shared;

public interface IQueue<T> {
	void enqueue(T item) throws QueueFullException;
	 T dequeue() throws QueueEmptyException;
	 int getSize();
	 T front() throws QueueEmptyException;
}
