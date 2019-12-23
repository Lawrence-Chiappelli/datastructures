package lab6;

public class RecursionExercises {
	
	/**
	 * Given an integer n, find the sum of the series 1^1 + 2^2 + 3^3 + ¡­.. + n^n 
	 * using recursion.
	 * @param n 
	 * @return the sum of the series 1^1 + 2^2 + 3^3 + ¡­.. + n^n 
	 */
	public static double sum(int n)
	{
		if (n<=1)
			return n;
		
		return Math.pow(n, n) + sum(n-1);
	}
	
	
	/**
	 * Climbing stairs Problem: @restriction: Each time can climb 1, 2 or 3 steps.
	 * @param n - total number of steps
	 * @return the number of distinct ways from bottom to top
	 */
	public static long climbStairs(int n)
	{
		if (n<=1) return 1;
		if (n==2) return 2;
		if (n==3) return 4;
		
		return climbStairs(n-3) + climbStairs(n-2) + climbStairs(n-1);
	}
	
	
	/**
	 * Find the index of the given target in sorted array (assume no duplicated elements)
	 * Example: (arr = [1 2 4 7 9], target = 7, start = 0, end = 4)  return true
	 * @param arr
	 * @param target
	 * @param start - starting index
	 * @param end - ending index
	 * @return true the given target in sorted array or false if not found
	 */
	public static boolean  binSearchTarget(int[] arr, int target, int start, int end)
	{
		if (arr[start] == target) return true;
		else if (start == end) return false;
		
		return binSearchTarget(arr, target, start+1, end);		
		
	}
	
		
//	==============================  5%  Extra Credit ==================================
	/**
	 * Find the index of first occurrence of given target in sorted array (allow duplicated elements)
	 * Example: (arr = [1 1 1 2 4], target = 1, start = 0, end = 4)  return 0
	 * @param arr
	 * @param target
	 * @param start - starting index
	 * @param end - ending index
	 * 
	 * @return the index of first occurrence of the given target in sorted array or -1 if not found
	 */
    // Please also add at least two J-unit test cases in the test file.
	public static int  binSearchTargetDup(int[] arr, int target, int start, int end)
	{
		if (arr[start] == target) return start;
		if (start == end) return -1;
	
		return binSearchTargetDup(arr, target, start+1, end);				
	}
	
	
	
//	==============================  5%  Extra Credit ==================================
	/*
	  Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
	  how many ways can we make the change? The order of coins doesn’t matter.
	  Examples :
      
      For example:
      For N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
      So output should be 4. 
      
      For N = 10 and S = {2, 5, 3, 6}, 
      there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
      and {5,5}. So the output should be 5.		
	 */
	
	public static int numCoinChange(int N, int[] S)
	{
		// Combination = factorial(n) / (factorial(r) * factorial(n-r))
		
		return numCoinChange(N-1, S);
	}
}
