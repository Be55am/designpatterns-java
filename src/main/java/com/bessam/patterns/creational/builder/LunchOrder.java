package com.bessam.patterns.creational.builder;

/**
 * @author bessam on 08/03/2021
 */

public class LunchOrder {

	private final String bread;
	private final String meat;
	private final String dressing;
	private final String condiments;

	private LunchOrder(Builder builder){
		this.bread = builder.bread;
		this.meat = builder.meat;
		this.condiments = builder.condiments;
		this.dressing = builder.dressing;
	}

	public static class Builder{
		/*
		the builder has its own components and it will build when we tell it to
		 */
		private  String bread;
		private  String meat;
		private  String dressing;
		private  String condiments;

		//we can put some arguments here and force the use of these arguments
		public Builder(){
		}

		public LunchOrder build(){
			return new LunchOrder(this);
		}

		public Builder condiments(String condiments){
			this.condiments = condiments;
			return this;
		}
		public Builder meat(String meat){
			this.meat = meat;
			return this;
		}public Builder dressing(String dressing){
			this.dressing = dressing;
			return this;
		}public Builder bread(String bread){
			this.bread = bread;
			return this;
		}

	}

	@Override
	public String toString() {
		return "LunchOrder{" +
				"bread='" + bread + '\'' +
				", meat='" + meat + '\'' +
				", dressing='" + dressing + '\'' +
				", condiments='" + condiments + '\'' +
				'}';
	}
}
