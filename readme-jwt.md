**_JWT Authorization_**
JWT - Json Web Token
JWT is used for Authorization

HTTP is Stateless protocol

Authorization Strategies
1. Session Token :
    1. Authenticates -> Session ID in Cookie
    2. Works for Monolith application. Does not work for Micro Services
    3. Reference Token . Refers to Session History 
2. Json Web Token
    1. Works for Micro services
    2. Value Token . Contains the actual value


**_JWT Structure_**
Header.Payload.Signature
All 3 are in Base64 Encoded format
Header -> Contains Algorithm info used in Signature
Payload -> Actual Payload
Signature -> Header + Payload + Secret Key are used to form Signature

To Play with : jwt.io

Signature Verification : 
1. Using (Header + Payload + Secret Key) signature is computed
2. Request Signature is compared against Computed Signature