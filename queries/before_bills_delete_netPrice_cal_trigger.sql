DELIMITER $$

CREATE TRIGGER before_bills_delete_netPrice_cal
    BEFORE DELETE
    ON bills FOR EACH ROW
BEGIN
    DECLARE currentNetPrice, newNetPrice DECIMAL(8,2);
	DECLARE id INT;
    
    IF OLD.deletedAt IS NULL THEN
		SET Id = OLD.orderID;
        
        SELECT netPrice
		INTO currentNetPrice
		FROM orders
		WHERE orderID = id;
        
		SET newNetPrice = currentNetPrice - (OLD.unitPrice * OLD.quantity);
        
        IF newNetPrice < 0 THEN
			SET newNetPrice = 0.00;
		END IF;

        UPDATE orders
		SET 
			netPrice = newNetPrice
		WHERE orderID = id;
    END IF;
END$$    

DELIMITER ;

DROP TRIGGER before_bills_delete_netPrice_cal;
