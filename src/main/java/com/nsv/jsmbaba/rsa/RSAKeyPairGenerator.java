package com.nsv.jsmbaba.rsa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

@Getter
@Setter
@ToString
public class RSAKeyPairGenerator {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
        keyPairGenerator.writeToFile("C:\\Users\\JSMBABA\\IdeaProjects\\Appi\\app-nsv-asymmetric-enc-dec\\src\\main\\resources\\qa\\publicKey", keyPairGenerator.getPublicKey().getEncoded());
        keyPairGenerator.writeToFile("C:\\Users\\JSMBABA\\IdeaProjects\\Appi\\app-nsv-asymmetric-enc-dec\\src\\main\\resources\\qa\\privateKey", keyPairGenerator.getPrivateKey().getEncoded());
        System.out.println("Public Key=\n"+keyPairGenerator.getPublicKey());
        System.out.println("\n**************************************************************************************");
        System.out.println("Private Key=\n"+keyPairGenerator.getPrivateKey());
        System.out.println("\n**************************************************************************************");
        System.out.println("Public Key Encoded=\n"+Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
        System.out.println("\n**************************************************************************************");
        System.out.println("Private Key Encoded=\n"+Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
        System.out.println("\n**************************************************************************************");

    }



}
