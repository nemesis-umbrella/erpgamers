drop database if exists gamers;
create database gamers;
use gamers;
-- creaciòn de tablas 
create table iniciosesion(
	login			varchar(50) primary key not null,
    pass			blob not null,
    nombre 			varchar(50) not null,
    apellidop 		varchar(50) not null,
    apellidom		varchar(50) not null,
    genero			varchar(1) not null,
    email			varchar(100) not null,
    tipo			int not null,
    fechacreacion	datetime,
    fechamod		datetime,
    ultimaconexion	datetime,
    activo			bool not null,
    terminos		bool not null
);
create table reclutamiento(
	idrec		    int primary key auto_increment,
    login			varchar(50) not null,
    fechacreacion	datetime,
    fechamod		datetime,
    index(login),
    foreign key(login) references iniciosesion(login) on delete cascade
);
alter table reclutamiento auto_increment = 10001;
create table sucursal(
	nosuc			int primary key	auto_increment,
    nombresuc		varchar(50) not null,
    direccion		varchar(100) not null,
    ciudad			varchar(50) not null,
    codpost			numeric(5) not null,
    telefono		numeric(10) not null,
    fax				numeric(10) not null,
    email			varchar(100) not null,
    fechacreacion	datetime,
    fechamod		datetime
);
create table empleado(
	matemp			int primary key not null,
    nosuc			int not null,
    login			varchar(50) not null,
    puesto			varchar(50) not null,
    departamento	varchar(50) not null,
    fechacreacion	datetime,
    fechamod		datetime,
    index(nosuc),
    index(login),
    foreign key(nosuc) references sucursal(nosuc) on delete cascade,
    foreign key(login) references iniciosesion(login) on delete cascade
);
create table proveedor(
	idprov			int primary key auto_increment,
    nombre			varchar(50) not null,
    contacto		varchar(100) not null,
    cargocontacto	varchar(50) not null,
    direccion		varchar(100) not null,
    ciudad			varchar(50) not null,
    pais			varchar(50) not null,
    codpost			numeric(5) not null,
    telefono		numeric(10) not null,
    fax				numeric(10) not null,
    email			varchar(100) not null,
    termpag			varchar(50) not null,
    notas			varchar(100) not null,
    fechacreacion	datetime,
    fechamod		datetime
);
alter table proveedor auto_increment = 10000;
create table plataforma(
	clave			varchar(15) primary key,
    nombre			varchar(50) not null,
    fabricante		varchar(50) not null,
    lanzamiento		int not null,
    fechacreacion	datetime,
    fechamod		datetime
);
create table producto(
	codbarras		numeric(12) primary key not null,
    idprov			int not null,
    clave			varchar(15) not null,
    nombre			varchar(80) not null,
    vendedor		varchar(50) not null,
    precio			decimal(10,2) not null,
    clasificacion	varchar(50) not null,
    fechacreacion	datetime,
    fechamod		datetime,
    index(clave),
	foreign key(idprov) references proveedor(idprov) on delete cascade,
    foreign key(clave) references plataforma(clave) on delete cascade
);
create table contiene(
	nocont			int primary key auto_increment,
	nosuc			int not null,
    codbarras		numeric(12) not null,
    cantidad		int not null,
    fechacreacion	datetime,
    fechamod		datetime,
    index(nosuc),
    foreign key(nosuc) references sucursal(nosuc) on delete cascade,
    foreign key(codbarras) references producto(codbarras) on delete cascade 
);
create table vehiculo(
	matveh			varchar(7) primary key not null,
    matemp			int not null,
    marca			varchar(30) not null,
    aniofab			int not null,
    disponibilidad	bool not null,
    fechacreacion	datetime,
    fechamod		datetime,
    foreign key(matemp) references empleado(matemp) 
);
create table ruta(
	idruta			int	primary key auto_increment,
    alias			varchar(50) not null,
    costo			decimal(10,2) not null,
    disponibilidad	bool not null,
    descrip			varchar(100) not null,
    tiempo			time not null,
    fechacreacion	datetime,
    fechamod		datetime
);
create table cliente(
	idcliente		int primary key auto_increment,
    nombre			varchar(50) not null,
    apellidop		varchar(50) not null,
    apellidom		varchar(50) not null,
    telefono		numeric(10) not null,
	direccion		varchar(100) not null,
    email			varchar(100) not null,
    fechacreacion	datetime,
    fechamod		datetime
);
alter table cliente auto_increment = 10000;
create table agenda(
	ref				int primary key auto_increment,
    idruta			int not null,
    idcliente		int not null,
    matveh			varchar(7) not null,
    codbarras		numeric(12) not null,
    estado			varchar(20) not null,
    fechacreacion	datetime,
    fechamod		datetime,
    foreign key(idruta)	references ruta(idruta),
    foreign key(matveh) references vehiculo(matveh),
    foreign key(idcliente) references cliente(idcliente),
    foreign key(codbarras) references producto(codbarras)
);
alter table agenda auto_increment = 10000;
create table nomina(
	rfc				varchar(13) primary key not null,
    matemp			int not null,
    tipocontrato	varchar(50) not null,
    tipojornada		varchar(50) not null,
    fechacreacion	datetime,
    fechamod		datetime,
    foreign key(matemp) references empleado(matemp)
);
create table pago(
	nopago			int primary key auto_increment,
    rfc				varchar(13) not null,
    nodias			int not null,
    importe			decimal(10,2) not null,
    fechapago		datetime not null,
    fechacreacion	datetime,
    fechamod		datetime,
    foreign key(rfc) references nomina(rfc)
);
create table poliza(
	nopoliza		int primary key auto_increment,
    tipopoliza		varchar(2) not null,
    periodo			int not null,
    ejercicio		int not null,
    concepto		varchar(100) not null,
    fecha			datetime not null,
    fechacreacion	datetime,
    fechamod		datetime
);
alter table poliza auto_increment = 10000;
create table cuenta(
	nocuenta		int primary key auto_increment,
    nopoliza		int not null,
    ejercicio		varchar(100) not null,
    sinicial		decimal(10,2),
    cargo			decimal(10,2),
    abono			decimal(10,2),
    fechacreacion	datetime,
    fechamod		datetime,
    foreign key(nopoliza) references poliza(nopoliza)
);
create table perfilcolor(
	login 			varchar(50)	 primary key,
    color			int,
    foreign key(login) references iniciosesion(login)
);
drop procedure if exists igmdiniciosesion;
delimiter $$
create procedure igmdiniciosesion(
IN _login varchar(50),
IN _pass			varchar(50),
IN _nombre 			varchar(50),
IN _apellidop 		varchar(50),
IN _apellidom		varchar(50),
IN _genero			varchar(1),
IN _email			varchar(100),
IN _tipo			int,
IN _activo			bool,
IN _terminos		bool)
begin
if not exists(select * from iniciosesion where login like(_login)) THEN
	insert into iniciosesion(login,pass,nombre,apellidop,apellidom,genero,email,tipo,fechacreacion,fechamod,ultimaconexion,activo,terminos) 
    values(_login,aes_encrypt(_pass,'OqZ8e5-pz+*LTeHG'),_nombre,_apellidop,_apellidom,_genero,_email,_tipo,now(),null,null,_activo,false);
