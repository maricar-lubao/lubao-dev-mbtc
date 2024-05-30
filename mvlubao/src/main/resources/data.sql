CREATE SEQUENCE IF NOT EXISTS accountNumber_seq 
START WITH 10000
INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS customer (
    customer_number  	INT AUTO_INCREMENT,
    customer_name    	VARCHAR2(50) NOT NULL,
    customer_mobile  	VARCHAR2(20) NOT NULL,
    customer_email   	VARCHAR2(50) NOT NULL,
    address1        	VARCHAR2(100) NOT NULL,
    address2        	VARCHAR2(100),
    
    PRIMARY KEY (customerNumber)
);



CREATE TABLE IF NOT EXISTS bankAccount (
    bank_acct_id      	INT PRIMARY KEY AUTO_INCREMENT,
    customer_number  	INT NOT NULL,
    account_number 		INT NOT NULL DEFAULT nextval('accountNumber_seq'),
    account_type		VARCHAR(1) NOT NULL,
    available_balance	DOUBLE,
    
    FOREIGN KEY (customerNumber) REFERENCES customer
);


INSERT INTO customer (customer_name, customer_mobile, customer_email	  , address1, address2)
VALUES (			  'JOHN DOE'   , '09123456789'	, 'john.doe@gmail.com', 'MAKATI', null);

INSERT INTO bankAccount (customer_number, account_number, account_type, available_balance)
VALUES (                  			   1, 9999			, 'S'		  , 150000);

INSERT INTO bankAccount (customer_number, account_number, account_type, available_balance)
VALUES (                  			   1, 10000			, 'S'		  , 400000);

