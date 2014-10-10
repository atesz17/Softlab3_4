package com.newl.col;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BeerRegister {

	ArrayList<Beer> pData = new ArrayList<Beer>();
	
	class NameComparator implements Comparator<Beer>	{

		@Override
		public int compare(Beer arg0, Beer arg1) {
			return arg0.getName().compareToIgnoreCase(arg1.getName());
		}
		
	}
	
	class StyleComparator implements Comparator<Beer>	{

		@Override
		public int compare(Beer o1, Beer o2) {
			return o1.getStyle().compareToIgnoreCase(o2.getStyle());
		}
		
	}
	
	class StrengthComparator implements Comparator<Beer>	{

		@Override
		public int compare(Beer arg0, Beer arg1) {
			if (arg0.getStrength() < arg1.getStrength())	{
				return -1;
			}
			else if (arg0.getStrength() > arg1.getStrength())	{
				return 1;
			}
			else	{
				return 0;
			}
		}
		
	}
	
	public void add(Beer b)	{
		pData.add(b);
	}
	
	
	public void list()	{
		for (Beer b : pData){
			System.out.println(b);
		}
	}
	
	public void list(String arg)	{
		
		if (arg.equals("name"))	{
			Collections.sort(pData, new NameComparator());
			list();
		}
		else if (arg.equals("style"))	{
			Collections.sort(pData, new StyleComparator());
			list();
		}
		else if (arg.equals("strength"))	{
			Collections.sort(pData, new StrengthComparator());
			list();
		}
		else	{
			System.err.println("Possible list arguments: \"name\", \"style\", \"strength\"");
		}
	}
}
