1. KeyPairGenerator to generate RSA Public Private keys 
2. By default, the private key is generated in PKCS#8 format and the public key is generated in X.509 format.
3. Remember, the public key is written in the text file as X.509 format. Also, we can do a base64 encode to make it readable and share the string with the client.
4. RSA/ECB/PKCS1Padding has been known to be insecure and you should use RSA/None/OAEPWithSHA1AndMGF1Padding instead
5. Public key generated is in X.509 format and we use public key for encryption. Hence, we need X509EncodedKeySpec class to convert it again to RSA public key. Remember, that we have base64 encoded public keys. Hence, first let us first Base64 decode and generate the public key.
6. PKCS8EncodedKeySpec generates the private key from base64 encoded string using PKCS8EncodedKeySpec

Note: - RSA/ECB/PKCS1Padding has been known to be insecure and you should use RSA/None/OAEPWithSHA1AndMGF1Padding instead.

**_RSA Encryption In Java_**
1. public key generated is in X.509 format and we use public key for encryption.
Hence, we need X509EncodedKeySpec class to convert it again to RSA public key.
Remember, that we have base64 encoded public keys.Hence, 
first let us first Base64 decode and generate the public key.

**_RSA Decryption In Java_**
1. For decryption we will be using private key and we discussed above that the private key is 
generated in PKCS#8 format.Hence, following is the code to generate the private key from base64
 encoded string using PKCS8EncodedKeySpec. 

**_Putting RSA and AES together_**
With every doubling of the RSA key length, decryption is 6-7 times times slower.Hence,
 when there are large messages for RSA encryption, the performance degrades.In such scenarios, we first do an AES encryption of the messages and the key used for AES encryption is RSA encrypted and sent to the server. 

**_SSL Certificates_**
1. SSL Certificates can be purchased from a web services company (Certificate Authority)
2. Ash is trying to buy Clothes from H&M.
3. Ash computer connects to H&M Website using the SSL Certificate.
4. Ash computer verifies H&M identity with Certificate Provider.
5. If everything is good , computer forms an initial handshake. During handshake they decide what type of
   encryption.
   This is to establish secure connection between 2 computers called SSL
   SSL - Secure Socket Layer
6. When data like card number leaves Ash computer in the encrypted format

**_Java Cryptography_**
1. The Java Cryptography API enables you to encrypt and decrypt data in Java, as well as manage keys, sign and authenticate messages, calculate cryptographic hashes and much more.

**_Java Cryptography Extension JCE_**
1. Java Cryptography API is provided by JCE - Java Cryptography extension

**_Java Cryptography Architecture JCA_**
1. The Java Cryptography Architecture (JCA) is the name for the internal design of the Java cryptography API.
2. JCA is structured around some central general purpose classes and interfaces. 
3. The real functionality behind these interfaces are provided by providers.
4. Providers like Built in Java , Bouncy Castle

**_Core Classes and Interfaces_**
The Java cryptography API is divided between the following Java packages:

java.security
java.security.cert
java.security.spec
java.security.interfaces
javax.crypto
javax.crypto.spec
javax.crypto.interfaces
The core classes and interfaces of these packages are:

Provider
SecureRandom
Cipher
MessageDigest
Signature
Mac
AlgorithmParameters
AlgorithmParameterGenerator
KeyFactory
SecretKeyFactory
KeyPairGenerator
KeyGenerator
KeyAgreement
KeyStore
CertificateFactory
CertPathBuilder
CertPathValidator
CertStore

**_Provider_**
The Provider (java.security.Provider) class is a central class in the Java cryptography API. In order to use the Java crypto API you need a Provider set. The Java SDK comes with its own cryptography provider. If you don't set an explicit cryptography provider, the Java SDK default provider is used. However, this provider may not support the encryption algorithms you want to use. Therefore you might have to set your own cryptography provider.

One of the most popular cryptography providers for the Java cryptography API is called Bouncy Castle. Here is an example that sets a BouncyCastleProvider:

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class ProviderExample {
    public static void main(String[] args) {

        Security.addProvider(new BouncyCastleProvider());

    }
}

**_Cipher**_
The Cipher (javax.crypto.Cipher) class represents a cryptographic algorithm. A cipher can be used to both encrypt and decrypt data. The Cipher class is explained in more detail in the text on the Java Cipher class, but I will give a brief introduction to the Cipher class in the following sections.

Here is how to create a Java Cipher instance:

Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
This example creates a Cipher instance which uses the AES encryption algorithm internally.

The Cipher.getInstance(...) method take a String identifying which encryption algorithm to use, as well as a few other configurations of the algorithm. In the example above, the CBC part is a mode the AES algorithm can work in. The PKCS5Padding part is how the AES algorithm should handle the last bytes of the data to encrypt, if the data does not align with a 64 bit or 128 bit block size boundary. What exactly that means belongs in a tutorial about cryptography in general, not a tutorial about the Java cryptography API.



Asymmetric Encryption Algorithms : 
1. RSA
2. Diffie-Hellman
3. ElGamal
4. DSS.

1. RSA is known as One way trapdoor function
2. We use Prime Numbers , Prime Factorization and Phi Function to generate Public and Private Key
3. Asymmetric encryption uses two different keys as public and private keys. 
Here, you can encrypt sensitive information with a public key and a matching private key 
is used to decrypt the same. 

RSA Algorithm
https://www.youtube.com/watch?v=Z8M2BTscoD4
https://www.youtube.com/watch?v=wXB-V_Keiu8

Cipher
RSAPublicKeySpec
RSAPrivateKeySpec
KeyPairGenerator


How exactly Encryption works
1. Take the base 3
2. Raise it to the exponent  4 -> 3^4 = 81
3. Modulus of the Number 10 -> Reminder is 1

exponent -> encryption key / decryption key

encrypted data = modulus(exponent(message))

Encryption Decryption

Encryption & Decryption -> e & d are encryption and decryption keys
Encryption Algorithm
m^e modulus n = c

Decryption Algorithm
c^d modulus n = m

Alice 
p1 = prime number 1 = 53
p2 = prime number 2 = 59
n= p1 * p2 = 53 * 59 = 3127
phi(n) = (p1-1) * (p2-1) = 52* 58 = 3016 
  phi - euler totient function
Choose any e say 3
d= ((2 * (3016)) +1 ) / 3 = 2011

Alice shares n & e with Bob

Bob uses n & e to encrypt

We use Prime Numbers , Prime Factorization and Phi Function to generate Public and Private Key 

Public key has e & n
Private Key has d 