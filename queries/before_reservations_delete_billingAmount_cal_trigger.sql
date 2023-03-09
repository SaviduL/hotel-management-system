DELIMITER $$

CREATE TRIGGER before_reservations_delete_billingAmount_cal
    BEFORE DELETE
    ON reservations FOR EACH ROW
BEGIN
	DECLARE currentNett, newNett DECIMAL(8,2);
	DECLARE Id INT;
    
    IF OLD.deletedAt IS NULL THEN
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

DROP TRIGGER before_reservations_delete_billingAmount_cal;