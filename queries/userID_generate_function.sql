DELIMITER $$

CREATE FUNCTION generateUserID()
RETURNS CHAR(8)
DETERMINISTIC
BEGIN
	DECLARE prefix CHAR(5) DEFAULT 'USERS';
	DECLARE idCount, counter INT;
	DECLARE id, lastId CHAR(8);
    
	SELECT COUNT(userID)
    INTO idCount
    FROM users;

    IF idCount > 0 THEN
		SELECT userID
		INTO lastId
		FROM users
		ORDER BY userID DESC
		LIMIT 1;
    
		SET lastId = SUBSTRING(lastId, 6, 3);
		SET counter = CAST(lastId AS DECIMAL);

		IF counter < 999 THEN
			IF counter < 9 THEN
				SET id = CONCAT(prefix, '00', counter + 1); 
			ELSEIF counter < 99 THEN
				SET id = CONCAT(prefix, '0', counter + 1);
			ELSE
				SET id = CONCAT(prefix, counter + 1);
			END IF;
		ELSE
			SET id  = "ID creation limit is exceeded for the system";
		END IF;
	ELSE
		SET id = CONCAT(prefix, '00', idCount + 1);
	END IF;
    
	RETURN id;
END$$

DELIMITER ;

SELECT generateUserID();
