package com.iuqaq.catalog2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
// 需要继承 WebSecurityConfigurerAdapter 这个类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
//         return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    // 重写这个方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 基于内存认证（认证可以理解为登陆）
        auth.inMemoryAuthentication()
                // 用户名
                .withUser("iuqaq")
                // 密码，这里需要编码一下
                .password(passwordEncoder().encode("123"))
                // 用户的角色，比如该用户是admin角色，案例中此处用不上，但是默认不能不写，哪怕是不传参都行o(╥﹏╥)o
                .roles("admin")
                // 有多个用户可以用 and() 方法连接多个
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("123"))
                .roles("user");
    }

}