/****************************************************** advance insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addAdvance(
	IN description VARCHAR(100),
	IN amount DECIMAL(7,2),
	IN employeeID CHAR(8),
	IN handlerManagerID CHAR(8)
)  
BEGIN
	INSERT INTO advances (
		description,
		amount,
		employeeID,
		handlerManagerID) 
    VALUES (description, amount, employeeID, handlerManagerID);
END$$

DELIMITER ;

CALL addAdvance('week advance', 699, 'CASHR001', 'MANGR001');

/****************************************************** advance update procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE updateAdvance(
	IN id INT,
	IN description VARCHAR(100),
	IN amount DECIMAL(7,2),
	IN employeeID CHAR(8),
	IN handlerManagerID CHAR(8)
)  
BEGIN
	UPDATE advances
    SET 
		description = description,
		amount = amount,
		employeeID = employeeID,
		handlerManagerID = handlerManagerID
    WHERE advanceID = id;
END$$

DELIMITER ;

CALL updateAdvance(1, 'week 1 advance', 8500, 'CASHR001', 'MANGR001');

/****************************************************** advance delete procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE deleteAdvance(
	IN id INT
)  
BEGIN
	UPDATE advances
    SET 
		deletedAt = CURRENT_TIMESTAMP()
    WHERE advanceID = id;
END$$

DELIMITER ;

CALL deleteAdvance(1);

/****************************************************** advance view *********************************************************************/
CREATE VIEW advances_view
AS 
SELECT
	advanceID,
    description,
	amount,
    date,
	employeeID,
	handlerManagerID,
    deletedAt
FROM
    advances
WHERE deletedAt IS NULL;    
    
SELECT * FROM advances_view;