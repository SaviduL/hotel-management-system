DELIMITER $$

CREATE TRIGGER after_bills_insert_netPrice_cal
    AFTER INSERT
    ON bills FOR EACH ROW
BEGIN
	DECLARE currentNetPrice, newNetPrice DECIMAL(8,2);
	DECLARE id INT;
    
    SET id = NEW.orderID;
	
    SELECT netPrice
    INTO currentNetPrice
    FROM orders
    WHERE orderID = id;
    
    IF currentNetPrice IS NULL THEN
		SET currentNetPrice = 0.00;
	END IF;
    
    SET newNetPrice = currentNetPrice + (NEW.unitPrice * NEW.quantity);
    
	UPDATE orders
	SET 
		netPrice = newNetPrice
	WHERE orderID = id;
END$$    

DELIMITER ;

DROP TRIGGER after_bills_insert_netPrice_cal;