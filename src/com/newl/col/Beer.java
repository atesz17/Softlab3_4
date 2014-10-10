package com.newl.col;

public class Beer {

	private String name;
	private String style;
	private double strength;
	
	
	public Beer(String n, String s, double str){
		setName(n);
		setStyle(s);
		setStrength(str);
	}
	
	public void setName(String n)	{
		if (n.length() > 0)	{
			name = n;
		}
		else	{
			name = new String("Unnamed");
		}
	}
	
	public void setStyle(String s)	{
		if (s.length() > 0)	{
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
}
