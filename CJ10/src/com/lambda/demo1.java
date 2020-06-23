package com.lambda;

interface I
{
	void method1();
}

interface I2
{
	int method2(int num);
}

interface I3
{
	void method3();
}
public class demo1 {

	public static void main(String[] args) {
		I iobj= () ->{ System.out.println("name");};
		iobj.method1();
		
		I2 iobj2= num -> 
		{
			int sqr=num*num;
			return sqr;
		};
		int val=iobj2.method2(2);
		System.out.println(val);
		
		
		I3 iobj3= () -> 
		{
			StringBuilder sb = new StringBuilder("hello");
			System.out.println(sb.reverse());};
			
		
		iobj3.method3();
		
	}

}
