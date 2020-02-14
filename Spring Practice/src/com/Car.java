package com;

public class Car {

	private long price;
	private String name;
	
	private Fuel fuel;

	public Car(long price, String name,Fuel fuel) {

		this.price = price;
		this.name = name;
		this.fuel=fuel;

	}

	@Override
	public String toString() {
		return "Car [price=" + price + ", name=" + name + ", fuel=" + fuel + "]";
	}
	
	

}
