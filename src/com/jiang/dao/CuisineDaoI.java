package com.jiang.dao;

import java.util.List;

import com.jiang.pojo.Cuisine;

/**
 *菜系操作接口
 * @author Administrator
 *
 */
public interface CuisineDaoI {
	/**
	 * 
	 * @return 返回所有菜系信息的集合
	 */
	List<Cuisine> getCuisineList();
	
	/**
	 * 根据菜系名称模糊查询
	 * @param cname 传入菜系名称 
	 * @return 返回菜系名称中含有cname的菜系集合
	 */
	List<Cuisine> getCuisineListByCname(String cname);
	/**
	 * 插入一条数据
	 * @param cname
	 */
	void insert(String cname);
	/**
	 * 根据菜系编号删除一条数据
	 * @param cid 需要删除的菜系的编号
	 */
	void delete(Integer cid);
}