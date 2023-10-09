--1.- Proponer un método de Auditar el comando select sobre todas la tablas de la base de datos Northwind. 
--Realizar 5 consultas y exponga el método de revisión de la auditoria.
DROP TABLE DBO.AUDITASELECT

CREATE TABLE DBO.AUDITASELECT(
CLAVE INT IDENTITY PRIMARY KEY NOT NULL,
FECHA DATETIME NOT NULL CONSTRAINT DF_AuditaSelect_FECHACAMBIOS DEFAULT (GETDATE()),
NOMBREDATABASE NVARCHAR (40) NOT NULL,
INICIOSESION NVARCHAR(500) NOT NULL,
USUARIO NVARCHAR (500)NOT NULL,
OBJETO NVARCHAR (500),
SENTENCIA NVARCHAR (MAX),
)

CREATE TRIGGER TRDB_1
ON DATABASE 
FOR ----------------- 
AS
BEGIN
      SET NOCOUNT ON;
	  DECLARE @INFOEVENT XML, @SENTENCIA NVARCHAR (MAX), @OBJETO NVARCHAR(500);
	  SET @INFOEVENT= EVENTDATA();
	  SET @OBJETO= @INFOEVENT.value('(/EVENT_INSTANCE/SCHEMANAME)[1]','VARCHAR(500)')
	  +','+@INFOEVENT.value('(EVENT_INSTANCE/OBJECTNAME)[1]','VARCHAR(500)');
	  SET @SENTENCIA=@INFOEVENT.value('(/EVENT_INSTANCE/TSQLCOMMAND)[1]','NVARCHAR(MAX)');

	  INSERT INTO DBO.AUDITASELECT(FECHA, NOMBREDATABASE, INICIOSESION, USUARIO, OBJETO, SENTENCIA)
	  VALUES( GETDATE(), 'Northwind', SUSER_NAME(), CURRENT_USER, @OBJETO, @SENTENCIA)
END
GO



--2.- Proponer un método para Auditar la execución de todos los procedimientos almacenados de la bd Northwind.
--Crear dos procedimientos almacenado y exponga el método de revisión de la auditoría.
CREATE TABLE DBO.AUDITAPROC(
CLAVE INT IDENTITY PRIMARY KEY NOT NULL,
FECHA DATETIME NOT NULL CONSTRAINT DF_AUDITAPROC_FECHACAMBIOS DEFAULT (GETDATE()),
NOMBREDATABASE VARCHAR (40) NOT NULL,
INICIOSESION VARCHAR(500) NOT NULL,
USUARIO VARCHAR (500)NOT NULL,
OBJETO VARCHAR (500) NOT NULL,
SENTENCIA VARCHAR (MAX)
)

CREATE TRIGGER TRDB_2
ON DATABASE
FOR-------
AS
   BEGIN
        SET NOCOUNT ON;
        DECLARE @INFOEVENT XML, @SENTENCIA NVARCHAR (MAX), @OBJETO NVARCHAR(500);
	     SET @INFOEVENT= EVENTDATA();
	     SET @OBJETO= @INFOEVENT.value('(/EVENT_INSTANCE/SCHEMANAME)[1]','VARCHAR(250)')
	     +','+@INFOEVENT.value('(EVENT_INSTANCE/OBJECTNAME)[1]','VARCHAR(250)');
	     SET @SENTENCIA=@INFOEVENT.value('(/EVENT_INSTANCE/TSQLCOMMAND)[1]','NVARCHAR(MAX)');

		 INSERT INTO DBO.AUDITAPROC(FECHA, NOMBREDATABASE,INICIOSESION,USUARIO, OBJETO, SENTENCIA)
		 VALUES(GETDATE(), 'Northwind' , SUSER_NAME(), CURRENT_USER, @OBJETO, @SENTENCIA)
   END
GO
--3.- Utilizando trigger DDL a nivel servidor auditar la creación, eliminación o modificación de base de datos, 
--inicios de sesión y copias de seguridad-restauraiones. Grabar en una tabla los siguientes datos: 
--ID
--Fecha del evento, 
--Servidor,
--Inicio de sesión,
--Tipo de evento, 
--Tipo de Objeto,
--Sentencia y 
--detalle del evento XML. 
--Realizar 5 acciones sobre base de datos, 5 acciones sobre inicios de sesión, 5 copias de seguridad y 5 respaldos.
DROP TABLE DBO.AUDITASERVIDOR
CREATE TABLE DBO.AUDITASERVIDOR(
ID INT IDENTITY PRIMARY KEY NOT NULL,
FECHA DATETIME NOT NULL CONSTRAINT DF_AUDITASERVIDOR_FECHACAMBIOS DEFAULT (GETDATE()),
SERVIDOR VARCHAR (500) NOT NULL,
INICIOSESION VARCHAR (500) NOT NULL,
EVENTO VARCHAR (500) ,
OBJETO VARCHAR (500) ,
SENTENCIA VARCHAR (MAX),
DETALLE XML NOT NULL
)

