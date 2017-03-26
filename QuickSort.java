package classDemos;

public class QuickSort {

	public static void printArray(int[] array)
	{
		int i = 0;
		while(i < array.length)
		{
			System.out.print(array[i] + " ");
			i = i + 1;
		}
		System.out.println();
	}
	
	public static void swapArrayElements(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void quickSort(int[] arr, int lo, int hi)
	{
		if(lo >= hi)
		{
			return;
		}
		int pi = (lo + hi)/2;
		int pivot = arr[pi];
		int leftI = lo, rightI = hi;
		while(leftI <= rightI)
		{
			while(arr[leftI] < pivot)
			{
				leftI++;
			}
			while(arr[rightI] > pivot)
			{
				rightI--;
			}
			if(leftI <= rightI)
			{
				swapArrayElements(arr, leftI, rightI);
				leftI++;
				rightI--;
			}
		}
		quickSort(arr, lo , rightI);
		quickSort(arr, leftI, hi);
	}

	public static void main(String[] args) {
		int[] arr =  {-2, -1, 5,4,3,2,1,0,9,8,7};
		printArray(arr);
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);
	}

}
