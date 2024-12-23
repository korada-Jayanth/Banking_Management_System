# Banking_Management_System

A simple Java-based Banking Management System with a graphical user interface (GUI) that simulates common ATM operations. It allows users to perform various transactions such as deposits, withdrawals, balance inquiry, fast cash, PIN change, and view mini statements.

Features

Login: Users can securely log in using a PIN.

Deposit: Users can deposit money into their bank account.

Withdrawals: Users can perform normal withdrawals or select fast cash options.

Balance Enquiry: Users can check their account balance.

Mini Statement: Users can view a transaction history.

PIN Change: Users can change their PIN.

ATM Interface: Interactive buttons and a user-friendly interface.


Technologies Used
Java: The core programming language for the application.

JDBC (Java Database Connectivity): For connecting to and interacting with the database.

Swing: For building the graphical user interface (GUI).

MySQL: Database used for storing user and transaction information.

Database Connectivity Queries: To Connect MySQL 

//creating a database

create database bankSystem;

use bankSystem;

create table signup(form_no varchar(30), name varchar(30), father_name varchar(30), DOB varchar(30), gender varchar(30),email varchar(50),marital_status varchar(30),address varchar(60), city varchar(30), pincode varchar(30), state varchar(50)); 

select * from signup;

create table signuptwo(form_no varchar(30), religion varchar(30), category varchar(30), income  varchar(30), education varchar(30),occupation varchar(50),pan varchar(30),aadhar varchar(60), seniorcitizen varchar(30), existing_account varchar(30));

select * from signuptwo;

create table signupthree(form_no varchar(30), account_type varchar(40), card_number varchar(30), pin varchar(30), facility varchar(200));

select * from signupthree;

create table login(form_no varchar(30), card_number varchar(30), pin varchar(30));

select * from login;
create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));
select * from bank;
