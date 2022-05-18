package com.example.config;

import com.example.filter.MyFilter;
import com.example.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);

        Map<String,String> map = new HashMap<>();
        map.put("/user/login","anon");

        map.put("/task/accept/**","authc");
        map.put("/user/order","authc");
        map.put("/user/release","authc");


        factoryBean.setFilterChainDefinitionMap(map);

        factoryBean.setLoginUrl("/login");

        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("authc",new MyFilter());

        factoryBean.setFilters(filterMap);

        return factoryBean;
    }


    @Bean
    public DefaultWebSecurityManager manager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        return manager;
    }

    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }
}