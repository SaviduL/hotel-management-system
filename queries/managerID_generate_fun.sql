DELIMITER $$

CREATE FUNCTION generateManagerID()
RETURNS CHAR(8)
DETERMINISTIC
BEGIN
	DECLARE prefix CHAR(5) DEFAULT 'MANGR';
	DECLARE idCount, counter INT;
	DECLARE id, lastId CHAR(8);
    
	SELECT COUNT(managerID)
    INTO idCount
    FROM managers;

    IF idCount > 0 THEN
		SELECT managerID
		INTO lastId
		FROM managers
		ORDER BY managerID DESC
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

SELECT generateManagerID();
