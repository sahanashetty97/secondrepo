package com.lambda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import com.day8.Employee;

class Employee implements Serializable
{
	int empid;
	String empname;
	int dno;
	public Employee(int empid, String empname, int dno) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.dno = dno;
	}
	public Employee(ObjectInputStream inn)
	{
		
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	
	
}

public class Scoreemp {

	public static void main(String[] args) throws IOException,ClassNotFoundException {
		Scanner sc= new Scanner(System.in);
		Employee em= new Employee(123,"Raman",51000);
		try {
			FileOutputStream fout=new FileOutputStream("e.txt");
			ObjectOutputStream objs=new ObjectOutputStream(fout);
			
			objs.writeObject(em);
			objs.flush();
			objs.close();
			{
			System.out.println("serializable completed");
			}
		}catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			ObjectInputStream inn= new ObjectInputStream(new FileInputStream("e.txt"));
			Employee ee=(Employee)inn.readObject();
			System.out.println(ee.getEmpname()+ " " + ee.getEmpid()+ " "+ ee.getDno());
		}

	}


