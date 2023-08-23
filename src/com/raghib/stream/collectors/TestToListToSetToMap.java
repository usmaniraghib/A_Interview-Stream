package com.raghib.stream.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Product {
	private int id;
	private String name;
	private float price;
	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}

public class TestToListToSetToMap {

	public static void main(String[] args) {
		
		Product p1 = new Product(1,"A",100f);
		Product p2 = new Product(2,"B",200f);
		Product p3 = new Product(3,"C",300f);
		Product p4 = new Product(4,"D",400f);
		Product p5 = new Product(5,"E",500f);
		
		List<Product> listProduct = new ArrayList<>();
		listProduct.add(p1);
		listProduct.add(p2);
		listProduct.add(p3);
		listProduct.add(p4);
		listProduct.add(p5);
		
		System.out.println("Collectors.toList()");
		List<Float> resultPrice = listProduct.stream().map(a -> a.getPrice()).collect(Collectors.toList());
		resultPrice.forEach(b -> System.out.print(b+" "));
		
		System.out.println("\nCollectors.toSet()");
		Set<Float> resultPrice1 = listProduct.stream().map(b -> b.getPrice()).collect(Collectors.toSet());
		resultPrice1.forEach(b -> System.out.print(b+" "));
		
		System.out.println("\nCollectors.toMap()");
		Map<String,Float> resultPrice3 = listProduct.stream().collect(Collectors.toMap(c -> c.getName(), c -> c.getPrice()));
		System.out.println(resultPrice3);
		
		resultPrice3.forEach((k,v) -> System.out.println("Name : " +k +" , " +"Value : "+v));
	}
}