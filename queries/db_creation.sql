CREATE DATABASE hotel_springboot_db;

USE hotel_springboot_db;

CREATE TABLE employees (
	employeeID CHAR(8) NOT NULL,
	employeeType VARCHAR(20) NOT NULL CHECK (employeeType IN ('Cashier', 'Chef', 'Manager', 'Receptionist', 'Waiter')),
	title VARCHAR(5) NOT NULL CHECK (title IN ('Mr.', 'Miss.', 'Mrs.', 'Ms.')),
	nic VARCHAR(12) NOT NULL,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50),
	dob DATE NOT NULL,
	sex CHAR(6) NOT NULL CHECK (Sex IN ('Male', 'Female', 'Other')),
	telNo CHAR(10) NOT NULL,
	address VARCHAR(150) NOT NULL,
	email VARCHAR(50),
    salary DECIMAL(8,2) NOT NULL,
	status CHAR(10) NOT NULL DEFAULT 'Active' CHECK (Status IN ('Active', 'Deactivate')),
	joinedDate DATE DEFAULT (CURRENT_DATE()),
    deletedAt DATETIME,
	PRIMARY KEY (employeeID)
);

CREATE TABLE cashiers (
	cashierID CHAR(8) NOT NULL,
    FOREIGN KEY (cashierID) REFERENCES employees(employeeID) ON DELETE CASCADE,
	PRIMARY KEY (cashierID)
);

CREATE TABLE chefs (
	chefID CHAR(8) NOT NULL,
    FOREIGN KEY (chefID) REFERENCES employees(employeeID) ON DELETE CASCADE,
	PRIMARY KEY (chefID)
);

CREATE TABLE managers (
	managerID CHAR(8) NOT NULL,
    FOREIGN KEY (managerID) REFERENCES employees(employeeID) ON DELETE CASCADE,
	PRIMARY KEY (managerID)
);

CREATE TABLE receptionists (
	receptionistID CHAR(8) NOT NULL,
    FOREIGN KEY (receptionistID) REFERENCES employees(employeeID) ON DELETE CASCADE,
	PRIMARY KEY (receptionistID)
);

CREATE TABLE waiters (
	waiterID CHAR(8) NOT NULL,
    FOREIGN KEY (waiterID) REFERENCES employees(employeeID) ON DELETE CASCADE,
	PRIMARY KEY (waiterID)
);

CREATE TABLE users (
	userID CHAR(8) NOT NULL,
	username VARCHAR(30) NOT NULL,
	password CHAR(100) NOT NULL,
    status CHAR(10) NOT NULL DEFAULT 'Active' CHECK (Status IN ('Active', 'Deactivate')),
	employeeID CHAR(8) NOT NULL,
    deletedAt DATETIME,
	FOREIGN KEY (employeeID) REFERENCES employees(employeeID) ON DELETE CASCADE,
	PRIMARY KEY (userID)
);

CREATE TABLE userloginrecords (
	userID CHAR(8) NOT NULL,
	loginDate DATE NOT NULL DEFAULT (CURRENT_DATE()),
	loginTime TIME NOT NULL DEFAULT (CURRENT_TIME()),
	logoutTime TIME,
	FOREIGN KEY (userID) REFERENCES users(userID),
	PRIMARY KEY (userID, loginDate, loginTime)
);

CREATE TABLE bonuses (
	bonusID INT NOT NULL AUTO_INCREMENT, 
	employeeID CHAR(8) NOT NULL,
    amount DECIMAL(7,2) NOT NULL,
    description VARCHAR(100) NOT NULL,
    date DATE NOT NULL DEFAULT (CURRENT_DATE()),
    deletedAt DATETIME,
	FOREIGN KEY (employeeID) REFERENCES employees(employeeID),
    PRIMARY KEY (bonusID)
);

CREATE TABLE advances (
	advanceID INT NOT NULL AUTO_INCREMENT,
	description VARCHAR(100) NOT NULL,
	amount DECIMAL(7,2) NOT NULL,
	date DATE NOT NULL DEFAULT (CURRENT_DATE()),
	employeeID CHAR(11) NOT NULL,
	handlerManagerID CHAR(11) NOT NULL,
    deletedAt DATETIME,
	FOREIGN KEY (employeeID) REFERENCES employees(employeeID),
	FOREIGN KEY (handlerManagerID) REFERENCES managers(managerID),
	PRIMARY KEY (advanceID)
);

