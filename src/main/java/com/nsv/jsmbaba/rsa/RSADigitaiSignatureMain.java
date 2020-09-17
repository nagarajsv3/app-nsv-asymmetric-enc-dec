package com.nsv.jsmbaba.rsa;


import com.nimbusds.jose.crypto.bc.BouncyCastleProviderSingleton;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

public class RSADigitaiSignatureMain {

    public static void main(String[] args) throws Exception {

        String publicKeyString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9NDJyC/NyxIli5sPQxHyUGJRd9eTYoGUQNFJfkL/bb2LOffb/R0nangwUbnDMjfdsW8vEgXnEQq/Bap3Xz8LZP/uN2aS3iw2oMSWADXLiWt1Qk5PEREquOaihBIFfK9iC5RDzSPOgff37wMYD3UEGAuSb+s8hq/tD/Q0NDB9KCjjmz7GbsTrab6P4pyWPPBJqA01I0834tJ03VIaeyl44F0sKrLxJhLxgwKhL6R/myJT6Zte8MX+hNp6gGzKF0970j+bvq/X5HSihQUI1zVQ7cGUfPzidRD78u/T2Lfl3LTb2F7vZewwbyFlxalWnZqopiC7fD+64ECIjWpQiL6fJQIDAQAB";
        String privateKeyStriing = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQD00MnIL83LEiWLmw9DEfJQYlF315NigZRA0Ul+Qv9tvYs599v9HSdqeDBRucMyN92xby8SBecRCr8FqndfPwtk/+43ZpLeLDagxJYANcuJa3VCTk8RESq45qKEEgV8r2ILlEPNI86B9/fvAxgPdQQYC5Jv6zyGr+0P9DQ0MH0oKOObPsZuxOtpvo/inJY88EmoDTUjTzfi0nTdUhp7KXjgXSwqsvEmEvGDAqEvpH+bIlPpm17wxf6E2nqAbMoXT3vSP5u+r9fkdKKFBQjXNVDtwZR8/OJ1EPvy79PYt+XctNvYXu9l7DBvIWXFqVadmqimILt8P7rgQIiNalCIvp8lAgMBAAECggEAOKRR+1IsIA7bxvgiSNdPJBALX1nuTL1EStbhVSg1JvPS0Z+qM17absTOESqUofrQ/SuHTXk2I/hDiBEPu2a/wSeBuymtU2ARZ5L0TaokpG/LWoL5wi4hn1QlR79Pq7B8U8eDBGSDdAimQZOKrpDZWKLcx646e8MaazWKGoUZf/+6BDp3qQOdlB6uulT2l5eBIS5sKXBUAan1L4GogRzY8oVIAjFWAl/Z+Yvno33n+H6NrkglunI/ZGc56t4F8D+KAEw6ZFlOqQZ8V6tFvM1AcJldProx6UcarkrCG6o8JqnT+wY06cFYvf4deErhhCAUv5kdjlInDN3kqt2Xiu7soQKBgQD/DGn7aGBatRzIeBF866bIdqrWmj4+VtHQ3rYk3Xg1a7BfQHmYXtjv8MlPS3jEU6X7dMXZe6Khd/9Z8n1Ee+foJZjYud4T+tNltszTdJzs/VO7LoM/1PV00dZ08i8wuWoTB3ASrGMUsXzBZhS/Gxwv06A60CQbY8QCbQsFrrfaiQKBgQD1upnoBa3YYRbmeyUO39STiIr8BjaVQsOGpMsQOk/dAJUNwVxgQysknS7iCIuAjX3UC1Ej1DDjwBPdvvt6fko2dwsamWE4wXICTXmKJ4m7T/DQgkPvloSCIAuAujFkCF0gJ8tBr9tsJlaZoPaRe3o4MuP1fychjdw1er5fJz4IvQKBgEgB8j4n1uRlM+4pcA6L3bfFQTB7tc0V6AEHj/dSi+jRMaeC5ZGuXaNIoR2BGmSblUYsTtu7O0xJO8/iVZmrPeteCgxOVbPgYiTaenPM/a0vTJ+RXz77Wh2UTO8RnV8tShR7ShoLj6G9BpL3xi26crfSEO/p6ffNr/5bWPxOutu5AoGBAJxthbxmoRy18dYXXqfxZWnl6lQ1wFmUftQf5AUYme6eiESRazT8jWJpjYbm2aekaw2phqXAVr8lb4AiLAT2kFfLwI3WRkXTH7jHiS+hq9RKN4sE4iqLLx+HNstjvD1p9Z6atpHCWXSnk0mJZm2GpW9RNjz6DPcXT6/by4TXfm4hAoGAK88eyEDHEM9oqrp/zHiK0r3spPg5GgR+30SKkQoG6KAWja3bO/kyz6IthAhNy2Jr9wgs1+MApw2BERvaIVU7/aGqXhazjT8Z8vYQbpipbj0H3hj5lC7anW+flxyXbEcLxNhk84INwPvwg3PGbLkNxuFmb1mtxG1CnRFf3dvaoUM=";

/*


        // RSA signatures require a public and private RSA key pair,
// the public key must be made known to the JWS recipient to
// allow the signatures to be verified
        RSAKey rsaJWK = new RSAKeyGenerator(2048)
                .keyID("123")
                .generate();
        RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();

// Create RSA-signer with the private key
        JWSSigner signer = new RSASSASigner(rsaJWK);

// Prepare JWS object with simple string as payload
        JWSObject jwsObject = new JWSObject(
                new JWSHeader.Builder(JWSAlgorithm.PS256).keyID(rsaJWK.getKeyID()).build(),
                new Payload("In RSA we trust!"));

// Compute the RSA signature
        jwsObject.sign(signer);

// To serialize to compact form, produces something like
// eyJhbGciOiJSUzI1NiJ9.SW4gUlNBIHdlIHRydXN0IQ.IRMQENi4nJyp4er2L
// mZq3ivwoAjqa1uUkSBKFIX7ATndFF5ivnt-m8uApHO4kfIFOrW7w2Ezmlg3Qd
// maXlS9DhN0nUk_hGI3amEjkKd0BWYCB8vfUbUv0XGjQip78AI4z1PrFRNidm7
// -jPDm5Iq0SZnjKjCNS5Q15fokXZc8u0A
        String s = jwsObject.serialize();

// To parse the JWS and verify it, e.g. on client-side
        jwsObject = JWSObject.parse(s);

        JWSVerifier verifier = new RSASSAVerifier(rsaPublicJWK);

        System.out.println("++++"+jwsObject.verify(verifier));

        System.out.println("))))"+jwsObject.getPayload().toString());
*/



        String message = "JSMBABA - Welcome to RSA Encryption Decryption";
        System.out.println("Original Message=\n"+message);
        System.out.println("\n*******************************************************");

        PrivateKey privateKey = RSAUtils.getPrivateKey(privateKeyStriing);
        String algo = "RSA-OAEP-256"; // "PS256";

        Security.addProvider(new BouncyCastleProvider());
        byte[] signature = signPS256(algo, message, privateKey);

        System.out.println("Signature"+signature.toString());

        PublicKey publicKey = RSAUtils.getPublicKey(publicKeyString);

        boolean isCorrect = verifyPS256(algo, message, publicKey, signature);
        System.out.println("Signature Verified="+isCorrect);


    }

