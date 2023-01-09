package edu.ser222.m01_03;

/**
 * CompletedOrderedList represents an implementation of an ordered list that builds on
 * CompletedList.
 *
 * @author (Lorenzo Stewart), Acuna
 * @version (01)
 */
public class CompletedOrderedList<T extends Comparable<T>> extends CompletedList<T>
         implements OrderedListADT<T> {

    /**
     * Adds the specified element to this collection at the proper location
     *
     * @param element the element to be added to this collection
     * @throws NullPointerException if element is null
     */
    public void add(T element) throws NullPointerException
    {	//Check for Null Exception
    	if (element == null)
    		throw new NullPointerException("Element is NULL!");
        
    	// If empty add Node

    	if ( head == null || tail == null || count == 0)
    	{
    		head = new DoubleLinearNode<T>(element);
    		tail = head;
    		count++;
    		modChange++;
    	}
    		
    	else 
    	{
    		 
    		
    		
    		//Create New Node to Insert with sorting.
    		DoubleLinearNode<T> First = head;
    		DoubleLinearNode<T> Last  = tail;
    		DoubleLinearNode<T> freshNode = new DoubleLinearNode<T>(element);	
    		
    		

    	//Store in back of Head Node if Lesser and Store in Back of Tail is Greater.
    	//Less than  head node
    	if(element.compareTo(First.getDataX()) <= 0)
    	{
    		freshNode.getNext().setPrev(First);
    		First.setNext(freshNode.getNext());
    		head = freshNode;
    		return;
    	}
    	// Greater than tail node
    	else if ( element.compareTo(Last.getDataX()) >= 0)
    	{
    		freshNode.getPrevious().setNext(Last);
    		Last.setPrev(freshNode.getPrevious());
    		tail=freshNode;
    		return;
    	}
    	
    		//For First and Last Node not the same
    	//Store in List where greater or Lesser than beyond Head and Tail Node while traversing
    		
    	while( First !=  Last)
   	
    	 {
    	     if(element.compareTo(First.getDataX()) <= 0) 
    	     {
    	    	 if(First.getPrevious() !=null) 
    	    	 {
                 First.getPrevious().setNext(freshNode);
                 freshNode.setPrev(First.getPrevious());
    	    	 }
                 First.setPrev(freshNode);
                 if(freshNode != null)
                 {
                	 freshNode.setNext(First);
                 }
                 
                 return;
             }
    	     else if(element.compareTo(Last.getDataX()) >= 0) 
    	     {
                 Last.setNext(freshNode);
                 if(Last.getNext()!=null)
                 {
                     Last.getNext().setPrev(freshNode);
                     freshNode.setNext(Last.getNext());
                 }
                 Last.setNext(freshNode);
                 if(freshNode != null)
                 {
                	 freshNode.setPrev(Last);
                 }
               
              
                 return;
             }
            if(Last.getPrevious() == null) 
             {
            	 throw new NullPointerException("Last is NULL!");
             } 
    		First = First.getNext();
    		Last = Last.getPrevious();
    			
    		
    		
    	}
    	 // For Same Node
    	if( element.compareTo(First.getDataX()) <= 0 )
    	{
    		if(First.getPrevious().getNext() != null)
    		{
    			First.getPrevious().getNext().setPrev(freshNode);
    			freshNode.setNext(First.getPrevious());
    		}
    			First.getPrevious().setNext(freshNode);
    			if(freshNode != null)
    			{
    				freshNode.setPrev(First.getPrevious());
    			}
    	}
    		if( element.compareTo(First.getDataX()) == 0 )
    		{
        		if(First.getPrevious() != null)
        		{
        			First.getPrevious().setNext(freshNode);
        			freshNode.setPrev(Last.getPrevious());
        		}
        		First.setPrev(freshNode);
        		if(freshNode != null) {
        			freshNode.setNext(First);
        		}
    		}
    			if( element.compareTo(First.getDataX()) >= 0 )
    			{
    				First.getNext().setPrev(freshNode);
    				if(First.getNext() != null) 
    				{
    					First.getNext().setPrev((freshNode));
    					freshNode.setNext(First.getNext());
    					
    				}
    				First.setNext(freshNode);
    				if(freshNode != null);
    					freshNode.setPrev(First);
    				
    				
    			}
;    	  count++ ;	
    	modChange++;
      }
    }
}