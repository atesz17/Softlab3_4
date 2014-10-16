package com.newl.col;

import java.io.Serializable;

public class Beer implements Serializable{

	private String name;
	private String style;
	private double strength;
	
	
	public Beer(String n, String s, double str){
		setName(n);
		setStyle(s);
		setStrength(str);
	}
	
	public void setName(String n)	{
		if (n != null)	{
			name = n;
		}
		else	{
			name = new String("Unnamed");
		}
	}
	
	public void setStyle(String s)	{
		if (s != null)	{
			style = s;
		}
		else	{
			style = new String("No-style");
		}
	}
	
	public void setStrength(double s)	{
		if (s < 0)	{
			strength = 0;
		}
		else	{
			strength = s;
		}
	}
	
	public String getName()	{
		return name;
	}
	
	public String getStyle()	{
		return style;
	}
	
	public double getStrength()	{
		return strength;
	}
	
	public String toString()	{
		return "Beer name: " + name + ", style: " + style + ", strength: " + strength;
	}
	
	public String toDatabaseString()	{
		return (name + "\t" + style + "\t" + strength);
	}
	
	
	
	/*
	@Override
	public int compareTo(Beer o) {
		return name.compareToIgnoreCase(o.getName());
	}
	*/
	
	/*
	@Override
	public int compareTo(Beer o)	{
		if (o.getStrength() > getStrength())
			return -1;
		else if (o.getStrength() < getStrength())
			return 1;
		else
			return 0;
	}
	*/
}
