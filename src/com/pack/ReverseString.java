package com.pack;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="adam";
		String rev="";
		int len=s.length();
		for (int i=len-1;i>=0; i--)
		{
			rev=rev+s.charAt(i);
		}
		System.out.println(rev);
		}
	}


