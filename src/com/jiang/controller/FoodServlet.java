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
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//判断请求
		String method=request.getParameter("method");
		if(method!=null){
			if("getList".equals(method)){
				getList(request,response);
			}
		}
	}

	private void getList(HttpServletRequest request, HttpServletResponse response) {
		FoodServiceI f = new FoodServiceImpl();
		//将菜品信息数组转为json字符串
		String jsonString = JSONObject.toJSONString(f.getFoodList());
//		System.out.println(jsonString);
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
