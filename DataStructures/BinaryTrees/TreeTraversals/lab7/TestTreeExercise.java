package lab7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class TestTreeExercise {
	
	private Node<String> root1;
	private Node<String> root2;	
	
	@Before
	  public void setUp()
	  {
		String str1 = "x y + a b + c - *";
		root1 = TreeExercise.conExpTree(str1);
        String str2 = "3 5 9 + 2 * +";
        root2 = TreeExercise.conExpTree(str2);
	  }
	
	
	@Test(timeout = 100)
	public void testinOrder()
	{
		String expected1 = "x + y * a + b - c";
		String expected2 = "3 + 5 + 9 * 2";
		
		assertEquals("inOrder function failed",expected1.replaceAll("\\s+", ""), TreeExercise.inOrderTraveral(root1).trim().replaceAll("\\s+", ""));		
		assertEquals("inOrder function failed", expected2.replaceAll("\\s+", ""), TreeExercise.inOrderTraveral(root2).trim().replaceAll("\\s+", ""));
		
	}	
	
	@Test(timeout = 100)
	public void testPreOrder()
	{
		String expected1 = "* + x y - + a b c";
		String expected2 = "+ 3 * + 5 9 2";
		
		assertEquals("inOrder function failed",expected1.replaceAll("\\s+", ""), TreeExercise.preOrderTraveral(root1).trim().replaceAll("\\s+", ""));		
		assertEquals("inOrder function failed", expected2.replaceAll("\\s+", ""), TreeExercise.preOrderTraveral(root2).trim().replaceAll("\\s+", ""));
		
	}	
	
	@Test(timeout = 100)
	public void testPostOrder()
	{
		String expected1 = "x y + a b + c - *";
		String expected2 = "3 5 9 + 2 * +";
		
		assertEquals("inOrder function failed",expected1.replaceAll("\\s+", ""), TreeExercise.postOrderTraveral(root1).replaceAll("\\s+", ""));		
		assertEquals("inOrder function failed", expected2.replaceAll("\\s+", ""), TreeExercise.postOrderTraveral(root2).trim().replaceAll("\\s+", ""));
		
	}	
	
	@Test(timeout = 100)
	public void testlevelOrderTraveral()
	{
		String expected1 = "* + - x y + c a b";
		String expected2 = "+ 3 * + 2 5 9";
		
		assertEquals("inOrder function failed",expected1.replaceAll("\\s+", ""), TreeExercise.levelOrderTraveral(root1).trim().replaceAll("\\s+", ""));		
		assertEquals("inOrder function failed", expected2.replaceAll("\\s+", ""), TreeExercise.levelOrderTraveral(root2).trim().replaceAll("\\s+", ""));
	}	
	
	
}


  