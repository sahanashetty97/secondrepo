package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


 class Order 
{
	private String orderId;
	private String custName;
	private float orderAmount;
	private String paymentOption;

	public Order(String orderId, String custName, float orderAmount, String paymentOption)
	{

		this.orderId = orderId;
		this.custName = custName;
		this.orderAmount = orderAmount;
		this.paymentOption = paymentOption;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}
public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	@Override
	public String toString() {
		return " [orderId=" + orderId + ", custName=" + custName + ", orderAmount=" + orderAmount
				+ ", paymentOption=" + paymentOption + "]";
	}   


}
 
 class InvaliedOrderException extends Exception
 {
    InvaliedOrderException(String message)
    {
    super(message);
    } 
 }
 
 class OrderServiceUtil 
 {
 	ArrayList<Order> list= new ArrayList();
 	
 	Order orderSearch=null;
 	float total =0;
 	
 	public void addOrder(Order o1)
 	{
 		if(o1!=null)
 		{
 			list.add(o1);
 		}
 	}
public Order searchId(String orderId)throws InvaliedOrderException
 {
 	
 	for(Order o2:list)
 	{
 		if(o2.getOrderId().equals(orderId))
 		{
 			orderSearch=o2;
 		
 		}
 		else 
 		{
 			throw new InvaliedOrderException("invalid order");
 		}
 	}
 	return orderSearch;
 	
 }

 public float findTotal()
 {
 	for(Order o2:list)
 	{
 		total=total+o2.getOrderAmount();
 	}
 	return total;
 	
 }
 }
 
 

public class TestClient {

	public static void main(String[] args) throws InvaliedOrderException {
		
		OrderServiceUtil service= new OrderServiceUtil();
		
		Scanner s=new  Scanner(System.in);
		System.out.println("enter no of orders to be added");
		int n=s.nextInt();
		
		for(int i=0;i<n;i++)
		{
			System.out.println("enter order id");
			String id=s.next();
			System.out.println("enter order name");
			String name=s.next();
			System.out.println("enter order amount");
			float amount=s.nextFloat();
			System.out.println("enter mode of payment ");
			String payoption=s.next();
		
       service.addOrder(new Order(id,name,amount,payoption));
		}
       System.out.println("total : "+service.findTotal());
       System.out.println("enter the id to be searched");
       String searchById=s.next();
       System.out.println("order details of id : " +service.searchId(searchById));
		 s.close();
	}

}


