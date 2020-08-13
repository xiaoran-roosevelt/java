<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>钟鼓乐器</title>
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
	        url:"MessageRefresh.jsp",//请求地址
	        data:{"opinion1":opinion1,"username":username},//
	        error:function(){
	           alert("登陆出错！");
	        },
	        success:function(data){ //返回成功执行回调函数。
	        	$("#mydiv").load("help.jsp");
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
    <h4 class="logo"> 钟鼓乐器</h4>
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
  <section class="hero" id="hero"><img src="images/宇宙素材 (322).png" width="1117" height="600" alt=""/>
<h2 class="hero_header">今夜闻君琵琶语，如听仙乐耳暂明 </h2>
</section>
  <!-- About Section -->
  <section class="about" id="about">
    <h2 class="hidden">About</h2>
    <p class="text_column">在古代，流传着很多乐器，尤其以十大乐器为代表的民族乐器，对后世产生了巨大的影响，这些乐器不但与古人的生活密切联系，还是作为个人品德的代表，受到文人雅士的青睐，在历史上留下了深刻的印记。 </p>
    <p class="text_column">琵琶，是一种木制拨弦乐器。琵琶最早在秦朝就已经出现了，距今已有二千多年的历史了。“琵”和“琶”是根据右手弹奏乐器的技法，“琵”为右手向前弹，“琶”为右手向后挑。琵琶表现力丰富、音域宽广、技巧性强，成为古代弹拨乐器之首。 </p>
    <p class="text_column">秦代的琵琶是长柄圆型的，经过改良形成了新型曲柄琵琶。而弹奏方法也发生了改变，由横抱变成了竖抱。琵琶的发展在唐代呈现出一个高峰，不论在宫廷还是民间，琵琶是十分流行的乐器，涌现了以曹保、曹善才、曹纲、裴兴奴、裴神符为代表的琵琶演奏大家。 </p>
  </section>
  <!-- Stats Gallery Section -->
  <!-- Parallax Section -->
  <!-- More Info Section -->
  <footer>
    <article class="footer_column">
      <img src="images/timg (2).jpg" width="400" height="650" alt=""/>
		<br>
		<h3>&nbsp;</h3>
		<h3>笛</h3>
		<img src="images/笛.jpg" alt="" width="400" height="200" class="cards"/>
		<p>中国笛子历史悠久，可以追溯到新石器时代。那时先辈们点燃篝火，架起猎物，围绕捕获的猎物边进食边欢腾歌舞，并且利用飞禽胫骨钻孔吹之（用其声音诱捕猎物和传递信号），也就诞生了出土于我国最古老的乐器——骨笛。 1977年浙江余姚河姆渡出土了骨哨、骨笛，距今约7000年。1986年5月，在河南舞阳县贾湖村东新石器时代早期遗址中发掘出16支竖吹骨笛（用鸟禽肢骨制成），根据测定距今已有8000余年历史。 </p>
    </article>
    <article class="footer_column">
      <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;琵琶行</p>
      <p> &nbsp; 忽闻水上琵琶声，主人忘归客不发。寻声暗问弹者谁，琵琶声停欲语迟。移船相近邀相见，添酒回灯重开宴。千呼万唤始出来，犹抱琵琶半遮面。转轴拨弦三两声，未成曲调先有情。弦弦掩抑声声思，似诉平生不得志。低眉信手续续弹，说尽心中无限事。轻拢慢捻抹复挑，初为《霓裳》后《六幺》。大弦嘈嘈如急雨，小弦切切如私语。嘈嘈切切错杂弹，大珠小珠落玉盘。间关莺语花底滑，幽咽泉流冰下难。冰泉冷涩弦凝绝，凝绝不通声暂歇。别有幽愁暗恨生，此时无声胜有声。银瓶乍破水浆迸，铁骑突出刀枪鸣。曲终收拨当心画，四弦一声如裂帛。东船西舫悄无言，唯见江心秋月白。</p>
      <p> 我闻琵琶已叹息，又闻此语重唧唧。同是天涯沦落人，相逢何必曾相识！我从去年辞帝京，谪居卧病浔阳城。浔阳地僻无音乐，终岁不闻丝竹声。住近湓江地低湿，黄芦苦竹绕宅生。其间旦暮闻何物？杜鹃啼血猿哀鸣。春江花朝秋月夜，往往取酒还独倾。岂无山歌与村笛？呕哑嘲哳难为听。今夜闻君琵琶语，如听仙乐耳暂明。莫辞更坐弹一曲，为君翻作《琵琶行》。感我此言良久立，却坐促弦弦转急。凄凄不似向前声，满座重闻皆掩泣。座中泣下谁最多？江州司马青衫湿。</p>
      <h3>&nbsp;</h3>
      <h3>琴瑟</h3>
      <img src="images//se.jpg" alt="" width="400" height="200" class="cards"/>
      <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 锦瑟&nbsp; &nbsp; &nbsp; &nbsp; </p>
      <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;——李商隐 </p>
      <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 锦瑟无端五十弦，一弦一柱思华年。</p>
      <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;庄生晓梦迷蝴蝶，望帝春心托杜鹃。</p>
      <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 沧海月明珠有泪，蓝田日暖玉生烟。</p>
      <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 此情可待成追忆，只是当时已惘然。</p>
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
    <p class="hero_header">善哉！洋洋兮若江河 ！</p>
    <div class="button"> 钟鼓乐器</div>
  </section>
  <!-- Copyrights Section -->
</div>
<!-- Main Container Ends -->
</body>
</html>
