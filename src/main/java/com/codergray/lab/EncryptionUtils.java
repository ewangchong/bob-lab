/**
 * Copyright Angel.com 2011
 *
 */
package com.codergray.lab;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 *
 * @author amcgrath
 */
public class EncryptionUtils {

    private static final Logger logger = Logger.getLogger(EncryptionUtils.class);
    private static Cipher ecipher;
    private static Cipher dcipher;
    private static int iterationCount = 19;
    // 8-byte Salt
    private static byte[] salt = {
            (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
            (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };

    static {
        try {
            // Create the key
            String passPhrase = "ANGEL";
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance(
                    "PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());

            // Prepare the parameter to the ciphers
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

            // Create the ciphers
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        }
        catch (InvalidKeySpecException e) {
            logger.error(e);
        }
        catch (InvalidAlgorithmParameterException e) {
            logger.error(e);
        }
        catch (InvalidKeyException e) {
            logger.error(e);
        }
        catch (NoSuchAlgorithmException e) {
            logger.error(e);
        }
        catch (NoSuchPaddingException e) {
            logger.error(e);
        }
    }

    public static void main(String[] args){
        System.out.println(EncryptionUtils.sha1Hash("1234QWER"));
    }

    /**
     * Private constructor for protection
     */
    private EncryptionUtils() {
        // this is a private constructor so people don't due stupid things like new EncryptionUtils();
    }

    /**
     * Create a sha1 hash of the passed string
     * @param value
     * @return
     */
    public static String sha1Hash(String value) {
        return DigestUtils.shaHex(value);
    }

    /**
     * DES Encrypt the passed string
     *
     * @param unencryptedString
     * @return
     */
    public static String desEncrypt(String unencryptedString) {
        try {
            // create bytes
            byte[] utf8 = unencryptedString.getBytes("UTF8");
            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);
            // base 64
            return Base64.encodeBase64String(enc);

        }
        catch (UnsupportedEncodingException ex) {
            logger.error(ex);
        }
        catch (IllegalBlockSizeException ex) {
            logger.error(ex);
        }
        catch (BadPaddingException ex) {
            logger.error(ex);
        }
        return null;
    }

    /**
     * DES decrypt the passed string
     *
     * @param encryptedString
     * @return
     */
    public static String desDecrypt(String encryptedString) {
        try {
            // Decode base64 to get bytes
            byte[] dec = Base64.decodeBase64(encryptedString);
            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);
            // Decode using utf-8
            return new String(utf8, "UTF8");
        }
        catch (UnsupportedEncodingException ex) {
            logger.error(ex);
        }
        catch (IllegalBlockSizeException ex) {
            logger.error(ex);
        }
        catch (BadPaddingException ex) {
            logger.error(ex);
        }
        return null;
    }
}