CREATE OR ALTER TRIGGER TRSV_3
ON ALL SERVER
FOR CREATE_DATABASE, ALTER_DATABASE, DROP_DATABASE, 
CREATE_LOGIN, DROP_LOGIN, ALTER_LOGIN, ADD_ROLE_MEMBER, DROP_ROLE_MEMBER, ADD_SERVER_ROLE_MEMBER, DROP_SERVER_ROLE_MEMBER,

AS
   BEGIN
        SET NOCOUNT ON;
		DECLARE @INFOEVENT XML, @EVENTO VARCHAR(500), @OBJETO VARCHAR(500), @SENTENCIA VARCHAR (MAX);
		SET	@INFOEVENT= EVENTDATA();
		SET @EVENTO= @INFOEVENT.value('(/EVENT_INSTANCE/EventType)[1]', 'NVARCHAR(500)');
	    SET @OBJETO= @INFOEVENT.value('(/EVENT_INSTANCE/SCHEMANAME)[1]','VARCHAR(500)')
	    +','+@INFOEVENT.value('(EVENT_INSTANCE/OBJECTNAME)[1]','VARCHAR(500)');
	    SET @SENTENCIA=@INFOEVENT.value('(/EVENT_INSTANCE/TSQLCOMMAND)[1]','NVARCHAR(MAX)');
	

		INSERT INTO DBO.AUDITASERVIDOR(FECHA, SERVIDOR, INICIOSESION, EVENTO, OBJETO, SENTENCIA, DETALLE)
		VALUES (GETDATE(), @@SERVERNAME, SUSER_NAME(), @EVENTO, @OBJETO, @SENTENCIA, @INFOEVENT)
   END
GO
-------------------------------BASE DE DATOSS
CREATE DATABASE DB_CALIZ1
GO
DROP DATABASE DB_CALIZ1
GO
CREATE DATABASE DB_CALIZ2
GO
DROP DATABASE DB_CALIZ2
GO
CREATE DATABASE DB_CALIZ3
------------------------------- INICIOS DE SESION
CREATE LOGIN JOSUE WITH PASSWORD = '123'
GO
SP_ADDSRVROLEMEMBER JOSUE, ServerAdmin

CREATE LOGIN SAMUEL WITH PASSWORD = '123'
GO
SP_ADDSRVROLEMEMBER SAMUEL, SecurityAdmin

CREATE LOGIN ALEXA WITH PASSWORD = '123'
GO
SP_ADDSRVROLEMEMBER ALEXA, SecurityAdmin

CREATE LOGIN ALAN WITH PASSWORD = '123'
GO
USE NorthwindNew
CREATE USER ALAN
GO
SP_ADDROLEMEMBER db_DataWriter, ALAN
GO

CREATE LOGIN CARLOS WITH PASSWORD = '123'
GO
USE NorthwindNew
CREATE USER CARLOS
GO
SP_ADDROLEMEMBER db_DataReader, CARLOS
GO
--------------------------------------RESTAURACIONES


SELECT*FROM DBO.AUDITASERVIDOR

--4.- Utilizando trigger DDL a nivel de base de datos (Northwind) auditar la creación, 
--eliminación o modificación de tablas vistas, procedimientos almacenados, funciones y trigger
CREATE TABLE dbo.AuditTrail
(
    Clave INT IDENTITY(1,1) PRIMARY KEY,
    EventDate DATETIME NOT NULL,
    LoginName varchar(100) NOT NULL,
    DBUserName varchar(120) NOT NULL,
    DatabaseName varchar(120) NOT NULL,
    EventType VARCHAR(120) NOT NULL,
    ObjectFullName NVARCHAR(500) NOT NULL,
    instruccion NVARCHAR(MAX) NOT NULL,
    detalle XML NOT NULL
);
CREATE or alter TRIGGER trigger4 
ON DATABASE 
FOR CREATE_PROCEDURE, ALTER_PROCEDURE, DROP_PROCEDURE,
    CREATE_FUNCTION, ALTER_FUNCTION, DROP_FUNCTION,
    CREATE_TRIGGER, ALTER_TRIGGER, DROP_TRIGGER,
    CREATE_VIEW, ALTER_VIEW, DROP_VIEW
