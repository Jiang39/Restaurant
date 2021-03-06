package com.jiang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jiang.service.CuisineServiceI;
import com.jiang.service.CuisineServiceImpl;

public class CuisineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 判断请求
		String method = request.getParameter("method");
		if (method != null) {
			if ("getList".equals(method)) {
				getList(response);
			} else if ("insert".equals(method)) {
				// 添加
				String cname = request.getParameter("cname");
				if (cname != null && !"".equals(cname)) {
					insert(cname);
					response.sendRedirect(request.getContextPath() + "/detail/cuisineList.jsp");
				}
			} else if ("delete".equals(method)) {
				Integer cid = Integer.parseInt(request.getParameter("cid"));
				delete(cid);
				// System.out.println(cid);
				response.sendRedirect(request.getContextPath() + "/detail/cuisineList.jsp");
			} else if ("getListByCid".equals(method)) {
				Integer cid = Integer.parseInt(request.getParameter("cid"));
				// System.out.println(cid);
				getListByCid(cid, response);
			}else if("update".equals(method)){
				Integer cid = Integer.parseInt(request.getParameter("cid"));
				String cname=request.getParameter("cname");
				update(cid,cname);
				response.sendRedirect(request.getContextPath() + "/detail/cuisineList.jsp");
			}

		}
	}
	/**
	 * 根据传入的菜系编号cid 修改对应的菜系名称
	 * @param cid 需要修改的菜系的编号
	 * @param cname 新的菜系名称
	 */
	private void update(Integer cid, String cname) {
		// TODO Auto-generated method stub
		CuisineServiceI c = new CuisineServiceImpl();
		c.update(cid, cname);	
	}

	/**
	 * 根据菜系编号cid查询一条菜系信息
	 * 
	 * @param cid
	 */
	private void getListByCid(Integer cid, HttpServletResponse response) {
		CuisineServiceI c = new CuisineServiceImpl();
		String jsonString = JSONObject.toJSONString(c.getCuisineListByCid(cid));
		// System.out.println(jsonString);
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据菜系编号删除一条数据
	 * 
	 * @param cid
	 *            要删除的菜系的编号
	 */
	private void delete(Integer cid) {
		CuisineServiceI c = new CuisineServiceImpl();
		c.delete(cid);
	}

	/**
	 * 添加一条菜系数据
	 * 
	 * @param cname
	 */
	private void insert(String cname) {
		CuisineServiceI c = new CuisineServiceImpl();
		c.insert(cname);
	}

	/**
	 * 查询全部的菜系信息 将信息封装到Cuisine类型的list集合 转为json字符串后 发往前台页面上
	 * 
	 * @param response
	 */
	private void getList(HttpServletResponse response) {
		CuisineServiceI c = new CuisineServiceImpl();
		String jsonString = JSONObject.toJSONString(c.getCuisineList());
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
