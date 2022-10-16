package com.wei.controller;

import com.wei.entity.ReturnResult;
import com.wei.entity.Student;
import com.wei.service.StudentService;
import com.wei.utils.ReturnUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(tags = "员工")
@RestController
@RequestMapping("student")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    Map<String, Object> map = new HashMap<String, Object>();

    @ApiOperation("分页查询用户信息")
    @RequestMapping(value = "findAll",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnResult<T> findAll(Integer page, Integer limit){
        try{
            map.put("data",studentService.listPage((page-1)*limit,limit));
            map.put("count",studentService.list().size());
            return ReturnUtils.success(map);
        }catch (Exception e){
            return ReturnUtils.fail(500,"请重新操作!");
        }
    }

    @ApiOperation("分页查询员工信息")
    @RequestMapping(value = "list1",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list1(Integer page, Integer limit){
        map.put("data",studentService.listPage((page-1)*limit,limit));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",studentService.list().size());
        return map;
    }

    @ApiOperation("添加员工")
    @RequestMapping(value = "insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnResult<T> insert(Student student){
        Student student1=new Student();
        student1.setName(student.getName());
        List<Student> stu=studentService.select(student1);
        //如果大于0，则不允许注册，因为id存在了
        if(stu.size()>0) {
            return ReturnUtils.fail(500,"请重新操作!");
        }else{
            studentService.insert(student);
            return ReturnUtils.success();
        }
    }
//    @ApiOperation("添加员工")
//    @RequestMapping(value = "insert",method = RequestMethod.POST)
//    @ResponseBody
//    public String insert(Student student){
//        Student student1=new Student();
//        student1.setName(student.getName());
//        List<Student> stu=studentService.select(student1);
//        //如果大于0，则不允许注册，因为学号存在了
//        if(stu.size()>0) {
//            return "error";
//        }else{
//            studentService.insert(student);
//            return "success";
//        }
//    }

    @ApiOperation("根据ID进行员工查询")
    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    @ResponseBody
    public Student selectById(Integer id){
        return studentService.selectById(id);
    }
//    @ApiOperation("根据ID进行修改")
//    @RequestMapping(value = "update",method = RequestMethod.POST)
//    @ResponseBody
//    public String update(Student student){
//        studentService.update(student);
//        return "success";
//    }
    @ApiOperation("根据ID进行修改")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult<T> update(Student student){
        studentService.update(student);
        return ReturnUtils.success();
    }
//    @ApiOperation("根据ID进行删除")
//    @RequestMapping(value = "delete",method = RequestMethod.POST)
//    @ResponseBody
//    public String delete(Integer id){
//
//        studentService.delete(id);
//        return "success";
//    }
    @ApiOperation("根据ID进行删除")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult<T> delete(Integer id){

        studentService.delete(id);
        return ReturnUtils.success();
    }
//    @ApiOperation("根据ID进行批量删除")
//    @RequestMapping(value = "deleteIds",method = RequestMethod.POST)
//    @ResponseBody
//    public String deleteIds(Integer[] ids){
//        for (Integer id:ids) {
//            studentService.delete(id);
//        }
//        return "success";
//    }
    @ApiOperation("根据ID进行批量删除")
    @RequestMapping(value = "deleteIds",method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult<T> deleteIds(Integer[] ids){
        for (Integer id:ids) {
            studentService.delete(id);
        }
        return ReturnUtils.success();
    }

    @ApiOperation("根据条件查询")
    @RequestMapping(value = "select",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> select(Student student){
        map.put("data",studentService.select(student));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",studentService.select(student).size());
        return map;
    }

    @ApiOperation("查询全部，给下拉框赋值")
    @RequestMapping(value = "selectBy",method = RequestMethod.POST)
    @ResponseBody
    public List<Student> selectBy(){
        return studentService.list();
    }
}
