/****************************************************** booking insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addBooking(
	IN guestID CHAR(10),
    IN dateFrom DATE,
    IN dateTo DATE,
    IN noOfPerson INT,
    IN receptionistID CHAR(8),
    OUT bookingID INT
)  
BEGIN
	INSERT INTO bookings (
		guestID,
        dateFrom,
        dateTo,
        noOfPerson,
        receptionistID) 
    VALUES (guestID, dateFrom, dateTo, noOfPerson, receptionistID);
    
    SET bookingID = LAST_INSERT_ID();
END$$

DELIMITER ;

CALL addBooking('0717893412', '2022-10-10', '2022-10-12', 3, 'RECEP001', @bookingID);
SELECT @bookingID;

/****************************************************** booking update procedure | change booking date *********************************************************************/
DELIMITER $$

CREATE PROCEDURE changeBookingDate(
	IN id INT,
    IN dateFrom DATE,
    IN dateTo DATE,
    IN receptionistID CHAR(8)
)  
BEGIN
	UPDATE bookings
    SET 
		dateFrom = dateFrom,
		dateTo = dateTo,
		receptionistID = receptionistID
    WHERE bookingID = id;
END$$

DELIMITER ;

CALL changeBookingDate(2, '2022-10-11', '2022-10-13','RECEP001');

/****************************************************** booking update procedure | change booking noOfPerson *********************************************************************/
DELIMITER $$

CREATE PROCEDURE changeBookingNoOfPerson(
	IN id INT,
    IN noOfPerson INT,
    IN receptionistID CHAR(8)
)  
BEGIN
	UPDATE bookings
    SET 
		noOfPerson = noOfPerson,
		receptionistID = receptionistID
    WHERE bookingID = id;
END$$

DELIMITER ;

CALL changeBookingNoOfPerson(2, 4, 'RECEP001');

/****************************************************** booking update procedure | checkIn *********************************************************************/

DELIMITER $$

CREATE PROCEDURE checkInToBooking(
	IN id INT,
    IN receptionistID CHAR(8)
)  
BEGIN
	UPDATE bookings
    SET 
		checkIn = CURRENT_TIMESTAMP(),
		status = 'Confirmed',
		receptionistID = receptionistID
    WHERE bookingID = id;
END$$

DELIMITER ;

CALL checkInToBooking(2, 'RECEP001');

/****************************************************** booking update procedure | checkOut *********************************************************************/
DELIMITER $$

CREATE PROCEDURE checkOutFromBooking(
	IN id INT,
    IN receptionistID CHAR(8)
)  
BEGIN
	UPDATE bookings
    SET 
		checkOut = CURRENT_TIMESTAMP(),
		status = 'Completed',
		receptionistID = receptionistID
    WHERE bookingID = id;
END$$

DELIMITER ;

CALL checkOutFromBooking(2, 'RECEP001');

/****************************************************** booking update procedure | cancel booking *********************************************************************/
DELIMITER $$

CREATE PROCEDURE cancelBooking(
	IN id INT,
    IN receptionistID CHAR(8)
)  
BEGIN
	UPDATE bookings
    SET 
		status = 'Cancelled',
		receptionistID = receptionistID
    WHERE bookingID = id;
END$$

DELIMITER ;

CALL cancelBooking(2, 'RECEP001');

/****************************************************** booking delete procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE deleteBooking(
	IN id INT
)  
BEGIN
	UPDATE bookings
    SET 
		deletedAt = CURRENT_TIMESTAMP()
    WHERE bookingID = id;
END$$

DELIMITER ;

CALL deleteBooking(3);

/****************************************************** booking view *********************************************************************/
CREATE VIEW bookings_view
AS 
SELECT 
    bookingID,
	guestID,
    dateFrom,
    dateTo,
    status,
    billingAmount,
    noOfPerson,
    checkIn,
    checkOut,
    receptionistID,
    deletedAt
FROM
    bookings
WHERE deletedAt IS NULL;    
    
SELECT * FROM bookings_view;