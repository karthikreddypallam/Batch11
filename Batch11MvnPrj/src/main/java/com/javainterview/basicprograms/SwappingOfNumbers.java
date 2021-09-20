package com.javainterview.basicprograms;

public class SwappingOfNumbers {

	public static void main(String[] args) {

		int a = 70; 
		int b = 90; 

		System.out.println("Before Swap a value==> "+a);
		System.out.println("Before Swap b value==> "+b);

		b = a+b; //30
		a = b-a;
		b = b-a;

		System.out.println("After Swap a value==> "+a);
		System.out.println("After Swap b value==> "+b);	

	}

}
