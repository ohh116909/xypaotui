package com.zhang.xypaotui.config;

import com.zhang.xypaotui.pojo.User;
import com.zhang.xypaotui.service.UserService;
import com.zhang.xypaotui.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        //根据身份信息
        String principal = (String)Token.getPrincipal();
        System.out.println(principal);
        //在工厂中获取service对象
        UserService userService = (UserService) ApplicationContextUtils.getBean("userServiceImpl");
        //根据身份信息查询
        User user = userService.findByUserName(principal);
        System.out.println(user);

        if(!ObjectUtils.isEmpty(user)){
            //返回数据库信息
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
        return null;
    }
}
