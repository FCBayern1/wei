package com.wei.controller;

import com.wei.entity.ReturnResult;
import com.wei.utils.ReturnUtils;
import com.wf.captcha.utils.CaptchaUtil;
import com.wei.entity.Student;
import com.wei.entity.Users;
import com.wei.service.StudentService;
import com.wei.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Api(tags = "登录方法")
@RestController
@RequestMapping("users")
public class UsersController {
    private static final Logger log = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UsersService usersService;
    @Autowired
    private StudentService studentService;
    Map<String, Object> map = new HashMap<String, Object>();

    @ApiOperation("登陆")
    @RequestMapping(value = "login1",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnResult<T> login1(String account, String password, String verCode,String tid,
                                  HttpSession session, HttpServletRequest request, RedirectAttributes attributes){
        try{
            Users admin=new Users();
            admin.setName(account);
            admin.setPassword(password);
            //1为管理员
            if(tid.equals("1")){
                Users u = usersService.login(admin);
                if(u==null){
                    return ReturnUtils.fail(500,"账号或密码错误!");
                }
                else{
                    session.setAttribute("user",u);
                    map.put("data",u);
                    map.put("count",1);
                    return ReturnUtils.success(map);
                }
            }else{
                Student student1=new Student();
                student1.setName(account);
                student1.setPassword(password);
                Student u=studentService.login(student1);
                if(u==null){
                    return ReturnUtils.fail(500,"账号或密码错误!");
                }
                else{
                    session.setAttribute("user",u);
                    map.put("data",u);
                    map.put("count",1);
                    return ReturnUtils.success(map);
                }
            }
        }catch (Exception e){
            return ReturnUtils.fail(500,"请重新操作!");
        }
    }

    @ApiOperation("登录")
    @RequestMapping(value = "login",method = {RequestMethod.GET, RequestMethod.POST})
    public String login(String account, String password, String verCode,String tid,
                        HttpSession session, HttpServletRequest request, RedirectAttributes attributes){
        Users admin=new Users();
        admin.setName(account);
        admin.setPassword(password);
        //1为管理员
        if(tid.equals("1")){
            Users u = usersService.login(admin);
            if(u==null){
                attributes.addFlashAttribute("msg","账号或密码错误");
                return "redirect:/login";
            }
//            else if (!CaptchaUtil.ver(verCode, request)) {
//                CaptchaUtil.clear(request);  // 清除session中的验证码
//                attributes.addFlashAttribute("msg","验证码错误");
//                attributes.addFlashAttribute("account", account);
//                attributes.addFlashAttribute("password", password);
//                return "redirect:/login";
//            }
            else{
                session.setAttribute("user",u);
                return "index";
            }
        }else{

            Student student1=new Student();
            student1.setName(account);
            student1.setPassword(password);
            Student u=studentService.login(student1);
            if(u==null){
                attributes.addFlashAttribute("msg","账号或密码错误");
                return "redirect:/login";
            }
//            else if (!CaptchaUtil.ver(verCode, request)) {
//                CaptchaUtil.clear(request);  // 清除session中的验证码
//                attributes.addFlashAttribute("msg","验证码错误");
//                attributes.addFlashAttribute("account", account);
//                attributes.addFlashAttribute("password", password);
//                return "redirect:/login";
//            }
            else{
                session.setAttribute("user",u);
                return "indexStudent";
            }
        }

    }


    @ApiOperation("退出方法，返回到登录")
    @RequestMapping(value = "logout", method= {RequestMethod.POST,RequestMethod.GET})
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
