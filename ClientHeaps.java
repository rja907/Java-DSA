package classDemos;


public class ClientHeaps {

	public static void heapSort(int[] arr)
	{
		int n = arr.length;
		for(int i = n/2 - 1; i >= 0; i--)
		{
			downHeapify(arr, 0, n);
		}
		
		for(int i = n-1; i >= 1; i--)
		{
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			downHeapify(arr, 0, i);
		}
	}
	
	public static void downHeapify(int[] arr, int pi, int lp)
	{
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		
		int maxIndex = pi;
	
		if(lci < lp &&  arr[maxIndex] < arr[lci])
		{
			maxIndex = lci;
		}
		if(rci < lp &&  arr[maxIndex] < arr[rci])
		{
			maxIndex = rci;
		}
		
		if(maxIndex != pi)
		{
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[pi];
			arr[pi] = temp;
			downHeapify(arr,maxIndex, lp);
		}
	}
	
	public static void main(String[] args) {
	
		Heap<Integer, String> heap = new Heap<Integer, String>(true);
		heap.add(1, "UK");
		heap.add(10, "India");
		heap.add(13, "USA");
		heap.add(0, "China");
		heap.add(-1, "Pakistan");
		heap.add(4, "Nepal");
		System.out.println(heap);
		
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		int[] arr = {6,5,4,3,2,1};
		heapSort(arr);
		for(int val: arr)
		{
			System.out.print(val + " ");
		}
	}
}

