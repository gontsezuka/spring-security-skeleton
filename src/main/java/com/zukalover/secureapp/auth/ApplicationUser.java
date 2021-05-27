package com.zukalover.secureapp.auth;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUser implements UserDetails {

	/**
	 * I WILL USE THIS CLASS INSTEAD OF USING BUILDER FROM 
	 * APPLICATION SECURITY FILE
	 */
	private final Set<? extends GrantedAuthority> grantedAuthorities;
	private final String password;
	private final String username;
	private final boolean isAccountNonExpired;
	private final boolean isAccountNonLocked;
	private final boolean isEnabled;
	private final boolean isCredentialsNonExpired;

	
	
	
	public ApplicationUser(Set<? extends GrantedAuthority> grantedAuthorities, String password, String username,
			boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isEnabled,
			boolean isCredentialsNonExpired) {
		
		this.grantedAuthorities = grantedAuthorities;
		this.password = password;
		this.username = username;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isEnabled = isEnabled;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isAccountNonLocked;
	}

	

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return isCredentialsNonExpired;
	}
	
	

}
