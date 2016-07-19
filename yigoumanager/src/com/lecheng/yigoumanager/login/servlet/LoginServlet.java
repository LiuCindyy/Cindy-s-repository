package com.lecheng.yigoumanager.login.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yigou.lecheng.util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 *�������� @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ҳ����û���
		String loginname = req.getParameter("userName");

		System.out.println("b");
		
		HttpSession session =null;

		String SQl = "select * from login where username = ? and password = ?";
		List<Map<String,String>> list = new ArrayList<>();
		Map<String,String> map= new HashMap<>();
		//���ҳ���ύ������
		String password=req.getParameter("pwd");
		Object[] obj ={loginname,password};
		DBUtil db = new DBUtil();
		req.setCharacterEncoding("utf-8");
		
		
		try {
			list = db.exeQury(SQl, obj);
			if(list==null || list.size()!=1) {
				response.sendRedirect("index.jsp");
			}else {
			
				response.sendRedirect("login.jsp");
				map = list.get(0);
				session = req.getSession();
				session.setAttribute("USER",map);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
