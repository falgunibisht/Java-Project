package com.training.task2;

class PrintingOddEven implements Runnable
{
	static int count=1;
	int flag;
	static Object lock=new Object();
	
	public PrintingOddEven(int flag) {
		// TODO Auto-generated constructor stub
		this.flag=flag;
	}

	
	public synchronized void run()
	{
		for (int i=1; i<=5; i++)
		{
			//System.out.println(Thread.currentThread().getName()+" Inside loop");
			synchronized (lock) {
				//System.out.println(Thread.currentThread().getName()+" Inside critical section");
				while(count%2 != flag)
					try {
						lock.wait();
						//System.out.println(Thread.currentThread().getName()+" Waiting");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				System.out.println(Thread.currentThread().getName()+" "+count++);
				lock.notifyAll();
			}
			}
		}
	}


public class MultithreadingOddEven{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintingOddEven odd_obj=new PrintingOddEven(1);
		PrintingOddEven even_obj=new PrintingOddEven(0);
		
		Thread odd=new Thread(odd_obj,"Thread for Odd");
		Thread even=new Thread(even_obj,"Thread for Even");
		
		odd.start();
		even.start();
	}

}

