package lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import lab7.Node;


public class TreeExercise {
		
	public static boolean isOp(String str)
	{
		if (str.equals("/") || str.equals("+") || str.equals("-") || str.equals("*"))
		{
			return true;
		}
		
		return false;
	}
	
	/*
	 * Construct Expression tree from postfixExpression
	 */
	public static Node<String> conExpTree(String str)
	{
		String[]  arr = str.split("\\s+");
		
		Stack<Node<String>> stk = new Stack<Node<String>>();
		
		for (String item: arr)
		{
			Node<String> newT = new Node<String>(item);
			if (!isOp(item))
			{
				stk.push(newT);
			}
			else
			{
				Node<String> right = stk.pop();
				Node<String> left = stk.pop();
				
				newT.left = left;
				newT.right = right;
				
				stk.push(newT);
			}
		}		
		return stk.pop();		
	}	
	
	/* * * * * * * * * * * * * * *****************************
	 * Please fill the code to complete the following functions
	 **********************************************************/
		
	/*
	 * Tree preOrder traversal
	 */ 
	/** @param root - root of the given tree
	 * @param str - a string representing inOrder tree traversal
	 * @return the str
	 *   
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 * return: "* + x y / + a b c"
"
	 */
	public static String preOrderTraveral(Node<String> root)
	{	
		if (root == null) return "";
		return root + preOrderTraveral(root.left) + preOrderTraveral(root.right);
	}
	
	
	/*
	 * Tree postOrder traversal
	 */ 
	/** @param root - root of the given tree
	 * @param str - a string representing postOrder tree traversal
	 * @return the str
	 *   
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 *  return: "x y + a b + c - *"
	 */
	public static String postOrderTraveral(Node<String> root)
	{
		if (root == null) return "";
		return postOrderTraveral(root.left) + postOrderTraveral(root.right) + root;
	}
	
	
	/*
	 * Tree inOrder traversal
	 */ 
	/** @param root - root of the given tree
	 * @param str - a string representing inOrder tree traversal
	 * @return the str
	 *   
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 *  return: "x + y * a + b - c"
	 */
	public static String inOrderTraveral(Node<String> root)
	{
		if (root == null) return "";
		return inOrderTraveral(root.left) + root + inOrderTraveral(root.right);
	}
	
	
	/*
	 *  Tree level traversal 
	 */
	/**
	 * @param root - the root of tree
	 * @return String - level traversal of tree
	 *   
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 *  return: "* + - x y + c a b"
	 */
	public static String levelOrderTraveral(Node<String> root)
	{
		Queue<Node<String>> queue = new LinkedList<Node<String>>();
		queue.add(root);
		String new_str = "";
		
		while (!queue.isEmpty())
		{
			Node temp = queue.poll();
			
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
			new_str += temp.data;
		}
		
		return new_str;
	}
	
/* ====== Extra Credit (10%)  ==============================*/
	
	/*
	 *  Tree level traversal 2 -
	 *  Please write test case by yourself for this extra credit question.
	 */
	/**
	 * @param root - the root of tree
	 * @return String - level traversal of tree
	 *   
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 *  return: 
	 *            * 
	 *          +  - 
	 *        x  y  +  c 
	 *        a b
	 */
	public static ArrayList<String> levelOrderTraveral2(Node<String> root)
	{
		
		//TODO: add your code here
		return null;  //remove this line after your coding
	}
}
