package com.callawaygolf.service;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callawaygolf.entity.User;
import com.callawaygolf.repository.UserRepository;
@Service
public class UserService implements UserDetailsService {

	
    @Autowired
	private UserRepository userRepo;
    public UserService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }


	  @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	          User user = userRepo.findByUserName(userName)
	                 .orElseThrow(() ->
	                         new UsernameNotFoundException("User not found with username or email: "+ userName));

	        Set<GrantedAuthority> authorities = user
	                .getRoles()
	                .stream()
	                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

	        return new org.springframework.security.core.userdetails.User(user.getUserName(),
	                user.getPassword(),
	                authorities);
		
	    }
}
