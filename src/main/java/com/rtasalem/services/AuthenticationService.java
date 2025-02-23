package com.rtasalem.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rtasalem.models.LoginResponseDTO;
import com.rtasalem.models.Role;
import com.rtasalem.models.User;
import com.rtasalem.repository.RoleRepository;
import com.rtasalem.repository.UserRepository;

@Service
@Transactional
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	public User registerUser(String username, String password) {

		String encodedPassword = passwordEncoder.encode(password);
		Role userRole = roleRepository.findByAuthority("USER").get();

		Set<Role> authorities = new HashSet<>();

		authorities.add(userRole);

		return userRepository.save(new User(0, username, encodedPassword, authorities));
	}

	public LoginResponseDTO loginUser(String username, String password) {

		try {
			Authentication auth = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));

			String token = tokenService.generateJwt(auth);

			return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);

		} catch (AuthenticationException e) {
			return new LoginResponseDTO(null, "");
		}
	}

}