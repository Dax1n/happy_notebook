## nginx学习笔记(1)
#### nginx安装
- nginx官网下载二进制包进行解压，然后进行./configure检查，会提示缺少pcre类库，此时可以安装该类库：yum install -y pcre pcre-devel;(devel表示开发的意思，一般是头文件的二进制文件)。同理还需安装：yum install -y zlib zlib-devel；此时
再次进行configure可以通过，最后分别进行make 与 make install(make 是编译过程，make install是进行安装)

-  nginx 安装目录:

	drwxrwxr-x. 2 daxin daxin 4096 Mar  9 17:50 conf // 配置目录
	drwxr-xr-x. 2 daxin daxin 4096 Mar  9 17:50 html // 存放静态页面的目录
	drwxrwxr-x. 2 daxin daxin 4096 Mar  9 17:51 logs // 日志目录
	drwxrwxr-x. 2 daxin daxin 4096 Mar  9 17:50 sbin // 启动脚本目录

- 启动：由于linux系统的1024以下端口只有root账户可以使用，因此切换root账户进行启动 sbin/nginx,然后浏览器访问即可显示页面如下：  
	![nginx启动.png](./pic/nginx启动.png)  	
	
#### nginx信号使用
- nginx信号： 官方说明：https://www.nginx.com/resources/wiki/start/topics/tutorials/commandline/; nginx关闭可以使用信号，信号发送格式： kill  -singal masterPid ,因此我们需要查看nginx的masterPid：

	[root@node sbin]# ps -ef |grep "nginx"
	root      26260      1  0 18:01 ?        00:00:00 nginx: master process ./nginx
	nobody    26261  26260  0 18:01 ?        00:00:00 nginx: worker process
	root      26343  26232  2 18:12 pts/1    00:00:00 grep nginx

启动master是主进程，worker是子进程，master衍生出子进程，master负责管理子进程，子进程服务接受请求。(另外一种关闭方式是nginx -s stop)

- nginx的信号量有如下：

	TREM,INT：快速关闭，一般不要这么用，尤其是线上部署的nginx
	QUIT：是优雅的关闭nginx，这个推荐
	HUP： 该信号量会读取新的配置文件然后启动新的worker，一些使用旧的配置的worker将会逐渐被关闭，这个可以被平滑的进行修改配置(此处需要配置nginx.conf中的 user 为root 否则权限不允许加载index文件)
	USR1：运维使用，配置日志。当对日志进行备份时候，我们可以mv src.log src.log.back 然后删除src.log但是此时依旧还在往src.log.back中写，所以为了让nginx不再向src.log.back中写，  
		  需要我们通知nginx向新的日志文件中写。例如：我们将access.log => access.log.back 然后 kill -USR1 pid即可切换日志。
	USR2：平滑升级，对nginx的平滑升级，例如nginx版本由1.4.升级到1.5版本，此时就可以使用USR2，将新版本覆盖旧版本然后kill -USR2 pid 然后会平滑升级
	WINCH：用于优雅的关闭旧的进程（通常是配合USR2使用）
	
- *小技巧：由于nginx的操作每一次都需要查找nginx的进程号，为了方便查找进程号可以如下方式：nginx运行时会将pid号存储到nginx/logs目录下的nginx.pid文件中，因此我们可以通过读取该文件获取进程号, kill -QUIT `cat logs/nginx.pid`*

- nginx脚本操作：nginx脚本同样可以完成信号的一些功能，例如 可以使用nginx -t 测试你的配置文件是否正确，其余此处不再列举。
	
	
#### nginx虚拟主机配置
- 基于IP的虚拟主机的管理配置：  
当浏览器请求node:80时候(可以不写端口，默认80),时候回将nginx/node目录下的node.html返回 ,具体配置如下： 

		server{
		# 监听端口
		listen		80;
		# 监听域名，会根据请求的域名进行匹配
		server_name node;
		
		location / {
			# 可以写相对路径，相对于nginx的根目录
			root node;
			index node.html;
		}
	}

根据ip地址请求返回ip目录下的ip.html：(nginx应该是根据http header中host进行解析然后转发请求)

		server{
		# 监听端口
		listen		80;
		# 监听域名，会根据请求的域名进行匹配
		server_name 192.168.53.131;
		
		location / {
			# 可以写相对路径，相对于nginx的根目录
			root ip;
			index ip.html;
		}
	}

- 基于端口的虚拟主机的管理配置：  当浏览器node:81时候回返回node81目录下的node81.html

		server{
		# 监听端口
		listen		81;
		# 监听域名，会根据请求的域名进行匹配
		server_name node;
		
		location / {
			# 可以写相对路径，相对于nginx的根目录
			root node81;
			index node81.html;
		}
	}













