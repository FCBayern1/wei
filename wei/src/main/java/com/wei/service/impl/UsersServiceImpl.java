package com.wei.service.impl;

import com.wei.entity.Users;
import com.wei.mapper.UsersMapper;
import com.wei.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {
    private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(Users users) {
        return usersMapper.login(users);
    }
}
