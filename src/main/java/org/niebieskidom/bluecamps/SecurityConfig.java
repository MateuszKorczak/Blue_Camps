package org.niebieskidom.bluecamps;

import org.niebieskidom.bluecamps.services.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("{bcrypt}pass").roles("USER")
                .and()
                .withUser("admin1").password("{bcrypt}adminpass").roles("ADMIN");
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()   //do usunięcia w przyszłości

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/child").hasRole("ADMIN")
                .antMatchers("/camp").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .and().formLogin().loginPage("/login")
                .and().logout().logoutSuccessUrl("/")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");


//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/user/add").permitAll()

//                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/camp/**").hasRole("ADMIN")
//                .antMatchers("/camp/edit/**").hasRole("ADMIN")
//                .antMatchers("/camp/delete/**").hasRole("ADMIN")
//                .antMatchers("/").permitAll()
//                .anyRequest().hasAnyRole("ADMIN", "USER")
//                .and().formLogin()
//                .and().logout().logoutSuccessUrl("/")
//                .permitAll()
//                .and().exceptionHandling().accessDeniedPage("/403");

    }

}