The current project name is CCLE, which is Card Credit Limit Enhancement.
The main objective of the CCLE application is customer can enhance their credit limit of credit cards. Generally based on the 
usage of the card bank provides offers to the customers to increase their credit limit. Customer can increase the Credit Limit by 
applying the promo code using different channels like web,mobile..etc.

There are 3 modules in this project
1. Batch module: This module is used to generate the promocodes for the identified customers 
2. Enquire module: This module is used to validate the promo code before redeem/use it
3. Redeem module: This module is used to redeem the promo code. i.e. apply the promo code for redemption

1. Batch Module:
 This module is used is used to generate the promo code for the targeted customers.
 Everyday midnight 12:00 AM CST, the batch jobs will be started which will take care of read the files from 
mainframes system, process the data and write into destination like postgres database
 Using cron expression, without user interaction these batch jobs will be executed.

2. Enquire Module: 
 This module is used to validate the promo code by calling credit-limit-enquiry-service
 Enquire service will validate the promo code like active, already used, expired, partially used..etc
 Once the promo code is valid and will get the details of promo code like card number, available limit, eligible limit, 
increase limit percentage..etc
 Using these details customer can enhance the credit limit

3. Redeem module:
 This module is used to enhance the credit limit by providing necessary details like card number, available limit, eligible 
limit, increase limit percentage and requested amount
 Make cardverifyservice call before initiate the redemption
 When user will initiate the redemption then it will update the details in database with newly increased limit
 Send redemption status to Message Queue (MQ) like Kafka, whoever (NotificaitonService, UpdateBalanceService) 
subscribers they can read the data from KAFKA to perform required operations.

Summary :
To implement all these modules we have developed 5 mircoservices, 1 batch component, and 1 web/ui
5 micro services are: 1. credit-limit-enquire-service, 2. Credit-limit-redeem-service 
 3. card-verify-service, 4. Notification-service, 5. user-auth-service
