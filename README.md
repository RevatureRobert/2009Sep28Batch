Console Based Car Dealership Application – (Project 0) 

Project Description

The Car Dealership app is a console-based application that facilitates the purchasing of cars. An employee can add cars to the lot and manage offers for those cars, while a customer can view the cars on the lot and make offers.

Project Requirements

1. Functionality should reflect the below user stories.
2. Data is stored in a database.
3. A custom stored procedure is called to perform some portion of the functionality.
4. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
5. All input is received using the java.util.Scanner class.
6. Log4j is implemented to log events to a file.
7. A minimum of one (1) JUnit test is written to test some functionality.

Project User Stories

* As a user, I can login.
* As a user, I can register for a customer account.

* As an employee, I can add a car to the lot.
* As an employee, I can view all payments.
* As an employee, I can accept or reject an offer for a car.
* As an employee, I can remove a car from the lot.

* As a customer, I can view the cars that I own.
* As a customer, I can view my remaining payments for a car.
* As a customer, I can view the cars on the lot.
* As a customer, I can make an offer for a car.

* As the system, I reject all other pending offers for a car when an offer is accepted.
* As the system, I can calculate the monthly payment.

Full Stack Reimbursement Application – (Project 1)

Project Description 

The Expense Reimbursement System (ERS) will manage the process of reimbursing
employees for expenses incurred while on company time. All employees in the
company can login and submit requests for reimbursement and view their past tickets
and pending requests. Finance managers can log in and view all reimbursement
requests and past history for all employees in the company. Finance managers are
authorized to approve and deny requests for expense reimbursement.

Project Technical Requirements 

The application shall employ the DAO design pattern, and properly separate your  code into the appropriate layers 
The back-end system shall use JDBC to connect to an PostgreSQL database. ○ Use PreparedStatement and CallableStatement 
The application shall deploy onto a Tomcat Server in an AWS EC2. The middle tier shall use Servlet technology for dynamic Web application  development 
The front-end view can use JavaScript and use AJAX to call server-side  components. The web pages should look presentable (try using css and  bootstrap); I’d rather not see a website from 1995.
Use Log4J and JUnit. 
Passwords should be encrypted and securely stored in the database. 60% test coverage minimum 
Users can upload a document or image of their receipt when submitting  reimbursements(optional) 
The application will send an email to employees letting them know that they have  been registered as a new user, giving them their temporary password(optional) 





