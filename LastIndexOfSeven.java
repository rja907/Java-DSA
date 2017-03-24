package classDemos;

public class LastIndexOfSeven {
	
	public static int lastIndexOfElement(int[] arr, int si, int elem)
	{
		if(si == arr.length)
		{
			return -1;
		}
	    int foundAt = lastIndexOfElement(arr, si + 1, elem);
	    if(foundAt == -1)
	    {
	    	if(arr[si] == elem)
	    	{
	    		return si;
	    	}
	    	else
	    	{
	    		return -1;
	    	}
	    }
	    else
	    {
	    	return foundAt;
	    }
	}
	public static void main(String[] args) {
		int[] arr = {1,17,6,27,8,9,7};
		int index = lastIndexOfElement(arr, 0, 7);
		System.out.println(index);
	}

}
