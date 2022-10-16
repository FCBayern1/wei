package com.wei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReturnResult<T> implements Serializable {
    private Integer code; // 异常码
    private String message; // 提示信息
    private T data; // 返回数据
// 省略getter和setter代码
}