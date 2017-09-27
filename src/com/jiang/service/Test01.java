package com.jiang.service;

import java.util.List;

import org.junit.Test;

import com.jiang.dao.FoodDaoImpl;
import com.jiang.pojo.Food;

public class Test01 {
	@Test
	public void getFoodList(){
		FoodDaoImpl f = new FoodDaoImpl();
		List<Food> foodList = f.getFoodList();
		for (Food food : foodList) {
			System.out.println(food);
		}
	}
	@Test
	public void getFoodListByFname(){
		FoodDaoImpl f = new FoodDaoImpl();
		List<Food> foodList = f.getFoodListByFname("白");
		for (Food food : foodList) {
			System.out.println(food);
		}
	}
	@Test
	public void insert(){
		FoodDaoImpl f = new FoodDaoImpl();
		 f.insert("aaaa", 1, 11D, 1.2, "aaa");
	}
	@Test
	public void update(){
		FoodDaoImpl f = new FoodDaoImpl();
		f.update(23, "bbbb", 2, 11.1, 12.1, "bbb");
	}
	@Test
	public void delete(){
		FoodDaoImpl f = new FoodDaoImpl();
		f.delete(23);
	}
}
