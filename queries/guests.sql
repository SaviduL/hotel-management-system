/****************************************************** guest insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addGuest(
    IN telNo CHAR(10),
	IN title VARCHAR(5),
	IN nic VARCHAR(12),
	IN firstName VARCHAR(50),
	IN lastName VARCHAR(50),
	IN sex CHAR(6),
	IN address VARCHAR(150),
	IN email VARCHAR(50)
)  
BEGIN
	INSERT INTO guests (
		telNo,
		title,
		nic,
		firstName,
		lastName,
		sex,
		address,
		email) 
    VALUES (telNo, title, nic, firstName, lastName, sex, address, email);
END$$

DELIMITER ;

CALL addGuest('0717893412', 'Mr.', '96566462674v', 'Dananjaya', 'Karunarathna', 'Male', 'Gampaha', 'dana.silva@gmail.com');

/****************************************************** guest update procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE updateGuest(
	IN id CHAR(10),
	IN title VARCHAR(5),
	IN nic VARCHAR(12),
	IN firstName VARCHAR(50),
	IN lastName VARCHAR(50),
	IN sex CHAR(6),
	IN address VARCHAR(150),
	IN email VARCHAR(50)
)  
BEGIN
	UPDATE guests
    SET 
		title = title,
        nic = nic,
        firstName = firstName,
        lastName = lastName,
        sex = sex,
        address = address,
        email = email
    WHERE telNo = id;
END$$

DELIMITER ;

CALL updateGuest('0717893482', 'Mr.', '96566462674v', 'Kasun', 'Hemal', 'Male', 'kalutara', 'dana.silva@gmail.com');

/****************************************************** guest delete procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE deleteGuest(
	IN id CHAR(10)
)  
BEGIN
	UPDATE guests
    SET 
		deletedAt = CURRENT_TIMESTAMP()
    WHERE telNo = id;
END$$

DELIMITER ;

CALL deleteGuest('0717893482');

/****************************************************** guest view *********************************************************************/
CREATE VIEW guests_view
AS 
SELECT
	telNo,
    title,
	nic,
	firstName,
	lastName,
	sex,
	address,
	email,
    deletedAt
FROM
    guests
WHERE deletedAt IS NULL;    
    
SELECT * FROM guests_view;