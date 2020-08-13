<%@ page language="java" import="java.util.*,util.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>help</title>
<style type="text/css">
.usrname{
            height: 15px;
            margin-left: 10px;
            margin-top: 5px;
            float: left;
            font-size: 15px;
            width:40%;
            text-align: left;
             color: red;
}
.usrtime {
	     height: 15px;
            margin-right: 10px;
            margin-top: 5px;
            float: right;
            font-size: 15px;
            width: 40%;
            text-align: right;
             color: red;
}
  .usrcomment{
            width: 90%;
            margin-top: 5px;
            font-size: 16px;
            text-align: left;
            margin-left: 10px;
             float: left;
        }
</style>
</head>
<body>
<%
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
ResultSet rs = stmt.executeQuery("select * from comment");
while (rs.next()) {
out.println("<div class='usrname'>"+rs.getString("user")+":"+"</div>"+"<div class='usrtime'>"+rs.getString("time")+"</div>"+"<div class='usrcomment'>"+rs.getString("content")+"</div>");
 }
  }
  catch (Exception e) {
    System.out.print("get data error!");
    e.printStackTrace();
  }
%>
</body>
</html>