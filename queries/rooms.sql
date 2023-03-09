/****************************************************** room insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addRoom(
    IN name VARCHAR(50),
    IN roomNo INT,
    IN description VARCHAR(100),
    IN bedType VARCHAR(15),
    IN noOfBed INT,
    IN roomType VARCHAR(10),
    IN charge DECIMAL(7,2)
)  
BEGIN
	INSERT INTO rooms (
		name,
		roomNo,
		description,
		bedType,
		noOfBed,
		roomType,
		charge) 
    VALUES (name, roomNo, description, bedType, noOfBed, roomType, charge);
END$$

DELIMITER ;

CALL addRoom('Chilax', '101', 'aaa bb cc', 'Double/Full', 2, 'Double', 20000);

/****************************************************** room update procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE updateRoom(
	IN id INT,
    IN name VARCHAR(50),
    IN roomNo INT,
    IN description VARCHAR(100),
    IN bedType VARCHAR(15),
    IN noOfBed INT,
    IN roomType VARCHAR(10),
    IN charge DECIMAL(7,2)
)  
BEGIN
	UPDATE rooms
    SET 
		name = name,
        roomNo = roomNo,
        description = description,
        bedType = bedType,
        noOfBed = noOfBed,
        roomType = roomType,
        charge = charge
    WHERE roomID = id;
END$$

DELIMITER ;

CALL updateRoom(2, 'Chilax 2', '102', 'aaa bb cc dd', 'Double/Full', 2, 'Double', 45000);

/****************************************************** room delete procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE deleteRoom(
	IN id INT
)  
BEGIN
	UPDATE rooms
    SET 
		deletedAt = CURRENT_TIMESTAMP()
    WHERE roomID = id;
END$$

DELIMITER ;

CALL deleteRoom(2);

/****************************************************** room view *********************************************************************/
CREATE VIEW rooms_view
AS 
SELECT 
    roomID,
    name,
    roomNo,
    description,
    bedType,
    noOfBed,
    roomType,
    charge,
    deletedAt
FROM
    rooms
WHERE deletedAt IS NULL;    
    
SELECT * FROM rooms_view;