-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.18-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para db_electronica
CREATE DATABASE IF NOT EXISTS `db_electronica` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_electronica`;

-- Volcando estructura para tabla db_electronica.clase_producto
CREATE TABLE IF NOT EXISTS `clase_producto` (
  `Codigo_CP` varchar(10) NOT NULL,
  `Nombre_CP` varchar(30) NOT NULL,
  `Estado_CP` char(3) DEFAULT 'HAB',
  PRIMARY KEY (`Codigo_CP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.detalle_venta
CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `Codigo_V` varchar(20) NOT NULL,
  `Codigo_P` varchar(10) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Cantidad` decimal(10,2) NOT NULL,
  `Descuento` decimal(10,2) NOT NULL,
  `SubTotal` decimal(10,2) NOT NULL,
  KEY `FK_Codigo_V` (`Codigo_V`),
  KEY `FK_Codigo_P` (`Codigo_P`),
  CONSTRAINT `FK_Codigo_P` FOREIGN KEY (`Codigo_P`) REFERENCES `producto` (`Codigo_P`),
  CONSTRAINT `FK_Codigo_V` FOREIGN KEY (`Codigo_V`) REFERENCES `venta` (`Codigo_V`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.marca_producto
CREATE TABLE IF NOT EXISTS `marca_producto` (
  `Codigo_MP` varchar(10) NOT NULL,
  `Nombre_MP` varchar(30) NOT NULL,
  `Estado_MP` char(3) DEFAULT 'HAB',
  PRIMARY KEY (`Codigo_MP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para procedimiento db_electronica.MODIFICAR_MARCA_PRODUCTO
DELIMITER //
CREATE PROCEDURE `MODIFICAR_MARCA_PRODUCTO`(
	IN CCodigo_MP VARCHAR(10), 
    IN NNombre_MP VARCHAR(30)
)
begin
	update MARCA_PRODUCTO set Nombre_MP=UPPER(NNombre_MP) where Codigo_MP=CCodigo_MP;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MODIFICAR_USUARIO
DELIMITER //
CREATE PROCEDURE `MODIFICAR_USUARIO`(
	IN CCodigo_U VARCHAR(10),
	IN NNombres_U VARCHAR(50),
    IN AApellidos_U VARCHAR(50),
    IN DDni_U CHAR(8),
    IN DDepartamento_U VARCHAR(20),
    IN PProvincia_U VARCHAR(20),
    IN DDistrito_U VARCHAR(20),
    IN DDireccion1_U VARCHAR(50),
    IN DDireccion2_U VARCHAR(50),
    IN TTelefono_U VARCHAR(9)
)
begin
	update USUARIO set Nombres_U=UPPER(NNombres_U), Apellidos_U=UPPER(AApellidos_U), Dni_U=UPPER(DDni_U), Departamento_U=UPPER(DDepartamento_U), Provincia_U=UPPER(PProvincia_U), Distrito_U=UPPER(DDistrito_U), Direccion1_U=UPPER(DDireccion1_U), Direccion2_U=UPPER(DDireccion2_U), Telefono_U=TTelefono_U where Codigo_U=UPPER(CCodigo_U);
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_CLASE_PRODUCTO_HABILITADOS
DELIMITER //
CREATE PROCEDURE `MOSTRAR_CLASE_PRODUCTO_HABILITADOS`()
BEGIN
	SELECT * FROM CLASE_PRODUCTO
    WHERE Estado_CP = 'HAB'
    ORDER BY Nombre_CP ASC;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_CLASE_PRODUCTO_INHABILITADOS
DELIMITER //
CREATE PROCEDURE `MOSTRAR_CLASE_PRODUCTO_INHABILITADOS`()
BEGIN
	SELECT * FROM CLASE_PRODUCTO
    WHERE Estado_CP = 'INH'
    ORDER BY Nombre_CP ASC;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_CODIGO_CLASE_PRODUCTO
