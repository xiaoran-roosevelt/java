这是一个javaweb项目
使用windows10+eclipse开发，用到了JavaScript，html，css以及jsp，有后端，用到了数据库，第一次开发后端，比较粗糙。
项目可以直接在eclipse里面运行，也可以打包成.war文件，放置在tomcat上运行，如果不对源代码里面数据库有关的代码进行修改，后端是没法用的。而且需要保证有数据库，以及jdk。
效果请访问网站：
http://175.24.86.6:8080/ChineseCulture/
本网站打开可能比较慢（前端设计有问题，但是没找到原因，这个项目本身也比较大有133mb，可能里面有很多冗杂的东西）


上传的时候出现了：warning: LF will be replaced by CRLF in

原因是存在符号转义问题

windows中的换行符为 CRLF， 而在linux下的换行符为LF，所以在执行add . 时出现提示

后面通过 git config --global core.autocrlf false 解决了。
那么clone的时候应该没问题了吧