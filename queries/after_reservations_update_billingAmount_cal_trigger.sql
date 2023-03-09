DELIMITER $$

CREATE TRIGGER after_reservations_update_billingAmount_cal
    AFTER UPDATE
    ON reservations FOR EACH ROW
BEGIN
	DECLARE currentNett, newNett DECIMAL(8,2);
	DECLARE Id INT;
    
    IF NEW.deletedAt IS NOT NULL THEN
		SET Id = OLD.bookingID;
        
        SELECT billingAmount
		INTO currentNett
		FROM bookings
		WHERE  bookingID = Id;
        
        SET newNett = currentNett - OLD.nett;
        
        IF newNett < 0 THEN
			SET newNett = 0.00;
		END IF;
        
        UPDATE bookings
		SET 
			billingAmount = newNett
		WHERE bookingID = Id;
    END IF;
END$$    

DELIMITER ;

DROP TRIGGER after_reservations_update_billingAmount_cal;