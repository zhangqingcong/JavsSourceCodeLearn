package cn.itcast.orm.utils;


import cn.itcast.orm.annotation.ORMColumn;
import cn.itcast.orm.annotation.ORMId;
import cn.itcast.orm.annotation.ORMTable;

import javax.lang.model.element.NestingKind;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnnotationUtil {
    /**
     * 得到类名
     *
     * @param clz
     * @return
     */
    public static String getClassName(Class clz) {
        return clz.getName();
    }

    /**
     * 得到ORMTable注解中的表名
     *
     * @param clz
     * @return
     */
    public static String getTableName(Class clz) {
        //java.lang.Class类的isAnnotationPresent()方法用于检查此类中是否存在指定注释类型的注释。该方法返回一个声明相同的布尔值。
        if (clz.isAnnotationPresent(ORMTable.class)) {
            ORMTable ormTable = (ORMTable) clz.getAnnotation(ORMTable.class);
            System.out.println(ormTable);
            return ormTable.name();
        } else {
            System.out.println("缺少ORMTable");
            return null;
        }
    }

    /**
     * 得到主键属性翮对应的字段
     *
     * @param clz
     * @return
     */
    public static Map<String, String> getIdMapper(Class clz) {
        boolean flag = true;
        Map<String, String> map = new HashMap<>();
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ORMId.class)) {
                flag = false;
                String fieldName = field.getName();
                if (field.isAnnotationPresent(ORMColumn.class)) {
                    ORMColumn ormColumn = field.getAnnotation(ORMColumn.class);
                    String columnName = ormColumn.name();
                    map.put(fieldName, columnName);
                    break;
                } else {
                    System.out.println("缺少ORMColumn注解");
                }
            }
        }
        if (flag) {
            System.out.println("缺少ORMId注解");
        }
        return map;
    }

    /**
     * 得到类中所有属性翮对应的字段
     *
     * @param clz
     * @return
     */
    public static Map<String, String> getPropertyMapping(Class clz) {
        //先声名一个map集合存放Java对象类中的属性和数据库字段的映射
        Map<String, String> map = new HashMap<>();
        //调用已经写好的获得ID属性映射存放到map中
        map.putAll(getIdMapper(clz));
        //通过反射得到所有的属性field
        Field[] fields = clz.getDeclaredFields();
        //遍历属性
        for (Field field : fields) {
            //判断当前属性是不是@ORMColumn注解修饰的属性
            if (field.isAnnotationPresent(ORMColumn.class)) {
                //得到该注解对象
                ORMColumn ormColumn = field.getAnnotation(ORMColumn.class);
                //得到属性名
                String fieldName = field.getName();
                //得到ORMColumn里面的属性
                String columnName = ormColumn.name();
                map.put(fieldName, columnName);
            }
        }
        return map;
    }

    /**
     * 获得某包下面的所有类名
     *
     * @param packagePath
     * @return
     */
//    public static Set<String> getClassNameByPackage(String packagePath) {
//        //用set存是应为类名不重复
//        Set<String> names = new HashSet<>();
//        //把路径名称里面的 . 换成 /
//        String packageFile = packagePath.replace(".", "/");
//        //获得classpath路径
//        String classpath = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
//        System.out.println(classpath);
//        if (classpath == null) {
//            classpath = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
//        }
//        try {
//            //为了避免路径中有中文 做了转码处理
//            classpath = URLDecoder.decode(classpath, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        //classpath+包路径组成完整的包路径
//        File dir = new File(classpath + packageFile);
//        if (dir.exists()) {
//            //获得包下面的所有文件
//            File[] files = dir.listFiles();
//            for (File file : files) {
//                String name = file.getName();
//                //路径下可能还有其他不是包文件的配置文件 必须是文件且以.class结尾的才是包
//                if (file.isFile() && name.endsWith(".class")) {
//                    name = packageFile + "." + name.substring(0, name.lastIndexOf("."));
//                    names.add(name);
//                }
//            }
//        } else {
//            System.out.println("包路径不存在");
//        }
//        return names;
//    }


}
