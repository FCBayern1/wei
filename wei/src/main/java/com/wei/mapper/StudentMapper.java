package com.wei.mapper;

import com.wei.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentMapper {

    /**
     * 登陆
     * @param student
     * @return
     */
    Student login(Student student);
    /**
     * 查询全部
     * @return
     */
    List<Student> list();

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    List<Student> listPage(Integer page, Integer limit);

    /**
     * 添加学生
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 根据ID进行查询
     * @param id
     * @return
     */
    Student selectById(Integer id);

    /**
     * 根据ID进行修改
     * @param student
     * @return
     */
    int update(Student student);

    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据条件查询
     * @param student
     * @return
     */
    List<Student> select(Student student);
}
