package com.rtasalem;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rtasalem.models.Role;
import com.rtasalem.models.User;
import com.rtasalem.repository.RoleRepository;
import com.rtasalem.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthServerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			
			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;
			
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			
			User admin = new User(1, "admin", passwordEncoder.encode("password"), roles);
			userRepository.save(admin);
		};
		
	}

}
