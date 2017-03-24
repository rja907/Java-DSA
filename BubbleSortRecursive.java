package classDemos;

public class BubbleSortRecursive {

	public static void printArray(int[] array)
	{
		int i = 0;
		while(i < array.length)
		{
			System.out.print(array[i] + " ");
			i = i + 1;
		}
	}
	
	public static void swapArrayItems(int[] arr, int i, int j)
	{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
	}

	public static void bubbleSortRecursive(int[] arr, int eI, int siBubble)
	{
		if(eI == 0)
		{
			return;
		}
		if(siBubble == eI)
		{
			bubbleSortRecursive(arr, eI - 1 , 0);
			return;
		}
		if(arr[siBubble] > arr[siBubble + 1])
		{
			swapArrayItems(arr, siBubble, siBubble + 1); 
		}
		bubbleSortRecursive(arr, eI, siBubble + 1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,67,32,21,8,3,0,45,11,2,32, -1};
		//int[] arr = {1,67,32,21,8,0};
		printArray(arr);
		System.out.println();
		bubbleSortRecursive(arr, arr.length - 1, 0);
		printArray(arr);
	}

}
