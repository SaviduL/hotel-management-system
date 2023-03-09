/****************************************************** bonus insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addBonus(
	IN employeeID CHAR(8),
    IN amount DECIMAL(7,2),
    IN description VARCHAR(100)
)  
BEGIN
	INSERT INTO bonuses (
		employeeID,
		amount,
		description) 
    VALUES (employeeID, amount, description);
END$$

DELIMITER ;

CALL addBonus('CASHR001', 38500.00, 'new year');

/****************************************************** bonus update procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE updateBonus(
	IN id INT,
	IN employeeID CHAR(8),
    IN amount DECIMAL(7,2),
    IN description VARCHAR(100)
)  
BEGIN
	UPDATE bonuses
    SET 
		employeeID = employeeID,
        amount = amount,
        description = description
    WHERE bonusID = id;
END$$

DELIMITER ;

CALL updateBonus(1, 'CASHR001', 400.00, 'new year');

/****************************************************** bonus delete procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE deleteBonus(
	IN id INT
)  
BEGIN
	UPDATE bonuses
    SET 
		deletedAt = CURRENT_TIMESTAMP()
    WHERE bonusID = id;
END$$

DELIMITER ;

CALL deleteBonus(1);

/****************************************************** bonus view *********************************************************************/
CREATE VIEW bonuses_view
AS 
SELECT 
    bonusID,
	employeeID,
	amount,
	description,
	date,
    deletedAt
FROM
    bonuses
WHERE deletedAt IS NULL;
    
SELECT * FROM bonuses_view;