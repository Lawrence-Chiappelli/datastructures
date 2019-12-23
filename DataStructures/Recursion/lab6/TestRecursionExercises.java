package lab6;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecursionExercises {
	
@Test(timeout = 100)
public void testsum() 
{
	assertEquals("sum function failed ", 32, RecursionExercises.sum(3), 0.1);
	assertEquals("sum function failed ", 288, RecursionExercises.sum(4), 0.1);
	assertEquals("sum function failed ", 3413, RecursionExercises.sum(5), 0.1);	
}

@Test(timeout = 100)
public void testclimbStairs() 
{
	assertEquals("climbStairs function failed ", 7, RecursionExercises.climbStairs(4));
	assertEquals("climbStairs function failed ", 13, RecursionExercises.climbStairs(5));
	assertEquals("climbStairs function failed ", 274, RecursionExercises.climbStairs(10));	
}

@Test(timeout = 100)
public void testbinSearchTarget() 
{
	assertEquals("binSearchTarget function failed ", true, RecursionExercises.binSearchTarget(new int[]{1,2,3}, 2, 0, 2));
	assertEquals("binSearchTarget function failed ", true, RecursionExercises.binSearchTarget(new int[]{1,5,6,9,10}, 1, 0, 4));
	assertEquals("binSearchTarget function failed ", false, RecursionExercises.binSearchTarget(new int[]{1,5,6,9,10}, 4, 0, 4));
	assertEquals("binSearchTarget function failed ", true, RecursionExercises.binSearchTarget(new int[]{1, 4, 6,10,12,13}, 13, 0, 5));	
}


/* -----------------------------------------------------------------------------------
 *  Please uncomment the following test cases for extra credit questions ......
 * ------------------------------------------------------------------------------------ 
 */


@Test(timeout = 100)
public void testbinSearchTargetDup() 
{
	assertEquals("binSearchTargetDup function failed ", 2, RecursionExercises.binSearchTargetDup(new int[]{1,1,2}, 2, 0, 2));
	assertEquals("binSearchTargetDup function failed ", 0, RecursionExercises.binSearchTargetDup(new int[]{1,1,1,1,1}, 1, 0, 4));
	assertEquals("binSearchTargetDup function failed ", -1, RecursionExercises.binSearchTargetDup(new int[]{1,5,6,9,10}, 4, 0, 4));
	assertEquals("binSearchTargetDup function failed ", 5, RecursionExercises.binSearchTargetDup(new int[]{1, 4, 6,10,12,13}, 13, 0, 5));	
}


//@Test(timeout = 100)
//public void testnumCoinChange1() 
//{
//	int N = 4;
//	int[] S = {1,2,3};
//	
//	assertEquals("numCoinChange function failed ", 4, RecursionExercises.numCoinChange(N, S));	
//}
//
//@Test(timeout = 100)
//public void testnumCoinChange2() 
//{
//	int N = 10;
//	int[] S = {2, 5, 3, 6};
//	
//	assertEquals("numCoinChange function failed ", 5, RecursionExercises.numCoinChange(N, S));	
//}


}
