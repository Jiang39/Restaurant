package com.jiang.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiang.pojo.Food;
import com.jiang.util.JDBCUtil;

public class FoodDaoImpl implements FoodDaoI {

	/**
	 * 获取全部菜品信息
	 * 
	 * @return 返回一个类型为Food的List集合 存放的是所有的菜品信息
	 */
	public List<Food> getFoodList() {
		PreparedStatement pstmt = null;
		Food food = null;
		ResultSet rs = null;
		List<Food> foodList = new ArrayList<Food>();
		// 查询语句
		String sql = "SELECT f.fid,f.fname,c.cname,f.price,f.vipprice,f.url FROM food f,cuisine c WHERE c.cid=f.cid ORDER BY f.fid";
		// 获取数据库连接
		try {
			pstmt = JDBCUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 将数据封装到food对象中
				food = new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5),
						rs.getString(6));
				// 将对象存入List集合
				foodList.add(food);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}

		return foodList;
	}

	/**
	 * 根据菜品名称模糊查询
	 * 
	 * @param fname
	 * @return 返回一个类型为Food的List集合 存放的是所有的菜品名称含有fname的菜品信息
	 */
	public List<Food> getFoodListByFname(String fname) {
		PreparedStatement pstmt = null;
		Food food = null;
		ResultSet rs = null;
		List<Food> foodList = new ArrayList<Food>();
		// 查询语句
		String sql = "SELECT f.fid,f.fname,c.cname,f.price,f.vipprice,f.url FROM food f,cuisine c WHERE c.cid=f.cid and f.fname like ? ORDER BY f.fid";
		// 获取数据库连接
		try {
			pstmt = JDBCUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, "%"+fname+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 将数据封装到food对象中
				food = new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5),
						rs.getString(6));
				// 将对象存入List集合
				foodList.add(food);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}

		return foodList;
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
			PreparedStatement pstmt=null;
			String sql="insert into food(fname,cid,price,vipprice,url) values(?,?,?,?,?)";
			try {
				pstmt=JDBCUtil.getConnection().prepareStatement(sql);
				pstmt.setString(1, fname);
				pstmt.setInt(2, cid);
				pstmt.setDouble(3, price);
				pstmt.setDouble(4, vipprice);
				pstmt.setString(5, url);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.close(pstmt);
			}
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
		PreparedStatement pstmt=null;
		String sql="update food set fname = ? ,cid=?,price=?,vipprice=?, url=? where fid=? ";
		try {
			pstmt=JDBCUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, fname);
			pstmt.setInt(2, cid);
			pstmt.setDouble(3, price);
			pstmt.setDouble(4, vipprice);
			pstmt.setString(5, url);
			pstmt.setInt(6, fid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		
		
	}

	/**
	 * 删除一条记录
	 * @param fid 需要删除的菜品的编号
	 */
	public void delete(Integer fid) {
		PreparedStatement pstmt=null;
		String sql="delete from food where fid=?";
		try {
			pstmt=JDBCUtil.getConnection().prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		
	}

}
