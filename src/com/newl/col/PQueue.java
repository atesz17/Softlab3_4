package com.newl.col;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Comparable;


class EmptyQueueException extends Exception	{
	
	public EmptyQueueException() {
		super();
	}
	
	@Override
	public String getMessage()	{
		return new String("The Queue is empty!");
	}
}

public class PQueue<T extends Comparable> implements Iterable<T> {
	
	private ArrayList<T> col;
	
	public PQueue()	{
		col = new ArrayList<T>();
	}
	
	public void push(T t)	{
		int i = 0;
		for(i = 0; i < col.size(); i++)	{
			if (col.get(i).compareTo(t) < 0)	{
				break;
			}
		}
		col.add(i, t);
	}
	
	public T pop()	{
		try
		{
			if (col.isEmpty())	{
				throw new EmptyQueueException();
			}
			return col.remove(0);
		}
		catch (EmptyQueueException e)
		{
			System.err.println(e.getMessage() + " " + "Returning null...");
			return null;
		}
	}
	
	public T top()	{
		try
		{
			if (col.isEmpty())	{
				throw new EmptyQueueException();
			}
			return col.get(0);
		}
		catch (EmptyQueueException e)
		{
			System.err.println(e.getMessage() + " " + "Returning null...");
			return null;
		}
	}
	
	public int size()	{
		return col.size();
	}
	
	public void clear()	{
		col.clear();
	}

	@Override
	public Iterator<T> iterator() {
		return col.iterator();
	}
}
