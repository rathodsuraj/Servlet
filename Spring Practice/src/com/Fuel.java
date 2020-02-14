package com;

public class Fuel {

	private String name;
	private int price;

	public Fuel(String name, int price) {

		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fuel [name=" + name + ", price=" + price + "]";
	}

	
}
