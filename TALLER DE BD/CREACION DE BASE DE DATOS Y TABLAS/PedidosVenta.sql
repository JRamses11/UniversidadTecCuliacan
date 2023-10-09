
CREATE TABLE Empleados(
empid INT not null,
emnombre NVARCHAR (40),
emapellidos NVARCHAR (40),
emcelular BIGINT,
jefeid INT not null
)
SELECT*FROM Empleados
GO

CREATE TABLE Pedidos(
folio INT not null,
pedfecha DATE,
cliid INT not null,
empid INT not null,
pedimporte NUMERIC (12,2)
)
SELECT*FROM Pedidos
GO

CREATE TABLE Clientes(
cliid INT not null,
clnombre NVARCHAR(40),
clapellidos NVARCHAR(40),
cldomicilio NVARCHAR(40),
clrfc NVARCHAR (40),
paisid INT not null,
edoid INT not null
)
SELECT*FROM Clientes
GO

CREATE TABLE Estados(
paisid INT not null,
edoid INT not null,
estnombre NVARCHAR(40),
estarea NVARCHAR (40)
)
SELECT*FROM Estados
GO

CREATE TABLE Pais(
paisid INT not null,
panombre NVARCHAR(40)
)
SELECT*FROM Pais
GO

-------------------------SELECT*FROM
SELECT*FROM Empleados
SELECT*FROM Pedidos
SELECT*FROM Clientes
SELECT*FROM Estados
SELECT*FROM Pais
---------------------------PRIMARY KEY
ALTER TABLE Empleados ADD CONSTRAINT PK_Empleados PRIMARY KEY (empid)
GO
ALTER TABLE Pedidos ADD CONSTRAINT PK_Pedidos PRIMARY KEY (folio)
GO
ALTER TABLE Clientes ADD CONSTRAINT PK_Clientes PRIMARY KEY (cliid)
GO
ALTER TABLE Estados ADD CONSTRAINT PK_Estados PRIMARY KEY (paisid,edoid)
GO
ALTER TABLE Pais ADD CONSTRAINT PK_Pais PRIMARY KEY (paisid)
GO

--------------------------FOREING KEY
ALTER TABLE Empleados ADD
CONSTRAINT FK_Empleados_Empleados FOREIGN KEY (jefeid) REFERENCES Empleados (empid)
GO
ALTER TABLE Pedidos ADD 
CONSTRAINT FK_Pedidos_Empleados FOREIGN KEY (empid) REFERENCES Empleados (empid),
CONSTRAINT FK_Pedidos_Clientes FOREIGN KEY (cliid) REFERENCES Clientes (cliid)
GO
ALTER TABLE Clientes ADD
CONSTRAINT FK_Cliente_Estados FOREIGN KEY (paisid, edoid) REFERENCES Estados (paisid, edoid)
GO
ALTER TABLE Estados ADD
CONSTRAINT FK_Estados_Pais FOREIGN KEY (paisid) REFERENCES Pais (paisid)
GO
-------------------------CHECK CONSTRAINT VALIDACIONES
ALTER TABLE Pedidos ADD
CONSTRAINT CC_Fecha_Pedidos CHECK (pedfecha>'2018/01/01'),
CONSTRAINT CC_Importe_Pedidos CHECK (pedimporte>0)
GO

------------------------INSERCIONES
--TABLA PAISES
INSERT INTO Pais VALUES(210,'Mexico');
INSERT INTO Pais VALUES(211,'Estados Unidos');
INSERT INTO Pais VALUES(212,'Canada');
GO
--TABLA ESTADOS
INSERT INTO Estados VALUES(210,111,'Sinaloa','Norte');
INSERT INTO Estados VALUES(210,112,'Sonora','Norte');
INSERT INTO Estados VALUES(211,113,'Los angeles','SUR');
INSERT INTO Estados VALUES(211,114,'Texas','SUR');
INSERT INTO Estados VALUES(212,115,'Toronto','ESTE');
GO
--TABLA CLIENTES
INSERT INTO Clientes VALUES(1,'Jose','Perez Marquez','Colonia Centro','AACR02091567',210,111);
INSERT INTO Clientes VALUES(2,'Mario','Ramirez Samboda','Boulevard conquistadores','AACR02098080',210,112);
INSERT INTO Clientes VALUES(3,'Pedro','Cruz Acosta','Santa Elena','AACR02091100',211,113);
INSERT INTO Clientes VALUES(4,'Maria','Rosario Cardenas','Villas del cedro','AACR02097361',211,114);
INSERT INTO Clientes VALUES(5,'Yaralilia','Valenzuela Lopez','4 de Marzo','AACR02095572',212,115);
GO
--TABLA PEDIDOS
INSERT INTO Pedidos VALUES(001,'01/09/2022',1,200,300);
INSERT INTO Pedidos VALUES(002,'02/09/2022',2,201,400);
INSERT INTO Pedidos VALUES(003,'03/09/2022',3,202,500)
INSERT INTO Pedidos VALUES(004,'04/09/2022',4,203,290);
INSERT INTO Pedidos VALUES(005,'05/09/2022',5,204,781);
GO
--TABLA EMPLEADOS
INSERT INTO Empleados VALUES(200,'Paco','Ramirez Obeso',667289567,200);
INSERT INTO Empleados VALUES(201,'Maria','Cazares Ayon',667356743,201);
INSERT INTO Empleados VALUES(202,'Jesus','Gastelum Rios',667405840,202);
INSERT INTO Empleados VALUES(203,'Sebastian','Aldama Rendon',667920482,203);
INSERT INTO Empleados VALUES(204,'Susana','Garibaldi Gomez',667289567,204);
GO



