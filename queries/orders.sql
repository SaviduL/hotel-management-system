/****************************************************** order insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addOrder(
    IN waiterID CHAR(8),
    OUT orderID INT
)  
BEGIN
	INSERT INTO orders (waiterID) 
    VALUES (waiterID);
    
    SET orderID = LAST_INSERT_ID();
END$$

DELIMITER ;

CALL addOrder('WAITR001', @orderID);
SELECT @orderID;

/****************************************************** order update procedure | cooking order *********************************************************************/
DELIMITER $$

CREATE PROCEDURE acceptOrderBychef(
	IN id INT,
    IN chefID CHAR(8)
)
BEGIN
	UPDATE orders
    SET 
        status = 'Cooking',
		chefID = chefID
    WHERE orderID = id;
END$$

DELIMITER ;

CALL acceptOrderBychef(1, 'CHEFS001');

/****************************************************** order update procedure | Cooked order *********************************************************************/
DELIMITER $$

CREATE PROCEDURE preparedOrderBychef(
	IN id INT,
    IN chefID CHAR(8)
)
BEGIN
	UPDATE orders
    SET 
        status = 'Cooked',
		chefID = chefID
    WHERE orderID = id;
END$$

DELIMITER ;

CALL preparedOrderBychef(1, 'CHEFS001');

/****************************************************** order update procedure | complete order *********************************************************************/
DELIMITER $$

CREATE PROCEDURE completeOrder(
	IN id INT,
    IN cashierID CHAR(8)
)
BEGIN
	UPDATE orders
    SET 
        status = 'Paid',
		cashierID = cashierID
    WHERE orderID = id;
END$$

DELIMITER ;

CALL completeOrder(1, 'CASHR001');

/****************************************************** order update procedure | cancel order *********************************************************************/
DELIMITER $$

CREATE PROCEDURE cancelOrder(
	IN id INT,
    IN chefID CHAR(8)
)  
BEGIN
	UPDATE orders
    SET 
		status = 'Cancelled',
		chefID = chefID
    WHERE orderID = id;
END$$

DELIMITER ;

CALL cancelOrder(2, 'CHEFS001');

/****************************************************** order delete procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE deleteOrder(
	IN id INT
)  
BEGIN
	UPDATE orders
    SET 
		deletedAt = CURRENT_TIMESTAMP()
    WHERE orderID = id;
END$$

DELIMITER ;

CALL deleteOrder(2);

/****************************************************** booking view *********************************************************************/
CREATE VIEW orders_view
AS 
SELECT 
    orderID,
    date,
    status,
    netPrice,
    waiterID,
    chefID,
    cashierID,
    deletedAt
FROM
    orders
WHERE deletedAt IS NULL;    
    
SELECT * FROM orders_view;