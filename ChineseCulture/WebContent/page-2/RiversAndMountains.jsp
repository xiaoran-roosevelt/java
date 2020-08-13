<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>万里河山</title>
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
		        url:"MessageRefresh4.jsp",//请求地址
		        data:{"opinion1":opinion1,"username":username},//
		        error:function(){
		           alert("登陆出错！");
		        },
		        success:function(data){ //返回成功执行回调函数。
		        	$("#mydiv").load("help4.jsp");
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
    <h4 class="logo"> 万里河山</h4>
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
    <h2 class="hidden">About</h2>
    <img src="images/河山5.jpg" width="1130" height="550" alt="" >
    <p id="mianfont">大好河山孕育了丰富璀璨的文化，唐宋诗人大都有走遍四方，阅尽河山的理想，将情感寄托于山水之间是中华文化特有的表达意境。耳熟能详的大诗人李白在游历中诞生了一片片佳作，徐霞客更是将游览经历写成游记。以徐霞客为例，徐霞客的出游大至分为两个时期：前期北登恒山，南及闽粤，东涉普陀，西攀太华之岭，偏重搜奇访胜，写下了天台山、雁荡山、黄山、庐山、嵩山、华山、五台山、恒山等名山游记十七篇；后期的西南地区之行，则在探寻山川源流、风土文物的同时，重点考察和记述喀斯特（石灰岩）地貌的分布及其发育规律。《徐霞客游记》的史料价值，涵盖层面甚广。徐霞客对于山水地理方面的贡献，除了对山形地貌的观察外，对于水文分布、江源探寻以及山水与气候关系的体验，也有翔实的记录。徐霞客对于当时政治情势的观察也很深入，他游历各地看到整体政治风气的败坏、藩镇的巧取豪夺、土司制度的紊乱、人民生活的困顿以及边关军事防卫的松弛，都显示出晚明政治的腐败现象。他的游记登录许多书院、古迹、碑碣、辞匾以及少数民族的特殊文化等等，对于文化古迹方面的记录保存，发挥很大的作用。另外，徐霞客对于各地的宗教信仰、道观寺庙也多有记载，为儒、释、道各种宗教在各地的传布情形，留下了历史的轨迹。由这些丰富的内容来看，这部游记能在历史上留名，被认为是晚明时期一部跨越文学与科学的著作，确实有其道理。 [5] </p>
<br>
<p class="text_column">&nbsp;</p>
</section>
<!-- Stats Gallery Section -->
  <!-- Parallax Section -->
  <!-- More Info Section -->
  <footer>
    <article class="footer_column">
      <h3>甘肃敦煌 玉门关遗址</h3>
<img src="images/河山7.jpg" alt="" width="400" height="200" class="cards"/>
<p>黄河远上白云间，一片孤城万仞山。羌笛何须怨杨柳，春风不度玉门关。——唐/王之涣《凉州词二首·其一》 </p>
<p>&nbsp;</p>
<hr>
      <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</p>
      <h3> 大唐芙蓉园 </h3>
      <img src="images/河山9.jpg" width="500" height="380" alt=""/>
      <p>&nbsp;</p>
    </article>
    <article class="footer_column">
      <h3>山西、陕西 壶口瀑布</h3>
      <img src="images/河山8.jpg" alt="" width="400" height="200" class="cards"/>
      <p>君不见，黄河之水天上来，奔流到海不复回。君不见，高堂明镜悲白发，朝如青丝暮成雪。人生得意须尽欢，莫使金樽空对月。天生我材必有用，千金散尽还复来。烹羊宰牛且为乐，会须一饮三百杯。岑夫子，丹丘生，将进酒，杯莫停。与君歌一曲，请君为我倾耳听。钟鼓馔玉不足贵，但愿长醉不复醒。古来圣贤皆寂寞，惟有饮者留其名。陈王昔时宴平乐，斗酒十千恣欢谑。主人何为言少钱，径须沽取对君酌。五花马，千金裘，呼儿将出换美酒，与尔同销万古愁。——唐/李白《将进酒》 </p>
      <p>&nbsp;</p>
      <hr>
      <p>&nbsp;</p>
<p>芙蓉秦地沼，卢橘汉家园。谷转斜盘径，川回曲抱原。风来花自舞，春入鸟能言。侍宴瑶池夕，归途笳吹繁。——唐/宋之问《春日芙蓉园侍宴应制》</p>
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
    <p class="hero_header">阅尽天下美景，赏文化盛宴</p>
    <div class="button"> 万里河山</div>
  </section>
  <!-- Copyrights Section -->
  <div class="copyright">
    <p> 2019.11.@scu</p>
  </div>
</div>
<!-- Main Container Ends -->
</body>
</html>
