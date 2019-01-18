package com.pinyougou.backend.config.shiro;


import com.pinyougou.backend.dto.Permission;
import com.pinyougou.backend.dto.Role;
import com.pinyougou.backend.dto.User;
import com.pinyougou.backend.feign.IUserFeign;
import com.pinyougou.common.dto.BaseResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author ljn
 * @date 2018/12/25.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserFeign userFeign;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User) principalCollection.getPrimaryPrincipal();
        List<Role> roleList = userInfo.getRoleList();
        if (CollectionUtils.isEmpty(roleList)) {
            return authorizationInfo;
        }
        for (Role role : roleList) {
            authorizationInfo.addRole(role.getRoleName());
            List<Permission> permissionList = role.getPermissionList();
            if (CollectionUtils.isEmpty(permissionList)) {
                continue;
            }
            for (Permission p : permissionList) {
                authorizationInfo.addStringPermission(p.getPermissionName());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
//      通过username从数据库中查找 User对象，如果找到，没找到.
//      实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        BaseResponse<User> response = userFeign.findByName(username);
        if (response == null || response.getResult() == null) {
            return null;
        }
//        String s = JSON.toJSONString(response.getResult());
//        User user = JSONObject.parseObject(s, User.class);
        User userInfo = response.getResult();
        if (userInfo == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), getName());
        //session中不需要保存密码
        userInfo.setPassword("");
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, userInfo);
        return authenticationInfo;
    }

    @Override
    protected void doClearCache(PrincipalCollection principals) {
        super.doClearCache(principals);
    }

    /**
     * 清除当前用户的授权缓存
     * @param principals
     */
    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除当前用的认证缓存
     * @param principals
     */
    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
