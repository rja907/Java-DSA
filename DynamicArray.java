package classDemos;

public class DynamicArray {
	
		private int[] data;
		
		private int lastIndex;
		
		public static final int DEFAULT_CAPACITY = 16;
		
		public DynamicArray()
		{
			this.data = new int[DEFAULT_CAPACITY];
			this.lastIndex = -1;
	    }
		
		public DynamicArray(int capacity)
		{
			this.data = new int[capacity];
			this.lastIndex = -1;
		}
		
		public int getSize()
		{
			return this.lastIndex + 1;
		}
		
		public void add(int item)
		{
			if(isFull())
			{
				resize();
			}
			
			lastIndex++;
			this.data[lastIndex] = item;
		}
		
		public int get(int index)
		{
			int retVal = -1;
			if(checkIndexBounds(index))
			{
				retVal = this.data[index];
			}
			else
			{
				System.out.println("Invalid index!");
			}
			return retVal;
		}
		
		public void removeAt(int index)
		{
			if(checkIndexBounds(index))
			{
				for(int j = index + 1; j <= this.lastIndex; j++)
				{
					this.data[j - 1] = this.data[j];
				}
				this.lastIndex--;
			}
			else
			{
				System.out.println("Invalid index!");
			}
		}
		
		public void addAt(int item, int index)
		{
			if(checkIndexBounds(index))
			{
				if(isFull())
				{
					resize();
				}
				for(int j = this.lastIndex; j >= index; j--)
				{
					this.data[j + 1] = this.data[j];
				}
				this.data[index] = item;
				this.lastIndex++;
			}
			else
			{
				System.out.println("Invalid index!");
			}
		}
		
		public void set(int item, int index)
		{
			if(checkIndexBounds(index))
			{
				this.data[index] = item;
			}
			else
			{
				System.out.println("Invalid index!");
			}
		}
		
		private boolean checkIndexBounds(int index)
		{
			boolean retVal = false;
			if(index >= 0 && index <= this.lastIndex)
			{
				retVal = true;
			}
			return retVal;
		}
		
		public boolean isEmpty()
		{
			boolean retVal = false;
			if(this.lastIndex == -1)
			{
				retVal = true;
			}
			return retVal;
		}
		
		private boolean isFull()
		{
			boolean retVal = false;
			if(this.lastIndex == this.data.length - 1)
			{
				retVal = true;
			}
			return retVal;
		}
		
		public void display(){
			for(int i = 0; i <= this.lastIndex; i++){
				System.out.print(this.data[i] + " ");
			}
			
			System.out.println("END");
		}
		
		private void resize()
		{
			int[] newArray = new int[this.data.length * 2];
			for(int i = 0; i < this.data.length; i++)
			{
				newArray[i] = this.data[i];
			}
			this.data = newArray;
		}
}
