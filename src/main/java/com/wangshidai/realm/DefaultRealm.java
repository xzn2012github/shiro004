package com.wangshidai.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class DefaultRealm extends AuthorizingRealm {
    //强制重新授权方法，以后再说
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {
        System.out.println("shiro开始进行权限校验-------------------------------");
        String clientUsername = principalCollection.getPrimaryPrincipal().toString();
        //调用服务层根据登录账号去数据库查询对应的角色下所有能访问的资源返回Set
        Set<String> perimissions=new HashSet<String>();
        perimissions.add("user:query");
        perimissions.add("user:delete");

        SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
//调用服务层根据登录账号去数据库查询对应的角色下返回Set
        Set<String> roles=new HashSet<String>();
        roles.add("role1");
        roles.add("role2");
        info.setRoles(roles);
        info.setStringPermissions(perimissions);
        return info;
    }

    //强制重写的认证方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //还记得吗，token封装了客户端的帐号密码，由Subject拉客并最终带到此处
        String clientUsername = (String) token.getPrincipal();
        //模拟一个Service

        //通过Service查询数据库，获取到正确的密码
        String passwordFromDB = "123456";
        if (passwordFromDB == null) {
            //如果根据用户输入的用户名，去数据库中没有查询到相关的密码
            throw new UnknownAccountException();
        }

        /**
         * 返回一个从数据库中查出来的的凭证。用户名为clientUsername，密码为passwordFromDB 。封装成当前返回值
         * 接下来shiro框架做的事情就很简单了。
         * 它会拿你的输入的token与当前返回的这个数据库凭证SimpleAuthenticationInfo对比一下
         * 看看是不是一样，如果用户的帐号密码与数据库中查出来的数据一样，那么本次登录成功
         * 否则就是你密码输入错误
         */
        return new SimpleAuthenticationInfo(clientUsername, passwordFromDB, getName());
    }
}
