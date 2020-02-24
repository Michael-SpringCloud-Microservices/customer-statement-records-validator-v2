# customer-statement-records-validator-v2
This service will validate customer statement records and will generate the reports of failed ones.

Prerequisite : The machine should have 'Java8' and Maven 3.6.0 or grater

Step 1 : Clone the code -> git clone https://github.com/Michael-SpringCloud-Microservices/customer-statement-records-validator-v2.git

Step 2 : Point the CLI to the root folder 'customer-statement-records-validator-v2' of the code checked out 

Step 3 : Build Code -> mvn clean install

Step 4 : Boot the application using the command -> mvn spring-boot:run

Step 5 : Access the swagger UI using http://localhost:8110/swagger-ui.html

Step 6 : Expand 'Statement Upload Controller', click on the 'POST' endpoint bar and finally click on 'Try it out' 

Step 7 : Then upload the sample files placed at folder -> src/test/resources using 'Choose File'

Step 8 : Click 'Execute' button

Step 9 : Check the 'Server Response' portion to check the report of failed record details. 

Step 10: You can check the code coverage report by launching 'index.html' at customer-statement-records-validator-v2\target\jacoco-ut 


Note: 
 * JaCoCo is used for coverage report

 * You can use any csv/xml which matches the file's (given for assignment) data format to validate the code.  

 * Configuration to upload large file -> https://dzone.com/articles/upload-large-file-in-spring-boot-2-application-usi

 * Format Decimal Numbers in Java  -> http://tutorials.jenkov.com/java-internationalization/decimalformat.html
