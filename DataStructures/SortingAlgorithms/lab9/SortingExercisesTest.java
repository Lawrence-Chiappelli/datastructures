/**
 * 
 */
package lab9;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author liz2
 *
 */
public class SortingExercisesTest {

	@Test
	public void quickSortTest1() {
		int[] arr = {5, 0, 3, 10, 0, 3};
		int[] expected = {10, 5, 3, 3, 0, 0};
		
		assertArrayEquals("quickSort failed", expected, SortingExercises.quickSort(arr));		
		
	}

	@Test
	public void quickSortTest2() {
		int[] arr = {5, 5, 11, 11};
		int[] expected = {11, 11, 5, 5};
		
		assertArrayEquals("quickSort failed", expected, SortingExercises.quickSort(arr));		
		
	}
	
	@Test
	public void improvedBubbleSortTest1() {
		int[] arr = {5, 0, 3, 10, 0, 3};
		int[] expected = {0, 0, 3, 3, 5, 10};
		
		assertArrayEquals("improvedBubbleSort failed", expected, SortingExercises.improvedBubbleSort(arr));		
		
	}
	
	@Test
	public void improvedBubbleSortTest2() {
		int[] arr = {1,2,3,4,6,5};
		int[] expected = {1,2,3,4,5,6};
		
		assertArrayEquals("improvedBubbleSort failed", expected, SortingExercises.improvedBubbleSort(arr));		
		
	}
	
	@Test
	public void threeNumsSortTest1() {
		int[] arr = {0, 1, 2, 2, 1, 0, 1, 0};
		int[] expected = {0, 0, 0, 1, 1, 1, 2, 2};
		
		assertArrayEquals("threeNumsSort failed", expected, SortingExercises.threeNumsSort(arr));		
	}
	
	@Test
	public void threeNumsSortTest2() {
		int[] arr = {0, 1, 0, 1, 0};
		int[] expected = {0, 0, 0, 1, 1};
		
		assertArrayEquals("threeNumsSort failed", expected, SortingExercises.threeNumsSort(arr));		
	}
	
	
/*
 * 	Uncomment the following test cases for extra credits ... 
 */

	@Test
	public void recursiveBubbleSortTest1() {
		Integer[] arr = {0, 1, 2, 2, 1, 0, 1, 0};
		Integer[] expected = {0, 0, 0, 1, 1, 1, 2, 2};
		SortingExercises.recursiveBubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		assertArrayEquals("recursiveBubbleSort failed", expected, arr);		
	}
	
	@Test
	public void recursiveBubbleSortTest2() {
		Character[] arr = {'z', 'a', 'd', 'b', 'c'};
		Character[] expected = {'a', 'b', 'c', 'd', 'z'};
		
		assertArrayEquals("recursiveBubbleSort failed", expected, SortingExercises.recursiveBubbleSort(arr));		
	}
	
}
