package lab8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTexercise {
	/*
	 * Construct BST from preorder traversal
	 */
	public static Node<Integer> consBSTfromPreOrder(int[] arr, int start, int end)
	{
				
		if(start > end) return null;
		
		Node<Integer> root = new Node<Integer>(arr[start], null, null);
		
		
		int index = start+1;
		while(index <= end)
		{
			if (arr[index] < arr[start])
			{
				index ++;
			}
			else
			{
				break;
			}
		}
				
		root.left = consBSTfromPreOrder(arr, start + 1, index -1);
		
		root.right = consBSTfromPreOrder(arr, index, end);
		
		return root;		
	}
		
	
  /****************************************************
   *  Please implement the following functions 	
   * **************************************************/
	
	/**
	 * 
	 * @param root - the root of given BST
	 * @return the maximum data in the given BST or Integer.MAX_VALUE if empty BST
	 */
	public static int maxBST(Node<Integer> root)
	{
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		if(root.right == null) {
			return root.data;
		}
		return maxBST(root.right);
	}	
		
	
	
	/**
	 * 
	 * @param root  - the root of given binary search tree
	 * @return - the minimum data in the given BST or Integer.MIN_VALUE if empty BST
	 */
	
	public static int minBST(Node<Integer> root)
	{
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		if(root.left == null) {
			return root.data;
		}
		return minBST(root.left);
	}
	
	
	/**
	 * @param root1 - root of tree-1
	 * @param root2 - root of tree-2
	 * @return  true if the same; otherwise, false
	 */
	public static boolean sameBST(Node<Integer> root1, Node<Integer> root2)
	{
		return preOrderTraveral(root1).equals(preOrderTraveral(root2));
	}
	
	public static String preOrderTraveral(Node<Integer> root)
	{	
		if(root == null) {
			return "";
		}
		return root + preOrderTraveral(root.left) + preOrderTraveral(root.right);
	}
		
	/**
	 * 
	 * @param root - the root of the given BST
	 * @return the mirror of BST
	 */
	public static Node<Integer> mirrorBST(Node<Integer> root)
	{
		if(root == null) {
			return root;
		}
		Node<Integer> left = mirrorBST(root.left);
		Node<Integer> right = mirrorBST(root.right);
		root.right = left;
		root.left = right;
		
		return root;
	}
	
	
	
	/* ====== Extra Credit (5% for each question)  ==============================*/	
	
	/**
	 * 
	 * @param root - the root of the given BST
	 * @return the height of BST
	 */
	
	public static int heightBST(Node<Integer> root)
	{	
		if (root == null)
			return 0;
		else
		{
			int left_height = heightBST(root.left);
			int right_height = heightBST(root.right);
			
			if (left_height > right_height)
				return left_height + 1;
			return right_height + 1;	
			
		}
	}
	
	/**
	 * 
	 * @param root - the given root of binary tree
	 * @return true if a binary search tree; otherwise false
	 */
	
	public static boolean isBST(Node<Integer> root)
	{	
		if (root.left != null && root.data < root.left.data)
			return false;
		if (root.right != null && root.data > root.right.data)
			return false;
		
		if (root.left != null)
			return isBST(root.left);
			
		if (root.right != null)
			return isBST(root.right);
		
		return true;
	}
}