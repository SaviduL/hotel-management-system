DELIMITER $$

CREATE TRIGGER after_bills_update_netPrice_cal
    AFTER UPDATE
    ON bills FOR EACH ROW
BEGIN
    DECLARE currentNetPrice, newNetPrice DECIMAL(8,2);
	DECLARE id INT;
    
    IF NEW.deletedAt IS NOT NULL THEN
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

DROP TRIGGER after_bills_update_netPrice_cal;
