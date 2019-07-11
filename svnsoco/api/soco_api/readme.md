#1 此项目所有针对socots01数据库的操作增删查改都统一放到此处维护,避免以前维护多个。plat,site，soco_provider
#2 此项目在此处，尽量做到简单，尽量不参与复杂业务。控制事务
#3 模块目前划分几块 
	3.1 车相关  2.用户相关 3.后台管理平台相关 4.基础数据 
#4 目前支持多数据源，但是只使用单数据库都是指向master数据库，根据以后业务进行扩展
#5 所有针对mybatis sqlmapper的操作。请不要在原始mapper文件中修改，如需修改请新增一个新的mapper.xml命名为mapper_ext.xml

#6 上传SOCO_API当前目录包命令，因本地没有搭建私服所以导致无法直接上传，故用次命令直接安装至本地再引用即可
mvn install:install-file -Dfile=target\soco_api-client-1.0-SNAPSHOT.jar -DgroupId=com.soco.car -DartifactId=soco_api-client -Dversion=1.0-SNAPSHOT -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true