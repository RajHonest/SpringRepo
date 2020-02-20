package com.airport.mgmt.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.airport.mgmt.controller.UserController;
import com.airport.mgmt.dao.PlaneDao;
import com.airport.mgmt.form.User;
import com.airport.mgmt.service.UserService;

public class AuthUserDetailsService implements UserDetailsService{
	
    //@Autowired
    private UserService userService;

    private static Logger log = Logger.getLogger(AuthUserDetailsService.class);
    
    public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	log.info("Inside userauth");
        User user = userService.getUserByName(username);
        log.info("user:"+user);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
       // for (Role role : user.getRoles()){
          //  grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        //}
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }

}
