/**
 * 
 */
package lab4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Zheng
 *
 */
public class TestFileDict {
	 FileDict dt;
	
	 @Before
	  public void setUp()
	  {
		 dt = new FileDict();			
		 dt.add(new MyFile("Abe", 5));
		 dt.add(new MyFile("Sample", 1));
		 dt.add(new MyFile("Dock", 3));
		 dt.add(new MyFile("Book", 5));
		 dt.add(new MyFile("Note", 3));
	    
	  } 
	  
	  @Test(timeout = 100)
	  public void testdisplay()  {		
		 
		  String ret = "[Note|3, Book|5, Dock|3, Sample|1, Abe|5]";
		  assertEquals(ret, dt.display());
	  } 
	  
	  @Test(timeout = 100)
	  public void testlruFile1()  {		 
		  assertEquals("Abe", dt.lruFile().getFileName());
	  } 
	  	  
	  @Test(timeout = 100)
	  public void testremove() {
		  String ret = "[Note|3, Book|5, Dock|3, Sample|1]";		  
		  dt.remove();
		  dt.display();
		  assertEquals(ret, dt.display());
	  } 
	
	  @Test(timeout = 100)
	  public void testaccess1()  {
		  String ret = "[Abe|5, Note|3, Book|5, Dock|3, Sample|1]";		  
		  dt.access("Abe");
		  dt.display();
		  assertEquals(ret, dt.display());
	  } 
	  
	   @Test(timeout = 100)
	  public void testaccess2()  {
		  String ret = "[Book|5, Note|3, Dock|3, Sample|1, Abe|5]";		  
		  dt.access("Book");
		  dt.display();
		  assertEquals(ret, dt.display());
	  } 
	  
	    @Test(timeout = 100)
	  public void testaccess3()  {
		  String ret = "[Sample|1, Note|3, Book|5, Dock|3, Abe|5]";		  
		  dt.access("Sample");
		  dt.display();		  
		  assertEquals(ret, dt.display());
		  ret = "[Dock|3, Sample|1, Note|3, Book|5, Abe|5]";		 
		  dt.access("Dock");
		  dt.display();		  
		  assertEquals(ret, dt.display());
	  } 
	    
//	  @Test(timeout = 100)
//	  public void testreorder() {
//		  String ret = "[Book|5, Abe|5, Note|3, Dock|3, Sample|1]";		  
//		  dt.reoderFiles();
//		  dt.display();
//		  assertEquals(ret, dt.display());
//	  } 

}
