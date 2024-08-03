package com.rtasalem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtasalem.models.LoginResponseDTO;
import com.rtasalem.models.RegistrationDTO;
import com.rtasalem.models.User;
import com.rtasalem.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * Handles POST requests to the "/auth/register" endpoint.
	 *
	 * This method accepts a {@link RegistrationDTO} object containing
	 * user registration details, such as username and password. It then
	 * invokes the {@link AuthenticationService#registerUser(String, String)}
	 * method to register the new user and returns a {@link User} object
	 * representing
	 * the registered user.
	 * 
	 * @param body The {@link RegistrationDTO} object containing user registration
	 *             details.
	 * @return The {@link User} object representing the newly registered user.
	 */
	@PostMapping("/register")
	public User registerUser(@RequestBody RegistrationDTO body) {
		return authenticationService.registerUser(body.getUsername(), body.getPassword());
	}

	/**
	 * Handles POST requests to the "/auth/login" endpoint.
	 *
	 * This method accepts a {@link RegistrationDTO} object containing
	 * user login credentials, such as username and password. It then
	 * invokes the {@link AuthenticationService#loginUser(String, String)}
	 * method to authenticate the user and returns a {@link LoginResponseDTO}
	 * object containing the authentication response, which typically includes
	 * authentication tokens or status information.
	 *
	 * @param body The {@link RegistrationDTO} object containing user login
	 *             credentials.
	 * @return The {@link LoginResponseDTO} object containing the result of the
	 *         login attempt.
	 */
	@PostMapping("/login")
	public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
		return authenticationService.loginUser(body.getUsername(), body.getPassword());
	}

}
