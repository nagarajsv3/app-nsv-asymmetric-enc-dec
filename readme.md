1. KeyPairGenerator to generate these keys 
2. By default, the private key is generated in PKCS#8 format and the public key is generated in X.509 format.
3. Remember, the public key is written in the text file as X.509 format. Also, we can do a base64 encode to make it readable and share the string with the client.
4. RSA/ECB/PKCS1Padding has been known to be insecure and you should use RSA/None/OAEPWithSHA1AndMGF1Padding instead
5. Public key generated is in X.509 format and we use public key for encryption. Hence, we need X509EncodedKeySpec class to convert it again to RSA public key. Remember, that we have base64 encoded public keys. Hence, first let us first Base64 decode and generate the public key.
6. PKCS8EncodedKeySpec generates the private key from base64 encoded string using PKCS8EncodedKeySpec