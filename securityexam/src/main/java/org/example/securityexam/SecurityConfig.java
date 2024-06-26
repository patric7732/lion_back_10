package org.example.securityexam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests(authroizeRequest -> authroizeRequest
                        .anyRequest() //모든 요청
                        .authenticated() //인증을 요구
                );
//                .formLogin(Customizer.withDefaults());

        http
                .formLogin(formLogin ->formLogin
//                        .loginPage("/loginForm")   //시큐리티기본으로 제공하는 페이지가 아니고, 사용자가 원하는 로그인페이지로 이동할수있게 설정
                        .defaultSuccessUrl("/success")
                        .failureUrl("/fail")
                                .successHandler((request, response, authentication) -> {
                                    log.info("authentication  :: "+ authentication.getName());
                                    response.sendRedirect("/success");
                                })
                                .failureHandler((request, response, exception) -> {
                                    log.info("exception::"+ exception.getMessage());
                                    response.sendRedirect("/login");
                                })
//                        .usernameParameter("userId")
//                        .passwordParameter("passwd")
//                        .loginProcessingUrl("/login_p")
                        .permitAll() //loginPage에 대한 요청은 누구나 요청 할 수 있도록!!
                );
        //logout 이 진행될때 기본적으로 세션을 무효화시키고, 인증토큰 삭제, 쿠키정보삭제하고, 로그인페이지로 리다이렉트 하는것이 기본설정!!
        http
                .logout(logout -> logout
//                        .logoutUrl("/log_out")
                        .logoutSuccessUrl("/login")
                        .addLogoutHandler((request, response, authentication) -> {
                            log.info("addLogoutHandler ");
                            HttpSession session = request.getSession();
                            session.invalidate();
                        })
                        .logoutSuccessHandler((request, response, authentication) -> {
                            log.info("logoutSuccessHandler ");
                            response.sendRedirect("/logout");
                        })
                        .deleteCookies("remember-me")
                );


        return http.build();
    }
}
