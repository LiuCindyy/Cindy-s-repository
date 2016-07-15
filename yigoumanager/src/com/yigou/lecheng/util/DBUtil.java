package com.yigou.lecheng.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBUtil {
	private static final String SQL = null;

	/**
	 * 数据库连接文件
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	//导入数据库驱动
	public static void main(String[] args)  {
		
		
		try {
			//1.导入数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库连接
			 Connection conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			 //创建处理对象
			 Statement st = conn.createStatement();
		
			 int se = st.executeUpdate("insert into login(name,password) values('niha',12345678)");
			 st.executeUpdate("insert into login(name,password) values('wanger',87654321)");
			 
			 
			 //执行SQL语句 插入
			
			 //执行SQL语句 查询
			 ResultSet flag=st.executeQuery("select * from stu where name=zhangsan");
			 
			
			 
			 
		}catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}
}
