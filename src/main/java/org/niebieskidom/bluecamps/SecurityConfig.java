package org.niebieskidom.bluecamps;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("{noop}pass").roles("USER")
                .and()
                .withUser("admin1").password("{noop}adminpass").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
    }


/*      do późniejszej rozbudowy
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/about").authenticated()  //to to usunięcia
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/about/**").hasAnyRole("USER", "ADMIN")
                .and().formLogin();
//        .loginPage("/login");

}
        */


}