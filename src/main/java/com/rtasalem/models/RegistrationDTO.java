package com.rtasalem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
	
	private String username;
	
	private String password;

	public String toString() {
		return "Registration info:\n username: " +this.username + "\n password: " + this.password;
	}
	
}
