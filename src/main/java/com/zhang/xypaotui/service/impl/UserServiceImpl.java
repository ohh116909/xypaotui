package com.zhang.xypaotui.service.impl;

import com.zhang.xypaotui.dao.UserDao;
import com.zhang.xypaotui.pojo.User;
import com.zhang.xypaotui.service.UserService;
import com.zhang.xypaotui.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void register(User user) {
        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());
        userDao.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}
