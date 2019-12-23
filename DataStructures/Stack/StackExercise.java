package lab5;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class StackExercise {

		/*
		 * Given an expression string exp,
		 *  write a program to examine whether the pairs and 
		 *  the orders of parenthesis are correct in exp. 
		 *  For example, the program should print true for exp = [()[]]
		 *  and false for exp = [()[])
		 */
		/**
		 * 
		 * @param str 
		 * @return  true if balanced; false is unbalanced 
		 */
		public static boolean isBalancedParentheses(String str)
		{
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < str.length(); i++)
			{
				char current_char = str.charAt(i);
				
				if (current_char == '(' || current_char == '[')
				{
					stack.push(current_char);
					continue;
				}
				
				if (current_char == ')')
				{
					
					if(!stack.isEmpty() && stack.peek() == '(')
					{
						stack.pop();
						continue;
					}
					stack.push(current_char);		
				}
			
				if (current_char == ']' )
				{
				
					if(!stack.isEmpty() && stack.peek() == '[')
					{
						stack.pop();
						continue;
					}
					stack.push(current_char);		
				}
				
			}
			
			return stack.isEmpty();
		}
		
		/*
		 * 
		 * Reverse the all the items in the linkedlist and return the return the head of the 
		 * reversed one, for example: A -> B -> C should be reversed as: C->B->A
		 */

		/**
		 * @param lst - the linkedlist to be reversed
		 * @return the linkedlist with all items reversed - 
		 */
		public static LinkedList<String> revLinkedList(LinkedList<String> lst)
		{			
			ListIterator<String> lst_as_li = lst.listIterator(lst.size());
			LinkedList<String> reversed_list = new LinkedList<String>();
			
			// I used the built in ListIterator because .next and .data were not inherently supplied
			while (lst_as_li.hasPrevious())
				reversed_list.add(lst_as_li.previous());
			
			return reversed_list;
		}
		
		
		
		
		/* Extra credit exercise (10%):  This function evaluates "postfix" expressions (also called "Reverse Polish 
		 * Notation"), which are mathematical expressions but with the operators placed
		 * after operands instead of between.
		 * For example: 1 + 2 * 3 + 4  is written as 1 2 3 * + 4 + 
		 */
		/**
		 * 
		 * @param str
		 * @return the result of postfix expression
		 */
		
		public static int postfixEvaluate(String exp) {
			System.out.println("Attempting to evaluate " + exp);
			Stack<Integer> stack = new Stack<Integer>();
		 	
			for (int i = 0; i < exp.length(); i++)
			{
				int pop_1 = 0;
				int pop_2 = 0;
				switch (exp.charAt(i))
				{
					case '+':
						stack.push(stack.pop() + stack.pop());
						break;
					case '-':
						pop_1 = stack.pop();
						pop_2 = stack.pop();
						stack.push(pop_2 - pop_1);
						break;
					case '*':
						stack.push(stack.pop() * stack.pop());
						break;
					case '/':
						pop_1 = stack.pop();
						pop_2 = stack.pop();
						stack.push(pop_2 / pop_1);
						break;
					case ' ':
						break;
					default:
						int numeric_value = Character.getNumericValue(exp.charAt(i));
						stack.push(numeric_value);
						break;
				}
				
				
			}
			return stack.pop();
		}
	}
