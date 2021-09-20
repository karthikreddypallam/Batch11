package com.javainterview.basicprograms;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
		
		int x = 0;
		int y = 1; 
		int z = 0;
		while(z<100) {
			z = x+y; //1, 2,  
			x=y; // x = 1, y=1
			y=z;
			System.out.println(z);
		}

	}

}
