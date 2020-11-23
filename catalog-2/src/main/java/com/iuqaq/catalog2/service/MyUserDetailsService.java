package com.iuqaq.catalog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// 注意这里要加一个具体的名字，目的是不与Security自带的那个UserDetailsService冲突，因为@Autowire默认是按照类型装配的
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    // 该方法传入的参数是用户名
    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 添加一个角色，多个角色用逗号隔开，以下代表有admin的角色和user角色
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user");
        // 这里可以从数据库获取账号名和密码，此处作为演示就直接写死了
        return new User("admin", passwordEncoder.encode("123"), auths);
    }

}