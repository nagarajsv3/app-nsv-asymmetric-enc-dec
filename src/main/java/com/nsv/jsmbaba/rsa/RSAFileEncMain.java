package com.nsv.jsmbaba.rsa;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAFileEncMain {

    public static void main(String[] args) throws Exception {
        PrivateKey privateKey = RSAUtils.getPrivateKeyFromFile("keypair/privatekey");
        PublicKey publicKey = RSAUtils.getPublicKeyFromFile("keypair/publickey");
        String message = "Hi. Welcome to RSA";


        if (new File("keypair/hi.txt").exists()) {
            RSAUtils.encryptFile(RSAUtils.getFileInBytes(new File("keypair/hi.txt")),
                    new File("keypair/text_encrypted.txt"),publicKey);
            RSAUtils.decryptFile(RSAUtils.getFileInBytes(new File("keypair/text_encrypted.txt")),
                    new File("keypair/text_decrypted.txt"), privateKey);
        } else {
            System.out.println("Create a file hi.txt under folder KeyPair");
        }

    }
}
