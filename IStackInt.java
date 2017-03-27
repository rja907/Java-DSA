package shared;

public interface IStackInt {
	
	void push(int item) throws StackFullException;
	int pop() throws StackEmptyException;
	int top() throws StackEmptyException;
	int getSize();
}
