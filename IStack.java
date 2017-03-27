package shared;

public interface IStack<T> {
	
	void push(T item) throws StackFullException;
	T pop() throws StackEmptyException;
	T top() throws StackEmptyException;

	int getSize();
	
}
