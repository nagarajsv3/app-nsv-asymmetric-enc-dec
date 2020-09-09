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
public class KeyPairGenerator {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public KeyPairGenerator(int length) throws NoSuchAlgorithmException {
        java.security.KeyPairGenerator keyGen = java.security.KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(length);
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
        KeyPairGenerator keyPairGenerator = new KeyPairGenerator(2048);
        keyPairGenerator.writeToFile("C:\\Users\\JSMBABA\\IdeaProjects\\Appi\\app-nsv-asymmetric-enc-dec\\src\\main\\resources\\qa\\2048\\publicKey", keyPairGenerator.getPublicKey().getEncoded());
        keyPairGenerator.writeToFile("C:\\Users\\JSMBABA\\IdeaProjects\\Appi\\app-nsv-asymmetric-enc-dec\\src\\main\\resources\\qa\\2048\\privateKey", keyPairGenerator.getPrivateKey().getEncoded());
        //keyPairGenerator.writeToFile("keypair2/publicKey", keyPairGenerator.getPublicKey().getEncoded());
        //keyPairGenerator.writeToFile("keypair2/privateKey", keyPairGenerator.getPrivateKey().getEncoded());

        System.out.println("Public Key=\n"+keyPairGenerator.getPublicKey());
        System.out.println("\n**************************************************************************************");
        System.out.println("Private Key=\n"+keyPairGenerator.getPrivateKey());
        System.out.println("\n**************************************************************************************");
        System.out.println("Public Key=\n"+keyPairGenerator.getPublicKey().toString());
        System.out.println("Public Key Encoded=\n"+keyPairGenerator.getPublicKey().getEncoded());
        System.out.println("Public Key Encoded String=\n"+keyPairGenerator.getPublicKey().getEncoded().toString());
        System.out.println("Public Key Encoded Base64 Encoded=\n"+Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
        System.out.println("\n**************************************************************************************");
        System.out.println("Private Key Encoded=\n"+keyPairGenerator.getPrivateKey().getEncoded().toString());
        System.out.println("Private Key Encoded=\n"+Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
        System.out.println("\n**************************************************************************************");

    }



}
