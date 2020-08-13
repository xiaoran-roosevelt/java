<%@page import="java.util.Date"%>
<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat,util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");//使用这个让表单提交的中文数据不为乱码
    String tc= request.getParameter("opinion1");
    String username=request.getParameter("username");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化类
    Date d1=new Date();
    String time=df.format(d1.getTime());//时间串
    try {
        Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
      }
      catch (Exception e) {
        System.out.println("Error loading Mysql Driver!");
        e.printStackTrace();
      }
    try {
    	Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_test?serverTimezone=UTC","root","123Lz0925@");
        //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密
    Statement stmt = connect.createStatement();
    String sql="insert into comment values('"+username+"','"+tc+"','"+time+"');";
	 stmt.executeUpdate(sql);
    }
    catch (Exception e) {
        System.out.print("get data error!");
        e.printStackTrace();
      }
%>