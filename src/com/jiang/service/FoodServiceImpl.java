package com.jiang.service;

import java.util.List;

import com.jiang.dao.FoodDaoI;
import com.jiang.dao.FoodDaoImpl;
import com.jiang.pojo.Food;

public class FoodServiceImpl implements FoodServiceI {
	/**
	 * 创建Dao对象
	 */
	FoodDaoI f = new FoodDaoImpl();

	/**
	 * 获取全部菜品信息
	 * 
	 * @return 返回一个类型为Food的List集合 存放的是所有的菜品信息
	 */
	public List<Food> getFoodList() {
		// TODO Auto-generated method stub
		return f.getFoodList();
	}

	/**
	 * 根据菜品名称模糊查询
	 * 
	 * @param fname
	 * @return 返回一个类型为Food的List集合 存放的是所有的菜品名称含有fname的菜品信息
	 */
	public List<Food> getFoodListByFname(String fname) {
		// TODO Auto-generated method stub
		return f.getFoodListByFname(fname);
	}

	/**
	 * 添加一条数据
	 * 
	 * @param fname
	 *            菜品名称
	 * @param cid
	 *            菜品所属菜系编号
	 * @param price
	 *            菜品价格
	 * @param vipprice
	 *            菜品VIP价格
	 * @param url
	 *            菜品图片路径
	 */
	public void insert(String fname, int cid, Double price, Double vipprice, String url) {
		// TODO Auto-generated method stub
		f.insert(fname, cid, price, vipprice, url);
	}

	/**
	 * 修改一条数据
	 * 
	 * @param fid
	 *            菜品编号
	 * @param fname
	 *            菜品名称
	 * @param cid
	 *            菜品所属菜系编号
	 * @param price
	 *            菜品价格
	 * @param vipprice
	 *            菜品VIP价格
	 * @param url
	 *            菜品图片路径
	 */
	public void update(int fid, String fname, int cid, Double price, Double vipprice, String url) {
		// TODO Auto-generated method stub
		f.update(fid, fname, cid, price, vipprice, url);
	}

	/**
	 * 删除一条记录
	 * 
	 * @param fid
	 *            需要删除的菜品的编号
	 */
	public void delete(Integer fid) {
		// TODO Auto-generated method stub
		f.delete(fid);
	}

	/**
	 * 根据fid查询一条数据
	 * 
	 * @param fid
	 *            菜品编号
	 * @return 返回一个类型为Food的List集合 存放的是所有的菜品编号为fid的菜品信息
	 */
	public List<Food> getFoodListByFid(Integer fid) {
		// TODO Auto-generated method stub
		return f.getFoodListByFid(fid);
	}

}
