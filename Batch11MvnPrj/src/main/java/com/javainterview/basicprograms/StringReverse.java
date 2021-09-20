package com.javainterview.basicprograms;

public class StringReverse {
	public static void main(String[] args) {
		
		String str = "Welcome";
		char charArray[] = str.toCharArray();
		String rev = "";
		for(int i=charArray.length-1;i>=0;i--) {
			rev = rev+charArray[i];
		}
		
		System.out.println(rev);
		
		
	}
}
