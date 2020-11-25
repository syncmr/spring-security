package com.iuqaq.catalog3.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello security!";
    }

    // 必须拥有 ROLE_admin 角色，以下两种写法是相同的，前缀可加可不加
    // @PreAuthorize("hasRole('admin')")
    @PreAuthorize("hasRole('ROLE_admin')")
    @GetMapping("/a")
    public String a() {
        System.out.println("权限不匹配我不会被打印");
        return "你访问到我了，管理员";
    }

    // 用户没有test角色，但是会先执行这个方法
    @PostAuthorize("hasRole('ROLE_test')")
    @GetMapping("/b")
    public String b() {
        System.out.println("我不管，有没有权限我都要执行");
        return "你访问到我了，管理员";
    }

    // 需要多个角色
    // @PreAuthorize("hasRole('ROLE_admin') and hasRole('ROLE_user')")
    // 用户名开头为 zs 的用户才能访问
    // @PreAuthorize("principal.username.startsWith('zs')")
    // 入参 name 必须同当前的用户名相同  同时  入参 id 限制小于 10
    // @PreAuthorize("#name.equals(principal.username) and #id < 10")
    public void c(String name, Integer id) {
    }

}