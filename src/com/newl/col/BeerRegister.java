package com.newl.col;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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

	public void load(File f)	{
		
		try	{
			FileInputStream fi = new FileInputStream("adat.ser");
			ObjectInputStream in = new ObjectInputStream(fi);
			pData = (ArrayList<Beer>)in.readObject();
			in.close();
			
		}
		catch(IOException e)	{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)	{
			e.printStackTrace();
		}
		/*
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			while(true)	{
				String line = br.readLine();
				if (line == null){
					break;
				}
				else	{
					String[] param = line.split("\\t");
					if (param.length == 3)	{
						
						pData.add(new Beer(param[0], param[1], Double.parseDouble(param[2])));
					}
					else	{
						throw new IOException("3 parameters are needed for each beer!");
					}
				}
			}
			br.close();
			System.out.println("List updated.");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	public void save(File f)	{
		/*
		try {
			FileWriter fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);
			
			for(Beer b : pData)	{
				pw.println(b.toDatabaseString());
			}
			pw.close();
			System.out.println("Database exported.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try	{
			FileOutputStream fo = new FileOutputStream("adat.ser");
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(pData);
			out.close();
		}
		catch (IOException e)	{
			e.printStackTrace();
		}
	}
	
	public void delete(Beer b)	{
		
		int index = Collections.binarySearch(pData, b, new StrengthComparator());
		if (index >= 0)	{
			pData.remove(index);
			System.out.println("Element named: \"" + b.getName() + "\" was removed.");
		}
		else	{
			System.err.println("No beer named: \"" + b.getName() + "\" is in the list.");
		}
	}
	
}
