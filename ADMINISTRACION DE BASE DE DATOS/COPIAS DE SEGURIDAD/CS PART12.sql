drop procedure sp_insertargral
--1.- sp que genere los insert de las tablas en el orden correcto.
create or alter proc sp_insertargral as
create table #orden(clave int ,nombretabla varchar (50),orden int) 
insert into #orden
exec sp_orden

declare @clave int, @nombre varchar(50), @texto varchar(50) select @clave = max(clave) from #orden
while @clave is not null
begin
     select @nombre = nombretabla
     from #orden
     where clave = @clave
     select @texto = 'sp_insertar['+ @nombre + ']'
     exec (@texto)
     select @clave = max(clave)
     from #orden
     where clave < @clave
end


--2.- sp que genere el orden de eliminacion de una tabla.
drop procedure sp_orden
create or alter proc sp_orden as
create table #t(clave int identity, id int, nombretabla varchar (50), orden int)
declare @orden int, @clave int, @id int
select @orden = 0
insert #t (id,nombretabla,orden)
select id, name, @orden from sysobjects
where id not in (select rkeyid from sysforeignkeys)
and xtype = 'u' and name not like 'sys%' and name not like 'ms%'
select @orden = @orden + 1
select @clave = min(clave) from #t
while @clave is not null
begin
      select @id = id from #t
      where clave = @clave
      if exists(select distinct rkeyid, object_name(rkeyid),@orden from sysforeignkeys where fkeyid = @id and object_name(rkeyid) not in (select nombretabla from #t))
      begin
          insert #t (id,nombretabla,orden)
          select distinct rkeyid, object_name(rkeyid),@orden
          from sysforeignkeys
          where fkeyid = @id
          and object_name(rkeyid) not in (select nombretabla from #t)
          select @orden = @orden + 1
      end
      else
          select @clave = min(clave) from #t where clave > @clave
end
select clave,nombretabla, orden from #t

--3.- sp que reciba el nombre de una tabla y genere el código de insert.
drop procedure sp_insertar
create or alter proc sp_insertar @tabla varchar(2000) as
declare @column_id int, @column_name varchar(max), @valor_actual varchar(max), @insert_inicio varchar(max), @tipo_dato varchar(max)
set @column_id=0
set @column_name=''
set @valor_actual=''
set @insert_inicio = 'insert ['+@tabla+'] '
select @column_id =
min(ordinal_position)
from information_schema.columns
where table_name=@tabla
while @column_id is not null
begin
     select @column_name=quotename(column_name),
     @tipo_dato=data_type
     from information_schema.columns
     where ordinal_position = @column_id
     and table_name = @tabla
     if @tipo_dato not in ('image','ntext','text')
     begin
         set @valor_actual=@valor_actual +
         case when @tipo_dato in ('char','varchar','nchar','nvarchar') then
         'coalesce(''''''''+replace(rtrim('+@column_name+'),'''''''','''''''''''')+'''''''',''null'')+'+''','''+'+'
         when @tipo_dato in ('datetime','smalldatetime') then
         'coalesce(''''''''+rtrim(convert(char,'+@column_name+',109))+'''''''',''null'')+'+''','''+'+'
         when @tipo_dato in ('int','smallint', 'bigint','numeric','decimal','bit','float','real','money') then
         'coalesce(''''+rtrim(convert(varchar,'+@column_name+'))+'''',''null'')+'+''','''+'+'
      end
end
select @column_id= min(ordinal_position)
from information_schema.columns
where table_name=@tabla
and ordinal_position>@column_id
end
set @valor_actual=left(@valor_actual,len(@valor_actual)-5)
set @valor_actual=
'select'+''''+rtrim(@insert_inicio)+''''+
'+'' values(''+'+ @valor_actual + '+'')'''+''+
'from'+''+'['+rtrim(@tabla) + ']'
exec (@valor_actual)

/*COMPROBAR*/
execute sp_insertargral
go
