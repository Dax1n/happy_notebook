### maven学习笔记

##### mvn常用命令

		mvn install -Dmaven.test.skip=true (-DskipTests=true) //跳过测试编译并安装本地仓库
		mvn source:jar //安装源码到本地仓库
		mvn javadoc:jar //安装javadoc到本地仓库
		mvn dependency:sources // 下载依赖源码
		
		
		

		
		
		
mvn deploy:deploy-file -DgroupId=com.jd.galaxy -DartifactId=hdfs-service -Dversion=0.1.0-SNAPSHOT -Dpackaging=jar -Dfile=./target/hdfs-service-0.1.0-SNAPSHOT.jar -Durl=http://artifactory.jd.com/libs-snapshots-local/ -DrepositoryId=snapshots