/**
 * 
 */
package lab4;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Zheng
 *
 */
public class FileDict {
	
	LinkedList<MyFile> filelst = new LinkedList<MyFile>();
		
	/**
	 * Add the file to the beginning of the list
	 * @param file - the file to be added 
	 * @return false - if the file with the same name is already existed; true - the file added successfully 
	 * 
	 */
	public boolean add(MyFile file)
	{
		if (filelst.contains(file))
			return false;
		else
		{
			filelst.addFirst(file);
			return true;
		}
	}
	
	/**
	 * Remove the least recently added or accessed file 
	 * @param - the given file name
	 *  
	 */
	public MyFile remove()
	{	
		 return filelst.removeLast();	
	}
	
	/**
	 * Access a file with given filename, 
	 * @param filename - the name of the file to access
	 * @return the file accessed, or null if no such file exists
	 */
	public MyFile access(String filename)
	{
		ListIterator<MyFile> iter = filelst.listIterator();
		
		while (iter.hasNext())
		{
			MyFile file_ref = iter.next();
			
			if (file_ref.getFileName() == filename)
			{
				filelst.remove(file_ref);
				filelst.addFirst(file_ref);
				return file_ref;
			}		
		}
		return null;
	}
	
	/**
	 * This method return the least recently used file, i.e. the file has not been accessed/used for the longest time
	 * Should be done in O(1) time cost
	 * 
	 * @return the least recently used file; or null if empty list
	 */
	public MyFile lruFile()
	{
		if (filelst.getLast() == null || filelst.isEmpty())
			return null;
		return filelst.getLast();
	}
	
		
	public String display()
	{
		return filelst.toString();
	}


       
   /** Extra Credit question (5%)
	 * Re-oder the files based on priorities, higher priority file placed first; ties are broken by 
	 * filename in alphabetical order
	 * Hint: You may need to add CompareTo function in MyFile Class
	 */
	public void reoderFiles()
	{
//		ListIterator<MyFile> iter = filelst.listIterator();
//		while (iter.hasNext())
//		{	
//			MyFile file_ref = iter.next();
//			switch (iter.next().getPriority())
//			{
//				case 1:
//					filelst.remove(file_ref);
//					filelst.addFirst(file_ref);
//					break;
//				case 5:
//					filelst.remove(file_ref);
//					filelst.addLast(file_ref);
//					break;
//			}
//		}
	}

	
}
