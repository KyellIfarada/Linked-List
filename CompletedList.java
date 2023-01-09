package edu.ser222.m01_03;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 * CompletedList represents an implementation of a list.
 *
 * @author (Lorenzo Stewart ), Acuna
 * @version (version)
 */
public class CompletedList<T> implements ListADT<T>, Iterable<T> {

    //The following three variables are a suggested start if you are using a list implementation.
    protected int count;
    protected int modChange;
    protected DoubleLinearNode<T> head, tail;


    /**  
     * Removes and returns the first element from this collection.
     * 
     * @return the first element from this collection
     * @throws NoSuchElementException if the collection is empty
     */
   public T removeFirst() throws NoSuchElementException
   {
	// TODO Auto-generated method stub
		

			if(head == null ||tail == null || count == 0 )
				{
					throw new   java.util.NoSuchElementException("deque is empty");
				
				}
			
			T NewInstance = head.getDataX();
			head =  head.getNext();
			
			if 	   (head==null)
				{

					tail = null;

				} 
			else 
			
				{

					head.setPrev(null);

				}
					
				
			count--;
			modChange++;
			return NewInstance;
	
   }
	
    /**  
     * Removes and returns the last element from this collection.
     *
     * @return the last element from this collection
     * @throws NoSuchElementException if the collection is empty
     */
   public T removeLast() throws NoSuchElementException
   {
   if(head == null ||tail == null || count == 0)
 	{
 		throw new   NoSuchElementException("deque is empty");
 		
 	}
 	
 	T NewDoubleLinearList = tail.getDataX();
 	tail = tail.getPrevious();
 	
 		if (tail == null) 
 		{

 			head = null;

 		} 
 		else 
 		
 		{

 			tail.setNext(null);

 		}
 			
 	count--;
 	modChange++;
 	return NewDoubleLinearList;
}
    /**  
     * Removes and returns the specified element from this collection.
     *
     * @param element the element to be removed from the collection
     * @throws NoSuchElementException if the target is not in the collection
    */
   @Override
   public  T remove(T element) throws NoSuchElementException
   {
	   if(head == null ||tail== null || count == 0 || element == null)
	 	{
	 		throw new NoSuchElementException("deque is empty");
	 		
	 	}
	 	

	   DoubleLinearNode<T> tracker = head;
	   
	if (tracker.getDataX() != element && tracker.getDataX() == null)
	{
	    tracker = tracker.next;
	}				
	

	if(tracker.getDataX() == element)
	{
	tracker.previous.next = tracker.next;
	tracker.next.previous = tracker.previous;
	count--;
 	modChange++;
 	return tracker.getDataX();
	}	
	throw new NoSuchElementException("The target is not in the collection"); 	
	 			
	 	
	 	
   }

    /**  
     * Returns, without removing, the first element in the collection.
     *
     * @return a reference to the first element in this collection
     * @throws NoSuchElementException if the collection is empty
     */
   public T first()
   {
		// TODO Auto-generated method stub
		if (head == null) 
		{
			throw new NoSuchElementException("No head");
		}
		
		else 
		
		{
			T FirstItem = head.getDataX();
			return  FirstItem;			
		}
		
	   
	   
   }

    /**  
     * Returns, without removing, the last element in the collection.
     *
     * @return a reference to the last element in this collection
     * @throws NoSuchElementException if the collection is empty
     */
   public T last()
   {
		// TODO Auto-generated method stub
		if(tail == null)
		{
			
			throw new NoSuchElementException("No tail");
		 
		}
		else 
		{
			
			T LastItem = tail.getDataX();
			return LastItem;
		
		}

   }

    /**  
     * Returns true if this collection contains the specified target element, false otherwise.
     *
     * @param target the target that is being sought in the collection
     * @return true if the collection contains this element
     */
   public boolean contains(T target)
   {
	   if(head == null || tail == null || count == 0)
			return false;
	  
	 

		for( DoubleLinearNode<T> tracker = head; tracker != null;tracker = tracker.getNext())
 		{
			if (tracker.getDataX() == target )
				return true;
 	
 		}
		return false;
 		
	   
   }

    /**  
     * Returns true if this collection is empty and false otherwise.
     *
     * @return true if this collection empty
     */
   public boolean isEmpty()
   {
	   if( head == null || tail == null || count == 0) 
			return true;
		
		else
			return false;
   }

    /**  
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    public int size()
    
    {
    	
    return count;
    
    }
    /**  
     * Returns an iterator for the elements in this collection.
     *
     * @return an iterator over the elements in this collection
     */
    public  Iterator<T> iterator()
    {
    
    	return new DoubleLinearNodeIterator<T>(head);
    }

    /**  
     * Returns a string representation of this collection.
     *
     * @return a string representation of this collection
     */
    public String toString()
    {
    	String LinkedString = "";

    	if (head == null || tail == null)
    	{

    		LinkedString = "empty";

    	} 

    	else 

    	{
    		DoubleLinearNode<T> node = tail;
    		

    		while (node != null) 
    		{

    			LinkedString += node.getDataX() + " ";

    			node = node.getPrevious();

    	    }

    	}
    	return LinkedString;
    }
    
    //private  DoubleLinearNodeIterator<T> class
    private class   DoubleLinearNodeIterator<T>  implements Iterator<T> 
    {
    	private  int ModCount ;
    	private DoubleLinearNode<T> iter;


    	public DoubleLinearNodeIterator(DoubleLinearNode<T> node)
    	{
    		this.ModCount = modChange;
    		this.iter = node;
    		
    	}
    	
    	public boolean hasNext()
    	{
    		if(this.ModCount != modChange)
    			throw new ConcurrentModificationException("The collection has been modified!");
    		
    		if(this.iter!= null) {
    			return this.iter != null;
    		} else {
    			return false;
    		}
    	}
    	
    	public T next() 
    	{
    		if (!hasNext())
    			throw new NoSuchElementException();
    		
    		if(this.ModCount != modChange)
    			throw new ConcurrentModificationException("The collection has been modified!");
    		
    	
    		
    		T element = this.iter.getDataX();
    		this.iter = iter.getNext();
    		return element;
    		
    	
    	
    	}
    	
    	
    	
    }
    
  //Node class

    public class DoubleLinearNode<T> 
    {

    //instance  variables

    private  T DataX;

   private  DoubleLinearNode<T> previous;

  private  DoubleLinearNode<T> next;


    //construct

    public DoubleLinearNode (T DataX)
    {

    this.DataX = DataX;

    this.previous = null;
    	
    this.next = null;

    }

    //gets and sets

    public T getDataX() 
    {

    	return DataX;

    }

    public void setDataX(T DataX)
    {

    	this.DataX = DataX;

    }

    public DoubleLinearNode<T> getPrevious() 
    {

    	return previous;

    }

    public void setPrev(DoubleLinearNode<T> previous) 
    {

    	this.previous = previous;
    }

    public DoubleLinearNode<T> getNext() 
    {

    	return next;

    }

    public void setNext(DoubleLinearNode<T> next) 
    {

    	this.next = next;

    }
       
    }
}