package classDemos;


public class CheckSeven {

	public static boolean checkIfContainsSeven(int[] arr, int startIndex, int elem)
	{
		if(startIndex == arr.length)
		{
			return false;
		}
		if(arr[startIndex] == elem)
		{
			return true;
		}
		return  checkIfContainsSeven(arr, startIndex + 1,elem);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,8,9,10};
		System.out.println(checkIfContainsSeven(arr, 0, 910));
	}

}
