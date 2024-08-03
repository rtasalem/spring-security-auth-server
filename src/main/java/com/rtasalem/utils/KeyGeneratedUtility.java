package com.rtasalem.utils;

import java.nio.channels.IllegalSelectorException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratedUtility {

	public static KeyPair generatedRsaKey() {

		KeyPair keyPair;

		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			keyPair = keyPairGenerator.generateKeyPair();
		} catch (Exception e) {
			throw new IllegalSelectorException();
		}

		return keyPair;
	}

}
