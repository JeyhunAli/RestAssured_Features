# RestAssured_Features
starting rest api features
hiting api with rest assured 

OAuth is an authorization method used to provide access to resources over the HTTP protocol.
OAuth.1 can be used for authorization of various, numerous applications
primarily its an access token to the applications which represents a user’s permission for the client to access their data
OAuth 1 Terms:
OAuth 1 has a few interacting components:

User is a person who wants to get access.
Consumer is an application or website that uses OAuth to access the Service Provider.
Service Provider is a web application that allows access via OAuth.
Protected Resource is the data the user wants to access.
Tokens
OAuth1 Authorization uses Request Token and Access Token to get access to the resources on the resource server.

Request Token – a token containing Consumer Key and Consumer Secret used to ask the service for authorization.

Access Token – a token used to access the resource.

The tokens can have different formats and structures based on the service provider security requirements.




![OAuth1  OAuth2](https://user-images.githubusercontent.com/50185967/139423567-e4524b6f-c6da-4b83-a1c6-2d5b1424d3d9.png)

About OAuth 2.0
OAuth 2.0 provides access to resources through the HTTP protocol.
You can use OAuth 2.0 in your applications or use it to access a service manually.

When you use OAuth 2.0, your application gets an access token that represents a user's permission to access their data. The token is used by the application to authenticate a request to an API endpoint.

OAuth Versions
There are two versions of OAuth: OAuth 1 (it uses HMAC-SHA signature strings) and OAuth 2.0 (it uses access tokens sent over HTTPS).

There is also a specific version of OAuth 2.0 that is used in Microsoft Azure Active Directory. It uses additional fields when you get an access token. If your service uses Azure Active Directory, select the OAuth 2.0 (Azure) authentication type.

OAuth 2.0 Terms
OAuth 2.0 has a few interacting components. The resource server (the API server) contains the resources to be accessed. Access tokens are provided by the authorization server, which can be the same as the API server. The server acts as the resource owner when you access the resources. An application that uses credentials and API is called a client.

Endpoints
Clients use a token endpoint to get an access token (and optionally refresh the token) from the authorization server.

Note:	When using the implicit grant, no token endpoint is used. Instead, an access token is sent from the authorization endpoint directly.
Tokens
The two token types involved in OAuth 2.0 authorization are Access Token and Refresh Token.

Access Token
An access token is a string used for authorization and authentication when getting access to resources on the resource server. It can have different formats and structures based on the resource server security requirements.

There are two types of access tokens: bearer tokens and MAC tokens.

Bearer tokens are sent over HTTPS to ensure secure transfer even if requests are neither signed nor encrypted. A request with a bearer token is considered as having been authorized.

MAC tokens are more secure than bearer tokens. They are similar to signatures, as they allow you to perform partial cryptographic verification of requests.

Refresh Token
Refresh tokens are normally sent along with access tokens. Refresh tokens are used to get a new access token when the old one expires. Instead of performing the normal grant procedure, the client provides a refresh token and receives a new access token. Using refresh tokens makes expiration time for access tokens on the resource server shorter and expiration time for accessing the authorization server longer.

Grants
You get access tokens from the authorization server by using grants. The same grant type can be used, for example, to request a token and validate it on the resource server.

The four basic grant types are Authorization Code, Implicit, Resource Owner Credentials, and Client Credentials. For more information about the grant types, see the OAuth 2.0 Grant Types section.

Scope
In OAuth 2.0, scope is a way to provide access only to specific areas. Normally, you specify areas as a list of comma-separated or space-delimited strings. Each string indicates the area you can access.

https://support.smartbear.com/readyapi/docs/performance/index.html

<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<>>>>


OAuth 2.0 is a complete rewrite of OAuth 1.0 from the ground up

OAuth 2.0 is uses the HTTPS protocol to pass tokens.

OAuth 1 is uses HMAC-SHA signature strings.

what is that means let me explain in easy way 

HMAC-SHA 
hmac is keyed hash message identification code 
here hash is a function which is map input and output 
you provide it with specific amout of bits number or integer or string and output will be specific fixed amount of bits 
but 
hmac basically has 3 parameters 
Actual hmac input 
hash function 
and secret
these all together creating message authenticating code 

now let me explain about http, https protocol  HTTP Vs HTTPS SSL/TLS 
http ---> hyper text transfer protocol 
when using this protocol theres insecure connection happening between client and server and communication is happening over the network 
just with plain text format 
its fine for small application where we dont use
any personal information or any payment options 
its very lightweight 
and default port nummber is 80.    {(learn more about OSI reference model)}

HTTPs ---> hyper text transfer protocol secure 
always encrypted data pasing through communication client and server 
port number for hhtps is 443
Certificate authority on the browser level 
https very well secured system 
there are two type of security can involve here 
SSL and TSL.   SSL--> secure socket layer,  TSL--> transport secure layer
ssl older than tsl 
tsl more secure than ssl
majority of companies uses tsl 
so the encryption is happening over the network before reaching out our info to the server its encrypt then server decrepit it 
and same thing server sending responnse its encrypted over the network then our client decrepit it then its available in the form of readable for us

SSL AND TSL HAVE THESE MODELS AS WELL 
ASYMMETRIC AND SYMMETRIC encryption methods 

![image](https://user-images.githubusercontent.com/50185967/139556533-f9b07f75-6102-4740-93bf-c24cb25eb3f9.png)

#API #Gateway
Api is require additional infrastructure to secure, scale, and accelerate. applications
And nowadays most of the applications build with #microservices
These #microservices are loosely coupled in order to make your apps more scalable and highly available
using a  #microservice comes with many more API calls going between your clients and your  
microservices
So, how do you securely manage this API traffic for a distributed system?  
Well, with an API Gateway! 
the first main benefit of API gateway is client #performance.
the next main benefit is #security.
another benefit which is #http #https #protocol
API gateway count can be more than one in holiday season in order
to control load traffic
#APiTesting
#ApIinfrastructure
![image](https://user-images.githubusercontent.com/50185967/139562777-c3a07bd9-09f1-4a0a-828a-d1ccea26466b.png)



