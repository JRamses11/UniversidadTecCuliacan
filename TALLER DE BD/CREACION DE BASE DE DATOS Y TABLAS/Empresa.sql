use Empresa

create table Marcas(
ID int NOT NULL,
Nombre varchar(50),
PaisOrigen varchar (50),
AñoInicioVenta int,
Vigencia char
)
go

create table Estados(
IDEstado int NOT NULL,
Nombre varchar (50),
)
go

create table Municipios(
IDEstado int NOT NULL,
IDMunicipio int NOT NULL,
Nombre varchar (50),
)
go
create table Ciudades(
IDEstado int NOT NULL,
IDMunicipio int NOT NULL,
IDCiudad int NOT NULL, 
Nombre varchar (50)
)
go
--PRIMARYS KEYS
ALTER TABLE Marcas ADD CONSTRAINT PK_Marcas PRIMARY KEY (ID)
GO
ALTER TABLE Estados ADD CONSTRAINT PK_Estados PRIMARY KEY (IDEstado)
GO
ALTER TABLE Municipios ADD CONSTRAINT PK_Municipios PRIMARY KEY (IDEstado, IDMunicipio)
GO
ALTER TABLE Ciudades ADD CONSTRAINT PK_Ciudades PRIMARY KEY (IDEstado, IDMunicipio, IDCiudad)
GO
--FOREING KEY
ALTER TABLE Municipios ADD 
CONSTRAINT FK_Municipios_Estado FOREIGN KEY (IDEstado) REFERENCES Estados (IDEstado)
GO
ALTER TABLE Ciudades ADD
CONSTRAINT FK_Ciudades_Municipio FOREIGN KEY (IDEstado,IDMunicipio) REFERENCES Municipios (IDEstado,IDMunicipio)
GO

--INSERCIONES ESTADOS 
INSERT INTO Estados VALUES(11,'Sinaloa')
INSERT INTO Estados VALUES(12,'Sonora')
INSERT INTO Estados VALUES(13,'Jalisco')

--INSERCIONES MUNICIPIOS
INSERT INTO Municipios VALUES(11,01,'Culiacan')
INSERT INTO Municipios VALUES(11,02,'Mochis')
INSERT INTO Municipios VALUES(11,03,'Mocorito')
INSERT INTO Municipios VALUES(12,04,'Hermosillo')
INSERT INTO Municipios VALUES(12,05,'Nogales')
INSERT INTO Municipios VALUES(12,06,'Obregon')
INSERT INTO Municipios VALUES(13,07,'Zapotlanejo')
INSERT INTO Municipios VALUES(13,08,'Guadalajara')
INSERT INTO Municipios VALUES(13,09,'Mazamitla')

--INSERCIONES CIUDADES
INSERT INTO Ciudades VALUES (11,01,20,'Aguaruto')
INSERT INTO Ciudades VALUES (11,01,21,'Costa Rica')
INSERT INTO Ciudades VALUES (11,02,22,'Alamo')
INSERT INTO Ciudades VALUES (11,02,23,'Avila Corona')
INSERT INTO Ciudades VALUES (11,03,24,'Agua Pepe')
INSERT INTO Ciudades VALUES (11,03,25,'Pericos')

INSERT INTO Ciudades VALUES (12,04 ,26 ,'Olivares')
INSERT INTO Ciudades VALUES (12,04 ,27 ,'Villa Bonita ')
INSERT INTO Ciudades VALUES (12,05 ,28 ,'Agua Blanca')
INSERT INTO Ciudades VALUES (12,05 ,29 ,'Agua Caliente ')
INSERT INTO Ciudades VALUES (12,06 ,30 ,'Comisaria Providencia')
INSERT INTO Ciudades VALUES (12,06 ,31 ,'Comisaria Pueblo Yaqui ')

INSERT INTO Ciudades VALUES (13,07 ,32 ,'Colimilla')
INSERT INTO Ciudades VALUES (13,07 ,33 ,'Cuchillas')
INSERT INTO Ciudades VALUES (13,08 ,34 ,'Chapultepec ')
INSERT INTO Ciudades VALUES (13,08 ,35 ,'Arcos Vallarta')
INSERT INTO Ciudades VALUES (13,09 ,36 ,'El Humo')
INSERT INTO Ciudades VALUES (13,09 ,37 ,'El Paiztle')

--INSERCIONES MARCAS
INSERT INTO Marcas VALUES (1, 'Nike', 'USA', 2000, 'A')
INSERT INTO Marcas VALUES (2, 'Addidas', 'Alemania', 1998, 'A')
INSERT INTO Marcas VALUES (3, 'Puma', 'Italia', 1990, 'A')
INSERT INTO Marcas VALUES (4, 'Joma', 'España', 2002, 'A')
INSERT INTO Marcas VALUES (5, 'Charly', 'Mexico', 2015, 'A')
INSERT INTO Marcas VALUES (6, 'Sara', 'Francia', 2010, 'A')
INSERT INTO Marcas VALUES (7, 'Shein', 'USA', 1999, 'A')
INSERT INTO Marcas VALUES (8, 'Audi', 'Alemania', 1986, 'A')
INSERT INTO Marcas VALUES (9, 'Gucci', 'Reino Unido', 1980, 'A')
INSERT INTO Marcas VALUES (10, 'Nissan', 'Gales', 2002, 'A')

select*from Marcas
select*from Estados
select*from Municipios
select*from Ciudades