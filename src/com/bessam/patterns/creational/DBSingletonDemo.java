package com.bessam.patterns.creational;

/**
 * @author bessam on 08/03/2021
 */

public class DBSingletonDemo {

	public static void main(String[] args){
		DBSingleton instance = DBSingleton.getInstance();
		System.out.println(instance);

		DBSingleton instance2 = DBSingleton.getInstance();
		System.out.println(instance2);

		if (instance == instance2)
			System.out.println("the same instance ");


	}
}