CREATE TABLE guests (
	telNo CHAR(10) NOT NULL,
	title VARCHAR(5) NOT NULL CHECK (title IN ('Mr.', 'Miss.', 'Mrs.', 'Ms.', 'Rev.')),
	nic VARCHAR(12) NOT NULL,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50),
	sex CHAR(6) NOT NULL CHECK (Sex IN ('Male', 'Female', 'Other')),
	address VARCHAR(150) NOT NULL,
	email VARCHAR(50),
    deletedAt DATETIME,
	PRIMARY KEY (telNo)
);

CREATE TABLE bookings (
	bookingID INT NOT NULL AUTO_INCREMENT,
	guestID CHAR(10) NOT NULL,
    dateFrom DATE NOT NULL,
    dateTo DATE NOT NULL,
    status CHAR(9) NOT NULL DEFAULT 'Reserved' CHECK (Status IN ('Reserved', 'Confirmed', 'Cancelled', 'Completed')),
    billingAmount DECIMAL(8,2),
    noOfPerson INT NOT NULL,
    checkIn DATETIME,
    checkOut DATETIME,
    receptionistID CHAR(8) NOT NULL,
    deletedAt DATETIME,
    FOREIGN KEY (guestID) REFERENCES guests(telNo),
    FOREIGN KEY (receptionistID) REFERENCES receptionists(receptionistID),
    PRIMARY KEY (bookingID)
);

CREATE TABLE rooms (
	roomID INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    roomNo INT NOT NULL,
    description VARCHAR(100),
    bedType VARCHAR(15) NOT NULL CHECK (bedType IN ('Double/Full', 'Queen', 'King')),
    noOfBed INT NOT NULL,
    roomType VARCHAR(10) NOT NULL CHECK (roomType IN ('Single', 'Double', 'Triple', 'Quad')),
    charge DECIMAL(7,2) NOT NULL,
    deletedAt DATETIME,
    PRIMARY KEY (roomID)
);

CREATE TABLE reservations (
	bookingID INT NOT NULL,
    roomID INT NOT NULL,
    nett DECIMAL(8,2) NOT NULL,
    deletedAt DATETIME,
    FOREIGN KEY (bookingID) REFERENCES bookings(bookingID),
    FOREIGN KEY (roomID) REFERENCES rooms(roomID),
    PRIMARY KEY (bookingID, roomID)
);

CREATE TABLE items (
	itemID CHAR(8) NOT NULL,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(20) NOT NULL,
    description VARCHAR(150),
    price DECIMAL(7,2) NOT NULL,
    image VARCHAR(300) NOT NULL,
    deletedAt DATETIME,
    PRIMARY KEY (itemID)
);

CREATE TABLE orders (
	orderID INT NOT NULL AUTO_INCREMENT,
    date DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP()),
    status VARCHAR(20) NOT NULL DEFAULT 'Pending' CHECK (Status IN ('Pending', 'Cooking', 'Cooked', 'Cancelled', 'Paid')),
    netPrice DECIMAL(8,2),
    waiterID CHAR(8) NOT NULL,
    chefID CHAR(8),
    cashierID CHAR(8),
    deletedAt DATETIME,
    FOREIGN KEY (waiterID) REFERENCES waiters(waiterID),
    FOREIGN KEY (chefID) REFERENCES chefs(chefID),
    FOREIGN KEY (cashierID) REFERENCES cashiers(cashierID),
	PRIMARY KEY (orderID)
);

CREATE TABLE bills (
	orderID INT NOT NULL,
    itemID CHAR(8) NOT NULL,
    unitPrice DECIMAL(7,2) NOT NULL,
    quantity INT NOT NULL,
    deletedAt DATETIME,
    FOREIGN KEY (orderID) REFERENCES orders(orderID),
    FOREIGN KEY (itemID) REFERENCES items(itemID),
    PRIMARY KEY (orderID, itemID)
);
