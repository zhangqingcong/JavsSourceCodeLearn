package cn.itcast.orm.core;

import cn.itcast.orm.utils.AnnotationUtil;
import cn.itcast.orm.utils.Dom4jUtil;
import org.dom4j.Document;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//该类用来解析并封装框架的核心配置文件中数据-->使用Dom4jUtil类解析
public class ORMConfig {
    //编写代码的时候放在resource路径下 编译以后的.class文件放在classpath路径下
    private static String classpath;
    private static File cfgFile;//从classpath路径下拿到核心配置文件
    private static Map<String,String> propertyConfig;// <property>标签中的数据 所以有多少标签 就要有几个map
    private static Set<String> mappingSet;//存放解析出来的映射配置文件路径
    private static Set<String> entitySet;//存放解析出来的实体类
    public static List<Mapper> mapperList;//存解析出来的映射信息

    static {
        // "/"代表就是classpath根路径
       classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        try {
            URLDecoder.decode(classpath,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //得到核心配置文件
       cfgFile= new File(classpath+"miniORM.cfg.xml");
       if (cfgFile.exists()){
           //解析核心配置文件中的数据
           Document document = Dom4jUtil.getXMLByFilePath(cfgFile.getPath());
           propertyConfig = Dom4jUtil.Element2Map(document, "property", "name");
           mappingSet = Dom4jUtil.Element2Set(document,"mapping","resource");
           entitySet = Dom4jUtil.Element2Set(document,"entity","package");
       }else {
           cfgFile = null;
           System.out.println("未找到核心配置文件miniORM.cfg.xml");
       }
    }

    //从propertyConfig集合中获取数据并链接数据库
    private Connection getConnection() throws Exception {
        String url = propertyConfig.get("connection.url");
        String driverClass = propertyConfig.get("connection.driverClass");
        String username = propertyConfig.get("connection.username");
        String password = propertyConfig.get("connection.password");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(true);
        return connection;
    }

    //解析类名和表名、属性名和字段名的映射信息 解析出来的数据用mapperList存
    private void getMapping(){
        mapperList = new ArrayList<>();
        //可能通过两种方式来配置映射信息

        //1.通过xxx.mapper.xml文件配置 那就解析xml文件
        //这个mappingSet里面存的就是xxx.mapper.xml存放的位置 路径名称
        //逐个遍历循环取出xmlPath路径
        for (String xmlPath : mappingSet) {
            //生成document对象
            Document document = Dom4jUtil.getXMLByFilePath(classpath + xmlPath);
            String className = Dom4jUtil.getPropertyValue(document, "class", "name");
            String tableName  = Dom4jUtil.getPropertyValue(document, "class", "table");
            Map<String, String> id_id = Dom4jUtil.ElementID2Map(document);
            Map<String, String> propertyMapping = Dom4jUtil.Element2Map(document);

            Mapper mapper = new Mapper();
            mapper.setClassName(className);
            mapper.setTableName(tableName);
            mapper.setIdMapper(id_id);
            mapper.setPropertyMapper(propertyMapping);

            mapperList.add(mapper);
        }

        //2.通过实体类上的注解配置 解析注解拿到配置信息
        //entitySet存放的是带注解的实体类所在的包，可能有多个
//        for (String packagePath : entitySet) {
//            Set<String> classpathNameSet = AnnotationUtil.getClassNameByPackage(packagePath);
//
//            for (String classpathName : classpathNameSet) {
//                try {
//                    //通过完整的类名获得使用反射方法获得Class对象
//                    Class c = Class.forName(classpathName);
//                    String className = AnnotationUtil.getClassName(c);
//                    String tableName = AnnotationUtil.getTableName(c);
//                    Map<String, String> idMapper = AnnotationUtil.getIdMapper(c);
//                    Map<String, String> propertyMapping = AnnotationUtil.getPropertyMapping(c);
//
//                    Mapper mapper = new Mapper();
//                    mapper.setTableName(tableName);
//                    mapper.setClassName(className);
//                    mapper.setIdMapper(idMapper);
//                    mapper.setPropertyMapper(propertyMapping);
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }

    }

    //创建ORMSession
    public ORMSession buildORMSession(){
        Connection connection =null;
        //1.链接数据库
        try {
            connection = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.得到映射数据
        getMapping();
        //3.创建ORMSession对象
        return new ORMSession(connection);
    }


}