AS 
BEGIN 
	DECLARE @eventdata XML = EVENTDATA();
    DECLARE @EventDate datetime = getdate();
	DECLARE @LoginName varchar(100) = system_user;
	DECLARE @DBUserName varchar(120) = @eventdata.value('(/EVENT_INSTANCE/UserName)[1]', 'varchar(120)');
	DECLARE @EventType NVARCHAR(100) = @eventdata.value('(/EVENT_INSTANCE/EventType)[1]', 'NVARCHAR(100)');
    DECLARE @ObjectName NVARCHAR(500) = @eventdata.value('(/EVENT_INSTANCE/ObjectName)[1]', 'NVARCHAR(500)');
    DECLARE @SchemaName NVARCHAR(500) = @eventdata.value('(/EVENT_INSTANCE/SchemaName)[1]', 'NVARCHAR(500)');
    DECLARE @Statement NVARCHAR(MAX) = @eventdata.value('(/EVENT_INSTANCE/TSQLCommand/CommandText)[1]', 'NVARCHAR(MAX)');

    -- Insertar los valores obtenidos en la tabla de auditoría
    INSERT INTO dbo.AuditTrail 
    VALUES (@EventDate, @LoginName, @DBUserName, 'northwind', @EventType, 
	QUOTENAME(@SchemaName) + '.' + QUOTENAME(@ObjectName), @Statement, @eventdata);
END;

create view vista as select * from Products

CREATE VIEW TestView AS
SELECT * FROM Customers

ALTER VIEW TestView AS
SELECT * FROM Suppliers

CREATE PROCEDURE TestProc
AS
BEGIN
    SELECT * FROM Orders;
END;

ALTER PROCEDURE TestProc
AS
BEGIN
    SELECT OrderID, CustomerID FROM Orders;
END;

CREATE FUNCTION TestFunc() RETURNS INT AS BEGIN RETURN 1; END;

select * from dbo.AuditTrail 

--5.- Auditar los cambios de las tablas de la base 
--de datos Northwind, grabar en una tabla los campos:
CREATE TABLE AuditTable (
    TipoTransaccion VARCHAR(10),
    NombreTabla VARCHAR(100),
    LlavePrimaria VARCHAR(MAX),
    CampoModificado VARCHAR(MAX),
    ValorOriginal VARCHAR(MAX),
    ValorNuevo VARCHAR(MAX),
    FechaTransaccion DATETIME,
    NombreUsuario VARCHAR(100)
);
CREATE OR ALTER TRIGGER updateproducts 
ON products FOR UPDATE 
AS 
BEGIN 
    IF UPDATE(ProductName) OR UPDATE(UnitPrice)
    BEGIN 
        DECLARE @TransactionType VARCHAR(10) = 'Update';
        DECLARE @TableName VARCHAR(50) = 'products';
        DECLARE @PrimaryKeyColumn VARCHAR(50) = 'ProductID';
        DECLARE @ModifiedColumn VARCHAR(50) = '';
        DECLARE @OriginalValue VARCHAR(100) = '';
        DECLARE @NewValue VARCHAR(100) = '';
        DECLARE @TransactionDate DATETIME = GETDATE();
        DECLARE @UserName VARCHAR(50) = system_user;
        
        -- Obtener los valores antiguos y nuevos del campo modificado
        IF UPDATE(ProductName)
        BEGIN
            SET @ModifiedColumn = 'ProductName';
            SET @OriginalValue = (SELECT ProductName FROM deleted);
            SET @NewValue = (SELECT ProductName FROM inserted);
        END
        ELSE IF UPDATE(UnitPrice)
        BEGIN
            SET @ModifiedColumn = 'UnitPrice';
            SET @OriginalValue = (SELECT CONVERT(VARCHAR(20), UnitPrice) FROM deleted);
            SET @NewValue = (SELECT CONVERT(VARCHAR(20), UnitPrice) FROM inserted);
        END
        
        -- Insertar los valores obtenidos en la tabla de auditoría
        INSERT INTO AuditTable 
        VALUES (@TransactionType, @TableName, @PrimaryKeyColumn, @ModifiedColumn, 
                @OriginalValue, @NewValue, @TransactionDate, @UserName);
    END
END;
select * from AuditTable
UPDATE Products
SET  UnitPrice = 10 + UnitPrice
WHERE ProductID = 1

