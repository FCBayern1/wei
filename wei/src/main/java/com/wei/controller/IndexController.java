package com.wei.controller;

import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Api(tags = "跳转链接")
@Controller
public class IndexController {
    @ApiOperation("验证码图片")
    @RequestMapping(value = "/captcha",method = {RequestMethod.GET,RequestMethod.POST})
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

    @ApiOperation("进入登录页面")
    @RequestMapping(value = {"/","/login"},method = {RequestMethod.GET,RequestMethod.POST})
    public String index(){
        return "login";
    }


    @ApiOperation("进入员工信息页面")
    @RequestMapping(value = "student/list",method = {RequestMethod.GET,RequestMethod.POST})
    public String studentList(){
        return "studentList";
    }
    @ApiOperation("进入员工添加信息页面")
    @RequestMapping(value = "student/add",method = {RequestMethod.GET,RequestMethod.POST})
    public String studentInsert(){
        return "studentInsert";
    }
    @ApiOperation("进入编辑员工页面，同时传入一个员工的id")
    @RequestMapping(value = "student/edit",method = {RequestMethod.GET,RequestMethod.POST})
    public String studentEdit(Integer id, Model model){
        model.addAttribute("id",id);
        return "studentEdit";
    }

    @ApiOperation("进入校验1页面")
    @RequestMapping(value = {"/1"},method = {RequestMethod.GET,RequestMethod.POST})
    public String jy1(){
        return "1";
    }
    @ApiOperation("进入校验2页面")
    @RequestMapping(value = {"/2"},method = {RequestMethod.GET,RequestMethod.POST})
    public String jy2(){
        return "2";
    }
    @ApiOperation("进入校验3页面")
    @RequestMapping(value = {"/3"},method = {RequestMethod.GET,RequestMethod.POST})
    public String jy3(){
        return "3";
    }


    @ApiOperation("进入组装1页面")
    @RequestMapping(value = {"/zu1"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu1(){
        return "zu1";
    }
    @ApiOperation("进入组装2页面")
    @RequestMapping(value = {"/zu2"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu2(){
        return "zu2";
    }
    @ApiOperation("进入组装3页面")
    @RequestMapping(value = {"/zu3"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu3(){
        return "zu3";
    }
    @ApiOperation("进入组装4页面")
    @RequestMapping(value = {"/zu4"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu4(){
        return "zu4";
    }
    @ApiOperation("进入组装5页面")
    @RequestMapping(value = {"/zu5"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu5(){
        return "zu5";
    }
    @ApiOperation("进入组装6页面")
    @RequestMapping(value = {"/zu6"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu6(){
        return "zu6";
    }
    @ApiOperation("进入组装7页面")
    @RequestMapping(value = {"/zu7"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu7(){
        return "zu7";
    }
    @ApiOperation("进入组装8页面")
    @RequestMapping(value = {"/zu8"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu8(){
        return "zu8";
    }
    @ApiOperation("进入组装9页面")
    @RequestMapping(value = {"/zu9"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu9(){
        return "zu9";
    }
    @ApiOperation("进入组装10页面")
    @RequestMapping(value = {"/zu10"},method = {RequestMethod.GET,RequestMethod.POST})
    public String zu10(){
        return "zu10";
    }


    @ApiOperation("进入喷漆1页面")
    @RequestMapping(value = {"/tu1"},method = {RequestMethod.GET,RequestMethod.POST})
    public String tu1(){
        return "tu1";
    }
    @ApiOperation("进入喷漆2页面")
    @RequestMapping(value = {"/tu2"},method = {RequestMethod.GET,RequestMethod.POST})
    public String tu2(){
        return "tu2";
    }
    @ApiOperation("进入喷漆3页面")
    @RequestMapping(value = {"/tu3"},method = {RequestMethod.GET,RequestMethod.POST})
    public String tu3(){
        return "tu3";
    }

}
