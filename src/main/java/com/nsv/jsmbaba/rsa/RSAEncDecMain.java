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

public class RSAEncDecMain {

    public static void main(String[] args) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {

        //String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgFGVfrY4jQSoZQWWygZ83roKXWD4YeT2x2p41dGkPixe73rT2IW04glagN2vgoZoHuOPqa5and6kAmK2ujmCHu6D1auJhE2tXP+yLkpSiYMQucDKmCsWMnW9XlC5K7OSL77TXXcfvTvyZcjObEz6LIBRzs6+FqpFbUO9SJEfh6wIDAQAB";
        //String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKAUZV+tjiNBKhlBZbKBnzeugpdYPhh5PbHanjV0aQ+LF7vetPYhbTiCVqA3a+Chmge44+prlqd3qQCYra6OYIe7oPVq4mETa1c/7IuSlKJgxC5wMqYKxYydb1eULkrs5IvvtNddx+9O/JlyM5sTPosgFHOzr4WqkVtQ71IkR+HrAgMBAAECgYAkQLo8kteP0GAyXAcmCAkA2Tql/8wASuTX9ITD4lsws/VqDKO64hMUKyBnJGX/91kkypCDNF5oCsdxZSJgV8owViYWZPnbvEcNqLtqgs7nj1UHuX9S5yYIPGN/mHL6OJJ7sosOd6rqdpg6JRRkAKUV+tmN/7Gh0+GFXM+ug6mgwQJBAO9/+CWpCAVoGxCA+YsTMb82fTOmGYMkZOAfQsvIV2v6DC8eJrSa+c0yCOTa3tirlCkhBfB08f8U2iEPS+Gu3bECQQCrG7O0gYmFL2RX1O+37ovyyHTbst4s4xbLW4jLzbSoimL235lCdIC+fllEEP96wPAiqo6dzmdH8KsGmVozsVRbAkB0ME8AZjp/9Pt8TDXD5LHzo8mlruUdnCBcIo5TMoRG2+3hRe1dHPonNCjgbdZCoyqjsWOiPfnQ2Brigvs7J4xhAkBGRiZUKC92x7QKbqXVgN9xYuq7oIanIM0nz/wq190uq0dh5Qtow7hshC/dSK3kmIEHe8z++tpoLWvQVgM538apAkBoSNfaTkDZhFavuiVl6L8cWCoDcJBItip8wKQhXwHp0O3HLg10OEd14M58ooNfpgt+8D8/8/2OOFaR0HzA+2Dm";

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdyKJYO0D14baR1zXSY5HNQMK18EjFJGL/GtyeO8DheAGWmVqSaEGneJsoXbeoW+6TAONx3FlJpXJnH6a+hZZOIIajhYk4/2oEyMVR0hB2dfdtq8iP4rmU5UwS7fP0NDm/qKkIj1SQVwN4mT54EFTddTnA/JLNcFlSyRTGioy1mwIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ3Iolg7QPXhtpHXNdJjkc1AwrXwSMUkYv8a3J47wOF4AZaZWpJoQad4myhdt6hb7pMA43HcWUmlcmcfpr6Flk4ghqOFiTj/agTIxVHSEHZ1922ryI/iuZTlTBLt8/Q0Ob+oqQiPVJBXA3iZPngQVN11OcD8ks1wWVLJFMaKjLWbAgMBAAECgYEAgnmQ1glZtHpL8NnYJfw0a1isKqtiYbOvMWlTGn4rB8em+JQjs4IHGKfBFmY5Iz2yUVmgu10NcLshmWkxB8eL/AevW+j/um3mGHJ+VxP0kGJ8TV3mrTzKe3rNM3CIs06jVQgEhKloz3FklcxFqyxy3pD/Y1CWCr+n02rmPnrEzdECQQD265fgr9+Y6x4GwPk2ho0vBrNQaDIvUMA2YTu/n7iiBuBQJ0BuNE7o+5YrgRBfV3tXDuzQhYbV7Mrrnkpt0Fl9AkEAo5XyGwVDm04TKwD3RxHoL4kZPNUTV3x6+3VGM0T5xagNRfasR0Spka+I8AFMNToPXhIX+imVccJPL5Ubcx429wJAJ61V22oHcQge7BDoOuXGHA9kkwAbSFUefd6D/lfJEGgwdVDJXqwTHgcHa3gyzE8/Z47jaOJ79zY0qUXnSdwX9QJAII+3OkOo+l/nFtdBYUciNVwPxvkOuYpQnH7yc0AWi45w3e1Ey4bSTepn0oYfmjStXGczmJrwYU1xH6KJbTelbwJASRywcpZxI86B4//Cz2F294dDtx3re+PtWUz4eE0FFjV0BuBbNGu89g9+FK9RB1Uosh+AUQHOwvYWm3DVwcRIaA==";

        //byte[] publicKey1 = readPublicKey();
        //String publicKey = publicKey1.toString();
        //String privateKey = readPrivateKey();


        String message = "JSMBABA - Welcome to RSA Encryption Decryption";

        try {
            String encryptedString = Base64.getEncoder().encodeToString(encrypt(message, publicKey));
            System.out.println("Original Message=\n"+message);
            System.out.println("\n*******************************************************");
            System.out.println("Cipher Text=\n"+encryptedString);
            System.out.println("\n*******************************************************");
            String decryptedString = RSAUtils.decrypt(encryptedString, privateKey);
            System.out.println("Decrypted  Message=\n"+decryptedString);
            System.out.println("\n*******************************************************");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }

    }


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
