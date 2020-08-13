<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>水墨丹青</title>
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
	}else {
		
		$.ajax({
	        type:"post",//请求方式 
	        url:"MessageRefresh2.jsp",//请求地址
	        data:{"opinion1":opinion1,"username":username},//
	        error:function(){
	           alert("登陆出错！");
	        },
	        success:function(data){ //返回成功执行回调函数。
	        	$("#mydiv").load("help2.jsp");
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
    <h4 class="logo">水墨丹青</h4>
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
  <section class="hero" id="hero"><img src="images/宇宙素材 (26).png" width="1177" height="535" alt=""/>  </section>
  <!-- About Section -->
  <section class="about" id="about">
    <h2 class="hidden">About</h2>
    <p class="text_column"> 国画一词起源于汉代，汉朝人认为中国是居天地之中者，所以称为中国，将中国的绘画称为“中国画”，简称“国画”。主要指的是画在绢、宣纸、帛上并加以装裱的卷轴画。国画是中国的传统绘画形式，是用毛笔蘸水、墨、彩作画于绢或纸上。</p>
    <p class="text_column">中国画起源古 侯子墓帛画(西汉) 侯子墓帛画(西汉) 代，象形字，奠基础；文与画在当初，无歧异，本是一个意思。我国夙有书画同源之说，有人认为伏羲画卦、仓颉造字，是为书画之先河。文字与画图初无歧异之分。. </p>
    <p class="text_column">中国画历史悠久，远在2000多年前的战国时期就出现了画在丝织品上的绘画——帛画，这之前又有原始岩画和彩陶画。春秋战国最为著名的有《御龙图》帛画。它是在丝织品上绘画。这些早期绘画奠定了后世中国画以线为主要造型手段的基础。 </p>
  </section>
  <!-- Stats Gallery Section -->
  <!-- Parallax Section -->
  <section class="banner"><img id="end1" src="images/宇宙素材 (602).png" width="1117" height="400" alt=""/><strong></strong>  </section>
  <!-- More Info Section -->
  <footer>
    <article class="footer_column">
      <h3>清明上河图(张泽瑞）</h3>
      <img src="images/timg.jpg" alt="" width="400" height="200" class="cards"/>
      <p>清明上河图，中国十大传世名画之一。为北宋风俗画，北宋画家张择端仅见的存世精品，属国宝级文物，现藏于北京故宫博物院。 清明上河图宽24.8厘米、长528.7厘米 [1] ，绢本设色。作品以长卷形式，采用散点透视构图法，生动记录了中国十二世纪北宋都城东京（又称汴京，今河南开封）的城市面貌和当时社会各阶层人民的生活状况，是北宋时期都城汴京当年繁荣的见证，也是北宋城市经济情况的写照。 </p>
    </article>
    <article class="footer_column">
      <h3>清明上河图（清院本）</h3>
      <img src="images/7a899e510fb30f24bba73712c895d143ad4b03e6.jpg" alt="" width="400" height="250" class="cards"/>
      <p>乾隆元年(1736年)由清宫画院五位画家陈枚、孙祜、金昆、戴洪、程志道合作画成，可以说是按照各朝的仿本，集各家所长之作品，再加上明清时代特殊风俗，如踏青、表演 等等娱乐活动，因此增加了许多丰富的情节，如戏剧、猴戏、特技、擂台等等，画的事物繁多，虽然失去了宋代古制，却是研究明清之际社会风俗不可缺的材料。 </p>
    </article>
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
    <p class="hero_header"> 雕刻在石碑上的印记 是否隐藏着秘密 在你的眼神中 我看到了情丝万缕 </p>
    <div class="button"> 中国画</div>
  </section>
  <!-- Copyrights Section -->
<!-- Main Container Ends -->
</body>
</html>
