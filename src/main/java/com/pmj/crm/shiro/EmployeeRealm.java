package com.pmj.crm.shiro;

import com.pmj.crm.entity.Employee;
import com.pmj.crm.entity.Permission;
import com.pmj.crm.entity.Role;
import com.pmj.crm.service.IEmployeeService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class EmployeeRealm extends AuthorizingRealm {

    @Resource
    private IEmployeeService iEmployeeService;

    /**
     * 权限核心配置 根据数据库中的该用户 角色 和 权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Employee employee = (Employee) principals.getPrimaryPrincipal();
        System.out.println("+++++++++++++++"+employee);

        for (Role role : employee.getRoleList()) {
            System.out.println("权限核心配置"+ role.getRoleName());//获取 角色
            authorizationInfo.addRole(role.getRoleName());                      //添加 角色
            for (Permission permission : role.getPermissionList()) {
                //获取 权限
                System.out.println("权限"+permission.getPermission());
                authorizationInfo.addStringPermission(permission.getPermission());//添加 权限
            }
        }
        return authorizationInfo;
    }

    /**
     * 用户登陆 凭证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Employee employee = iEmployeeService.selectByName(username);
        if (employee == null) return null;
        return new SimpleAuthenticationInfo(
                employee, //用户名
                employee.getPwd(), //密码
                ByteSource.Util.bytes(employee.getSalt()), //加密
                getName()  //realm name
        );
    }


}