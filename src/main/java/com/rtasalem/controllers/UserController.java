package com.rtasalem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    /**
     * Handles GET requests to the "/user/" endpoint.
     *
     * This method responds with a simple message indicating that the
     * access level is "User". It serves as a basic check to verify that
     * the user endpoint is accessible and functioning correctly.
     *
     * @return A {@link String} message stating "Access level: User".
     */
    @GetMapping("/")
    public String welcomeUserController() {
        return "Access level: User";
    }

}
