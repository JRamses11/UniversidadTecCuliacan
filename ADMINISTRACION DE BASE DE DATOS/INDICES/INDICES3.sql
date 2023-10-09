SET STATISTICS TIME ON

SET STATISTICS IO ON
---EJEMPLO SIN INDICE AGRUPADO
SELECT * FROM [dbo].[ClusteredIndexDemo] WHERE ID > 1000 and [EmployeeAddress] LIKE '%Hillcrest%'

--EJEMPLO INDICE CLUSTER
CREATE UNIQUE CLUSTERED INDEX IX_CLUSTEREDINDEXDEMO_ID
ON DBO.CLUSTEREDINDEXDEMO (ID ASC)
GO

SELECT * FROM [dbo].[ClusteredIndexDemo] WHERE ID > 1000 and [EmployeeAddress] LIKE '%Hillcrest%'

--EJMPLO 2 GUID
DROP INDEX IX_CLUSTEREDINDEXDEMO_ID ON DBO.CLUSTEREDINDEXDEMO

CREATE UNIQUE CLUSTERED INDEX IX_CLUSTEREDINDEXDEMO_ID
ON DBO.CLUSTEREDINDEXDEMO (GUID ASC)

SELECT * FROM [dbo].[ClusteredIndexDemo] WHERE GUID <> 'CB2F45A0-185F-9884-88EB-B7C497AB61EA' and [EmployeeAddress] LIKE '%Hillcrest%'

--EJEMPLO 3
DROP INDEX IX_CLUSTEREDINDEXDEMO_ID ON DBO.CLUSTEREDINDEXDEMO

CREATE CLUSTERED INDEX IX_CLUSTEREDINDEXDEMO_ID
ON DBO.CLUSTEREDINDEXDEMO (EMPLOYEENAME ASC)
WITH(SORT_IN_TEMPDB= OFF, DROP_EXISTING= OFF, FILLFACTOR=90) ON [PRIMARY]
GO

SELECT * FROM [dbo].[ClusteredIndexDemo] WHERE  EmployeeName  <> 'Gianna' and  EmployeeAddress  LIKE '%Hillcrest%'

--EJEMPLO 4
DROP INDEX IX_CLUSTEREDINDEXDEMO_ID ON DBO.CLUSTEREDINDEXDEMO

CREATE CLUSTERED INDEX IX_CLUSTEREDINDEXDEMO_ID
ON DBO.CLUSTEREDINDEXDEMO (BIRTHDATE ASC)
WITH(SORT_IN_TEMPDB= OFF, DROP_EXISTING= OFF, FILLFACTOR=90) ON [PRIMARY]
GO

SELECT * FROM [dbo].[ClusteredIndexDemo]  WHERE BirthDate BETWEEN '1950-01-01' AND '1950-12-31' AND EmployeeAddress like '%Hillcrest%'

--EJEMPLO 5
DROP INDEX IX_CLUSTEREDINDEXDEMO_ID ON DBO.CLUSTEREDINDEXDEMO

CREATE CLUSTERED INDEX IX_CLUSTEREDINDEXDEMO_ID
ON DBO.CLUSTEREDINDEXDEMO (EMPLOYEEADDRESS ASC)
WITH(SORT_IN_TEMPDB= OFF, DROP_EXISTING= OFF, FILLFACTOR=90) ON [PRIMARY]
GO

--EJEMPLO 6 INDICE NO CLUSTER
SELECT * FROM [dbo].[NonClusteredIndexDemo] 
WHERE StudentName ='Edward' AND STDAddress LIKE '%Route%'
GO
--EJEMPLO 7 INDICE NO CLUSTER 
CREATE NONCLUSTERED INDEX 
IX_NonClusteredIndexDemo_StudentName ON NonClusteredIndexDemo ( StudentName )
WITH (ONLINE = ON , FILLFACTOR=90 )
GO
SELECT * FROM dbo.NonClusteredIndexDemo WHERE StudentName ='Edward' AND STDAddress LIKE '%Route%'

--EJEMPLO 8 INDICE NO CLUSTER
DROP INDEX IX_NonClusteredIndexDemo_StudentName ON dbo.NonClusteredIndexDemo
GO

