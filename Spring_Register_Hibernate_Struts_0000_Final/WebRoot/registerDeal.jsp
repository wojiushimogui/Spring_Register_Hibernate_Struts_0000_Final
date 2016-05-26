<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="com.register.model.*" %>
<%@ page import="com.register.service.*" %>
<%@ page import="com.register.service.impl.*" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=request.getParameter("username");
String password=request.getParameter("password");
String password2=request.getParameter("password2");

User user=new User();
user.setUsername(username);
user.setPassword(password);

UserManager um=new UserManagerImpl();
boolean exists=um.exists(user);
if(exists){
	response.sendRedirect("registerFail.jsp");
	return;
}

um.save(user);
response.sendRedirect("registerSuccess.jsp");
%>

