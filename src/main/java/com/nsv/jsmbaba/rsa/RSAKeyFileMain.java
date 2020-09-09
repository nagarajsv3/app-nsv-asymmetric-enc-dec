package com.nsv.jsmbaba.rsa;

import org.apache.commons.codec.binary.Base64;

import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAKeyFileMain {

    public static void main(String[] args) throws Exception {

        PrivateKey privateKey = RSAUtils.getPrivateKeyFromFile("keypair/privatekey");
        PublicKey publicKey = RSAUtils.getPublicKeyFromFile("keypair/publickey");

        String message = "Hi. Welcome to RSA";

        byte[] encryptedData = RSAUtils.encrypt(message, publicKey);
        String decrypt = RSAUtils.decrypt(encryptedData, privateKey);
        System.out.println("Message="+message);
        System.out.println("Encrypted Data="+ Base64.encodeBase64String(encryptedData));
        System.out.println("Decrypted Data="+decrypt);


    }
}
