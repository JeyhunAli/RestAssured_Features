
![image](https://user-images.githubusercontent.com/50185967/133925366-6daa929e-7671-46f3-bb73-16ecf0e716ef.png)


most useful questions and answers about API
what is an api?
api stands for application programming interface

what is an api testing?
api is a part of integration testing to check whether the api meets expectations in terms of functionality reliability performance and security of applications

what are the layers in api testing?
answer applications often have three layers
presentation or UI layer, Business layer application user interface layer, Database layer

what is an api endpoint?
As we know that APIs work using ‘requests’ and ‘responses.’ When an API requests information from a web application or web server, it will receive a response. The place that APIs send requests and where the resource lives, is called an endpoint.

What are the types of API-s?
Public, private, partner 

what are some real-world examples of api s?
google maps twitter and YouTube api s

how many types of api testing are there?

1 unit testing is for testing the usefulness of individual activity
2 ui testing is for testing the usefulness of UI as a component of start to finish
3 functional testing is simply a test of specific functions within the code base load testing for testing the
functionality and execution under load conditions load testing takes on a few different
scenarios in order to ensure peak performance the first of these scenarios is called the baseline and tests the api against the theoretical regular traffic the api expects in normal day-to-day usage
5 usability testing it is easy to hit the APIs on different platforms and test the usability of a
Software 
6 is error detection for recognizing any blunders for example special cases and asset spills
this type of test is focused on the actual running of the api error detection is concerned with the universal results of utilizing the api code base 
7 security testing security testing also includes penetration testing
and fast testing
8 discovery testing helps in identifying APIs where the resources are not exposed

what is a typical api testing process?

The process starts with creating api testing requirement’s purpose of the api workflow of the
Application then defines the input parameters plan all possible input combinations to
verify the results to determine whether the api performs as expected

what are the types of bugs we face when performing api testing?

It can be status code error changing or not performing how it has to be 
It can be in json response sometimes the key value not matching to actual result 
Sometime reliability of an application can be broken 
Improper data 

what a soap? 
soap is also known as simple object access protocol is an xml-based messaging protocol
it aids in the exchanging of information between computers
it can be used to create retrieve update or delete records like accounts leads and user defined objects

what is rest?
all applications we use these days follow this architecture the app itself is the client or the front-end part
and it needs to talk to a server or the back-end to get or save the data this communication happens
using the HTTP protocol, the same protocol that powers our web now this is where rest comes into the picture rest is short for representational state transfer 
these HTTP services so we use simple HTTP protocol principles to provide support to create read update and delete data we refer to these operations all together as crud operations


what is the difference between soap and rest? 

SOAP stands for Simple Object Access Protocol whereas REST stands for Representational State Transfer. SOAP is a protocol whereas REST is an architectural pattern. ... Comparing SOAP vs REST API, SOAP only works with XML formats whereas REST work with plain text, XML, HTML and JSON.

differences between api and web service?
API is the acronym for Application Programming Interface. It is a software interface that allows two applications to interact with each other without any user intervention.
Web service is a collection of open-source protocols and standards used for exchanging data between systems or applications whereas API is a software interface that allows two applications to interact with each other without any user involvement.
Web service is used for REST, SOAP and XML-RPC for communication while API is used for any style of communication.

what is xml?
Extensible Markup Language is a markup language that defines a set of rules for encoding documents in a format that is both human-readable and machine-readable. The World Wide Web Consortium's XML 

What is a WSDL and how does it work?
The Web Services Description Language is an XML-based interface description language that is used for describing the functionality offered by a web service

What is JSON?
JSON stands for JavaScript Object Notation
JSON is a lightweight format for storing and transporting data
JSON is often used when data is sent from a server to a web page
JSON is "self-describing" and easy to understand

what are the commonly used http methods?
The primary or most commonly-used HTTP methods are POST, GET, PUT, PATCH, and DELETE. These methods correspond to create, read, update, and delete (or CRUD) operations, respectively. There are a number of other methods, too, but they are utilized less frequently.

what are the commonly used http response codes?
HTTP Status Code 200 - OK. ...
HTTP Status Code 201 – CREATED
HTTP Status Code 401 -UNAUTHORIZED 
HTTP Status Code 405 – METHOD NOT ALLOWED 
HTTP Status Code 400 – BAD REQUEST 
HTTP Status Code 301 - Permanent Redirect. ...
HTTP Status Code 302 - Temporary Redirect. ...
HTTP Status Code 404 - Not Found. ...
HTTP Status Code 410 - Gone. ...
HTTP Status Code 500 - Internal Server Error. ...
HTTP Status Code 503 - Service Unavailable.

what are commonly used api documentation templates?
there can be many but some of the popular api documentation templates are 
swagger 
rest-doc
mir-dot 
api blueprint
slate 
web service api specification
flat dock 

what is payload in restful web services?
payload of an api module is the body of your request and response message
it contains the data that you send to the server when you make an api request
you can send and receive payload in different formats for instance json


 what is the caching mechanism? And 
Caching refers to storing the server response in the client itself, so that a client no need to make a server request for the same resource again and again.
caching is the ability to store copies of frequently accessed data in several places
HTTP is a stateless protocol. 

what are the core components of an http request? 
each http request includes five key elements one the verb which indicates
1.http methods such as get put post delete 
2.uri stands for uniform resource identifier URI it is the identifier for the
resource on the server
3.http version which indicates http version for example http 1.1
4.request header carries metadata as key value pairs for the http request message metadata could be a client or browser type the format that the client supports message body format
and cache settings 
5.request body indicates the message content or resource representation question 

 what are the core components of an http response?
http response includes four key elements
1 status response code indicates server status for the resource present in the http request
for example, 404 means resource not found and 200 means responses okay
2. http version indicates http version for example http 1.1
3. response header contains metadata for the http response message stored in the form of key value pairs
for example, content length content type response date and server type
4 response body indicates response message content or resource representation

What is Microservices architecture and how does microservice architecture work?

microservice architecture is an architectural style and it's based on collection of services
Microservices
Here basically developers split all the services into small parts Basically, all the features of application splitting or dividing into small parts Here there are no dependencies among all the features. Continues Development happening individually. Each service here has their own DB. Parallel development and parallel testing are more practical here,
in micro services if any part of the api or feature is down for maintenance rest of the services works perfectly fine  
cause they are independent fault isolation – means if any feature has some failure, then easily, we can identify and
develop in micro services all the services communicating with each other through api calls
in micro services we can use multiple technology to develop app disadvantages of micro services are high complexity and automation and debugging are complex

As per the REST architecture, a RESTful Web Service should not keep a client state on the server. 
This restriction is called Statelessness.
For example:
If you hit the above URL using your browser or using a java-based client or using Postman, result will always be the User XML whose Id is 1 because the server does not store any information about the client.
<user> 
   <id>1</id> 
   <name>Jeyhun</name> 
   <profession>1</profession> 
</user>



what is the use of accept and content type headers in http request?

ACCEPT HEADERS tells web service what kind of response client is accepting
So, if a web service is capable of sending response in xml and json format and client sends accept header as
application xml then xml response will be sent

CONTENT-TYPE HEADER is used to tell server what is the format of data being sent in the request
if content type header is application-xml then server will try to pass it as
xml if it's application-json then server will try to pass it as json data
this header is useful in http post and put requests

what are differences between api testing and UI testing?

API testing is focused on the functionality of the business logic and it is entirely different from UI testing
API enables communication between two separate software systems.
UI testing refers to testing graphical user interfaces, such as how user interacts with the application, testing application elements like fonts, layouts, buttons, images, colors, etc. Basically, UI testing concentrates on the look-and-feel of an application.

what are some architectural styles for creating a web api?
common web api architectural styles
http for client server communication
xml json formatting language
URL, URI, URN as the address for the services
stateless communication question



what must be checked when performing api testing?

While testing an API, you should consider:
Accuracy of data.
Schema validation.
HTTP status codes.
Data type, validations, order and completeness.
Authorization checks.
Implementation of response timeout.
Error codes in case API returns, and.
Non-functional testing like performance and security testing.

what is patch? 
unlike put patch applies a partial update to the resource this means that you are only required to
send the data that you want to update and it won't affect or change anything else

benefits of api testing?
API testing will provide truly secure, reliable, and scalable connections between platforms. In every Company, they maintain standard practice to monitor API's during production to ensure that the live endpoints are up and returning expected information to the user.










