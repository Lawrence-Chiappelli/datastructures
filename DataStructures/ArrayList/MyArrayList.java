package lab2;
import java.util.Arrays;
import java.util.AbstractList;

/**
 * This class implements some of the methods of the Java
 *  ArrayList class.
 * 
 *  
 */
public class MyArrayList<E>  extends AbstractList<E>
{
    // Data Fields
    /** The default initial capacity */
    private static final int INITIAL_CAPACITY = 10;
    /** The underlying data array */				
    private E[] theData;
    /** The current size */
    private int size = 0;
    /** The current capacity */
    private int capacity = 0;

    /**
     * Construct an empty ArrayList with the default
     * initial capacity
     */
    public MyArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }

    
    
    /**
     * Add an entry to the end of the list
     * @param anEntry - The anEntry to be inserted
     * @return true/false - if the entry is inserted successfully at the end
     */
    public boolean add(E anEntry) {
        if (size == capacity) {
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * Get a value in the array based on its index.
     * @param index - The index of the item desired
     * @return The contents of the array at that index
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * Set the value in the array based on its index.
     * @param index - The index of the item desired
     * @param newValue - The new value to store at this position
     * @return The old value at this position
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     * @throws NullPointerException - if newValue is null       
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        if(newValue == null)
        	throw new NullPointerException();
        
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }
    
    /**
     * Get the current size of the array
     * @return The current size of the array
     */
    public int size() {
        return size;
    }
    
    /**
     * Allocate a new array to hold the directory
     * Double the capacity of the array and copy the original one at the beginning 
     * 
     */
    private void reallocate() {
        
    	capacity =  INITIAL_CAPACITY * 2;
    	theData = Arrays.copyOf(theData, capacity);
    }
    
    
    
    /*
     *  ================================   The following functions need to be filled ===================================================
     *    
     */
       
          
   /**
     * Add an entry to the data inserting it at the specified index.
     * @param index - The index of the time that the new
     *        value it to be inserted           
     * @param newValue - The value to be inserted
     *         
     */
    public void add(int index, E newValue) {
    	
        for (int i = size-1; i >= index; i--)
        {
        	theData[i + 1] = theData[i];
        }
    	theData[index] = newValue;
    	size++;
    	
    } 
    
    

    
    
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element
     * @param item The object to search for
     * @returns The index of the first occurrence of the specified item
     *          or -1 if this list does not contain the element
     */
    public int indexOf(Object item) {
    	
    	for (int i = 0; i < size; i++)
    	{
    		if ((theData[i] == null && item == null) || theData[i].equals(item))
    		{
    			return i;
    		}
    	}
    	
        return -1;
    } 
    
    
    
    /**
     * Remove an entry based on its index
     * @param index - The index of the entry to be removed
     * @return The Item removed
     */
    public E remove(int index) {

    	E temp = theData[index];
    	
    	for (int i = 0; size > i; i++)
    	{
    		theData[i] = theData[i+1];
    	}
    	size--;
    	
        return temp;   // please remove this line after filling your code 
    }
          
    
    /**
     * Count the total number of elements equals to theValue
     * @param theValue - the compared element
     * @return the total number of replicas or 0 if not found in the list    
     */
    public int countApperance(E theValue)
    {
    	int count = 0;
    	for (int i = 0; i < size; i++)
    	{
    		if(theData[i] == theValue)
    		{
    			count++;
    		}
    	}
    	
    	return count;
    	    	
    }
        
     
    /**
     * Remove all the duplicated elements equals to theValue but keep one left in the list
     * @param theValue - the duplicated element to be removed     * 
     */
    public void removeDuplicate(E theValue)
    {
    	int numOf = countApperance(theValue);
    	for (int i = 0; i < size; i++)
    	{
    		if(theData[i] == theValue && numOf != 1)
    		{
    			remove(theData[i]);
    		}
    	}
    }
    
    
    /**
     * remove ALL the element equals to theValue in the list 
     * @param theValue - the remove element
     */
    public void removeAll(E theValue)
    {
    	int numOf = countApperance(theValue);
    	for (int i = size; i >= 0; i--)
    	{
    		if(theData[i] == theValue)
    		{
    			remove(theData[i]);
    		}
    	}
    }
       
    
 }