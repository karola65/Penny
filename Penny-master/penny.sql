
CREATE TABLE Charity (
	Id INTEGER /*GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1)*/,
	Name VARCHAR2(255) NOT NULL,
	Description NCLOB,
	Purpose NCLOB,
	Keyword VARCHAR2(255),
	Location VARCHAR2(255),
	CONSTRAINT pk_charity PRIMARY KEY (Id)
);




CREATE TABLE User (
	UserName VARCHAR2(255) NOT NULL, /*GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1)*/,
	FirstName VARCHAR2(255) NOT NULL,
	LastName VARCHAR2(255) NOT NULL,
	Email VARCHAR2(255),
	Password1 VARCHAR2(255), NOT NULL,
	CONSTRAINT pk_user PRIMARY KEY (UserName)
);

CREATE TABLE Card (
	CardNumber VARCHAR2(255) NOT NULL, /*GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1)*/,
	Name VARCHAR2(255) NOT NULL,
	DateExire DATE,
	Purpose NCLOB,
	Type VARCHAR2(255),
	SecurityNumber INT,
	Balance INT,
	CONSTRAINT pk_charity PRIMARY KEY (CardNumber)
);