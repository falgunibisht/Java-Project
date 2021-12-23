package com.training.task1;

public class RightTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=i; j++)
			{
				if(j<=i)
				{
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("done");

	}

}
