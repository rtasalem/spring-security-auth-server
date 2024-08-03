package com.rtasalem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    /**
     * Handles GET requests to the root of the admin path ("/admin/").
     *
     * This method returns a simple message indicating that the access level
     * is admin. It is used for testing or confirming that the admin endpoint
     * is accessible and operational.
     * </p>
     * 
     * @return A {@link String} message stating "Access level: Admin".
     */
    @GetMapping("/")
    public String welcomeAdminController() {
        return "Access level: Admin";
    }

}
