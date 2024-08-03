package com.rtasalem.utils;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class RsaKeyProperties {
	
	private RSAPublicKey rsaPublicKey;
	private RSAPrivateKey rsaPrivateKey;
	
	public RsaKeyProperties() {
		KeyPair keyPair = KeyGeneratedUtility.generatedRsaKey();
		this.rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
		this.rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
	}

}