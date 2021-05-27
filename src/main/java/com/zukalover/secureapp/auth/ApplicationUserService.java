package com.zukalover.secureapp.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ApplicationUserService implements UserDetailsService{

	@Autowired
	private final ApplicationRepoService applicationUserRepository;
	
	public ApplicationUserService(@Qualifier("fake")ApplicationRepoService applicationUserRepository)
	{
		this.applicationUserRepository = applicationUserRepository;
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return applicationUserRepository.selectApplicationUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}

}
