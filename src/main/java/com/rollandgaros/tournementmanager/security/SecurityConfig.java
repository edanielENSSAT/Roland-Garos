package com.rollandgaros.tournementmanager.security;


import com.rollandgaros.tournementmanager.model.MyUserDetails;
import com.rollandgaros.tournementmanager.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.rollandgaros.tournementmanager.security.ApplicationUserPermission.MATCH_WRITE;
import static com.rollandgaros.tournementmanager.security.ApplicationUserPermission.PLAYER_WRITE;
import static com.rollandgaros.tournementmanager.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
       // private final BCryptPasswordEncoder passwordEncoder;

    //@Autowired
    MyUserDetailsService myUserDetailsService;


    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

   /* @Autowired
    public SecurityConfig(BCryptPasswordEncoder passwordEncoder){

        this.passwordEncoder =passwordEncoder;


    }*/
    /*@Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }*/




    //geerer la permission delete
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/admin").hasRole(ADMIN.name())
                    .antMatchers("/editeurdejoueur").hasRole(PLAYER.name())
                    .antMatchers("/editeurdematch").hasRole(MATCH.name())
                    .antMatchers("/","index","/css","/js/*").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/home", true)
                    .passwordParameter("password")
                    .usernameParameter("username")
                    .and()
                    .rememberMe()
                        .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
                        .key("somethingverysecured")
                        .rememberMeParameter("remember-me")
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/login");
            //http.authenticationProvider(userDetailsAuthProvider());
              http.userDetailsService(myUserDetailsService);

            return http.build();
        }

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder(10);
        }
        /*PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
        }*/

   /* @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }*/

           //


   /* @Bean
    public DaoAuthenticationProvider daoAuthentificationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }*/
  /* @Bean
   public AuthenticationProvider userDetailsAuthProvider(){
       DaoAuthenticationProvider a = new DaoAuthenticationProvider();
       a.setUserDetailsService(myUserDetailsService);
       a.setPasswordEncoder(bCryptPasswordEncoder());
       return a;
   }*/

    /*@Bean
    public AuthenticationManager authenticationManager( AuthenticationManagerBuilder amb) throws Exception {
        return amb.authenticationProvider(userDetailsAuthProvider()).build();
    }*/
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }

    }


