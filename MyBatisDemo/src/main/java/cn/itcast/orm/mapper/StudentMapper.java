package cn.itcast.orm.mapper;

import cn.itcast.orm.entity.Student;

import java.util.List;

public interface StudentMapper {
    List<cn.itcast.orm.entity.Student> findAll();
    Student findStudentByID(Integer id);
    Integer add(Student student);
    Integer delete(Integer id);
    Integer update(Student student);
}
