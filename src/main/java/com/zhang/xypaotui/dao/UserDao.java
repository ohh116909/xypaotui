package com.zhang.xypaotui.dao;

import com.zhang.xypaotui.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    void save(User user);
    User findByUserName(String username);
}
