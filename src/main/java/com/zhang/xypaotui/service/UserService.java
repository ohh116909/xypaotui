package com.zhang.xypaotui.service;

import com.zhang.xypaotui.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    void register(User user);
    User findByUserName(String username);
}
