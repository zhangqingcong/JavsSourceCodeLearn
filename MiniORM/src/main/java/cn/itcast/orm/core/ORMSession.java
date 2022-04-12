package cn.itcast.orm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ORMSession {

    private Connection connection;

    public ORMSession(Connection connection) {
        this.connection = connection;
    }

    public void save(Object entity) throws IllegalAccessException, SQLException {
        String insertSql = null;
        //1.从ORMConfig中获取保存有映射信息的集合
        //insert into table_name (column1,column2,column3,...) values(value1,value2,value3,...)
        //SQL语句中未知的有table_name 和 column 以及value table和column从映射文件中获得 value从传进来的参数entity中获得
        List<Mapper> mapperList = ORMConfig.mapperList;

        //2.MapperList可能会有多个类 需要遍历循环找到翮entity参数相对应的那个Mapper
        for (Mapper mapper : mapperList) {
            //用你传进来想操作那个类名通过反射获得，遍历出来的配置的文件名称做判断 通过就进入逻辑
            if (mapper.getClassName().equals(entity.getClass().getName())) {
                String tableName = mapper.getTableName();
                String insertSQL1 = "insert into " + tableName + "( ";
                String insertSQL2 = " ) values ( ";
                Class c = entity.getClass();
                //3.获得当前对象所属类中所有属性
                Field[] fields = c.getDeclaredFields();
                for (Field field : fields) {
                    //4.1 遍历过程中 从解析的映射文件根据field字段获得对应的column是哪个
                    /**
                     *  {id=bid,name=bname,author=author,price=price}
                     *
                     *
                     */
                    String columnName = mapper.getPropertyMapper().get(field.getName());
                    //4.2 遍历过程中从传进来的对象实体中获得值要插入数据中的值
                    field.setAccessible(true);
                    String columnValue = field.get(entity).toString();
                    insertSQL1 += columnName + ",";
                    insertSQL2 += "'" + columnValue + "',";
                }
                Map<String, String> idMapper = mapper.getIdMapper();
                Map<String, String> propertyMapper = mapper.getPropertyMapper();
                //减去insertSQL1的最后一个 ,
                insertSql = insertSQL1.substring(0, insertSQL1.length() - 1) + insertSQL2.substring(0, insertSQL2.length() - 1) + ")";
                break;
            }
        }
        System.out.println("MiniORM-save: " + insertSql);


        //通过JDBC发送并执行SQL
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    //根据主键进行数据删除 delete from tablename where 主键 = 值
    public void delete(Object entity) throws Exception {
        String delSQL = "delete from ";
        //1.从ORMConfig中获得保存有映射信息的集合
        //这个Mapper存的都是解析出来的映射信息 包括表名和实体类的映射 字段和属性的映射
        List<Mapper> mapperList = ORMConfig.mapperList;

        //2.遍历得到的映射信息，和传进来的类名匹配上的就是我们需要的那个映射集合
        for (Mapper mapper : mapperList) {
            if (mapper.getClassName().equals(entity.getClass().getName())) {
                String tableName = mapper.getTableName();
                delSQL += tableName + " where ";
                //4.得到主键的字段名
                //这里set是不重复的集合[id] 可以转成数组 且只有一个 可以用idProp[0]来取 idColumn同理
                Object[] idProp = mapper.getIdMapper().keySet().toArray();
                Object[] idColumn = mapper.getIdMapper().values().toArray();
                //5.得到主键的值 主键的值从传进来的实体中获得 通过反射 根据属性名得到Field
                Field field = entity.getClass().getDeclaredField(idProp[0].toString());
                field.setAccessible(true);
                //再通过field.get(传进来的实体类)反射的方式拿到传进来的对象的ID值，
                //可能有两种情况哈 一、entity里面没有id这个字段 二、有ID这个属性 但是值为空
                String idVal = field.get(entity).toString();

                //6.拼接sql
                delSQL += idColumn[0].toString() + "=" + idVal;
                System.out.println("MiniORM-delete: " +  delSQL );
                break;
            }
        }
        PreparedStatement statement = connection.prepareStatement(delSQL);
        statement.executeUpdate();
        statement.close();
    }

    //根据主键进行查询
    public Object findOne(Class clz,Object id) throws Exception{
        String querySQL ="select * from  ";
        //1.从ORMconfig中得到存有映射信息的集合
        List<Mapper> mapperList = ORMConfig.mapperList;

        //2.遍历集合拿到我们想要的mapper对象
        for (Mapper mapper : mapperList) {
            if (mapper.getClassName().equals(clz.getName())){
                //3.从集合中获得表名
                String tableName = mapper.getTableName();

                //4.获得主键字段名
                Object[] idColumn = mapper.getIdMapper().values().toArray();//idColumn[0]


                //5.拼接SQL
                querySQL += tableName + " where " + idColumn[0].toString()+" = "+id;
                 break;
            }
        }
        System.out.println("MiniORM-findOne: "+querySQL);

        //6.通过JDBC执行SQL 获得结果
        PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
        ResultSet rs = preparedStatement.executeQuery();

        //7.封装结果，返回对象
        if (rs.next()){
            //8.创建一个对象 这个时候对象的属性都还是默认值 都还没有赋值
            Object obj = clz.newInstance();
            //9.遍历mapperList集合找到我们想要的mapper对象
            for (Mapper mapper : mapperList) {
                if (mapper.getClassName().equals(clz.getName())){
                    //10.得到存有属性-字段的映射信息
                    Map<String, String> propertyMapper = mapper.getPropertyMapper();
                    //11.遍历集合分别拿到属性名和字段名
                    Set<String> propSet = propertyMapper.keySet();
                    for (String property : propSet) {//prop就是属性名称
                        String column = propertyMapper.get(property);//column就是和属性映射的字段名
                        Field field = clz.getDeclaredField(property);
                        //反射 把查询出来的原始的mysql数据装进传进来的clz当中
                        field.setAccessible(true);
                        field.set(obj,rs.getObject(column));
                    }
                    break;
                }
            }
            //12.释放资源
            preparedStatement.close();
            rs.close();
            //13.返回查询出来的数据
            return obj;
        }else{
            //没有查到数据
            return null;
        }
    }

    public void close() throws Exception{
        if (connection != null){
            connection.close();
            connection = null;
        }
    }
}
