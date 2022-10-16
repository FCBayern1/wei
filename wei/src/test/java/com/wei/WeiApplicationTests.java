package com.wei;

import com.wei.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class WeiApplicationTests {
    @Autowired
    private RedisUtils redisUtils;
    @Test
    void contextLoads() {
        boolean hasKey = redisUtils.exists("zu1");
        String str = "";
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get("zu1");
            System.out.println("从缓存获取的数据"+ object);
            str = object.toString();
        }else{
            //从数据库中获取信息
            System.out.println("从数据库中获取数据");
            str = "true";
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set("zu1",str,1000L, TimeUnit.MINUTES);
            System.out.println("数据插入缓存" + str);
        }
    }

}
