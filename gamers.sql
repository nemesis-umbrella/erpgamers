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
	matemp			numeric(10) primary key not null,
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
    matemp			numeric(10) not null,
    marca			varchar(10) not null,
    aniofab			int not null,
    diponibilidad	bool not null,
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
    matemp			numeric(10) not null,
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
