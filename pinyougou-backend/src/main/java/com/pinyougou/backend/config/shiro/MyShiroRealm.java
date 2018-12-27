package com.pinyougou.backend.config.shiro;


import com.pinyougou.backend.dto.Permission;
import com.pinyougou.backend.dto.Role;
import com.pinyougou.backend.dto.User;
import com.pinyougou.backend.feign.IUserFeign;
import com.pinyougou.common.dto.BaseResponse;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

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
        for (Role role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRoleName());
            for (Permission p : role.getPermissionList()) {
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
        return authenticationInfo;
    }
}
