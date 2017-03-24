package classDemos;

public class AllIndicesOfSeven {

	public static int[] allIndicesOfElement(int[] arr, int si, int elem)
	{
		if(si == arr.length)
		{
			return new int[0];
		}
		
		int[] smaller = allIndicesOfElement(arr, si+1, elem);
		if(arr[si] == elem)
		{
			int[] larger = new int[smaller.length + 1];
			int i = 0;
			for(i = 0; i < smaller.length; i++)
			{
				larger[i] = smaller[i];
			}
			larger[i] = si;
			
			return larger;
		}
		else
		{
			return smaller;
		}
	}
	
	public static int[] allIndicesOfElement(int[] arr, int si, int elem, int count)
	{
		if(si == arr.length)
		{
			return new int[count];
		}
		if(arr[si] == elem)
		{
			count++;
		}
		int[] result = allIndicesOfElement(arr, si + 1, elem, count);
		if(arr[si] == elem)
		{
			result[count - 1] = si;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {1,5,8,9,10,7,23,7,89,7,7,7};
		int[] indices = allIndicesOfElement(arr, 0, 7,0);
		
		for(int val : indices)
		{
			System.out.println(val);
		}
	}

}
