import cn.itcast.orm.entity.Student;
import cn.itcast.orm.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class StudentTest {
    @Test
    public void test01() throws IOException {
        //1.加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据加载解析出来的核心配置文件，创建SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(inputStream);
        //3.获得SqlSession对象
        SqlSession sqlSession = build.openSession();
        //4.得到Mapper代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //5.发送执行
        List<Student> studentList = mapper.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
