package com.wei.service.impl;

import com.wei.entity.Student;
import com.wei.mapper.StudentMapper;
import com.wei.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(Student student) {
        return studentMapper.login(student);
    }

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public List<Student> listPage(Integer page, Integer limit) {
        return studentMapper.listPage(page,limit);
    }

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int delete(Integer id) {
        return studentMapper.delete(id);
    }

    @Override
    public List<Student> select(Student student) {
        return studentMapper.select(student);
    }
}
