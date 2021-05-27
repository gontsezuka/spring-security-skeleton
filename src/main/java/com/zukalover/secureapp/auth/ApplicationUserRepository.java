package com.zukalover.secureapp.auth;

import java.util.Optional;

import org.springframework.stereotype.Repository;


public interface ApplicationUserRepository {

	Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
