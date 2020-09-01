Asymmetric Encryption Algorithms : 
1. RSA
2. Diffie-Hellman
3. ElGamal
4. DSS.

1. RSA is known as One way trapdoor function
2. We use Prime Numbers , Prime Factorization and Phi Function to generate Public and Private Key

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