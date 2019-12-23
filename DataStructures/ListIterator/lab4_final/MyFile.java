/**
 * 
 */
package lab4;

/**
 * You are free to add more methods, implements an interface or extends a class
 * @author Zheng
 *
 */
public class MyFile{
	
	private String fileName;
	private int priority;  // higher value means higher priority
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @param fileName
	 * @param priority
	 */
	/* 
	 *  Please don't change this implementation
	 */
	public MyFile(String fileName, int priority) {
		this.fileName = fileName;
		this.priority = priority;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Please don't change this implementation
	 */
	@Override
	public String toString() {
		return fileName + "|" + priority;
	}
}