    //The method that signs the data using the private key that is stored in keyFile path
    public static byte[] sign(String algo, String data, PrivateKey privateKey) throws InvalidKeyException, Exception{
        //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        //Signature rsa = java.security.Signature.getInstance("SHA256withRSAandMGF1");
        Signature rsa = java.security.Signature.getInstance(algo);
        rsa.initSign(privateKey);
        rsa.update(data.getBytes());
        return rsa.sign();
    }

    //The method that signs the data using the private key that is stored in keyFile path
    public static byte[] signPS256(String algo, String data, PrivateKey privateKey) throws InvalidKeyException, Exception{
        //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        //Signature rsa = java.security.Signature.getInstance("SHA256withRSAandMGF1");
        Signature rsa= Signature.getInstance("SHA256withRSA/PSS");
        rsa.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
        rsa.initSign(privateKey);
        rsa.update(data.getBytes());
        return rsa.sign();
    }


    public static boolean verify(String algo, String receivedMessage , PublicKey publicKey, byte[] receivedSignature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature rsa = java.security.Signature.getInstance(algo);
        rsa.initVerify(publicKey);
        byte[] messageBytes = receivedMessage.getBytes();

        rsa.update(messageBytes);
        return rsa.verify(receivedSignature);

    }


    public static boolean verifyPS256(String algo, String receivedMessage , PublicKey publicKey, byte[] receivedSignature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidAlgorithmParameterException {
        Signature rsa= Signature.getInstance("SHA256withRSA/PSS");
        rsa.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
        rsa.initVerify(publicKey);
        byte[] messageBytes = receivedMessage.getBytes();

        rsa.update(messageBytes);
        return rsa.verify(receivedSignature);

    }

}
