package stackProblems;

public class GenericStack<T> {

	private T[] data;
	private int top;
	
	//Constructor
	public GenericStack(int capacity)
	{
		this.data = (T[]) new Object[capacity];
		this.top = -1;
	}
	
	//Push
	public void push(T item){
		if(this.isFull())
		{
		}
		else
		{
			this.top++;
			this.data[this.top] = item;
		}
	}
	
	//Pop
	public T pop(){
		T retVal = null;
		if(this.isEmpty())
		{
		}
		else
		{
			retVal = this.data[this.top];
			this.top--;
		}
		return retVal;
	}
	
	//Top
	public T top(){
		T retVal = null;
		if(this.isEmpty())
		{
		}
		else
		{
			retVal = this.data[this.top];
		}
		return retVal;
	}
	
	//Display
	public void display() {
		for(int i = this.top; i >=0; i--)
		{
			System.out.print(this.data[i] + " ");
		}
		System.out.println("END");
	}
	
	//Size
	public int getSize() {
		return this.top + 1;
	}
	
	//Check empty
	public boolean isEmpty() {
		boolean retVal = false;
		if(this.top == -1)
		{
			retVal = true;
		}
		return retVal;
	}
	
	//Check full
	public boolean isFull() {
		boolean retVal = false;
		if(this.top == this.data.length - 1)
		{
			retVal = true;
		}
		return retVal;
	}

	@Override
	public String toString()
	{
		String retVal = "";
		for(int i = this.top; i >=0; i--)
		{
			retVal += this.data[i] + " ";
		}
		return retVal;
	}
}
