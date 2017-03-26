package classDemos;

import java.util.Scanner;

public class MergeSort {

	public static int[] inputArray()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of array : ");
		int size = s.nextInt();
		int[] array = new int[size];
		int i = 0;
		while(i < size)
		{
			System.out.println("Enter "+i + "th value :");
			array[i] = s.nextInt();
			i = i + 1; 
		}
		return array;
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
	
	public static int[] mergeSort(int[] arr, int left, int right)
	{
		if(left == right)
		{
			return new int[]{arr[left]};
		}
		int mid = (left + right)/2;
		int[] leftArray = mergeSort(arr, left, mid);
		int[] rightArray = mergeSort(arr, mid+1, right);
		int[] result = merge(leftArray,rightArray);
		return result;
	}
	
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
	
	public static void main(String[] args) {
		int[] input = inputArray();
		printArray(input);
		System.out.println();
		
		//Merge Sort
		//Input - 9 4 9 8 0 12 54 2 91 1
		input = mergeSort(input, 0, input.length - 1);
		printArray(input);
		System.out.println();
		
	}

}
