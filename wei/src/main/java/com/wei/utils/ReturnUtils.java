package com.wei.utils;

import com.wei.entity.ReturnResult;

/**
 * @author
 * @date: 2022/1/11 10:51
 */
public class ReturnUtils {

    /***
     * 成功不带数据
     * @return
     */
    public static ReturnResult success(){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(200);
        return returnResult;
    }
    /***
     * 成功带数据
     * @return
     */
    public static ReturnResult success(Object data){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(200);
        returnResult.setData(data);
        return returnResult;
    }
    /***
     * 失败
     * @return
     */
    public static ReturnResult fail(Integer code,String message){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMessage(message);
        return returnResult;
    }
}