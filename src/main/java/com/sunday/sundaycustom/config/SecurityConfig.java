package com.sunday.sundaycustom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // 비활성화된 CSRF 보안. 실제 운영 환경에서는 이것을 비활성화하지 마세요.
                .authorizeRequests()
                .antMatchers("/api/signup").permitAll() // '/api/signup'은 누구나 접근할 수 있습니다.
                .anyRequest().authenticated() // 그 외의 요청은 인증된 사용자만 접근 가능
                .and()
                .formLogin().disable() // 폼 기반의 로그인을 비활성화
                .logout().disable(); // 로그아웃 기능을 비활성화
    }
}
