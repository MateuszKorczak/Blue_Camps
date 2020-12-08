package org.niebieskidom.bluecamps;

import org.niebieskidom.bluecamps.services.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }


//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password("{noop}pass").roles("USER")
//                .and()
//                .withUser("admin1").password("{noop}adminpass").roles("ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//               http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .anyRequest().authenticated();


        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/user/add").permitAll()
                .antMatchers("/create-user").permitAll()
                .antMatchers("/create-admin").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/camp/**").hasRole("ADMIN")
                .antMatchers("/child/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/").permitAll()
                .anyRequest().hasAnyRole("ADMIN", "USER")
                .and().formLogin()
                .and().logout().logoutSuccessUrl("/")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");


    }

}