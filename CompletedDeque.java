package edu.ser222.m01_03;

import java.util.NoSuchElementException;

/**
 * This program provides an implementation of the Deque interface. Also provides a main that
 * demonstrates it.
 * 
 * @author (Lorenzo Stewart) , Acuna
 * @version (version)
 */


public class CompletedDeque<Item> implements Deque<Item> {
	
	private int size = 0 ;
	private Node<Item> head = null; 
	private Node<Item> tail = null; 
	
    //TODO: implement all the methods

    
	@Override
	public void enqueueFront(Item element) 
	{
		Node<Item> LocalNode = new Node<Item>(element) ;
		if(head == null ||tail == null )
		{
			head = LocalNode;
			tail = LocalNode; 
			
		}
		else 
		{	
		LocalNode.setNext(head);
		head.setPrev(LocalNode);
		head = LocalNode;
		}	
		size++;
		
	}

	@Override
	public void enqueueBack(Item element) 
	{
		Node<Item> LocalNode = new Node<Item>(element) ;
		if(head == null ||tail == null || size == 0 )
		{
			head = LocalNode;
			tail = LocalNode; 
			
		}
		else 
		{	
		LocalNode.setNext(null);
		LocalNode.setPrev(tail);
		tail.setNext(LocalNode);
		tail = LocalNode;
		}	
		size++;
	}

	@Override
	public Item dequeueFront()  throws NoSuchElementException 
	{
		// TODO Auto-generated method stub
		

		if(head == null ||tail == null || size == 0 )
			{
				throw new   java.util.NoSuchElementException("deque is empty");
			
			}
		
		Item NewInstance = head.getInstance();
		head =  head.getNext();
		
		if 	   (head==null)
			{

				tail = null;

			} 
		else 
		
			{

				head.setPrev(null);

			}
				
			
		size--;
		return NewInstance;
	}

	@Override
	public Item dequeueBack()  throws NoSuchElementException 
	{
		// TODO Auto-generated method stub

		if(head == null ||tail == null || size == 0)
		{
			throw new   NoSuchElementException("deque is empty");
			
		}
		
		Item NewInstance = tail.getInstance();
		tail = tail.getPrevious();
		
			if (tail == null) 
			{

				head = null;

			} 
			else 
			
			{

				tail.setNext(null);

			}
				
	
		size--;
		return NewInstance;
		
	
	}

	@Override
	public Item first() throws NoSuchElementException 
	{
		// TODO Auto-generated method stub
		if (head == null) 
		{
			throw new NoSuchElementException("No head");
		}
		
		else 
		
		{
			Item FirstItem = head.getInstance();
			return  FirstItem;			
		}
		
	}

	@Override
	public Item last() throws NoSuchElementException 
	{
		// TODO Auto-generated method stub
		if(tail == null)
		{
			
			throw new NoSuchElementException("No tail");
		 
		}
		else 
		{
			
			Item LastItem = tail.getInstance();
			return LastItem;
		
		}
	}

	@Override
	public boolean isEmpty() 
	{
		
		if(head == null || tail == null)
			return true;
		
		else
			return false;
	}

	@Override
	public int size() 
	{
		
		return size;
	}

	@Override
public String toString()
{

String LinkedString = "";

if (head == null || tail == null)
{

	LinkedString = "empty";

} 

else 

{
	Node<Item> node = tail;
	

	while (node != null) 
	{

		LinkedString += node.getInstance() + " ";

		node = node.getPrevious();

    }

}

return LinkedString;

}

	/**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) 
    {
        CompletedDeque<Integer> deque = new CompletedDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());            
    }

	
	
	
//Node class

private class Node<Item> {

//instance  variables

Item instance;

Node<Item> previous;

Node<Item> next;


//construct

public Node(Item instance)
{

this.instance = instance;

previous = null;

next = null;

}

//gets and sets

public Item getInstance() 
{

	return instance;

}

public void setInstance(Item instance)
{

	this.instance = instance;

}

public Node<Item> getPrevious() 
{

	return previous;

}

public void setPrev(Node<Item> previous) 
{

	this.previous = previous;

}

public Node<Item> getNext() 
{

	return next;

}

public void setNext(Node<Item> next) 
{

	this.next = next;

}

}

}
