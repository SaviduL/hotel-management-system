/****************************************************** reservation insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addReservation(
	IN bookingID INT,
    IN roomID INT,
    IN nett DECIMAL(8,2)
)  
BEGIN
	INSERT INTO reservations (
		bookingID,
        roomID,
        nett) 
    VALUES (bookingID, roomID, nett);
END$$

DELIMITER ;

CALL addReservation(2, 1, 20000.00);