package com.training.task2;

import java.util.*;

class Student
{
	String name;
	String dept;
	String regNum;
	String mobNum;
	String seqNum;
	
	
	Student(String name,String dept, String mobNum, String seqNum)
	{
		this.name=name;
		this.dept=dept;
		this.mobNum=mobNum;
		this.seqNum=seqNum;
		regNum="IITD"+dept+"2021-"+seqNum;
	}
	
	public String toString()
	{
		return this.name+" "+this.dept;
	}
}

//class ComImpl implements Comparator<Student>
//{
//
//	@Override
//	public int compare(Student o1, Student o2) {
//		// TODO Auto-generated method stub
//		return o1.seqNum.compareTo(o2.seqNum);
//	}
//	
//}

public class MergeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> arrCS= new ArrayList<Student>();
		ArrayList<Student> arrIT= new ArrayList<Student>();
		arrCS.add(new Student("aaa","CS","123456","01"));
		arrIT.add(new Student("bbb","IT","123456","02"));
		arrIT.add(new Student("ccc","IT","123456","03"));
		arrCS.add(new Student("ddd","CS","123456","04"));
		arrIT.add(new Student("eee","IT","123456","05"));
		
		arrCS.addAll(arrIT);
		ArrayList<Student> arr= new ArrayList<Student>(arrCS);
		
		System.out.println("Unsorted List");
		for(int i=0; i<arr.size(); i++)
		{
			System.out.println(arr.get(i));
		}
		
//		Comparator<Student> com = new ComImpl();
//		Collections.sort(arr, com);
		
		arr.sort((Student o1, Student o2)->o1.seqNum.compareTo(o2.seqNum));
		System.out.println("\nSorted List");
		for(int i=0; i<arr.size(); i++)
		{
			System.out.println(arr.get(i));
		}

	}

}


