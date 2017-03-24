package classDemos;


public class CheckForSortedArray {
	
	public static boolean checkIfSorted(int[] arr, int si)
	{
		if(si == arr.length - 1)
		{
			return true;
		}
		if(arr[si] > arr[si  + 1])
		{
			return false;
		}
		return checkIfSorted(arr,  si + 1);
	}
	public static void main(String[] args) {
		int[] arr = {11,3,4,5,16,7,8,9};
		boolean result = checkIfSorted(arr, 0);
		System.out.println(result);
	}
	
	

}
