package com.hand.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
private String name;
private String password;
	public String execute() throws Exception {
		 String ret = ERROR;
		 Connection conn = null;
		 try {
	         String URL = "jdbc:mysql://localhost/sakila";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "");
	         String sql = "SELECT first_name FROM customer WHERE first_name="+name;
	         Statement st = conn.createStatement();
	         ResultSet rs =st.executeQuery(sql);
	         while (rs.next()&&name.equals(password)) {
	             ret = SUCCESS;
	          }
		 }catch (Exception e) {
	              ret = ERROR;
	          } finally {
	             if (conn != null) {
	                try {
	                   conn.close();
	                } catch (Exception e) {
	                }
	             }
	          }
	          return ret;
	       
		 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		 
	
	
}
