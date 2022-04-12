package cn.itcast.orm.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

/**
 * Document Object Model 文档对象模型
 * 文档对象模型 (DOM) 将 web 页面与到脚本或编程语言连接起来。
 * 通常是指  JavaScript，但将 HTML、SVG 或 XML 文档建模为对象并不是 JavaScript 语言的一部分。
 * DOM模型用一个逻辑树来表示一个文档，树的每个分支的终点都是一个节点(node)，每个节点都包含着对象(objects)。
 * DOM的方法(methods)让你可以用特定方式操作这个树，用这些方法你可以改变文档的结构、样式或者内容。
 * 节点可以关联上事件处理器，一旦某一事件被触发了，那些事件处理器就会被执行。
 * 文档对象模型 (DOM) 是HTML和XML文档的编程接口
 *
 *
 * SAX:simple API for XML
 * JAVA 解析 XML 通常有两种方式:DOM 和SAX
 */
public class Dom4jUtil {

    /**
     * 通过文件的路径获取xml的document对象
     * @param path .xml文件的路径
     * @return 返回文档对象
     */
    public static Document getXMLByFilePath(String path){
        if(path == null){
            return null;
        }
        Document document = null;
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(new File(path));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * 获得某文档中某元素内某属性的值和元素的文本信息
     * @param document xml文档对象
     * @param elementName 元素名
     * @param attrName 属性名
     * @return
     */
    public static Map<String,String> Element2Map(Document document, String elementName, String attrName){
        //得到根标签下所有元素名叫传进来的elementName的标签 document->rootElement->element
        List<Element> propertyList = document.getRootElement().elements(elementName);
        Map<String,String> propertyConfig = new HashMap<>();
        for (Element element : propertyList) {
            String key = element.attribute(attrName).getValue();
            //getTextTrim()方法返回给定标签的内容 元素所含有的text内容，其中连续的空格被转化为单个空格，该方法不会返回null
            String value = element.getTextTrim();
            propertyConfig.put(key,value);
        }
        return propertyConfig;
    }

    /**
     * 针对mapper.xml文件，获得映射信息并存到Map集合中
     * @param document xml文档对象
     * @return 返回一个map集合
     */
    public static Map<String,String> Element2Map(Document document){
        //Book.mapper.xml的根标签是<orm-mapping>
        Element classElement = document.getRootElement().element("class");
        Map<String,String> mapping = new HashMap<>();

        //        <id name="id" column="bid"></id> <id></id>标签对应idElement
        Element idElement = classElement.element("id");
        //根据属性attribute的名获取属性的值
        //        <id name="id" column="bid"></id>
        String idKey = idElement.attribute("name").getValue();
        //        <id name="id" column="bid"></id>
        String idValue = idElement.attribute("column").getValue();
        mapping.put(idKey,idValue);

        List<Element> propertyElement = classElement.elements("property");
        for (Element element : propertyElement) {
            /**
             *   <property name="name" column="bname"></property>
             *   <property name="author" column="author"></property>
             *   <property name="price" column="price"></property>
             */
            String propertyKey = element.attribute("name").getValue();
            String propertyValue = element.attribute("column").getValue();
            //把Java类中的属性field属性当成Map集合的key 把数据库中的column字段当成Map集合的value
            mapping.put(propertyKey,propertyValue);
        }
        return mapping;
    }

    /**
     * 和上面的方法类似 不过这个只是单单的获得主键的映射信息并存到Map集合中
     * @param document xml文档对象
     * @return 返回一个Map集合
     */
    public static Map<String,String> ElementID2Map(Document document){
        Element classElement = document.getRootElement().element("class");
        Map<String,String> mapping = new HashMap<>();


        Element idElement = classElement.element("id");//这个id是得到标签名称为id的元素对象
        String idKey = idElement.attribute("name").getValue();//这个name是name属性 通过属性名得到name属性的值 这个值是Java实体类中的id field属性
        String idValue = idElement.attribute("column").getValue();//这个column是column属性，对应的是数据库中的字段
        mapping.put(idKey,idValue);

        return mapping;
    }

    /**
     * 获得某文档中某元素内某属性的值
     * @param document xml文档对象
     * @param elementName 元素名
     * @param attrName 属性名
     * @return 返回一个set集合
     */
    public static Set<String> Element2Set(Document document, String elementName, String attrName){
        List<Element> mappingList = document.getRootElement().elements(elementName);
        Set<String> mappingSet = new HashSet<>();

        for (Element element : mappingList) {
            String value = element.attribute(attrName).getValue();
            mappingSet.add(value);
        }
        return mappingSet;
    }

    /**
     * 获得某文档中某元素内某属性的值
     * @param document xml文档对象
     * @param elementName 元素名
     * @param attrName 属性名
     * @return 返回一个set集合
     *
     * 这个方法只适用于element中只有一个情况 也就是表名和类名
     */
    public static String getPropertyValue(Document document,String elementName,String attrName){
        Element element = (Element) document.getRootElement().elements(elementName).get(0);
        return element.attribute(attrName).getValue();
    }

}
