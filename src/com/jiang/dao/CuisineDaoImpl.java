package com.jiang.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiang.pojo.Cuisine;
import com.jiang.util.JDBCUtil;

/**
 * 菜系操作类
 * 
 * @author Administrator
 *
 */
public class CuisineDaoImpl implements CuisineDaoI {

	/**
	 * 
	 * @return 返回所有菜系信息的集合
	 */
	public List<Cuisine> getCuisineList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cuisine cuisine = null;
		List<Cuisine> cList = new ArrayList<Cuisine>();
		String sql = "select * from cuisine order by cid";
		try {
			pstmt = JDBCUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cuisine = new Cuisine(rs.getInt(1), rs.getString(2));
				cList.add(cuisine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}

		return cList;
	}

	/**
	 * 
	 * @param cname
	 * @return
	 */
	public List<Cuisine> getCuisineListByCname(String cname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cuisine cuisine = null;
		List<Cuisine> cList = new ArrayList<Cuisine>();
		String sql = "select * from cuisine where cname like ? order by cid";
		try {
			pstmt = JDBCUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, "%" + cname + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cuisine = new Cuisine(rs.getInt(1), rs.getString(2));
				cList.add(cuisine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}

		return cList;
	}

	/**
	 * 插入一条数据
	 * 
	 * @param cname
	 */
	public void insert(String cname) {
		PreparedStatement pstmt = null;
		String sql="insert into cuisine(cname) values(?)";
		try {
			pstmt=JDBCUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, cname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			JDBCUtil.close(pstmt);
		}
		
	}

	/**
	 * 根据菜系编号删除一条数据
	 * @param cid 需要删除的菜系的编号
	 */
	public void delete(Integer cid) {
		PreparedStatement pstmt=null;
		String sql="delete from cuisine where cid=?";
		try {
			pstmt=JDBCUtil.getConnection().prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			JDBCUtil.close(pstmt);
		}
		
	}

	/**
	 * 根据菜系编号查询
	 * @param cid 传入菜系编号
	 * @return 返回菜系编号对应的的菜系集合
	 */
	public List<Cuisine> getCuisineListByCid(Integer cid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cuisine cuisine = null;
		List<Cuisine> cList = new ArrayList<Cuisine>();
		String sql = "select * from cuisine where cid = ? order by cid";
		try {
			pstmt = JDBCUtil.getConnection().prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cuisine = new Cuisine(rs.getInt(1), rs.getString(2));
				cList.add(cuisine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, rs);
		}

		return cList;
	
	}

}
