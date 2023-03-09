DELIMITER $$

CREATE TRIGGER after_reservations_insert_billingAmount_cal
    AFTER INSERT
    ON reservations FOR EACH ROW
BEGIN
	DECLARE currentNett DECIMAL(8,2);
	DECLARE newNett DECIMAL(8,2);
	DECLARE id INT;
    
    SET id = NEW.bookingID;
	
    SELECT billingAmount
    INTO currentNett
    FROM bookings
    WHERE  bookingID = id;
    
    IF currentNett IS NULL THEN
		SET currentNett = 0.00;
	END IF;
    
    SET newNett = currentNett + NEW.nett;
    
	UPDATE bookings
	SET 
		billingAmount = newNett
	WHERE bookingID = id;
    
END$$    

DELIMITER ;
