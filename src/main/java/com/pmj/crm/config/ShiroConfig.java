package com.pmj.crm.config;

import com.pmj.crm.entity.Permission;
import com.pmj.crm.service.IPermissionService;
import com.pmj.crm.shiro.EmployeeRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Configuration
public class ShiroConfig {

    @Resource
    private IPermissionService iPermissionService;

    /**
     * 过滤器工厂
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        System.out.println("启动 ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        /**
         * 拦截器 map 集合.
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        /**
         * 配置不会被拦截的链接 顺序判断
         * anon 匿名 访问
         */
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/doLogin", "anon");
        filterChainDefinitionMap.put("/employee/admin-list.html", "anon");
        filterChainDefinitionMap.put("/employee/del", "anon");

        /**
         * 配置退出 过滤器,其中的具体的退出代码Shiro已经实现了
         */
        filterChainDefinitionMap.put("/logout", "logout");


        /**
         * authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
         * 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
         */
/*        filterChainDefinitionMap.put("/employee/queryEmployeeList", "perms[employee:query]");
        filterChainDefinitionMap.put("/employee/saveEmployeetList", "perms[employee:save]");
        filterChainDefinitionMap.put("/employee/updateEmployeetList", "perms[employee:update]");
        filterChainDefinitionMap.put("/employee/updateEmployeeState", "perms[employee:updateState]");*/
        filterChainDefinitionMap.put("/employee", "perms[employee:*]");
        filterChainDefinitionMap.put("/employee/employee-list.html", "perms[employee:*]");
        filterChainDefinitionMap.put("/**", "authc");

        /**
         * 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
         */
        shiroFilterFactoryBean.setLoginUrl("/login.html");


        /**
         * 登录成功后要跳转的链接
         */
        shiroFilterFactoryBean.setSuccessUrl("/index");


        /**
         * 未授权界面
         */
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 身份认证realm; (账号密码校验；权限等)
     *
     * @return MyShiroRealm
     */
    @Bean
    public EmployeeRealm myShiroRealm() {
        EmployeeRealm myShiroRealm = new EmployeeRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }



    /**
     * 安全管理器
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }


    /**
     * 凭证匹配器
     * （密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 修改下doGetAuthenticationInfo中的代码;
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        /**
         * 散列算法:使用MD5算法
         * 加密一次
         */
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }


    /**
     * Shiro生命周期处理器 * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 顾问自动代理创建者
     *
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 授权属性来源顾问
     *
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }


}