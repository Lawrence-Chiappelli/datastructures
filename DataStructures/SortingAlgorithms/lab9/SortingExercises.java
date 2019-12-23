package lab9;

public class SortingExercises {
	
	/*
	 * Please implement quickSort algorithm 
	 * to sort any given integer array in non-increasing order
	 * Example: 
	 *    input: arr = [5, 0, 3, 10, 0, 3]
	 *    return [10, 5, 3, 3, 0, 0] 
	 *
	 */
	/**
	 * @param arr - input array (unsorted)
	 * @return array in non-increasing order
	 */
	public static int[] quickSort(int[] arr)
	{
		quickSort_helper(arr, 0, arr.length-1);
		return arr;
	}
	
	private static void quickSort_helper(int[] arr, int low, int high)
	{		
		if (low >= high)
			return;
		else
		{
			int pivot_index = partition(arr, low, high);
			quickSort_helper(arr, low, pivot_index-1);
			quickSort_helper(arr, pivot_index+1, high);
		}
	}
	
	private static void swap(int[] arr, int index1, int index2)
	{
		int temp_value = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp_value;
	}
	
	public static int partition(int[] arr, int _low, int _high) 
	{
		int low = _low;
		int high = _high-1;
		int pivot = arr[_high];
		
		while (low<=high) 
		{

			while (low <= high && arr[low] >= pivot)
			{
				low++;
			}
			
			while (low <= high && arr[high] < pivot)
			{
				high--;
			}
			
			if (low<high) 
			{
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		
		swap(arr, low, _high);
		return high;
	}
	
		
	/*
	 * Please implement improved Bubble Sort algorithm (NOT the regular bubble sort) to sort any given integer array
	 * Note: improved Bubble Sort is the one using a flag to detect if array has been already sorted and hence can stop earlier.
	 * (If you can't recall this algorithm, please check the lecture note posted on blackboard.)
	 *  
	 *  Example: 
	 *    input: arr = [5, 0, 3, 10, 0, 3]
	 *    return [0, 0, 3, 3, 5, 10] 
	 */
	/**
	 * @param arr - input array (unsorted)
	 * @return array sorted in non-decreasing order
	 */
	public static int[] improvedBubbleSort(int[] arr)
	{
		if(arr == null || arr.length==0) return arr;
		
		boolean did_swap = false;
		
		for (int i = 0; i < arr.length-1; i++)
		{
			if (arr[i] > arr[i+1])
			{
				did_swap = true;
				swap(arr, i, i+1);
			}
		}
		
		if (did_swap) improvedBubbleSort(arr);
		return arr;
	}
	
	
	
	/*
	 * Given an array containing only 0's, 1's and/or 2's, please implement an in-place [without using extra memory]
	 * algorithm to sort the array in O(N) time.
	 * 
	 * Example: 
	 *    input: arr = [0, 1, 2, 2, 1, 0, 1, 0]
	 *    return [0, 0, 0, 1, 1, 1, 2, 2]  
	 */
		
	/**
	 * @param arr  - input array 
	 * @return array sorted in non-decreasing order
	 */
	
	//Used merge sort, which has O(n) worst-case time complexity
	public static int[] threeNumsSort(int[] arr)
	{
		threeNumsSort_helper(arr, 0, arr.length-1);
		return arr;
	}
	
	private static void threeNumsSort_helper(int[] arr, int lowerBound, int upperBound)
	{
		if (lowerBound >= upperBound) 
			return; // if range is 0 or 1, no need to sort
		else
		{
			
			int mid = (lowerBound+upperBound) / 2; // find midpoint
			threeNumsSort_helper(arr, lowerBound, mid); // sort low half
			threeNumsSort_helper(arr, mid+1, upperBound); // sort high half
			merge(arr, lowerBound, mid, upperBound); // merge them
		}
	}
	
	private static void merge(int[] arr, int low1, int high1, int high2)
	{
		int n = high2 - low1 + 1; // # of items
		int[] tmp=new int[n]; // temporary array
		int j = 0; // temporary index
		int low2 = high1 + 1;
		int i1 = low1; // index in the first part
		int i2 = low2; // index in the second part
		
		while (i1 <= high1 && i2 <= high2)
		{
			if (arr[i1] < arr[i2])
			{
				tmp[j++] = arr[i1++];
			}
			else
			{
				tmp[j++] = arr[i2++];
			}
		}
		
		while (i1 <= high1) // copy remaining elements in the first part
		{
			tmp[j++] = arr[i1++];
		}
		
		while (i2 <= high2) // copy remaining elements in the second part
		{
			tmp[j++] = arr[i2++];
		}
		
		for (j=0; j<n; j++) // copy everything back to original array
		{
			arr[low1+j] = tmp[j];
		}
	}
	
			
	
	
    /* ====== Extra Credit (10% question)  ==============================*/	
	
	/*
	 * Please implement bubble sort algorithm using recursion. Feel free to add any helper function if needed.
	 * 
	 */
	/**
	 * 
	 * @param arr - a generic array
	 * @return array sorted in non-decreasing order
	 */
	
	public static<E extends Comparable<E>> E[] recursiveBubbleSort(E[] arr)
	{
			
			if(arr == null || arr.length==0) return arr;
			
			boolean did_swap = false;
			
			for (int i = 0; i < arr.length-1; i++)
			{
				if (arr[i].compareTo(arr[i+1]) > 0)
				{
					did_swap = true;
					swap_generic(arr, i, i+1);
				}
			}
			
			if (did_swap) recursiveBubbleSort(arr);
			return arr;
	}
	
		private static <E extends Comparable<E>> void swap_generic(E[] arr, int index1, int index2)
		{
			E temp_value = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp_value;
		}
	
}
