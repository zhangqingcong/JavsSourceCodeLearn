package cn.itcast.orm.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 该类用来封装存储映射信息
 * 封装从映射文件Xxx.mapper -->通过Dom4jUtil.class解析
 * 封装实体类中注解信息 -->通过Annotation.class解析
 */

public class Mapper {
    /**
     *这里类名称和表名用单独的 是应为一个类对应一个表
     * 这里要是看不懂了 就去看getPropertyValue（）方法就明白了
     * 意思就是Book.mapper.xml对应数据库中的tb_book表
     * Book.java类 加注释 对应数据库中的tb_book表
     * 解析出来的有表名 类名 属性包括主键 所以这里要存放解析出来的
     */

    //Book.mapper.xml文件里面只有一个<class>标签 只有一个类名
    private String className;//类名

    //Book.mapper.xml文件里面只有一个<class>标签 只有一个表名
    private String tableName;//表名

    //表里可能有多个属性和字段对应
    private Map<String, String> idMapper = new HashMap<>();//主键信息

    //Book.mapper.xml文件有多个<property>标签
    private Map<String, String> propertyMapper = new HashMap<>();//普通的属性和字段信息

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, String> getIdMapper() {
        return idMapper;
    }

    public void setIdMapper(Map<String, String> idMapper) {
        this.idMapper = idMapper;
    }

    public Map<String, String> getPropertyMapper() {
        return propertyMapper;
    }

    public void setPropertyMapper(Map<String, String> propertyMapper) {
        this.propertyMapper = propertyMapper;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "className='" + className + '\'' +
                ", tableName='" + tableName + '\'' +
                ", idMapper=" + idMapper +
                ", propertyMapper=" + propertyMapper +
                '}';
    }
}