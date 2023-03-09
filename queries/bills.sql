/****************************************************** bill insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addBill(
	IN orderID INT,
    IN itemID CHAR(8),
    IN unitPrice DECIMAL(7,2),
    IN quantity INT
)  
BEGIN
	INSERT INTO bills (
		orderID,
        itemID,
        quantity,
        unitPrice)
    VALUES (orderID, itemID, quantity, unitPrice);
END$$

DELIMITER ;

CALL addBill(1, 'ITEMS001', 1500.00, 2);
CALL addBill(1, 'ITEMS002', 2000.00, 1);