ELSE
	if _pass is null then
		update iniciosesion set nombre=_nombre, apellidop=_apellidop,apellidom=_apellidom,genero=_genero,email=_email,fechamod=now(),activo=_activo where login=_login;
    else
		update iniciosesion set pass=aes_encrypt(_pass,'OqZ8e5-pz+*LTeHG'), nombre=_nombre, apellidop=_apellidop,apellidom=_apellidom,genero=_genero,tipo = _tipo,email=_email,fechamod=now(),activo=_activo where login=_login;
    end if;
END IF;
END
$$
drop procedure if exists verificariniciosesion;
delimiter $$
create procedure verificariniciosesion(
IN _login	varchar(50),
IN _pass	blob)
begin
declare _desci varchar(50);
declare _verificar bool default false;
declare _terminos bool default false;
if exists (select * from iniciosesion where login=_login) THEN
	set _desci = (select convert(aes_decrypt(pass,'OqZ8e5-pz+*LTeHG'), char(50))  from iniciosesion where login=_login);
    if _pass = _desci then
		set _verificar = (select activo from iniciosesion where login = _login);
        if _verificar = true then
			set _terminos = (select terminos from iniciosesion where login = _login);
            if _terminos = true then
				-- Significa que el usuario puede ingresar al sistema
				select '1' as 'resultado';
                update iniciosesion set ultimaconexion = now() where login = _login;
            else
				-- Significa que el usuario debe aceptar los terminos
                select '4' as 'resultado';
            end if;
        else
            -- significa que el usuario no puede ingresar al sistema
			select '3' as 'resultado';
        end if;
	else
        -- sinfica que el password esta erroneo
		select '2' as 'resultado';
    end if;
