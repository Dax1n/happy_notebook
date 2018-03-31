### MYSQL高级学习笔记

##### MYSQL的架构介绍

- 前身  

			MYSQL是由瑞典MYSQL AB公司开发，目前归属Oracle。
- SQL特点  
			
			易学难精，写出一条高效简洁的SQL还是比较困难的。

- 高级MYSQL
			
			MYSQL内核，大公司内部自行会优化MYSQL内核
			SQL优化
			MYSQL参数优化
			MYSQL主从复制
			软硬件升级
			容灾备份
			SQL编程

- 设置mysql开机启动
		
		chkconfig mysqld on		
		chkconfig --list |grep mysql 


- 解决中文乱码修改配置文件,client表示客户端，mysqld表示服务端
		
		/etc.my.cnf
			
			[client]
			default-character-set=utf8

			[mysqld]
			collation_server=utf8_general_ci
			character_set_server=utf8
			character_set_client=utf8
			
注意：如果修改完编码之后依旧不生效，原因可能是由于数据库在编码之前创建的，所以需要修改数据库编码。

- MYSQL架构图

架构优点：插拔式的存储架构将查询和其他系统的任务进行分离。	

![MYSQL架构图.png](./pic/MYSQL架构图.png)	

架构分层：连接层，服务层，引擎层，存储层


- MYSQL存储引擎

![MYSQL存储引擎.png](./pic/MYSQL存储引擎.png)	  


![当前数据库使用的存储引擎.png](./pic/当前数据库使用的存储引擎.png)	  

mysam与innodb引擎区别：

![MYSAM与InnoDb引擎却别.png](./pic/MYSAM与InnoDb引擎却别.png)	  

MySam比Innbo性能好的原因是MySam没有事务



##### MYSQL索引优化分析

- 数据库性能差，SQL变慢，执行时间长，等待时间长  
导致原因：SQL写的烂，索引失效，关联查询太多，服务器参数设置不合理(缓冲区与线程数等)

- 创建索引语句

单值索引：
![mysql创建索引语句.png](./pic/mysql创建索引语句.png)	 

多值索引：

		create index index_user_id_name on user(id,name)

- SQL解析过程：

![SQL解析过程.png](./pic/SQL解析过程.png)	  


- SQL的join写法以及区别  

![SQL的join写法.png](./pic/SQL的join写法.png)	

- 索引简介  

当面试提及索引时候切勿拿书的目录做类似，忌讳。  

索引的定义：索引是帮助数据库高效获取数据的数据结构。(核心：索引是一种数据结构)  

索引用于：记录排序与提高查找效率  

提否提高查找效率：主要是看where条件是否使用了索引。

索引会影响where条件以及排序order by。

互联网公司一般数据删除都是逻辑删除，而不是真实删除，这么做好处：1：为了数据分析，2：为了索引，因为真实删除数据会导致索引频繁更新。

频繁删改的字段不适合创建索引，因为字段变动会导致索引变动。

索引的优劣：  
  ![索引优劣.png](./pic/索引优劣.png)	
	

索引的分类：  
  ![索引分类.png](./pic/索引分类.png)	

查看已知表上的索引：  
  ![查看已知表上的索引.png](./pic/查看已知表上的索引.png)	







性能分析

索引优化


##### MYSQL查询截取分析

查询优化

慢查询日志

批量数据脚本

show profile

全局查询日志



##### MYSQL主从复制



##### MYSQL的锁机制

行锁


表锁


页锁