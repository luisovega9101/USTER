CREATE TABLE "vehicles" (
	Id SERIAL NOT NULL,
	Brand varchar(55),
	Model varchar(55),
	Plate varchar(10),
	LicenseRequired varchar(1),
	PRIMARY KEY (Id)
);

CREATE TABLE "drivers" (
	Id SERIAL NOT NULL,
	Name varchar(55),
	Surname varchar(55),
	License varchar(1),
	PRIMARY KEY (Id)
);

CREATE TABLE "trip" (
	Id SERIAL NOT NULL, 
	vehiclesId SERIAL NOT NULL,
	driversId SERIAL NOT NULL,
	Date date,
	PRIMARY KEY (Id, vehiclesId, driversId), 
    CONSTRAINT "RefVehicles" FOREIGN KEY (vehiclesId)
    REFERENCES "vehicles"(Id),
    CONSTRAINT "RefDrivers" FOREIGN KEY (driversId)
    REFERENCES "drivers"(id)
);