//package com.pinyougou.backend.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * @author ljn
// * @date 2018/12/5.
// */
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 关闭csrf保护功能（跨域访问）
//        http.csrf().disable()
//                .authorizeRequests()
//                //访问backend下无需登录认证权限
//                .antMatchers("/backend/**").permitAll().and().headers().frameOptions().sameOrigin();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/login.html", "/**/*.css", "/**/img/**", "**/*.js");
//    }
//
//}
