package classDemos;

public class SelectionSort {

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
	
	public static void selectionSortRecursive(int[] arr,int siArray, int siMin, int mEI)
	{
		if(siArray == arr.length - 1)
		{
			return;
		}
		if(siMin == arr.length)
		{
			swapArrayItems(arr, siArray, mEI);
			selectionSortRecursive(arr, siArray + 1, siArray + 1, siArray + 1);
			return;
		}
		if(arr[siMin] < arr[mEI])
		{
			mEI = siMin;
		}
		selectionSortRecursive(arr,siArray, siMin+ 1, mEI);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,67,32,21,8,3,0,45,11,2,32, -1};
		printArray(arr);
		System.out.println();
		selectionSortRecursive(arr, 0, 0, 0);
		printArray(arr);
	}
}
