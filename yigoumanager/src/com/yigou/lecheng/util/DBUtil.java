package com.yigou.lecheng.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBUtil {
	private static final String SQL = null;

	/**
	 * ���ݿ������ļ�
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	//�������ݿ�����
	public static void main(String[] args)  {
		
		
		try {
			//1.�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ���ݿ�����
			 Connection conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			 //�����������
			 Statement st = conn.createStatement();
		
			 int se = st.executeUpdate("insert into login(name,password) values('niha',12345678)");
			 st.executeUpdate("insert into login(name,password) values('wanger',87654321)");
			 
			 
			 //ִ��SQL��� ����
			
			 //ִ��SQL��� ��ѯ
			 ResultSet flag=st.executeQuery("select * from stu where name=zhangsan");
			 
			
			 
			 
		}catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
	}
}
