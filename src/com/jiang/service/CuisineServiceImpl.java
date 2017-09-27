package com.jiang.service;

import java.util.List;

import com.jiang.dao.CuisineDaoI;
import com.jiang.dao.CuisineDaoImpl;
import com.jiang.pojo.Cuisine;

public class CuisineServiceImpl implements CuisineServiceI {
	CuisineDaoI c = new CuisineDaoImpl();

	/**
	 * 
	 * @return 返回所有菜系信息的集合
	 */
	public List<Cuisine> getCuisineList() {
		// TODO Auto-generated method stub
		return c.getCuisineList();
	}

	/**
	 * 根据菜系名称模糊查询
	 * 
	 * @param cname
	 *            传入菜系名称
	 * @return 返回菜系名称中含有cname的菜系集合
	 */
	public List<Cuisine> getCuisineListByCname(String cname) {
		// TODO Auto-generated method stub
		return c.getCuisineListByCname(cname);
	}

	/**
	 * 插入一条数据
	 * 
	 * @param cname
	 */
	public void insert(String cname) {
		// TODO Auto-generated method stub
		c.insert(cname);
	}

	/**
	 * 根据菜系编号删除一条数据
	 * 
	 * @param cid
	 *            需要删除的菜系的编号
	 */
	public void delete(Integer cid) {
		// TODO Auto-generated method stub
		c.delete(cid);
	}

}
