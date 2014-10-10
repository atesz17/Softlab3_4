package com.newl;

import com.newl.col.PQueue;

public class Test {

	public static void main(String[] args) {
		
		PQueue<String> q = new PQueue<String>();
		q.top();
		q.pop();
		q.push("Elso");
		q.push("Masodik");
		q.push("Harmadik");
		System.out.println(q.size());
		System.out.println(q.top());
		System.out.println(q.pop());
		System.out.println(q.pop());
		q.clear();
		q.top();
		q.pop();
	}

}
