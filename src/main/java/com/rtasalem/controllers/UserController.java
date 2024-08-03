package com.rtasalem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Operation(summary = "Welcome message for user(s).", description = "Returns a welcome message indicating the access level is User.", responses = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/")
    public String welcomeUserController() {
        return "Access level: User";
    }

}
