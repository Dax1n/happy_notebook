### xml学习笔记

- xml可拓展标记语言，作用是用于存储数据(一般用作于配置文件),xml的标准：

		标准：
			区分大小
			有根标签同时可以自定义标签
			标签必须有关闭标签
			标签可以有属性但是属性值必须有引号
			标签内的空格和制表符都会当做数据解析
			特殊字符需要转义
		

- xml组成：

		声明：用于说明该文件是一个xml文件，声明格式：<?xml .......?>，例如：<? version="1.0" encoding = "UTF-8" ?>
		声明要求: xml的声明必须放在第一行而且顶格写，否则报错
		标签要求： <xx></xx>或者<xx/> 而且标签名字不能以xml开始。
		标签名字：标签名字中不能出现空格或者":"等特殊空格
		属性格式：<xx 属性名="属性值"/> 
		CDATA：通过CDATA可以保证数据的原样输出，为了方便转义，例如：<![CDATA[数据]]>



- xml文件解析：
		
		解析方式：
			sax解析：逐行解析，只能查询
			dom解析：一次性将文档加载到内存中形成dom树，然后可以对dom树进行增删改查（不适合解析超大xml）

		解析技术：
			JAXP：sun公司提供的支持DOM与SAX解析开发包
			JDom：dom4j兄弟工具包
			Jsoup：html解析开发包
			dom4j：比较常用的解析开发包，hibernate底层使用
			
			

- dom4j解析步骤(其他个多解析方式自行学习)：

		引入依赖
		创建解析核心对象SAXReader
		将xml加载到内存形成一个树
		获取根节点			
				
			
- xml的dtd约束

		约束原因：约定xml文件中哪些标签是合法标签，以及标签之间的顺序。
		约束分类：
				DTD约束：struts，hibernate中有使用。
				DTD与XML的关联：
					关联方式1：内部关联
						格式：<!DOCTYPE 根元素名 [dtd语法]>
					关联方式2：外部关联-系统关联
						格式：<!DOCTYPE 根元素名 SYSTEM "dtd约束文件的位置">
					关联方式3：外部关联-公共关联
						格式：<!DOCTYPE 根元素名  PUBLIC  "dtd约束文件的名称" "dtd约束文件的位置">
				
				SCHEMA约束：tomcat与spring中有使用
		
		
- dtd语法
		
		元素限制：
			<!Element 元素名称  数据类型|包含内容 >，例如:
					<!ELEMENT web-app (servlet*,servlet-mapping* , welcome-file-list?) >
					<!ELEMENT servlet (servlet-name,description?,(servlet-class|jsp-file))>
					<!ELEMENT servlet-mapping (servlet-name,url-pattern) >
					<!ELEMENT servlet-name (#PCDATA)>
		
		
		
		
		
		
		
			
			