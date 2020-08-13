<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>歌舞文化</title>
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
		        url:"MessageRefresh5.jsp",//请求地址
		        data:{"opinion1":opinion1,"username":username},//
		        error:function(){
		           alert("登陆出错！");
		        },
		        success:function(data){ //返回成功执行回调函数。
		        	$("#mydiv").load("help5.jsp");
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
    <h4 class="logo">歌舞文化</h4>
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
  <!-- About Section -->
  <section class="about" id="about">
    <h1> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 中国古代舞蹈 </h1>
    <h2 class="hidden">About</h2>
    <p class="text_column">从原始社会到封建社会时期的中国舞蹈，统称为中国古代舞蹈。在漫长的历史进程中，它经历了若干阶段的发展、演变，逐渐形成具有中国独特形态和神韵的东方舞蹈艺术。</p>
    <p class="text_column"> [1] 舞蹈，是通过有节奏的、经过提炼和组织的人体动作和造型，来表达一定的思想感情的艺术。正如闻一多在《说舞》中所言：舞是生命情调最直接、最实质、最烈、最尖锐、最单纯而又最充足的表现。舞蹈总是与人类最热烈的感情联系在一起的。&nbsp;</p>
    <p class="text_column">古代代表歌舞：《霓裳羽衣舞》《踏谣娘》《剑舞》《采莲》《拓枝》《天魔舞》《白纻舞》 《大垂手》《明君》《巴渝舞》《公莫舞》《铎舞》《鞞舞》《太平乐》《破阵舞》《庆善舞》</p>
  </section>
  <!-- Stats Gallery Section -->
  <!-- Parallax Section -->

  <section class="banner">
    <h3>&nbsp;</h3>
    <h3> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;电影中歌舞片段欣赏</h3>
    <video id="video_dance" width="1000" height="370" controls>
  <source src="video/歌舞.mp4" type="video/mp4">
</video>
    <h2 class="parallax">&nbsp;</h2>
</section>
  <!-- More Info Section -->
  <footer>
    <article class="footer_column">
      <h3>七盘舞</h3>
      <img src="images/歌舞2.jpg" alt="" width="400" height="200" class="cards"/>
      <p>七盘舞又称盘舞、盘鼓舞。是一种古代的汉族舞蹈。在汉代，舞时将盘、鼓覆置于地上。盘、鼓数目不等，按表演者技艺高低而定。舞者有男有女，在盘、鼓上高纵轻蹑，浮腾累跪，踏舞出有节奏的音响。 汉画像砖石有十分丰富的《盘鼓舞》形象，或飞舞长袖，或踩鼓下腰，或按鼓倒立，或身俯鼓面，手、膝、足皆触及鼓面拍击，或单腿立鼓上，或正从鼓上纵身跳下。舞姿各异，优美矫健。 </p>
    </article>
    <article class="footer_column">
      <h3>长袖舞</h3>
      <img src="images/歌舞3.jpg" alt="" width="450" height="200" class="cards"/>
      <p>长袖舞长袖舞在秦代以前已经存在，曾是战国楚国宫廷的风尚，汉人继承楚人艺术，长袖舞更为盛行。。汉人傅毅在《舞赋》中形容长袖细腰的舞女为体如游龙，袖如素虞.戚夫人的翘袖折腰之舞正是这种舞姿的体现。迄今所获的汉代舞蹈资料说明 长袖舞 实际包括了许多不同的舞蹈，许多种舞蹈都以舞袖为特征。舞人有男有女，有单人舞、双人对舞和多人群舞，以单人独舞为主。分为婉约和奔放两个风格。</p>
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
    
    <div class="button"> 中国歌舞</div>
  </section>
  <!-- Copyrights Section -->
  <div class="copyright">&copy;SCU2019.11</div>
</div>
<!-- Main Container Ends -->
</body>
</html>
