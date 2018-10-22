package com.codergray.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

public class DESCryptographer {
	// This is the DES algorith with CBC mode and PKCS5 padding mode
	private static final String keyAlgorithm = "DES/CBC/PKCS5Padding";
	private AlgorithmParameterSpec algParamSpec;
	private static Logger logger = Logger.getLogger(DESCryptographer.class.getName());

	public DESCryptographer() {
		// Initialization vector used for AlgorithParameterSpec. Required for
		// CBC mode.
		byte[] initVector = new byte[] { 0x10, 0x10, 0x01, 0x04, 0x01, 0x01, 0x01, 0x02 };
		algParamSpec = new IvParameterSpec(initVector);
	}

	public String encrypt(String plainTextToBeEncrypted) {
		byte[] encBytes;
		try {
			Key key = readKey();
			encBytes = encryptString(plainTextToBeEncrypted.getBytes(), key);
		} catch (BadPaddingException e) {
			logger.warning("Error occured while encrypting the string " + plainTextToBeEncrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntEncrptExcep1");
		} catch (NoSuchAlgorithmException e) {
			logger.warning("Error occured while encrypting the string " + plainTextToBeEncrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntEncrptExcep2");
		} catch (IOException e) {
			logger.warning("Error occured while encrypting the string " + plainTextToBeEncrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntEncrptExcep3");
		} catch (InvalidAlgorithmParameterException e) {
			logger.warning("Error occured while encrypting the string " + plainTextToBeEncrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntEncrptExcep4");
		} catch (IllegalBlockSizeException e) {
			logger.warning("Error occured while encrypting the string " + plainTextToBeEncrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntEncrptExcep5");
		} catch (InvalidKeyException e) {
			logger.warning("Error occured while encrypting the string " + plainTextToBeEncrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntEncrptExcep6");
		} catch (ClassNotFoundException e) {
			logger.warning("Error occured while encrypting the string " + plainTextToBeEncrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntEncrptExcep7");
		} catch (NoSuchPaddingException e) {
			logger.warning("Error occured while encrypting the string " + plainTextToBeEncrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntEncrptExcep8");
		}

		Base64.Encoder enc = Base64.getEncoder();
		return enc.encodeToString(encBytes);
	}

	public String decrypt(String encryptedTextToBeDecrypted) {
		byte[] decBytes;
		try {
			Key key = readKey();
			Base64.Decoder dec = Base64.getDecoder();
			byte[] encryptedBytes = dec.decode(encryptedTextToBeDecrypted);
			decBytes = decryptString(encryptedBytes, key);
		} catch (BadPaddingException e) {
			logger.warning("Error occured while decrypting the string " + encryptedTextToBeDecrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntDecrptExcep1");
		} catch (NoSuchAlgorithmException e) {
			logger.warning("Error occured while decrypting the string " + encryptedTextToBeDecrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntDecrptExcep2");
		} catch (IOException e) {
			logger.warning("Error occured while decrypting the string " + encryptedTextToBeDecrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntDecrptExcep3");
		} catch (InvalidAlgorithmParameterException e) {
			logger.warning("Error occured while decrypting the string " + encryptedTextToBeDecrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntDecrptExcep4");
		} catch (IllegalBlockSizeException e) {
			logger.warning("Error occured while decrypting the string " + encryptedTextToBeDecrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntDecrptExcep5");
		} catch (InvalidKeyException e) {
			logger.warning("Error occured while decrypting the string " + encryptedTextToBeDecrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntDecrptExcep6");
		} catch (ClassNotFoundException e) {
			logger.warning("Error occured while decrypting the string " + encryptedTextToBeDecrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntDecrptExcep7");
		} catch (NoSuchPaddingException e) {
			logger.warning("Error occured while decrypting the string " + encryptedTextToBeDecrypted);
			// This method cannot throw any exception by contract. but we dont
			// want client to proceed if there is any exception.
			// so we are throwing the runtime exception
			throw new NullPointerException("com.mstr.security.DESCryptographer.notNPntDecrptExcep8");
		}

		return new String(decBytes);
	}

	private Key readKey() throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			InvalidKeyException, IOException, ClassNotFoundException, InvalidAlgorithmParameterException {
		String keyLocation = "/Users/cwang/hgRepo/angel_config/src/main/resources/config/key.dat";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(keyLocation));
		Key readKey = (Key) ois.readObject();
		ois.close();
		return readKey;
	}

	private byte[] decryptString(byte[] encryptedBytes, Key key)
			throws InvalidAlgorithmParameterException, InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance(keyAlgorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, algParamSpec);
		return cipher.doFinal(encryptedBytes);
	}

	private byte[] encryptString(byte[] bytes, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance(keyAlgorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, algParamSpec);
		return cipher.doFinal(bytes);
	}

	public static void main(String[] args) {
		DESCryptographer crypt = new DESCryptographer();
		System.out.println(crypt.encrypt("Genesys123"));
		System.out.println(crypt.decrypt("VL03AfUU5cxCPpMHywUNrQ=="));
	}
}
