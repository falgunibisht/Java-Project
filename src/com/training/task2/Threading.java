package com.training.task2;

class Odd extends Thread
{
	public void run()
	{
		for(int i=1; i<=10; i=i+2)
		{
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Even extends Thread
{
	public void run()
	{
		for(int i=2; i<=10; i=i+2)
		{
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Threading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Odd obj1 =new Odd();
		Even obj2 = new Even();
		
		obj1.start();
		obj2.start();

	}

}
