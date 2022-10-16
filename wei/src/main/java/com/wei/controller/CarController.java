package com.wei.controller;

import com.wei.entity.Car;
import com.wei.entity.ReturnResult;
import com.wei.entity.Student;
import com.wei.service.CarService;
import com.wei.utils.RedisUtils;
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
import java.util.concurrent.TimeUnit;


@Api(tags = "车辆")
@RestController
@RequestMapping("car")
public class CarController {

    private static final Logger log = LoggerFactory.getLogger(CarController.class);
    @Autowired
    private CarService carService;
    @Autowired
    private RedisUtils redisUtils;
    Map<String, Object> map = new HashMap<String, Object>();


    @ApiOperation("分页查询用户信息")
    @RequestMapping(value = "findAll",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnResult<T> findAll1(Integer page, Integer limit){
        try{
            map.put("data",carService.listPage((page-1)*limit,limit));
            map.put("count",carService.list().size());
            return ReturnUtils.success(map);
        }catch (Exception e){
            return ReturnUtils.fail(500,"请重新操作!");
        }
    }
    @ApiOperation("添加车辆")
    @RequestMapping(value = "insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnResult<T> insert(Car car){
        Car car1=new Car();
        car1.setPinpai(car.getPinpai());
        List<Car> stu=carService.select(car1);
        if(stu.size()>0) {
            return ReturnUtils.fail(500,"请重新操作!");
        }else{
            carService.insert(car);
            return ReturnUtils.success();
        }
    }


    @ApiOperation("分页查询车辆信息")
    @RequestMapping(value = "list1",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list1(Integer page, Integer limit){
        map.put("data",carService.listPage((page-1)*limit,limit));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",carService.list().size());
        return map;
    }


    @ApiOperation("根据ID进行车辆查询")
    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    @ResponseBody
    public Car selectById(Integer id){
        return carService.selectById(id);
    }
//    @ApiOperation("根据ID进行修改")
//    @RequestMapping(value = "update",method = RequestMethod.POST)
//    @ResponseBody
//    public String update(Car car){
//        carService.update(car);
//        return "success";
//    }
    @ApiOperation("根据ID进行修改")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult<T> update(Car car){
        Car car1=new Car();
        car1.setId(car.getId());
        if(car.getJy1()!=null){
            boolean hasKey = redisUtils.exists(car.getJy1());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getJy1());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getJy1(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setJy1(redisUtils.get(car.getJy1()).toString());
        }

        if(car.getJy2()!=null){
            boolean hasKey = redisUtils.exists(car.getJy2());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getJy2());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getJy2(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setJy2(redisUtils.get(car.getJy2()).toString());
        }
        if(car.getJy3()!=null){
            boolean hasKey = redisUtils.exists(car.getJy3());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getJy3());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getJy3(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setJy3(redisUtils.get(car.getJy3()).toString());
        }

        if(car.getTu1()!=null){
            boolean hasKey = redisUtils.exists(car.getTu1());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getTu1());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getTu1(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setTu1(redisUtils.get(car.getTu1()).toString());
        }
        if(car.getTu2()!=null){
            boolean hasKey = redisUtils.exists(car.getTu2());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getTu2());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getTu2(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setTu2(redisUtils.get(car.getTu2()).toString());
        }
        if(car.getTu3()!=null){
            boolean hasKey = redisUtils.exists(car.getTu3());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getTu3());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getTu3(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setTu3(redisUtils.get(car.getTu3()).toString());
        }
        if(car.getZu1()!=null){
            boolean hasKey = redisUtils.exists(car.getZu1());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu1());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu1(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu1(redisUtils.get(car.getZu1()).toString());
        }
        if(car.getZu2()!=null){
            boolean hasKey = redisUtils.exists(car.getZu2());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu2());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu2(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu2(redisUtils.get(car.getZu2()).toString());
        }
        if(car.getZu3()!=null){
            boolean hasKey = redisUtils.exists(car.getZu3());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu3());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu3(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu3(redisUtils.get(car.getZu3()).toString());
        }
        if(car.getZu4()!=null){
            boolean hasKey = redisUtils.exists(car.getZu4());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu4());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu4(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu4(redisUtils.get(car.getZu4()).toString());
        }
        if(car.getZu5()!=null){
            boolean hasKey = redisUtils.exists(car.getZu5());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu5());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu5(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu5(redisUtils.get(car.getZu5()).toString());
        }
        if(car.getZu6()!=null){
            boolean hasKey = redisUtils.exists(car.getZu6());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu6());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu6(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu6(redisUtils.get(car.getZu6()).toString());
        }
        if(car.getZu7()!=null){
            boolean hasKey = redisUtils.exists(car.getZu7());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu7());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu7(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu7( redisUtils.get(car.getZu7()).toString());
        }
        if(car.getZu8()!=null){
            boolean hasKey = redisUtils.exists(car.getZu8());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu8());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu8(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu8(redisUtils.get(car.getZu8()).toString());
        }
        if(car.getZu9()!=null){
            boolean hasKey = redisUtils.exists(car.getZu9());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu9());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu9(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu9(redisUtils.get(car.getZu9()).toString());
        }
        if(car.getZu10()!=null){
            boolean hasKey = redisUtils.exists(car.getZu10());
            String str = "";
            if(hasKey){
                //获取缓存
                Object object =  redisUtils.get(car.getZu10());
                str = object.toString();
            }else{
                //从数据库中获取信息
                str = "true";
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(car.getZu10(),str,1000L, TimeUnit.MINUTES);
            }
            car1.setZu10(redisUtils.get(car.getZu10()).toString());
        }

        carService.update(car1);
        return ReturnUtils.success();
    }

    @ApiOperation("根据ID进行删除")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult<T> delete(Integer id){

        carService.delete(id);
        return ReturnUtils.success();
    }

    @ApiOperation("根据ID进行批量删除")
    @RequestMapping(value = "deleteIds",method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult<T> deleteIds(Integer[] ids){
        for (Integer id:ids) {
            carService.delete(id);
        }
        return ReturnUtils.success();
    }


    @ApiOperation("根据条件查询")
    @RequestMapping(value = "select",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> select(Car car){
        map.put("data",carService.select(car));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",carService.select(car).size());
        return map;
    }

//    @ApiOperation("查询全部，给下拉框赋值")
//    @RequestMapping(value = "selectBy",method = RequestMethod.POST)
//    @ResponseBody
//    public List<Car> selectBy(){
//        return carService.list();
//    }

    @ApiOperation("分页查询用户信息")
    @RequestMapping(value = "selectBy",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnResult<T> findAll(Integer page, Integer limit){
        try{
            map.put("data",carService.list());
            map.put("count",carService.list().size());
            return ReturnUtils.success(map);
        }catch (Exception e){
            return ReturnUtils.fail(500,"请重新操作!");
        }
    }
}
