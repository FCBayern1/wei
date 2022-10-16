package com.wei.mapper;

import com.wei.entity.Users;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UsersMapper {
    Users login(Users users);
}
