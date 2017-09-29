package com.jiang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jiang.service.FoodServiceI;
import com.jiang.service.FoodServiceImpl;

public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 判断请求
		String method = request.getParameter("method");
		if (method != null) {
			if ("getList".equals(method)) {
				getList(request, response);
			} else if ("insert".equals(method)) {
				String fname = request.getParameter("fname");
				int cid = Integer.parseInt(request.getParameter("cid"));
				Double price = Double.parseDouble(request.getParameter("price"));
				Double vipprice = Double.parseDouble(request.getParameter("vipprice"));
				String url = request.getParameter("");
				insert(fname, cid, price, vipprice, url);
				response.sendRedirect(request.getContextPath() + "/detail/foodList.jsp");
			} else if ("delete".equals(method)) {
				Integer fid = Integer.parseInt(request.getParameter("fid"));
				delete(fid);
				response.sendRedirect(request.getContextPath() + "/detail/foodList.jsp");
			} else if ("update".equals(method)) {
				int fid = Integer.parseInt(request.getParameter("fid"));
				String fname = request.getParameter("fname");
				int cid = Integer.parseInt(request.getParameter("cid"));
				Double price = Double.parseDouble(request.getParameter("price"));
				Double vipprice = Double.parseDouble(request.getParameter("vipprice"));
				String url = request.getParameter("");
				update(fid, fname, cid, price, vipprice, url);
				response.sendRedirect(request.getContextPath() + "/detail/foodList.jsp");
			}else if("getListByFid".equals(method)){
				Integer fid=Integer.parseInt(request.getParameter("fid"));
				getListByFid(fid, response);
			}
		}
	}
	/**
	 * 根据fid查询一条数据
	 * 
	 * @param fid
	 *            菜品编号
	 * @return 返回一个类型为Food的List集合 存放的是所有的菜品编号为fid的菜品信息
	 */
	private void getListByFid(Integer fid,HttpServletResponse response) {
		// TODO Auto-generated method stub
		FoodServiceI f = new FoodServiceImpl();
		String jsonString = JSONObject.toJSONString(f.getFoodListByFid(fid));
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	private void update(int fid, String fname, int cid, Double price, Double vipprice, String url) {
		// TODO Auto-generated method stub
		FoodServiceI f = new FoodServiceImpl();
		f.update(fid, fname, cid, price, vipprice, url);
	}

	/**
	 * 删除一条记录
	 * 
	 * @param fid
	 *            需要删除的菜品的编号
	 */
	private void delete(Integer fid) {
		// TODO Auto-generated method stub
		FoodServiceI f = new FoodServiceImpl();
		f.delete(fid);
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
	private void insert(String fname, int cid, Double price, Double vipprice, String url) {
		// TODO Auto-generated method stub
		FoodServiceI f = new FoodServiceImpl();
		f.insert(fname, cid, price, vipprice, url);
	}

	private void getList(HttpServletRequest request, HttpServletResponse response) {
		FoodServiceI f = new FoodServiceImpl();
		// 将菜品信息数组转为json字符串
		String jsonString = JSONObject.toJSONString(f.getFoodList());
		// System.out.println(jsonString);
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
