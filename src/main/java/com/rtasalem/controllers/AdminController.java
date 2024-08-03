package com.rtasalem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

	@Operation(summary = "Welcome message for admin(s).", description = "Returns a welcome message indicating the access level is Admin.", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "401", description = "Unauthorised")
	})
	@GetMapping("/")
	public String welcomeAdminController() {
		return "Access level: Admin";
	}

}
