package com.app.GestionCv.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.GestionCv.model.User;
import com.app.GestionCv.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	List<User> getAllUsers();
	User save(UserRegistrationDto registrationDto);
	User findByEmail(String email);
	User getUserConnected();
}
