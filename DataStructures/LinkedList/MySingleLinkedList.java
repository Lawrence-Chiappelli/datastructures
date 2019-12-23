package lab3;

/***************************************************************************
 * A Linked List class with a private static inner Node class.
 *
 *****************************************************************************/

import java.util.*;

public class MySingleLinkedList<E>
{
   private Node<E> head;

 /**
   *  Constructs an empty list
   */
   public MySingleLinkedList()
   {
      head = null;
   }
 /**
   *  Returns true if the list is empty
   *  @return true/false - empty/not empty
   */
   public boolean isEmpty()
   {
      return head == null;
   }
 /**
   *  Inserts a new node at the beginning of this list.
   *  @param item - element to add
   *
   */
   public void addFirst(E item)
   {
      head = new Node<E>(item, head);
   }
 /**
  *  Returns the first element in the list.
  *  @return the head of the list
  *  @exception NoSuchElementException if an empty list
  */
   public E getFirst()
   {
      if(head == null) throw new NoSuchElementException();

      return head.data;
   }
   
 /**
   *  Removes the first element in the list.
   *  @return head of the list
   *
   */
   public E removeFirst()
   {
      E tmp = getFirst();
      head = head.next;
      return tmp;
   }
   
   
 /**
   *  Inserts a new node to the end of this list.
   *  @param item - the element to add at the end of list
   */
   public void addLast(E item)
   {
      if( head == null)
         addFirst(item);
      else
      {
         Node<E> tmp = head;
         while(tmp.next != null) tmp = tmp.next;

         tmp.next = new Node<E>(item, null);
      }
   }
   
   /**
    *  Removes all nodes from the list.
    *
    */
    public void clear()
    {
       head = null;
    }   
 
 /**
   *  @return a string representation
   *
   */
   public String toString()
   {
      StringBuffer result = new StringBuffer();
      Node<E> tmp = head;
      
      while(tmp != null)
      {
    	  tmp = tmp.next;
      	  result.append(tmp + " ");
      }
      
      return result.toString();
   }
 /**
   *  Inserts a new node after a node containing the key
   *  @param key - the data of existing node included in the list 
   *  @param toInsert - the data of the new node to be inserted 
   */
   public void insertAfter(E key, E toInsert)
   {
      Node<E> tmp = head;

      while(tmp != null && !tmp.data.equals(key)) tmp = tmp.next;

      if(tmp != null)
         tmp.next = new Node<E>(toInsert, tmp.next);
   }
 
   /*
    * ================================   The following functions need to be filled ===================================================
    */
   
   /**
    *  Returns the last element in the list.
    *  @return  last element in the list
    *  @throws  NoSuchElementException if the list is empty
    */
    public E getLast()
    { 
    	if (head==null) throw new NoSuchElementException();
    	
    	Node<E> tmp = head;
        while(tmp.next != null) 
    	{
        	tmp = tmp.next;
    	}
		return tmp.data;
    }

  /**
    *  Returns true if this list contains the specified element.
    *  @param item - element to be checked
    *  @return True - if contained; otherwise False 
    *
    */
    public boolean contains(E item)
    {
    	    
    	Node<E> tmp = head;
        while (tmp != null)
        {
        	if (tmp.data.equals(item))
        		return true;
        	tmp = tmp.next;
        }
        
        return false;
    }
    /**
     *  Returns the data at the specified position in the list.
     *  @param  the position index
     *  @return  the data contained at the given position index
     *  @throws  IndexOutOfBoundsException if pos is larger than the size of list
     *
     */
    public E get(int pos)
    {
    	if (head == null) { throw new IndexOutOfBoundsException(); }
    	
    	Node<E> tmp = head;
    	
    	if (tmp.next == null) { throw new IndexOutOfBoundsException(); }
    	
    	for (int i = 0; i < pos; i++)
    	{
    		tmp = tmp.next;
    	}

    	return tmp.data;
    }
    
         
     /**
      * Count the number of occurrence of key 
      * @param key - the element to be counted
      */
     public int countApperance(E key)
     {
    	 int ret = 0;
    	 Node<E> tmp = head;
    	 
    	 
    	 while (tmp != null)
    	 {
    		if (tmp.data.equals(key))
    			ret++;
    		tmp = tmp.next;
    	 }
    	 return ret;    	 
     }
   
     
     /**
      *  Removes the first occurrence of the specified element in this list.
      *  @param key - the element to be removed
      *
      */
      public void remove(E key)
      {
    	  if (head.data.equals(key))
    	  {
    		  head = head.next;
    	  }
    	  
    	  Node<E> tmp = head;
    	  Node<E> before = null;
    	  while (tmp != null && !tmp.data.equals(key))
    	  {
    		  before = tmp;
    		  tmp = tmp.next;
    	  }
    	  
    	  before.next = tmp.next;
      }
    
     
     
 /**
   *  Removes all the occurrence of the specified element in this list.
   *  @param key - the element to be removed
   *
   */
   public void removeAll(E key)
   {
	  Node<E> tmp = head;
 	  while (tmp != null)
 	  {
 		  if (tmp.data.equals(key))
 			  remove(tmp.data);
 		  tmp = tmp.next;
 	  }
   }
 
   /***************************   Extra Credit Exercises *****************************************/ 
   
   /***** This is for  Extra Credit (3 points) *********************  
   /**
    *  Inserts a new node before the first appearance of the node containing the key.
    *  @param key  the data of existing node included in the list 
    *  @param toInsert  the data of the new node to be inserted 
    *
    */
    public void insertBefore(E key, E toInsert)
    {
    	
    	if (head == null) { throw new IndexOutOfBoundsException(); }
    	
    	Node<E> temp_node_ref = head;
    	
    	while (temp_node_ref.next != null)
    	{
    		Node<E> insert_data_in_this_node = temp_node_ref;
    		if (temp_node_ref.data.equals(key))
    		{
    			insert_data_in_this_node.data = toInsert;
    			break;
    		}
    	}
    }   
   
 /***** This is for  Extra Credit (5 points) *********************
   *  Reverses the list: A->B->C to C->B->A
   *  @return the new head
   */
   public Node<E> reverse()
   {
	
	   // Keeping track of:
	   // The current head, the previous node, and the subsequent node
	   Node<E> temp_node_ref = head;
	   Node<E> previous = null;
	   Node<E> next = temp_node_ref.next;
	   
	   while (temp_node_ref != null)
	   {
		   next = temp_node_ref.next;
		   temp_node_ref.next = previous;
		   previous = temp_node_ref;
		   temp_node_ref = next;
	   }

	   head = previous;
	   return previous;
   }
     
   
 /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
   private static class Node<E>
   {
      private E data;
      private Node<E> next;

      public Node(E data, Node<E> next)
      {
         this.data = data;
         this.next = next;
      }
   }

}