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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Operation(summary = "Register a new user", description = "Registers a new user with the provided username and password.", responses = {
			@ApiResponse(responseCode = "201", description = "User successfully registered", content = @Content(schema = @Schema(implementation = User.class)))
	})
	@PostMapping("/register")
	public User registerUser(@RequestBody RegistrationDTO body) {
		return authenticationService.registerUser(body.getUsername(), body.getPassword());
	}

	@Operation(summary = "Login a user", description = "Logs in a user and returns a token and user details.", responses = {
			@ApiResponse(responseCode = "200", description = "User successfully logged in", content = @Content(schema = @Schema(implementation = LoginResponseDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized due to invalid credentials")
	})
	@PostMapping("/login")
	public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
		return authenticationService.loginUser(body.getUsername(), body.getPassword());
	}

}
