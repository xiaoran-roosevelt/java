<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>汉服文化</title>
<link href="css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2:default.js" type="text/javascript"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
#mydiv{
	 font-size: 15px;
	 overflow:scroll;
	 height:150px;
}
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
<script src="jqueryload.js"></script>
<script language="javascript">//src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"
function Rrefresh(){
	var opinion1=$('#opinion1').val();
	var username=$('#username').val();
	if(opinion1=='' || username==''){
		alert("您未输入姓名或者留言");
		}else{
			
			$.ajax({
		        type:"post",//请求方式 
		        url:"MessageRefresh3.jsp",//请求地址
		        data:{"opinion1":opinion1,"username":username},//
		        error:function(){
		           alert("登陆出错！");
		        },
		        success:function(data){ //返回成功执行回调函数。
		        	$("#mydiv").load("help3.jsp");
		        }
		    }); 
			$("#opinion1").val("");//清空文本域
			
		}
	
   } 
</script>  
</head>
<body>
<!-- Main Container -->
<div class="container"> 
  <!-- Navigation -->
  <header> <a href="">
    <h4 class="logo">汉服文化</h4>
  </a>
    <nav>
      <ul>
        <li><a href="main.html">HOME</a></li>
        <li><a href="#about">ABOUT</a></li>
        <li> <a href="#contact">CONTACT</a></li>
      </ul>
    </nav>
  </header>
  <!-- Hero Section -->
  <section class="hero" id="hero"><img src="images/汉服0.jpg" width="1180" height="500" alt=""/> </section>
  <!-- About Section -->
  <section class="about" id="about">
    <h2 class="hidden">About</h2>
    <p class="text_column">汉服文化是反映儒家礼典服制的文化总和，贯穿西周到明朝的儒家书史体系《礼记》、《后汉书·舆服下》、《晋书·舆服》、《宋书·礼五》、《南齐书·舆服》、《魏书·礼志四之四第十三》、《隋书·礼仪七》、《旧唐书·舆服》、《新唐书·车服》、《宋史·舆服》、《明史·舆服》，通过祭服、朝服、公服、常服以及配饰体现出来。汉服文化从三皇五帝延续至今（清代被迫中断），通过连绵不断的继承完善着自己，汉服文化是一个非常成熟并自成体系的千年文化。在当代，汉服文化正在通过汉服运动这一民间文化运动形式逐渐复兴。 </p>
    <p class="text_column">汉服中最典型的深衣，孔氏正义曰：“所以称深衣者，以余服则上衣下裳不相连，此深衣衣裳相连，被体深邃，故谓之深衣。”深衣是最能体现华夏文化精神的服饰。深衣象征天人合一，恢宏大度，公平正直，包容万物的东方美德。袖口宽大，象征天道圆融；领口直角相交，象征地道方正；背后一条直缝贯通上下，象征人道正直；腰系大带，象征权衡；上衣用布四幅，象征一年四季；下裳用布十二幅，象征一年十二月。身穿深衣，自然能体现天道之圆融，怀抱地道之方正，身合人间之正道，行动进退合权衡规矩，生活起居顺应四时之序。 </p>
    <p class="text_column">汉服文化中的正色就是阴阳五行对应的颜色：所谓六象六色，源自阴阳五行说，概指青所以象东方的木，赤所以象南方的火，白所以象西方的金，黑所以象北方的水，玄所以象天，黄所以象地。此「六象六色」分别取其直线相对的方位为「次」，每两色成一对位，即青(东)与白(西)相对；赤(南)与黑(北)相对；玄(天)与黄(地)相对。 而汉服的配色是如《礼记·玉藻》云：“衣正色，裳间色。” </p>
  </section>
  <!-- Stats Gallery Section -->
  <!-- Parallax Section -->
  <!-- More Info Section -->
  <footer>
<article class="footer_column"> </article>
<article class="footer_column">
      <h3>祭天的冕服 </h3>
      <img src="images/汉服7.jpg" alt="" width="400" height="200" class="cards"/>
      <p>冕服产生于西周时期，随着周礼的一次次复兴，处于汉朝至明朝的汉服体系中的核心。冕服的千年延续是对汉文化的坚守。周代冕服种类有大裘冕、衮冕、惊冕、毳冕、希冕[絺冕]、玄冕等六冕，按照不同场合需要加以穿用。六冕在汉以后历代王朝的复礼思潮中,有时或以别的称谓形式出现。六冕中，历代主要采用的是衮冕一种。 </p>
      <p>&nbsp;</p>
<div id="picture">
  <p>&nbsp;</p>
      <img id="cloth1" src="images/汉服2.jpg" width="400" height="260" alt=""/>
			</div>
    </article>
<div>
  <p><img src="images/汉服5.jpg" alt="" width="400" height="200"></p>
  <p><br>
  </p>
<p>&nbsp;</p>
  <img src="images/汉服3.jpg" width="400" height="200" >
  <p>&nbsp;</p>
<p><br>
</p>
  <img src="images/汉服6.jpg" alt="" width="400" height="200"></div>
  </footer>
  
  <div class="divmid">
    <div class="comment-mid">
      
        <fieldset>
          <legend>我们期待您的发言：</legend>
          <p><textarea id="opinion1" name="opinion1" cols="150" rows="5" title="comments"></textarea></p>
          <p><input type="text" name="username" id="username" placeholder="请输入您的名字">&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="Rrefresh()">发表</button></p>
        </fieldset>
    </div>
    <div class="comment-mid">
    <fieldset>
          <legend>精彩留言：</legend>
          <div id="mydiv">
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
          </div>
        </fieldset>
    
  
    </div>
  </div>
  
  
  <!-- Footer Section -->
  <section class="footer_banner" id="contact">
    <h2 class="hidden">Footer Banner Section </h2>
    <p class="hero_header">“汉服”体现出穿着者的宽大、随和以及包容四海的气度 </p>
    <div class="button"> 汉服文化</div>
  </section>
  <!-- Copyrights Section -->
  <div class="copyright">&copy;SCU2019.11</div>
</div>
<!-- Main Container Ends -->
</body>
</html>
