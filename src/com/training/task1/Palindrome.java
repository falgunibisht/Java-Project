package com.training.task1;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num=121;
		int n=num;
		int rev=0;
		int x=0;
		
		while(n!=0)
		{
			x=n%10;
			rev=rev*10+x;
			n/=10;
		}
		if(rev == num)
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
	}

}
