### Java SecurityManager学习笔记

- 预备知识

			Java是一门安全性很高的语言，因此也会考虑到用户代码对整个系统的侵入性。试想一下，如果你引用了一个jar包，  
			里面包含了依据system.exit()，每次执行到这里都直接退出，会不会很蛋疼！Java开发者肯定想过如此的问题，  
			所以引入了java安全策略机制，利用一个配置文件来管理所有的代码权限。JDK中就有这样的文件，   
			就是  C:\Program Files\Java\jdk1.8.0_111\jre\lib\security\java.policy ，参考下该文件,就能理解其中的关系：  
			
- java.policy的配置文件内容：

			// default permissions granted to all domains
			grant {
		        // Allows any thread to stop itself using the java.lang.Thread.stop()
		        // method that takes no argument.
		        // Note that this permission is granted by default only to remain
		        // backwards compatible.
		        // It is strongly recommended that you either remove this permission
		        // from this policy file or further restrict it to code sources
		        // that you specify, because Thread.stop() is potentially unsafe.
		        // See the API specification of java.lang.Thread.stop() for more
		        // information.
		        permission java.lang.RuntimePermission "stopThread";
		
		        // allows anyone to listen on dynamic ports
		        permission java.net.SocketPermission "localhost:0", "listen";
		
		        // "standard" properies that can be read by anyone
		
		        permission java.util.PropertyPermission "java.version", "read";
		        permission java.util.PropertyPermission "java.vendor", "read";
		        permission java.util.PropertyPermission "java.vendor.url", "read";
		        permission java.util.PropertyPermission "java.class.version", "read";
		        permission java.util.PropertyPermission "os.name", "read";
		        permission java.util.PropertyPermission "os.version", "read";
		        permission java.util.PropertyPermission "os.arch", "read";
		        permission java.util.PropertyPermission "file.separator", "read";
		        permission java.util.PropertyPermission "path.separator", "read";
		        permission java.util.PropertyPermission "line.separator", "read";
		
		        permission java.util.PropertyPermission "java.specification.version", "read";
		        permission java.util.PropertyPermission "java.specification.vendor", "read";
		        permission java.util.PropertyPermission "java.specification.name", "read";
		
		        permission java.util.PropertyPermission "java.vm.specification.version", "read";
		        permission java.util.PropertyPermission "java.vm.specification.vendor", "read";
		        permission java.util.PropertyPermission "java.vm.specification.name", "read";
		        permission java.util.PropertyPermission "java.vm.version", "read";
		        permission java.util.PropertyPermission "java.vm.vendor", "read";
		        permission java.util.PropertyPermission "java.vm.name", "read";
			};

			
- 启动SecurityManager，默认是不开启的，两种启动方式：


启动程序的时候通过附加JVM参数启动安全管理器：

		-Djava.security.manager
若要同时指定配置文件的位置那么示例如下：

		-Djava.security.manager -Djava.security.policy="E:/java.policy"

也可以通过编码方式启动，不过不建议：

		System.setSecurityManager(new SecurityManager());


- 设置启动SecurityManager，同时检查是否允许监听8080端口：

	     System.setSecurityManager(new SecurityManager());
	     SecurityManager securityManager = System.getSecurityManager();
	     securityManager.checkListen(8080);


默认上面是会抛出异常不允许监听8080，但是可以通过配置java.policy文件允许监听，配合如下：

		permission java.net.SocketPermission "localhost:8080", "listen";

也可以开放所有权限：
		
		grant { 
    		permission java.security.AllPermission;
		};
如果权限全允许的话根不开安全管理器是一样的，所以没有必要，Java SecurityManager只可以配置允许什么权限，无法配置禁止什么权限，更多配置可以参考文档。