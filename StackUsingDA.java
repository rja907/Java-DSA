package stackProblems;

public class StackUsingDA extends StackUsingArray{
	
	public StackUsingDA(int capacity)
	{
		super(capacity);
	}
	
	@Override
	public void push(int item)
	{
		if(isFull())
		{
			resize();
		}
		this.top++;
		this.data[this.top] = item;
	}
	
	private void resize()
	{
		int[] temp = new int[this.data.length * 2];
		for(int i = 0; i <this.data.length; i++)
		{
			temp[i] = this.data[i];
		}
		this.data = temp;
	}
}