DELIMITER //
CREATE PROCEDURE `MOSTRAR_CODIGO_CLASE_PRODUCTO`()
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_CP) from CLASE_PRODUCTO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('CP000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('CP00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('CP0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('CP'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'CP0001');
	end if;
    
    SELECT MAX(CCodigo) AS Codigo_CP FROM CLASE_PRODUCTO;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_CODIGO_MARCA_PRODUCTO
DELIMITER //
CREATE PROCEDURE `MOSTRAR_CODIGO_MARCA_PRODUCTO`()
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_MP) from MARCA_PRODUCTO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('MP000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('MP00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('MP0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('MP'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'MP0001');
	end if;
    
    SELECT MAX(CCodigo) AS Codigo_MP FROM MARCA_PRODUCTO;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_CODIGO_PRODUCTO
DELIMITER //
CREATE PROCEDURE `MOSTRAR_CODIGO_PRODUCTO`()
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_P) from PRODUCTO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('P000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('P00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('P0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('P'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'P0001');
	end if;
    
    SELECT MAX(CCodigo) AS Codigo_P FROM PRODUCTO;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_CODIGO_USUARIO
DELIMITER //
CREATE PROCEDURE `MOSTRAR_CODIGO_USUARIO`()
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_U) from USUARIO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('U000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('U00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('U0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('U'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'U0001');
	end if;
    
    SELECT MAX(CCodigo) AS Codigo_U FROM USUARIO;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_CODIGO_VENTA
DELIMITER //
CREATE PROCEDURE `MOSTRAR_CODIGO_VENTA`()
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_V) from VENTA);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('V000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('V00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('V0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('V'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'V0001');
	end if;
    
    SELECT MAX(CCodigo) AS Codigo_V FROM VENTA;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_DETALLE_VENTA_POR_CODIGO
DELIMITER //
CREATE PROCEDURE `MOSTRAR_DETALLE_VENTA_POR_CODIGO`(IN CCodigo_V VARCHAR(10))
BEGIN
	SELECT dv.Codigo_V, CONCAT(c.Nombre_CP,' ',m.Nombre_MP,' - ',p.Descripcion_P) as Producto, dv.Precio, dv.Cantidad, dv.Descuento, dv.SubTotal
    FROM DETALLE_VENTA dv
    INNER JOIN PRODUCTO p ON p.Codigo_P = dv.Codigo_P
    INNER JOIN CLASE_PRODUCTO c ON c.Codigo_CP = p.Codigo_CP
    INNER JOIN MARCA_PRODUCTO m ON m.Codigo_MP = p.Codigo_MP
    WHERE dv.Codigo_V = CCodigo_V;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_MARCA_PRODUCTO_HABILITADOS
DELIMITER //
CREATE PROCEDURE `MOSTRAR_MARCA_PRODUCTO_HABILITADOS`()
begin
	SELECT * FROM MARCA_PRODUCTO
    where Estado_MP = 'HAB'
    ORDER BY Nombre_MP ASC;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_MARCA_PRODUCTO_INHABILITADOS
DELIMITER //
CREATE PROCEDURE `MOSTRAR_MARCA_PRODUCTO_INHABILITADOS`()
begin
	SELECT * FROM MARCA_PRODUCTO
    where Estado_MP = 'INH'
    ORDER BY Nombre_MP ASC;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_PRODUCTOS_ELIMINADOS
DELIMITER //
CREATE PROCEDURE `MOSTRAR_PRODUCTOS_ELIMINADOS`()
BEGIN
	SELECT P.Codigo_P, CP.Nombre_CP as Clase_P, MP.Nombre_MP as Marca_P, P.Descripcion_P, P.Precio_P, P.Imagen_P, P.Estado_P FROM PRODUCTO P
	INNER JOIN clase_producto CP ON CP.Codigo_CP = P.Codigo_CP
	INNER JOIN marca_producto MP ON MP.Codigo_MP = P.Codigo_MP
	WHERE P.Estado_P = 'INH' ORDER BY cp.Nombre_CP ASC;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_PRODUCTOS_HABILITADOS
DELIMITER //
CREATE PROCEDURE `MOSTRAR_PRODUCTOS_HABILITADOS`()
BEGIN
	SELECT P.Codigo_P, CP.Nombre_CP as Clase_P, MP.Nombre_MP as Marca_P, P.Descripcion_P, P.Precio_P, P.Imagen_P, P.Estado_P FROM PRODUCTO P
	INNER JOIN clase_producto CP ON CP.Codigo_CP = P.Codigo_CP
	INNER JOIN marca_producto MP ON MP.Codigo_MP = P.Codigo_MP
	WHERE P.Estado_P = 'HAB' and CP.Estado_CP = 'HAB' and MP.Estado_MP = 'HAB' ORDER BY cp.Nombre_CP ASC;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_USUARIOS_CLIENTES_HABILITADOS
DELIMITER //
CREATE PROCEDURE `MOSTRAR_USUARIOS_CLIENTES_HABILITADOS`()
begin
	select Codigo_U,Nombres_U,Apellidos_U,Dni_U,Email_U,Telefono_U,Id_U,Tipo_U,Estado_U from USUARIO
    where Tipo_U LIKE 'CLIENTE' and Estado_U = 'HAB'
    order by Nombres_U asc;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_USUARIOS_CLIENTES_INHABILITADOS
DELIMITER //
CREATE PROCEDURE `MOSTRAR_USUARIOS_CLIENTES_INHABILITADOS`()
begin
	select Codigo_U,Nombres_U,Apellidos_U,Dni_U,Email_U,Telefono_U,Id_U,Tipo_U,Estado_U from USUARIO
    where Tipo_U LIKE 'CLIENTE' and Estado_U = 'INH'
    order by Nombres_U asc;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_USUARIO_POR_CODIGO
DELIMITER //
CREATE PROCEDURE `MOSTRAR_USUARIO_POR_CODIGO`(
	IN CCodigo_U VARCHAR(10)
)
begin
	select * from USUARIO
    where Codigo_U = CCodigo_U;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.MOSTRAR_VENTA
DELIMITER //
CREATE PROCEDURE `MOSTRAR_VENTA`()
BEGIN
	SELECT Codigo_V, USUARIO.Codigo_U, concat(USUARIO.Nombres_U,', ', USUARIO.Apellidos_U) AS Cliente, Total, DATE_FORMAT(Fecha,'%d/%m/%Y a las %H:%i:%s horas') AS Fecha  FROM VENTA
    INNER JOIN USUARIO ON USUARIO.Codigo_U = VENTA.Codigo_U 
    ORDER BY Fecha desc;
END//
DELIMITER ;

-- Volcando estructura para tabla db_electronica.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `Codigo_P` varchar(10) NOT NULL,
  `Codigo_CP` varchar(10) NOT NULL,
  `Codigo_MP` varchar(10) NOT NULL,
  `Descripcion_P` varchar(100) NOT NULL,
  `Precio_P` decimal(10,2) NOT NULL,
  `Stock_P` decimal(6,2) DEFAULT 0.00,
  `Imagen_P` varchar(100) DEFAULT NULL,
  `Estado_P` char(3) DEFAULT 'HAB',
  PRIMARY KEY (`Codigo_P`),
  KEY `FK_Codigo_CP` (`Codigo_CP`),
  KEY `FK_Codigo_MP` (`Codigo_MP`),
  CONSTRAINT `FK_Codigo_CP` FOREIGN KEY (`Codigo_CP`) REFERENCES `clase_producto` (`Codigo_CP`),
  CONSTRAINT `FK_Codigo_MP` FOREIGN KEY (`Codigo_MP`) REFERENCES `marca_producto` (`Codigo_MP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para procedimiento db_electronica.RECUPERAR_CLASE_PRODUCTO
DELIMITER //
CREATE PROCEDURE `RECUPERAR_CLASE_PRODUCTO`(
	IN CCodigo_CP VARCHAR(10)
)
begin
	update CLASE_PRODUCTO set Estado_CP='HAB' where Codigo_CP=UPPER(CCodigo_CP);
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.RECUPERAR_MARCA_PRODUCTO
DELIMITER //
CREATE PROCEDURE `RECUPERAR_MARCA_PRODUCTO`(
	IN CCodigo_MP VARCHAR(10)
)
begin
	update MARCA_PRODUCTO set Estado_MP='HAB' where Codigo_MP=CCodigo_MP;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.RECUPERAR_PRODUCTO
DELIMITER //
CREATE PROCEDURE `RECUPERAR_PRODUCTO`(
	IN CCodigo_P VARCHAR(10)
)
begin
	update PRODUCTO set Estado_P='HAB' where Codigo_P=CCodigo_P;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.RECUPERAR_USUARIO
DELIMITER //
CREATE PROCEDURE `RECUPERAR_USUARIO`(
	IN CCodigo_U VARCHAR(10)
)
begin
	update USUARIO set Estado_U='HAB' where Codigo_U=CCodigo_U;
end//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.REGISTRAR_CLASE_PRODUCTO
DELIMITER //
CREATE PROCEDURE `REGISTRAR_CLASE_PRODUCTO`(
	IN NNombre_CP VARCHAR(30)
)
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_CP) from CLASE_PRODUCTO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('CP000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('CP00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('CP0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('CP'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'CP0001');
	end if;
    
    if not exists (select Codigo_CP,Nombre_CP,Estado_CP from CLASE_PRODUCTO where Codigo_CP=CCodigo or Nombre_CP=NNombre_CP and (Estado_CP='HAB' or Estado_CP='INH')) then
		insert into CLASE_PRODUCTO(Codigo_CP,Nombre_CP) values (UPPER(CCodigo) ,UPPER(NNombre_CP));
	end if;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.REGISTRAR_DETALLE_VENTA
DELIMITER //
CREATE PROCEDURE `REGISTRAR_DETALLE_VENTA`(
	IN CCodigo_V VARCHAR(10),
    IN NNombre_P VARCHAR(100),
    IN PPrecio DECIMAL(10,2),
	IN CCantidad DECIMAL(10,2),
    IN DDescuento DECIMAL(10,2),
    IN SSubTotal DECIMAL(10,2)
)
BEGIN
	declare CCodigo_P varchar(10);
    
    set CCodigo_P = (SELECT Codigo_P FROM PRODUCTO P
    INNER JOIN clase_producto CP ON CP.Codigo_CP = P.Codigo_CP
    INNER JOIN marca_producto MP ON MP.Codigo_MP = P.Codigo_MP
    WHERE CONCAT(CP.Nombre_CP,' ',MP.Nombre_MP,' - ',P.Descripcion_P) = NNombre_P);
    
    INSERT INTO DETALLE_VENTA(Codigo_V, Codigo_P, Precio, Cantidad, Descuento, SubTotal) VALUES(UPPER(CCodigo_V),UPPER(CCodigo_P),PPrecio,CCantidad,DDescuento,SSubTotal);
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.REGISTRAR_MARCA_PRODUCTO
DELIMITER //
CREATE PROCEDURE `REGISTRAR_MARCA_PRODUCTO`(
	IN NNombre_MP VARCHAR(30)
)
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_MP) from MARCA_PRODUCTO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('MP000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('MP00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('MP0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('MP'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'MP0001');
	end if;
    
    if not exists (select Codigo_MP,Nombre_MP,Estado_MP from MARCA_PRODUCTO where Codigo_MP=CCodigo or Nombre_MP=NNombre_MP and (Estado_MP='HAB' or Estado_MP='INH')) then
		insert into MARCA_PRODUCTO(Codigo_MP,Nombre_MP) values (UPPER(CCodigo) ,UPPER(NNombre_MP));
	end if;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.REGISTRAR_PRODUCTO
DELIMITER //
CREATE PROCEDURE `REGISTRAR_PRODUCTO`(
	IN NNombre_CP VARCHAR(30), 
	IN NNombre_MP VARCHAR(30),
    IN DDescripcion_P VARCHAR(50),
    IN PPrecio_P DECIMAL(6,2),
    IN IImagen_P VARCHAR(50)
)
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
    
    declare CCodigo_CP varchar(30);
    declare CCodigo_MP varchar(30);
	
    set max = (select MAX(Codigo_P) from PRODUCTO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('P000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('P00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('P0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('P'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'P0001');
	end if;
    
    set CCodigo_CP = (SELECT Codigo_CP FROM clase_producto where Nombre_CP = NNombre_CP);
    set CCodigo_MP = (SELECT Codigo_MP FROM marca_producto where Nombre_MP = NNombre_MP);
    
    
    if not exists (select Codigo_P,Codigo_CP,Codigo_MP,Descripcion_P,Precio_P,Estado_P from PRODUCTO
    where Codigo_P=CCodigo or Codigo_CP=CCodigo_CP and Codigo_MP = CCodigo_MP and Descripcion_P = DDescripcion_P and Precio_P=PPrecio_P and (Estado_P='HAB' or Estado_P='INH')) then
		insert into PRODUCTO(Codigo_P, Codigo_CP, Codigo_MP, Descripcion_P, Precio_P, Imagen_P) values (UPPER(CCodigo) ,UPPER(CCodigo_CP), UPPER(CCodigo_MP), UPPER(DDescripcion_P), UPPER(PPrecio_P), IImagen_P);
	end if;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.REGISTRAR_USUARIO
DELIMITER //
CREATE PROCEDURE `REGISTRAR_USUARIO`(
	IN NNombres_U VARCHAR(50),
    IN AApellidos_U VARCHAR(50),
    IN DDni_U CHAR(8),
    IN EEmail_U VARCHAR(50),
    IN DDepartamento_U VARCHAR(20),
    IN PProvincia_U VARCHAR(20),
    IN DDistrito_U VARCHAR(20),
    IN DDireccion1_U VARCHAR(50),
    IN DDireccion2_U VARCHAR(50),
    IN TTelefono_U VARCHAR(9),
    IN IId_U VARCHAR(30),
    IN CClave_U VARCHAR(20),
    IN TTipo_U VARCHAR(15)
)
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_U) from USUARIO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('U000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('U00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('U0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('U'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'U0001');
	end if;
    
    if not exists (select Id_U,Email_U from USUARIO where Id_U = IId_U and Email_U=EEmail_U) then
		insert into USUARIO(Codigo_U,Nombres_U,Apellidos_U,Dni_U,Email_U,Departamento_U,Provincia_U,Distrito_U,Direccion1_U,Direccion2_U,Telefono_U,Id_U,Clave_U,Tipo_U,Estado_U) 
        values (UPPER(CCodigo),UPPER(NNombres_U),UPPER(AApellidos_U),DDni_U,EEmail_U,UPPER(DDepartamento_U),UPPER(PProvincia_U),UPPER(DDistrito_U),UPPER(DDireccion1_U),UPPER(DDireccion2_U),TTelefono_U,IId_U,CClave_U,UPPER(TTipo_U),'HAB');
	end if;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.REGISTRAR_USUARIO_CLIENTE
DELIMITER //
CREATE PROCEDURE `REGISTRAR_USUARIO_CLIENTE`(
	IN NNombres_U VARCHAR(50),
    IN AApellidos_U VARCHAR(50),
    IN DDni_U CHAR(8),
    IN EEmail_U VARCHAR(50),
    IN DDepartamento_U VARCHAR(20),
    IN PProvincia_U VARCHAR(20),
    IN DDistrito_U VARCHAR(20),
    IN DDireccion1_U VARCHAR(50),
    IN DDireccion2_U VARCHAR(50),
    IN TTelefono_U VARCHAR(9),
    IN IId_U VARCHAR(30),
    IN CClave_U VARCHAR(20)
)
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
	
    set max = (select MAX(Codigo_U) from USUARIO);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('U000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('U00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('U0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('U'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'U0001');
	end if;
    
    if not exists (select Id_U,Email_U from USUARIO where Id_U = IId_U and Email_U=EEmail_U) then
		insert into USUARIO(Codigo_U,Nombres_U,Apellidos_U,Dni_U,Email_U,Departamento_U,Provincia_U,Distrito_U,Direccion1_U,Direccion2_U,Telefono_U,Id_U,Clave_U,Tipo_U,Estado_U) 
        values (UPPER(CCodigo),UPPER(NNombres_U),UPPER(AApellidos_U),DDni_U,EEmail_U,UPPER(DDepartamento_U),UPPER(PProvincia_U),UPPER(DDistrito_U),UPPER(DDireccion1_U), UPPER(DDireccion2_U),TTelefono_U,IId_U,CClave_U,'CLIENTE','HAB');
	end if;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.REGISTRAR_VENTA
DELIMITER //
CREATE PROCEDURE `REGISTRAR_VENTA`(
	IN NNombre_U VARCHAR(100),
    IN TTotal DECIMAL(10,2)
)
BEGIN
	declare max varchar(10);
	declare num int;
	declare CCodigo varchar(10);
    
    declare CCodigo_U varchar(10);
	
    set max = (select MAX(Codigo_V) from VENTA);
	set num = (SELECT LTRIM(RIGHT(max,4)));
	if num>=1 and num <=8 then
		set num = num + 1;
		set CCodigo = (select concat('V000'  ,  CAST(num as CHAR)));
	elseif num>=9 and num <=98 then
		set num = num + 1;
		set CCodigo = (select concat('V00'  ,  CAST(num as CHAR)));
	elseif num>=99 and num <=998 then
		set num = num + 1;
		set CCodigo = (select concat('V0'  ,  CAST(num as CHAR)));
	elseif num>=999 and num <=9998 then
		set num = num + 1;
		set CCodigo = (select concat('V'  ,  CAST(num as CHAR)));
	else 
		set CCodigo=(select 'V0001');
	end if;
    
    set CCodigo_U = (SELECT Codigo_U FROM USUARIO WHERE concat(Nombres_U,', ',Apellidos_U)=NNombre_U);
    
    if not exists (select Codigo_V from VENTA where Codigo_V = CCodigo) then
		insert into VENTA(Codigo_V, Codigo_U, Total) values (UPPER(CCodigo), UPPER(CCodigo_U), TTotal);
	end if;
END//
DELIMITER ;

-- Volcando estructura para tabla db_electronica.tb_balance
CREATE TABLE IF NOT EXISTS `tb_balance` (
  `id_balance` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `sueldo_empleado` decimal(10,2) DEFAULT NULL,
  `Alquiler` decimal(10,2) DEFAULT NULL,
  `Luz` decimal(10,2) DEFAULT NULL,
  `Agua` decimal(10,2) DEFAULT NULL,
  `Otros` decimal(10,2) DEFAULT NULL,
  `Compras` decimal(10,2) DEFAULT NULL,
  `Ventas` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_balance`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `tb_balance_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `tb_empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_caja
CREATE TABLE IF NOT EXISTS `tb_caja` (
  `fecha` date NOT NULL,
  `hora_apertura` time DEFAULT NULL,
  `hora_cierre` time DEFAULT NULL,
  `id_empleado` int(11) DEFAULT NULL,
  `inicio` decimal(10,2) DEFAULT NULL,
  `salida` decimal(10,2) DEFAULT NULL,
  `entrada` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `estado` char(1) NOT NULL,
  PRIMARY KEY (`fecha`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `tb_caja_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `tb_empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_cargoempleado
CREATE TABLE IF NOT EXISTS `tb_cargoempleado` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_cargoempleado` varchar(30) NOT NULL,
  `sueldo_cargo` decimal(10,2) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_categoriap
CREATE TABLE IF NOT EXISTS `tb_categoriap` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `fecha_inscripcion` datetime DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_cliente
CREATE TABLE IF NOT EXISTS `tb_cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(11) NOT NULL DEFAULT '0',
  `edad` int(11) NOT NULL,
  `nombrec` varchar(80) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `observacion` varchar(100) NOT NULL,
  `fecha_inscripcion` date DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_clientelog
CREATE TABLE IF NOT EXISTS `tb_clientelog` (
  `id_clientelog` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `accion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_clientelog`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `tb_clientelog_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `tb_empleado` (`id_empleado`),
  CONSTRAINT `tb_clientelog_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `tb_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_detalleventa
CREATE TABLE IF NOT EXISTS `tb_detalleventa` (
  `id_detalle` int(11) NOT NULL AUTO_INCREMENT,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `id_venta` (`id_venta`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `tb_detalleventa_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `tb_venta` (`id_venta`),
  CONSTRAINT `tb_detalleventa_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `tb_producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_empleado
CREATE TABLE IF NOT EXISTS `tb_empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `dni` char(8) NOT NULL,
  `id_cargo` int(11) DEFAULT NULL,
  `nombre` varchar(80) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `sexo` varchar(30) NOT NULL,
  `estado_empleado` varchar(30) NOT NULL DEFAULT '',
  `sueldo` decimal(10,2) NOT NULL,
  `imagen` blob DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `dni` (`dni`),
  KEY `id_cargo` (`id_cargo`),
  CONSTRAINT `tb_empleado_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `tb_cargoempleado` (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_igv
CREATE TABLE IF NOT EXISTS `tb_igv` (
  `id_igv` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_igv`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_pension
CREATE TABLE IF NOT EXISTS `tb_pension` (
  `id_pension` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_pension` varchar(30) DEFAULT NULL,
  `fondo_pension` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_pension`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_planilla
CREATE TABLE IF NOT EXISTS `tb_planilla` (
  `codigo_planilla` varchar(30) NOT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_empleado` int(11) DEFAULT NULL,
  `id_cargo` int(11) DEFAULT NULL,
  `id_pension` int(11) DEFAULT NULL,
  `id_tasa` int(11) DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `gratificacion` decimal(10,2) DEFAULT NULL,
  `total_pago` decimal(10,2) DEFAULT NULL,
  `mes` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_planilla`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_cargo` (`id_cargo`),
  KEY `id_pension` (`id_pension`),
  KEY `id_tasa` (`id_tasa`),
  CONSTRAINT `tb_planilla_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `tb_empleado` (`id_empleado`),
  CONSTRAINT `tb_planilla_ibfk_2` FOREIGN KEY (`id_cargo`) REFERENCES `tb_cargoempleado` (`id_cargo`),
  CONSTRAINT `tb_planilla_ibfk_3` FOREIGN KEY (`id_pension`) REFERENCES `tb_pension` (`id_pension`),
  CONSTRAINT `tb_planilla_ibfk_4` FOREIGN KEY (`id_tasa`) REFERENCES `tb_tasa` (`id_tasa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_producto
CREATE TABLE IF NOT EXISTS `tb_producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_compra` decimal(10,2) NOT NULL,
  `precio_venta` decimal(10,2) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `nombrep` varchar(50) NOT NULL,
  `marca` varchar(9) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `imagen` blob DEFAULT NULL,
  `fecha_inscripcion` date DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `id_categoria` (`id_categoria`),
  KEY `id_proveedor` (`id_proveedor`),
  CONSTRAINT `tb_producto_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `tb_categoriap` (`id_categoria`),
  CONSTRAINT `tb_producto_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `tb_proveedor` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_proveedor
CREATE TABLE IF NOT EXISTS `tb_proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_proveedor` varchar(30) NOT NULL,
  `ruc` varchar(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `celular` varchar(15) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `email` varchar(40) NOT NULL,
  `estado` varchar(10) NOT NULL,
  `observacion` varchar(150) NOT NULL,
  `fecha_inscripcion` date DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_tasa
CREATE TABLE IF NOT EXISTS `tb_tasa` (
  `id_tasa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tasa` varchar(30) DEFAULT NULL,
  `impuesto_tasa` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_tasa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_usuario
CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `clave_usuario` varchar(30) NOT NULL,
  `estado_usuario` varchar(10) NOT NULL,
  `fecha_sesion` datetime DEFAULT NULL,
  `fecha_salida` datetime DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `tb_empleado` (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.tb_venta
CREATE TABLE IF NOT EXISTS `tb_venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `numero_serie` varchar(30) NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `monto` decimal(10,2) NOT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `tb_venta_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `tb_empleado` (`id_empleado`),
  CONSTRAINT `tb_venta_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `tb_cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para procedimiento db_electronica.USP_AgregarEmpleado
DELIMITER //
CREATE PROCEDURE `USP_AgregarEmpleado`(
	IN `PtipoEmp` VARCHAR(30),
	IN `PdniEmp` CHAR(8),
	IN `PapellidoEmp` VARCHAR(30),
	IN `PnombreEmp` VARCHAR(30),
	IN `PsexoEmp` CHAR(1),
	IN `PdireccionEmp` VARCHAR(50),
	IN `PemailEmp` VARCHAR(50),
	IN `PtelefonoEmp` VARCHAR(9),
	IN `PsueldoEmp` DECIMAL(10,2),
	IN `PClaveEmp` VARCHAR(30),
	IN `PestadoEmp` CHAR(1)
)
BEGIN
INSERT INTO tb_empleado(tipoEmpleado,dni,apellidos,nombres,sexo,direccion,email,telefono,sueldo,clave,estado)
VALUES(PtipoEmp,PdniEmp,PapellidoEmp,PnombreEmp,PsexoEmp,PdireccionEmp,PemailEmp,PtelefonoEmp,PsueldoEmp,PclaveEmp,PestadoEmp);
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.USP_BuscarMultitabla
DELIMITER //
CREATE PROCEDURE `USP_BuscarMultitabla`(
	IN `busqueda` VARCHAR(50)
)
BEGIN
SELECT c.id_empleado,a.tipo_cargoempleado,b.usuario,b.clave_usuario,b.estado_usuario
FROM tb_empleado AS c
INNER JOIN tb_cargoempleado AS a ON c.id_cargo=a.id_cargo
INNER JOIN tb_usuario AS b ON b.id_empleado=c.id_empleado
WHERE b.usuario=busqueda;
END//
DELIMITER ;

-- Volcando estructura para procedimiento db_electronica.USP_LogueEmpleado
DELIMITER //
CREATE PROCEDURE `USP_LogueEmpleado`(
	IN `PdniEmp` INT,
	IN `PclaveEmp` INT
)
BEGIN
	SELECT * FROM tb_empleado
	WHERE dni=PdniEmp AND clave=PclaveEmp AND estado='1';
END//
DELIMITER ;

-- Volcando estructura para tabla db_electronica.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `Codigo_U` varchar(10) NOT NULL,
  `Nombres_U` varchar(50) NOT NULL,
  `Apellidos_U` varchar(50) NOT NULL,
  `Dni_U` char(8) NOT NULL,
  `Email_U` varchar(50) NOT NULL,
  `Departamento_U` varchar(20) NOT NULL,
  `Provincia_U` varchar(20) NOT NULL,
  `Distrito_U` varchar(20) NOT NULL,
  `Direccion1_U` varchar(50) NOT NULL,
  `Direccion2_U` varchar(50) DEFAULT NULL,
  `Telefono_U` varchar(9) NOT NULL,
  `Id_U` varchar(30) NOT NULL,
  `Clave_U` varchar(20) NOT NULL,
  `Tipo_U` varchar(15) NOT NULL,
  `Estado_U` char(3) DEFAULT 'INH',
  PRIMARY KEY (`Codigo_U`),
  UNIQUE KEY `U_Id_U` (`Id_U`),
  UNIQUE KEY `U_Dni_U` (`Dni_U`),
  UNIQUE KEY `U_Email_U` (`Email_U`),
  UNIQUE KEY `U_Telefono_U` (`Telefono_U`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_electronica.venta
CREATE TABLE IF NOT EXISTS `venta` (
  `Codigo_V` varchar(20) NOT NULL,
  `Codigo_U` varchar(10) NOT NULL,
  `Total` decimal(10,2) NOT NULL,
  `Fecha` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`Codigo_V`),
  KEY `FK_Codigo_U` (`Codigo_U`),
  CONSTRAINT `FK_Codigo_U` FOREIGN KEY (`Codigo_U`) REFERENCES `usuario` (`Codigo_U`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
