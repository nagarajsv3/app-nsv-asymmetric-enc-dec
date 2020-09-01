AES - Advanced Encryption Standard

**_Classes to remember_**
Cipher 
SecretKeySpec - Secret Key Specification
BASE64Encoder
BASE64Decoder

Always key is inputted to the algorithm in the form of byte[]


Cipher cipher = Cipher.getInstance("AES"); //Get an instance of Cipher
cipher.init(Cipher.ENCRYPT_MODE/DECRYPT_MODE, key); //Initialize the cipher with key and encrypt/decrypt mode
cipher.doFinal(data); //data should be byte[] . it can be encrypted or decrypted data based on the MODE


DES - Data Encryption Standard
Cipher cipher = Cipher.getInstance("DES");

Triple DES
Cipher cipher = Cipher.getInstance("DESede");

