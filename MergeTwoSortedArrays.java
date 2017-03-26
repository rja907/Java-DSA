package classDemos;

public class MergeTwoSortedArrays {

	public static int[] merge(int[] arr1, int[] arr2)
	{
		int[] result = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while(i < arr1.length && j < arr2.length)
		{
			if(arr1[i] < arr2[j])
			{
				result[k++] = arr1[i];
				i++;
			}
			else
			{
				result[k++] = arr2[j];
				j++;
			}
		}
		
		while(i < arr1.length)
		{
			result[k++] = arr1[i];
			i++;
		}
		while(j < arr2.length)
		{
			result[k++] = arr2[j];
			j++;
		}
		return result;
 	}
	
	public static void printArray(int[] array)
	{
		int i = 0;
		while(i < array.length)
		{
			System.out.print(array[i] + " ");
			i = i + 1;
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,7,8,9,10};
		int[] arr2 = {3,4,5,11,23,45};
		int[] result = merge(arr1,arr2);
		printArray(result);
	}

}
