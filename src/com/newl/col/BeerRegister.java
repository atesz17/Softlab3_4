package com.newl.col;

import java.util.ArrayList;

public class BeerRegister {

	ArrayList<Beer> pData = new ArrayList<Beer>();
	
	public void add(Beer b)	{
		pData.add(b);
	}
	
	
	public void list()	{
		for (Beer b : pData){
			System.out.println(b);
		}
	}
}
