/****************************************************** employee insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addEmployee(
    IN employeeType VARCHAR(20),
    IN title VARCHAR(5),
    IN nic VARCHAR(12),
    IN firstName VARCHAR(50),
    IN lastName VARCHAR(50),
    IN dob DATE,
    IN sex CHAR(6),
    IN telNo CHAR(10),
    IN address VARCHAR(150),
    IN email VARCHAR(50),
    IN salary DECIMAL(8,2)
)  
BEGIN
	DECLARE employeeID CHAR(8);
    
    CASE employeeType
		WHEN 'Cashier' THEN
			SET employeeID = generateCashierID();
        WHEN 'Chef' THEN
			SET employeeID = generateChefID();
		WHEN 'Manager' THEN
			SET employeeID = generateManagerID();
		WHEN 'Receptionist' THEN
			SET employeeID = generateReceptionistID();
		WHEN 'Waiter' THEN
			SET employeeID = generateWaiterID();
	END CASE;

	INSERT INTO employees (
		employeeID,
        employeeType,
        title,
        nic,
        firstName,
        lastName,
        dob,
        sex,
        telNo,
        address,
        email,
        salary) 
    VALUES (employeeID, employeeType, title, nic, firstName, lastName, dob, sex, telNo, address, email, salary);
END$$

DELIMITER ;

CALL addEmployee('Manager', 'Mr.', '96566462674v', 'Dananjaya', 'Karunarathna', '1996-04-16' , 'Male', '0717893412', 'Gampaha', 'dana.silva@gmail.com', 38500.00);
CALL addEmployee('Cashier', 'Mr.', '96566462674v', 'Dananjaya', 'Karunarathna', '1996-04-16' , 'Male', '0717893412', 'Gampaha', 'dana.silva@gmail.com', 38500.00);
CALL addEmployee('Chef', 'Mr.', '96566462674v', 'Dananjaya', 'Karunarathna', '1996-04-16' , 'Male', '0717893412', 'Gampaha', 'dana.silva@gmail.com', 38500.00);
CALL addEmployee('Receptionist', 'Mr.', '96566462674v', 'Dananjaya', 'Karunarathna', '1996-04-16' , 'Male', '0717893412', 'Gampaha', 'dana.silva@gmail.com', 38500.00);
CALL addEmployee('Waiter', 'Mr.', '96566462674v', 'Dananjaya', 'Karunarathna', '1996-04-16' , 'Male', '0717893412', 'Gampaha', 'dana.silva@gmail.com', 38500.00);

/****************************************************** employee update procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE updateEmployee(
	IN id CHAR(8),
    IN title VARCHAR(5),
    IN nic VARCHAR(12),
    IN firstName VARCHAR(50),
    IN lastName VARCHAR(50),
    IN dob DATE,
    IN sex CHAR(6),
    IN telNo CHAR(10),
    IN address VARCHAR(150),
    IN email VARCHAR(50),
    IN salary DECIMAL(8,2),
    IN status CHAR(10)
)  
BEGIN
	UPDATE employees
    SET 
		title = title,
        nic = nic,
        firstName = firstName,
        lastName = lastName,
        dob = dob,
        sex = sex,
        telNo = telNo,
        address = address,
        email = email,
        salary = salary,
        status = status
    WHERE employeeID = id;
END$$

DELIMITER ;

CALL updateEmployee('CASHR005', 'Mr.', '96566462674v', 'Savindu', 'laki', '1996-04-16' , 'Male', '0717893412', 'Gampaha', 'dana.silva@gmail.com', 38500.00, 'Deactivate');

/****************************************************** employee delete procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE deleteEmployee(
	IN id CHAR(8)
)  
BEGIN
	UPDATE employees
    SET 
		deletedAt = CURRENT_TIMESTAMP()
    WHERE employeeID = id;
END$$

DELIMITER ;

CALL deleteEmployee('CASHR005');

/****************************************************** employee view *********************************************************************/
CREATE VIEW employees_view
AS 
SELECT 
    employeeID,
	employeeType,
	title,
	nic,
	firstName,
	lastName,
	dob,
	sex,
	telNo,
	address,
	email,
	salary,
    status,
    JoinedDate,
    deletedAt
FROM
    employees
WHERE deletedAt IS NULL;    
    
SELECT * FROM employees_view;