CREATE NONCLUSTERED INDEX IX_NonClusteredIndexDemo_StudentName ON NonClusteredIndexDemo ( StudentName )
WITH (ONLINE = ON , FILLFACTOR=90)
GO

CREATE NONCLUSTERED INDEX [IX_NonClusteredIndexDemo_StudentName] ON [dbo].[NonClusteredIndexDemo] ( StudentName )
INCLUDE (  ID , STDAddress  ) WITH (DROP_EXISTING=ON, ONLINE=ON, FILLFACTOR=90)
GO
SELECT * FROM dbo.NonClusteredIndexDemo WHERE StudentName ='Edward' AND STDAddress LIKE '%Route%'

--EJEMPLO 9 INDICE NO CLUSTER
CREATE NONCLUSTERED INDEX IX_NonClusteredIndexDemo_StudentName ON dbo.NonClusteredIndexDemo ( StudentName )
INCLUDE (  ID, STDBirthDate, STDPhone, STDAddress  ) WITH (DROP_EXISTING=ON, ONLINE=ON, FILLFACTOR=90)
GO

SELECT * FROM dbo.NonClusteredIndexDemo  WHERE StudentName ='Edward' AND STDAddress LIKE '%Route%'


--EJEMPLO 10 INDICE NO AGRUPADO CON INDICE AGRUPADO
DROP INDEX IX_NonClusteredIndexDemo_ID 
ON NonClusteredIndexDemo

CREATE UNIQUE CLUSTERED INDEX IX_NonClusteredIndexDemo_ID 
ON NonClusteredIndexDemo( ID )
WITH (ONLINE=ON, FILLFACTOR=90)

SELECT * FROM dbo.NonClusteredIndexDemo WHERE StudentName ='Edward' AND STDAddress LIKE '%Route%'

--EJEMPLPO 11
DROP INDEX IX_NonClusteredIndexDemo_StudentName
ON dbo.NonClusteredIndexDemo

CREATE NONCLUSTERED INDEX IX_NonClusteredIndexDemo_StudentName
ON dbo.NonClusteredIndexDemo ( StudentName )
INCLUDE ( ID , STDAddress )
WITH (ONLINE=ON, FILLFACTOR=90)

SELECT * FROM dbo.NonClusteredIndexDemo WHERE StudentName ='Edward' AND STDAddress LIKE '%Route%'

--EJEMPLO 12
CREATE NONCLUSTERED INDEX IX_NonClusteredIndexDemo_StudentName
ON dbo.NonClusteredIndexDemo ( StudentName )
INCLUDE ( ID , STDBirthDate, STDPhone, STDAddress )
WITH (DROP_EXISTING=ON, ONLINE=ON, FILLFACTOR=90)

SELECT * FROM dbo.NonClusteredIndexDemo WHERE StudentName ='Edward' AND STDAddress LIKE '%Route%'

--EJEMPLO 13
UPDATE [dbo].[NonClusteredIndexDemo]  SET STDAddress='335 Delaware Avenue'WHERE  STDAddress LIKE '%Delaware%'

--EJEMPLO 14
CREATE NONCLUSTERED INDEX IX_NonClusteredIndexDemo_StudentName
ON dbo.NonClusteredIndexDemo ( StudentName )
INCLUDE ([ID],[STDBirthDate],[STDPhone],[STDAddress])
WITH ( ONLINE=ON, FILLFACTOR=90)

UPDATE dbo.NonClusteredIndexDemo  SET STDAddress='336 Delaware Avenue' WHERE  STDAddress LIKE '%Delaware%'

--EJEMPLO 15
SELECT * FROM dbo.STD_Evaluation WHERE STD_ID < 1530

--EJEMPLO 16
CREATE NONCLUSTERED INDEX IX_STD_Evaluation_STD_ID ON [STD_Evaluation] (STD_ID)

SELECT * FROM [dbo].[STD_Evaluation] WHERE STD_ID < 1530

--EJEMPLO 17
DROP INDEX IX_STD_Evaluation_STD_ID ON STD_Evaluation
GO

