package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/Config.xml");
		Result result_1 = (Result) context.getBean("result1");
		result_1.calculateAvg();
		result_1.calculateTotal();
		System.out.println(result_1.toString());
		
	}

}
