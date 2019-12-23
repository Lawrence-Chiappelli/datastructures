package lab7;

public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
	E data;
	Node<E> left;
	Node<E> right;
	
	public Node(E data)
	{
		this.data = data;
		this.left = null;
		this.right = null;		
	}
	
	public Node(E data, Node<E> left, Node<E> right)
	{
		this.data = data;
		this.left = left;
		this.right = right;		
	}
	
	public String toString()
	{
		return  data.toString();
	}

	
	@Override
	public int compareTo(Node<E> o) {
		// TODO Auto-generated method stub
		return this.data.compareTo(o.data);
	}
	
	
}