CREATE OR ALTER TRIGGER updatedeletecustomers 
ON customers FOR UPDATE 
AS 
BEGIN 
	DECLARE @TipoTransaccion VARCHAR(10);
        IF EXISTS (SELECT * FROM inserted) AND EXISTS (SELECT * FROM deleted)
			SET @TipoTransaccion = 'update'
		ELSE IF EXISTS (SELECT * FROM deleted)
			SET @TipoTransaccion = 'delete'
    IF UPDATE(Address) OR UPDATE(phone)
    BEGIN 
        DECLARE @TableName VARCHAR(50) = 'customers';
        DECLARE @PrimaryKeyColumn VARCHAR(50) = 'CustomerID';
        DECLARE @ModifiedColumn VARCHAR(50) = '';
        DECLARE @OriginalValue VARCHAR(100) = '';
        DECLARE @NewValue VARCHAR(100) = '';
        DECLARE @TransactionDate DATETIME = GETDATE();
        DECLARE @UserName VARCHAR(50) = system_user;
        
        -- Obtener los valores antiguos y nuevos del campo modificado
        IF UPDATE(Address)
        BEGIN
            SET @ModifiedColumn = 'Adress';
            SET @OriginalValue = (SELECT Address FROM deleted);
            SET @NewValue = (SELECT Address FROM inserted);
        END
        ELSE IF UPDATE(phone)
        BEGIN
            SET @ModifiedColumn = 'phone';
            SET @OriginalValue = (SELECT CONVERT(VARCHAR(20), phone) FROM deleted);
            SET @NewValue = (SELECT CONVERT(VARCHAR(20), phone) FROM inserted);
        END
        
        -- Insertar los valores obtenidos en la tabla de auditoría
        INSERT INTO AuditTable 
        VALUES (@TipoTransaccion, @TableName, @PrimaryKeyColumn, @ModifiedColumn, 
                @OriginalValue, @NewValue, @TransactionDate, @UserName);
    END
END;
select * from Customers
UPDATE Customers
SET  phone = 'fdsfadfdsf'
WHERE customerID = 'alfki'
select * from AuditTable

CREATE OR ALTER TRIGGER insertdeleteEmployees 
ON employees FOR insert, delete 
AS 
BEGIN 
	DECLARE @TipoTransaccion VARCHAR(10);
        IF EXISTS (SELECT * FROM inserted)
			SET @TipoTransaccion = 'insert'
		ELSE IF EXISTS (SELECT * FROM deleted)
			SET @TipoTransaccion = 'delete'
        DECLARE @TableName VARCHAR(50) = 'Employees';
        DECLARE @PrimaryKeyColumn VARCHAR(50) = 'EmployeeID';
        DECLARE @ModifiedColumn VARCHAR(50) = 'todas';
        DECLARE @OriginalValue VARCHAR(100) = '-';
        DECLARE @NewValue VARCHAR(100) = '-';
        DECLARE @TransactionDate DATETIME = GETDATE();
        DECLARE @UserName VARCHAR(50) = system_user;

        -- Insertar los valores obtenidos en la tabla de auditoría
        INSERT INTO AuditTable 
        VALUES (@TipoTransaccion, @TableName, @PrimaryKeyColumn, @ModifiedColumn, 
                @OriginalValue, @NewValue, @TransactionDate, @UserName);
END;
select * from Employees

INSERT INTO Employees 
    (LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath)
VALUES 
    ('Doe', 'John', 'Sales Manager', 'Mr.', '1980-01-01', '2020-01-01', '123 Main St', 'Seattle', 'WA', '98001', 'USA', '555-1234', '1', null, 'Some notes', 2, null);
delete from Employees where EmployeeID = 12
select * from AuditTable

CREATE OR ALTER TRIGGER updatedetalle 
ON [order details] FOR UPDATE 
AS 
BEGIN 
    IF UPDATE(unitprice) OR UPDATE(quantity)
    BEGIN 
        DECLARE @TransactionType VARCHAR(10) = 'Update';
        DECLARE @TableName VARCHAR(50) = 'Order Detalle';
        DECLARE @PrimaryKeyColumn VARCHAR(50) = '-';
        DECLARE @ModifiedColumn VARCHAR(50) = '';
        DECLARE @OriginalValue VARCHAR(100) = '';
        DECLARE @NewValue VARCHAR(100) = '';
        DECLARE @TransactionDate DATETIME = GETDATE();
        DECLARE @UserName VARCHAR(50) = system_user;
        
        -- Obtener los valores antiguos y nuevos del campo modificado
        IF UPDATE(unitprice)
        BEGIN
            SET @ModifiedColumn = 'unitprice';
            SET @OriginalValue = (SELECT CONVERT(VARCHAR(20), unitprice) FROM deleted);
            SET @NewValue = (SELECT CONVERT(VARCHAR(20), unitprice) FROM inserted);
        END
        ELSE IF UPDATE(quantity)
        BEGIN
            SET @ModifiedColumn = 'quantity';
            SET @OriginalValue = (SELECT CONVERT(VARCHAR(20), quantity) FROM deleted);
            SET @NewValue = (SELECT CONVERT(VARCHAR(20), quantity) FROM inserted);
        END
        
        -- Insertar los valores obtenidos en la tabla de auditoría
        INSERT INTO AuditTable 
        VALUES (@TransactionType, @TableName, @PrimaryKeyColumn, @ModifiedColumn, 
                @OriginalValue, @NewValue, @TransactionDate, @UserName);
    END
END;
select * from [Order Details]
update [Order Details] set Quantity = Quantity + 1 where orderid = 10248 and ProductID = 11
select * from AuditTable