else
    -- significa que el usuario no existe
	select '0' as 'resultado';
end if;
end;
$$
DROP PROCEDURE IF EXISTS cambiarpass;
delimiter $$
CREATE PROCEDURE cambiarpass(
IN _login 	VARCHAR(50),
IN _pass 	VARCHAR(50),
IN _newpass VARCHAR(50))
BEGIN
DECLARE _desc VARCHAR(50);
  IF EXISTS(SELECT * FROM iniciosesion WHERE login = _login) THEN
	SET _desc = (select convert(aes_decrypt(pass,'OqZ8e5-pz+*LTeHG'), char(50))  from iniciosesion where login=_login);
    IF _desc = _pass THEN
		-- Significa que el password corresponde y es cambiado
        update iniciosesion set pass=aes_encrypt(_newpass,'OqZ8e5-pz+*LTeHG') where login=_login;
		SELECT 1 as 'resultado';
	ELSE
		-- Significa que el password no corresponde
		SELECT 2 as 'resultado';
	END IF;
  ELSE
	-- Significa que el usuario no existe
	SELECT 0 as 'resultado';
  END IF;
END;
$$
DROP PROCEDURE IF EXISTS cargarcolor;
DELIMITER $$
CREATE PROCEDURE cargarcolor(
IN _login		VARCHAR(50))
BEGIN
	IF EXISTS(SELECT * FROM perfilcolor WHERE login = _login) THEN
		SELECT color FROM perfilcolor WHERE login = _login;
    ELSE
		SELECT 0 AS 'color';
    END IF;
END;
$$
DROP PROCEDURE IF EXISTS guardarcolor;
DELIMITER $$
CREATE PROCEDURE guardarcolor(
IN _login		VARCHAR(50),
IN _color 		INT)
BEGIN
	IF NOT EXISTS(SELECT * FROM perfilcolor WHERE login = _login) THEN
		INSERT INTO perfilcolor(login,color) VALUES(_login,_color);
    ELSE
		UPDATE perfilcolor set color = _color WHERE login = _login;
    END IF;
END;
$$
CALL igmdiniciosesion('nemesis-umbrella','Ab123456','Jorge Luis','Mondragón','Zarate','M','nemesis_umbrella@outlook.com',1,false,false);
CALL igmdiniciosesion('jill-valentine','Ab123456','Jill','Valentine','','F','jillvalentine@stars.org',1,false,false);
INSERT INTO `gamers`.`ruta` (`idruta`,`alias`, `costo`, `disponibilidad`, `descrip`, `tiempo`, `fechacreacion`, `fechamod`) VALUES(null,'Ruta 58',500.50,false,'Ruta poco fiable','01:20:55',now(),null);
INSERT INTO sucursal(nombresuc,direccion,ciudad,codpost,telefono,fax,email,fechacreacion) VALUES('Las lomas','Calle Del Prado #23','Ciudad de México',08962,5589601245,5589601145,'laslomas@gamers.vg',now());
INSERT INTO empleado (matemp,nosuc,login,puesto,departamento,fechacreacion) VALUES
(201420484,1,'nemesis-umbrella','Director General','Desarrollo y Tecnología',now()),
(201620512,1,'jill-valentine','Director de ventas','Ventas',now());
update iniciosesion set activo = true where login = 'nemesis-umbrella';