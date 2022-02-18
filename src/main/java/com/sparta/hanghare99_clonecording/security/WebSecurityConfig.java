//package com.sparta.hanghare99_clonecording.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    private final JWTAuthProvider jwtAuthProvider;
////    private final HeaderTokenExtractor headerTokenExtractor;
////
////    public WebSecurityConfig(
////            JWTAuthProvider jwtAuthProvider,
////            HeaderTokenExtractor headerTokenExtractor) {
////        this.jwtAuthProvider = jwtAuthProvider;
////        this.headerTokenExtractor = headerTokenExtractor;
////    }
////
////    @Bean
////    public LoginAuthProvider loginAuthProvider() {
////        return new LoginAuthProvider(encodePassword());
////    }
////
////    @Bean
////    public LoginSuccessHandler loginSuccessHandler() {
////        return new LoginSuccessHandler();
////    }
////
////    @Bean
////    public LoginFailureHandler loginFailureHandler() {
////        return new LoginFailureHandler();
////    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder encodePassword() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Override
////    public void configure(AuthenticationManagerBuilder auth) {
////        auth
////                .authenticationProvider(loginAuthProvider())
////                .authenticationProvider(jwtAuthProvider);
////    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
//        web
//                .ignoring()
//                .antMatchers("/h2-console/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf()
//                .disable()
//                // 서버에서 인증은 JWT로 인증하기 때문에 Session의 생성을 막습니다.
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////                .and()
////                .addFilterBefore(getAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
////                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        http.authorizeRequests()
////              .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//                .anyRequest().permitAll()
//                .and()
//                .cors()
//                .and()
//                .formLogin().disable();
//
//// [로그아웃 기능]
//        http.logout()
//// 로그아웃 요청 처리 URL
//                .logoutUrl("/user/logout")
////                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
//                .permitAll();
//    }
//
//
////    public CustomUsernamePasswordAuthenticationFilter getAuthenticationFilter()
////            throws Exception {
////        CustomUsernamePasswordAuthenticationFilter authenticationFilter =
////                new CustomUsernamePasswordAuthenticationFilter(authenticationManager());
////        authenticationFilter.setFilterProcessesUrl("/user/login");
////        authenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
////        authenticationFilter.setAuthenticationFailureHandler(loginFailureHandler());
////        authenticationFilter.afterPropertiesSet();
////        return authenticationFilter;
////    }
//
////    // JWT 인증 여부 필터
////    private JwtAuthFilter jwtFilter() throws Exception {
////        List<String> skipPathList = new ArrayList<>();
////
////        // h2-console 허용
////        skipPathList.add("GET,/h2-console/**");
////        skipPathList.add("POST,/h2-console/**");
////        // 회원 관리 API 허용
////        skipPathList.add("GET,/user/**");
////        skipPathList.add("POST,/user/**");
////
////        skipPathList.add("GET,/boards/**");
////
////        FilterSkipMatcher matcher = new FilterSkipMatcher(
////                skipPathList,
////                "/**"
////        );
////
////        JwtAuthFilter filter = new JwtAuthFilter(
////                matcher,
////                headerTokenExtractor
////        );
////        filter.setAuthenticationManager(super.authenticationManagerBean());
////
////        return filter;
////    }
//
//}