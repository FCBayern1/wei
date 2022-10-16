package com.wei.service.impl;

import com.wei.entity.Car;
import com.wei.mapper.CarMapper;
import com.wei.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {
    private static final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> list() {
        return carMapper.list();
    }

    @Override
    public List<Car> listPage(Integer page, Integer limit) {
        return carMapper.listPage(page,limit);
    }

    @Override
    public int insert(Car car) {
        return carMapper.insert(car);
    }

    @Override
    public Car selectById(Integer id) {
        return carMapper.selectById(id);
    }

    @Override
    public int update(Car car) {
        return carMapper.update(car);
    }

    @Override
    public int delete(Integer id) {
        return carMapper.delete(id);
    }

    @Override
    public List<Car> select(Car car) {
        return carMapper.select(car);
    }
}
