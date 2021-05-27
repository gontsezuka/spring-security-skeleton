package com.zukalover.secureapp.auth;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.zukalover.secureapp.enums.ApplicationUserRole;

@Repository("fake")
public class ApplicationRepoService implements ApplicationUserRepository {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		// TODO Auto-generated method stub
		return getApplicationUsers().stream().filter(appUser -> username.equals(appUser.getUsername())).findFirst();
	}

	private List<ApplicationUser> getApplicationUsers()
	{
		List<ApplicationUser> applicationUser = Arrays.asList(
				
				new ApplicationUser(
						ApplicationUserRole.STUDENT.getGrantedAuthorities(),
						passwordEncoder.encode("zuka"),
						"zuka",
						true,
						true,
						true,
						true
						),
				new ApplicationUser(
						ApplicationUserRole.ADMIN.getGrantedAuthorities(),
						passwordEncoder.encode("linda"),
						"linda",
						true,
						true,
						true,
						true
						),
				new ApplicationUser(
						ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
						passwordEncoder.encode("tom"),
						"tom",
						true,
						true,
						true,
						true
						)
						
				);
		
		return applicationUser;
	}
}
