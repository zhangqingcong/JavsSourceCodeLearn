package cn.itcast.orm.test.dao;

import cn.itcast.orm.core.ORMConfig;
import cn.itcast.orm.core.ORMSession;
import cn.itcast.orm.test.entity.Book;
import org.junit.jupiter.api.Test;

public class BookDao {
    private ORMConfig ormConfig;

    @Test
    public void testSave() throws Exception{
        //1.创建config对象
        ormConfig = new ORMConfig();
        //2.创建ORMSession对象
        ORMSession ormSession = ormConfig.buildORMSession();
        //3.创建实体对象并保存
        Book book = new Book();
        book.setId(5);
        book.setAuthor("笑笑声");
        book.setName("金瓶梅");
        book.setPrice(59);
        ormSession.save(book);
        //4.释放资源
        ormSession.close();
    }

    @Test
    public void testFindOne() throws Exception {
        //1.创建ORMConfig对象
        ormConfig = new ORMConfig();
        //2.创建ORMSession对象
        ORMSession ormSession = ormConfig.buildORMSession();
        //3.创建实体对象并查询
        Book book = (Book) ormSession.findOne(Book.class, 5);
        System.out.println();
        //4.释放资源
        ormSession.close();
    }

    @Test
    public void testDelete() throws Exception{
        ormConfig = new ORMConfig();
        ORMSession ormSession = ormConfig.buildORMSession();
        Book book = new Book();
        book.setId(5L);
        ormSession.delete(book);
        ormSession.close();
    }

}
