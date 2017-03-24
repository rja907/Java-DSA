package classDemos;

public class FirstIndexOfSeven {

	public static int firstIndexOfElement(int[] arr, int si, int elem)
	{
		if(si == arr.length)
		{
			return -1;
		}
		if(arr[si] == elem)
		{
			return si;
		}
		return firstIndexOfElement(arr, si + 1, elem);
	}
	public static void main(String[] args) {
		int[] arr = {1,5,7,8,9,10};
		int index = firstIndexOfElement(arr, 0, 7);
		if(index == -1)
		{
			System.out.println("Element not found!");
		}
		else
		{
			System.out.println("Element found at index : "+index);
		}
	}

}
