package com.nsv.jsmbaba.rsa;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static com.nsv.jsmbaba.rsa.RSAUtils.encrypt;

public class RSAMain {

    public static void main(String[] args) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {

        //String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgFGVfrY4jQSoZQWWygZ83roKXWD4YeT2x2p41dGkPixe73rT2IW04glagN2vgoZoHuOPqa5and6kAmK2ujmCHu6D1auJhE2tXP+yLkpSiYMQucDKmCsWMnW9XlC5K7OSL77TXXcfvTvyZcjObEz6LIBRzs6+FqpFbUO9SJEfh6wIDAQAB";
        //String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKAUZV+tjiNBKhlBZbKBnzeugpdYPhh5PbHanjV0aQ+LF7vetPYhbTiCVqA3a+Chmge44+prlqd3qQCYra6OYIe7oPVq4mETa1c/7IuSlKJgxC5wMqYKxYydb1eULkrs5IvvtNddx+9O/JlyM5sTPosgFHOzr4WqkVtQ71IkR+HrAgMBAAECgYAkQLo8kteP0GAyXAcmCAkA2Tql/8wASuTX9ITD4lsws/VqDKO64hMUKyBnJGX/91kkypCDNF5oCsdxZSJgV8owViYWZPnbvEcNqLtqgs7nj1UHuX9S5yYIPGN/mHL6OJJ7sosOd6rqdpg6JRRkAKUV+tmN/7Gh0+GFXM+ug6mgwQJBAO9/+CWpCAVoGxCA+YsTMb82fTOmGYMkZOAfQsvIV2v6DC8eJrSa+c0yCOTa3tirlCkhBfB08f8U2iEPS+Gu3bECQQCrG7O0gYmFL2RX1O+37ovyyHTbst4s4xbLW4jLzbSoimL235lCdIC+fllEEP96wPAiqo6dzmdH8KsGmVozsVRbAkB0ME8AZjp/9Pt8TDXD5LHzo8mlruUdnCBcIo5TMoRG2+3hRe1dHPonNCjgbdZCoyqjsWOiPfnQ2Brigvs7J4xhAkBGRiZUKC92x7QKbqXVgN9xYuq7oIanIM0nz/wq190uq0dh5Qtow7hshC/dSK3kmIEHe8z++tpoLWvQVgM538apAkBoSNfaTkDZhFavuiVl6L8cWCoDcJBItip8wKQhXwHp0O3HLg10OEd14M58ooNfpgt+8D8/8/2OOFaR0HzA+2Dm";

        //String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdyKJYO0D14baR1zXSY5HNQMK18EjFJGL/GtyeO8DheAGWmVqSaEGneJsoXbeoW+6TAONx3FlJpXJnH6a+hZZOIIajhYk4/2oEyMVR0hB2dfdtq8iP4rmU5UwS7fP0NDm/qKkIj1SQVwN4mT54EFTddTnA/JLNcFlSyRTGioy1mwIDAQAB";
        //String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ3Iolg7QPXhtpHXNdJjkc1AwrXwSMUkYv8a3J47wOF4AZaZWpJoQad4myhdt6hb7pMA43HcWUmlcmcfpr6Flk4ghqOFiTj/agTIxVHSEHZ1922ryI/iuZTlTBLt8/Q0Ob+oqQiPVJBXA3iZPngQVN11OcD8ks1wWVLJFMaKjLWbAgMBAAECgYEAgnmQ1glZtHpL8NnYJfw0a1isKqtiYbOvMWlTGn4rB8em+JQjs4IHGKfBFmY5Iz2yUVmgu10NcLshmWkxB8eL/AevW+j/um3mGHJ+VxP0kGJ8TV3mrTzKe3rNM3CIs06jVQgEhKloz3FklcxFqyxy3pD/Y1CWCr+n02rmPnrEzdECQQD265fgr9+Y6x4GwPk2ho0vBrNQaDIvUMA2YTu/n7iiBuBQJ0BuNE7o+5YrgRBfV3tXDuzQhYbV7Mrrnkpt0Fl9AkEAo5XyGwVDm04TKwD3RxHoL4kZPNUTV3x6+3VGM0T5xagNRfasR0Spka+I8AFMNToPXhIX+imVccJPL5Ubcx429wJAJ61V22oHcQge7BDoOuXGHA9kkwAbSFUefd6D/lfJEGgwdVDJXqwTHgcHa3gyzE8/Z47jaOJ79zY0qUXnSdwX9QJAII+3OkOo+l/nFtdBYUciNVwPxvkOuYpQnH7yc0AWi45w3e1Ey4bSTepn0oYfmjStXGczmJrwYU1xH6KJbTelbwJASRywcpZxI86B4//Cz2F294dDtx3re+PtWUz4eE0FFjV0BuBbNGu89g9+FK9RB1Uosh+AUQHOwvYWm3DVwcRIaA==";

        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9NDJyC/NyxIli5sPQxHyUGJRd9eTYoGUQNFJfkL/bb2LOffb/R0nangwUbnDMjfdsW8vEgXnEQq/Bap3Xz8LZP/uN2aS3iw2oMSWADXLiWt1Qk5PEREquOaihBIFfK9iC5RDzSPOgff37wMYD3UEGAuSb+s8hq/tD/Q0NDB9KCjjmz7GbsTrab6P4pyWPPBJqA01I0834tJ03VIaeyl44F0sKrLxJhLxgwKhL6R/myJT6Zte8MX+hNp6gGzKF0970j+bvq/X5HSihQUI1zVQ7cGUfPzidRD78u/T2Lfl3LTb2F7vZewwbyFlxalWnZqopiC7fD+64ECIjWpQiL6fJQIDAQAB";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQD00MnIL83LEiWLmw9DEfJQYlF315NigZRA0Ul+Qv9tvYs599v9HSdqeDBRucMyN92xby8SBecRCr8FqndfPwtk/+43ZpLeLDagxJYANcuJa3VCTk8RESq45qKEEgV8r2ILlEPNI86B9/fvAxgPdQQYC5Jv6zyGr+0P9DQ0MH0oKOObPsZuxOtpvo/inJY88EmoDTUjTzfi0nTdUhp7KXjgXSwqsvEmEvGDAqEvpH+bIlPpm17wxf6E2nqAbMoXT3vSP5u+r9fkdKKFBQjXNVDtwZR8/OJ1EPvy79PYt+XctNvYXu9l7DBvIWXFqVadmqimILt8P7rgQIiNalCIvp8lAgMBAAECggEAOKRR+1IsIA7bxvgiSNdPJBALX1nuTL1EStbhVSg1JvPS0Z+qM17absTOESqUofrQ/SuHTXk2I/hDiBEPu2a/wSeBuymtU2ARZ5L0TaokpG/LWoL5wi4hn1QlR79Pq7B8U8eDBGSDdAimQZOKrpDZWKLcx646e8MaazWKGoUZf/+6BDp3qQOdlB6uulT2l5eBIS5sKXBUAan1L4GogRzY8oVIAjFWAl/Z+Yvno33n+H6NrkglunI/ZGc56t4F8D+KAEw6ZFlOqQZ8V6tFvM1AcJldProx6UcarkrCG6o8JqnT+wY06cFYvf4deErhhCAUv5kdjlInDN3kqt2Xiu7soQKBgQD/DGn7aGBatRzIeBF866bIdqrWmj4+VtHQ3rYk3Xg1a7BfQHmYXtjv8MlPS3jEU6X7dMXZe6Khd/9Z8n1Ee+foJZjYud4T+tNltszTdJzs/VO7LoM/1PV00dZ08i8wuWoTB3ASrGMUsXzBZhS/Gxwv06A60CQbY8QCbQsFrrfaiQKBgQD1upnoBa3YYRbmeyUO39STiIr8BjaVQsOGpMsQOk/dAJUNwVxgQysknS7iCIuAjX3UC1Ej1DDjwBPdvvt6fko2dwsamWE4wXICTXmKJ4m7T/DQgkPvloSCIAuAujFkCF0gJ8tBr9tsJlaZoPaRe3o4MuP1fychjdw1er5fJz4IvQKBgEgB8j4n1uRlM+4pcA6L3bfFQTB7tc0V6AEHj/dSi+jRMaeC5ZGuXaNIoR2BGmSblUYsTtu7O0xJO8/iVZmrPeteCgxOVbPgYiTaenPM/a0vTJ+RXz77Wh2UTO8RnV8tShR7ShoLj6G9BpL3xi26crfSEO/p6ffNr/5bWPxOutu5AoGBAJxthbxmoRy18dYXXqfxZWnl6lQ1wFmUftQf5AUYme6eiESRazT8jWJpjYbm2aekaw2phqXAVr8lb4AiLAT2kFfLwI3WRkXTH7jHiS+hq9RKN4sE4iqLLx+HNstjvD1p9Z6atpHCWXSnk0mJZm2GpW9RNjz6DPcXT6/by4TXfm4hAoGAK88eyEDHEM9oqrp/zHiK0r3spPg5GgR+30SKkQoG6KAWja3bO/kyz6IthAhNy2Jr9wgs1+MApw2BERvaIVU7/aGqXhazjT8Z8vYQbpipbj0H3hj5lC7anW+flxyXbEcLxNhk84INwPvwg3PGbLkNxuFmb1mtxG1CnRFf3dvaoUM=";

        String message = "JSMBABA - Welcome to RSA Encryption Decryption";
        System.out.println("Original Message=\n"+message);
        System.out.println("\n*******************************************************");

        try {
            byte[] encryptedBytes = RSAUtils.encrypt(message, publicKey);
            String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Cipher Text; Plain=\n"+encryptedBytes.toString());
            System.out.println("Cipher Text; Base64Encoded=\n"+encryptedString);
            System.out.println("\n*******************************************************");
            String decryptedString = RSAUtils.decrypt(encryptedString, privateKey);
            System.out.println("Decrypted  Message=\n"+decryptedString);
            System.out.println("\n*******************************************************");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }

    }


/*
    private static byte[] readPublicKey() {
        String fileName = "qa/publickey";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try {
            String data = new String(Files.readAllBytes(file.toPath()));

            return data.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
*/


/*    private static String readPrivateKey() {
        String fileName = "qa/privatekey";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try {
            String data = new String(Files.readAllBytes(file.toPath()));
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }*/
}
