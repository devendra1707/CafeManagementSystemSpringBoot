package com.cms.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cms.doa.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerUsersDetailsService implements UserDetailsService {

	@Autowired
	UserDAO userDao;

	private com.cms.model.User userDetails;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Inside loadUserByUsername {}", username);
		userDetails = userDao.findByEmailId(username);
		if (!Objects.isNull(userDetails))
			return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
		else
			throw new UsernameNotFoundException("User Not Found.");
	}

	public com.cms.model.User getUserDetail() {

		com.cms.model.User user = userDetails;
		user.setPassword(null);
		return userDetails;

	}

}