CREATE NONCLUSTERED INDEX  IX_STD_Evaluation_STD_ID 
ON dbo.STD_Evaluation (  STD_ID )
INCLUDE ( EV_ID,Course_ID,STD_Course_Grade  )
GO

SELECT * FROM dbo.STD_Evaluation WHERE STD_ID < 1532

--EJEMPLO 18
SELECT ST.STD_Name , C.Course_Name, C.Course_MaxGrade,EV.STD_Course_Grade
FROM dbo.STD_Info ST
JOIN  dbo.STD_Evaluation EV ON ST.STD_ID =EV.STD_ID
JOIN dbo.Courses C ON C.Course_ID= EV.Course_ID
WHERE ST.STD_ID > 1500 AND C.Course_ID >320

--EJEMPLO 19
DROP INDEX IX_STD_Evaluation_Course_ID
ON dbo.STD_Evaluation

CREATE NONCLUSTERED INDEX IX_STD_Evaluation_Course_ID
ON dbo.STD_Evaluation (STD_ID,Course_ID)
INCLUDE (STD_Course_Grade)
GO

SELECT ST.STD_Name , C.Course_Name, C.Course_MaxGrade,EV.STD_Course_Grade
FROM dbo.STD_Info ST
JOIN  dbo.STD_Evaluation EV ON ST.STD_ID =EV.STD_ID
JOIN dbo.Courses C  ON C.Course_ID= EV.Course_ID
WHERE ST.STD_ID > 1500 AND C.Course_ID >320

--EJEMPLO 20
DROP INDEX IX_STD_Evaluation_Course_I ON dbo.STD_Evaluation 
GO
 
CREATE CLUSTERED INDEX IX_Evaluation_EV_ID ON STD_Evaluation  (EV_ID)
GO
 
CREATE NONCLUSTERED INDEX IX_STD_Evaluation_Course_ID
ON dbo.STD_Evaluation ( STD_ID , Course_ID )
INCLUDE ( STD_Course_Grade )
GO

--EJEMPLO 21
DROP INDEX IX_STD_Evaluation_Course_ID
ON dbo.STD_Evaluation

CREATE NONCLUSTERED INDEX IX_STD_Evaluation_Course_ID
ON dbo.STD_Evaluation ( STD_ID , Course_ID )
INCLUDE ( STD_Course_Grade )

SELECT ST.STD_Name , C.Course_Name, C.Course_MaxGrade,EV.STD_Course_Grade FROM dbo.STD_Info ST JOIN  dbo.STD_Evaluation EV ON ST.STD_ID =EV.STD_ID JOIN dbo.Courses C ON C.Course_ID= EV.Course_ID WHERE ST.STD_ID > 1500 AND C.Course_ID >322
ORDER BY ST.STD_ID DESC , C.Course_ID DESC

--EJEMPLO 22
CREATE NONCLUSTERED INDEX IX_XD ON dbo.STD_Evaluation (STD_ID , Course_ID )
INCLUDE ( STD_Course_Grade )


SELECT ST.STD_Name , C.Course_Name, C.Course_MaxGrade,EV.STD_Course_Grade
FROM dbo.STD_Info ST
JOIN  dbo.STD_Evaluation EV ON ST.STD_ID =EV.STD_ID
JOIN dbo.Courses C  ON C.Course_ID= EV.Course_ID
WHERE ST.STD_ID > 1500 AND C.Course_ID >320
ORDER BY ST.STD_ID ASC, C.Course_ID DESC

--EJEMPLO 23
DROP INDEX IX_XD ON dbo.STD_Evaluation
CREATE NONCLUSTERED INDEX IX_XD ON dbo.STD_Evaluation (STD_ID , Course_ID )
INCLUDE ( STD_Course_Grade )

SELECT ST.STD_Name , C.Course_Name, C.Course_MaxGrade,EV.STD_Course_Grade FROM dbo.STD_Info ST JOIN  dbo.STD_Evaluation EV ON ST.STD_ID =EV.STD_ID JOIN dbo.Courses C ON C.Course_ID= EV.Course_ID WHERE ST.STD_ID > 1500 AND C.Course_ID >322
ORDER BY ST.STD_ID ASC, C.Course_ID DESC

















