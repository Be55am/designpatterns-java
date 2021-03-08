package com.bessam.patterns.creational.builder;

/**
 * @author bessam on 08/03/2021
 */

public class BuilderDemo {

	public static void main(String[] args) {
		/*
		Just an example of StringBuilder
		 */
//		StringBuilder builder = new StringBuilder();
//		builder.append("This is an example ");
//		builder.append("of the design pattern ");
//		builder.append("it can append anything u want like numbers ");
//		builder.append(23432);
//		builder.append(true);
//		System.out.println(builder.toString());

		LunchOrder.Builder builder = new LunchOrder.Builder();
		LunchOrder lunchOrder = builder.bread("bread")
				.condiments("condiments")
				.dressing("some dressings")
				.meat("ham")
				.build();

		System.out.println(lunchOrder.toString());
	}

}
