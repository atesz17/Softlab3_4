package com.newl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.newl.col.Beer;
import com.newl.col.BeerRegister;

public class BeerTest {

	public static void main(String[] atneveztem) throws IOException {
		
		BeerRegister bReg = new BeerRegister();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Ready, waiting for input...");
		System.out.println();
		
		String s = new String();
		while (!(s = br.readLine()).equals("exit")){
			
			String[] args = s.split("\\s");
			
			if ((args.length == 4) && (args[0].equals("add")))	{
				double str = Double.parseDouble(args[3]);
				bReg.add(new Beer(args[1], args[2], str));
			}
			else if(args[0].equals("list")){
				if (args.length == 1)	{
					bReg.list();
				}
				else	{
					bReg.list(args[1]);
				}
			}
			else if((args[0].equals("load")) && (args.length == 2))	{
				File wd = new File(System.getProperty("user.dir"));
				File f = new File(wd, args[1]);
				bReg.load(f);
			}
			else if((args[0].equals("save")) && (args.length == 2))	{
				File wd = new File(System.getProperty("user.dir"));
				File f = new File(wd, args[1]);
				bReg.save(f);
			}
			else if((args[0].equals("delete")) && (args.length == 2))	{
				//bReg.delete(new Beer(args[1], null, 0.0));
				Beer b = new Beer(null, null, 0);
				b.setStrength(Double.parseDouble(args[1]));
				bReg.delete(b);
			}
			else	{
				System.err.println("Unknown command.");
			}
		}
	}

}
