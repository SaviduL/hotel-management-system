DELIMITER $$

CREATE TRIGGER after_employees_insert
    AFTER INSERT
    ON employees FOR EACH ROW
BEGIN
	CASE NEW.employeeType
		WHEN 'Cashier' THEN
			INSERT INTO cashiers (cashierID)
			VALUES (new.employeeID);
        WHEN 'Chef' THEN
			INSERT INTO chefs (chefID)
			VALUES (new.employeeID);
		WHEN 'Manager' THEN
			INSERT INTO managers (managerID)
			VALUES (new.employeeID);
		WHEN 'Receptionist' THEN
			INSERT INTO receptionists (receptionistID)
			VALUES (new.employeeID);
		WHEN 'Waiter' THEN
			INSERT INTO waiters (waiterID)
			VALUES (new.employeeID);
	END CASE;
END$$    

DELIMITER ;