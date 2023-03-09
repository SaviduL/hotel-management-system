/****************************************************** item insert procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE addItem(
    IN name VARCHAR(50),
    IN category VARCHAR(20),
    IN description VARCHAR(150),
    IN price DECIMAL(7,2),
    IN image VARCHAR(300)
)  
BEGIN
	DECLARE itemID CHAR(8);
    
	SET itemID = generateItemID();
    
	INSERT INTO items (
		itemID,
		name,
		category,
		description,
		price,
		image) 
    VALUES (itemID, name, category, description, price, image);
END$$

DELIMITER ;

CALL addItem('Dum Biriyani', 'Main Course', 'include eggs, checken etc.', 1500, 'http://127.0.0.1:8080/');

/****************************************************** item update procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE updateItem(
	IN id CHAR(8),
    IN name VARCHAR(50),
    IN category VARCHAR(20),
    IN description VARCHAR(150),
    IN price DECIMAL(7,2),
    IN image VARCHAR(300)
)  
BEGIN
	UPDATE items
    SET 
		name = name,
        category = category,
        description = description,
        price = price,
        image = image
    WHERE itemID = id;
END$$

DELIMITER ;

CALL updateItem('ITEMS002', 'Tandoori chicken Biriyani', 'Main Course', 'include eggs, tandoori checken etc.', 1650, 'http://127.0.0.1:8080/');

/****************************************************** item delete procedure *********************************************************************/
DELIMITER $$

CREATE PROCEDURE deleteItem(
	IN id CHAR(8)
)  
BEGIN
	UPDATE items
    SET 
		deletedAt = CURRENT_TIMESTAMP()
    WHERE itemID = id;
END$$

DELIMITER ;

CALL deleteItem('ITEMS002');

/****************************************************** item view *********************************************************************/
CREATE VIEW items_view
AS 
SELECT 
	itemID,
	name,
	category,
	description,
	price,
	image,
    deletedAt
FROM
    items
WHERE deletedAt IS NULL;    
    
SELECT * FROM items_view;