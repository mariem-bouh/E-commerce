package com.example.ecommerce.security;

import javax.sql.DataSource;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
	private DataSource dataSource; 
	@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*
	//les utilisateurs qui ont le droit d'acceder a l'application
	auth.inMemoryAuthentication().withUser("samba").password("{noop}123").roles("ADMIN_PROD","ADMIN_CAT");
	auth.inMemoryAuthentication().withUser("moussa").password("{noop}123").roles("ADMIN_PROD");
*/

		
		//authentification avec la BD
auth.jdbcAuthentication().dataSource(dataSource)
.usersByUsernameQuery("select username as principal , password as credentials , actived from User where username= ? ")
.authoritiesByUsernameQuery("select u.username as principal ,r.role_name as role from Role r,User u where r.user_id=u.iduser and username= ? ")
.rolePrefix("ROLE_").passwordEncoder(NoOpPasswordEncoder.getInstance());

	}
@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub	
	 http.formLogin().loginPage("/login");
	 //toute les requetes necessite une authentification
	 //http.authorizeRequests().anyRequest().authenticated();
	//controle sur les urls
	 http.authorizeRequests().antMatchers("/adminProd/**").hasRole("ADMIN_PROD");
	 http.authorizeRequests().antMatchers("/adminCat/**").hasRole("ADMIN_CAT");
	 http.exceptionHandling().accessDeniedPage("/403");
	}
}
