# RetailMgmt
RetailMgmt Assignment

Steps to run the application on Command Prompt

1.	Browse to project root location

2.	Execute command “gradle clean build” to run build.gradle

3.	Once the build successful, to deploy the application and run, execute the command “java –jar build\libs\<<PROJECT_JAR_NAME>>”

4.	Launch postman and access the RetailMgmt APIs. 

TO register shop

POST Request : http://localhost:8080/shop/add

requestData Sample : {"shopName":"Phoenix+Mall,+Vimannagar,+Pune","shopAddress":{"number":"1", "postCode":411014}}

To get shop details

GET Request Sample : http://localhost:8080/shop/find?longitude=74.00&latitude=17.00
