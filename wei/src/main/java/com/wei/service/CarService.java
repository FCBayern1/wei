package com.wei.service;

import com.wei.entity.Car;

import java.util.List;

public interface CarService {
    /**
     * 查询全部
     * @return
     */
    List<Car> list();

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    List<Car> listPage(Integer page, Integer limit);

    /**
     * 添加
     * @param car
     * @return
     */
    int insert(Car car);

    /**
     * 根据ID进行查询
     * @param id
     * @return
     */
    Car selectById(Integer id);

    /**
     * 根据ID进行修改
     * @param car
     * @return
     */
    int update(Car car);

    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据条件查询
     * @param car
     * @return
     */
    List<Car> select(Car car);
}
