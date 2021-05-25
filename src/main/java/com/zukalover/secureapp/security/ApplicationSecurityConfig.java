package com.zukalover.secureapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.zukalover.secureapp.enums.ApplicationUserPermission;
import com.zukalover.secureapp.enums.ApplicationUserRole;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder)
	{
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","index","/css/*","/js/*")
		.permitAll()
		.antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name())
		.antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
		.antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
		.antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
		.antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(),ApplicationUserRole.ADMINTRAINEE.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	//We will retrieve users from database using this METHOD
	//42
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
	UserDetails zukaUser =User.builder()
		.username("zukalover")
		.password(passwordEncoder.encode("zuka"))
		//.roles(ApplicationUserRole.STUDENT.name()) //ROLE_STUDENT
		.authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())
		.build();
	
	UserDetails lindaUser = User.builder()
	.username("linda")
	.password(passwordEncoder.encode("linda"))
	//.roles(ApplicationUserRole.ADMIN.name())
	.authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
	.build();
	
	UserDetails tomUser = User.builder()
			.username("tom")
			.password(passwordEncoder.encode("tom"))
			//.roles(ApplicationUserRole.ADMINTRAINEE.name())
			.authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities())
			.build();

	
	return new InMemoryUserDetailsManager(
			zukaUser,
			lindaUser,
			tomUser
			);
	}
	
	
	
}
