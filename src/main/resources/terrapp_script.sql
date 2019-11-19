CREATE DATABASE terrapp;

USE terrapp;

CREATE TABLE domicilio(
	id INT NOT NULL auto_increment PRIMARY KEY,
	calle VARCHAR(50) NOT NULL,
	numero_int VARCHAR(5),
	numero_ext VARCHAR(5) NOT NULL,
	cp VARCHAR(5) NOT NULL,
	municipio VARCHAR(50) NOT NULL,
	estado VARCHAR(30) NOT NULL,
	eliminado BOOLEAN NOT NULL DEFAULT FALSE,
	fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	fecha_modificacion DATETIME,
	fecha_eliminacion DATETIME
);

CREATE TABLE inmobiliaria(
	id INT NOT NULL auto_increment PRIMARY KEY,
	id_domicilio INT NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	telefono VARCHAR(15) NOT NULL UNIQUE,
	eliminado BOOLEAN NOT NULL DEFAULT FALSE,
	fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	fecha_modificacion DATETIME,
	fecha_eliminacion DATETIME,
	FOREIGN KEY(id_domicilio) REFERENCES domicilio(id) ON UPDATE CASCADE
);

CREATE TABLE usuario(
	id INT NOT NULL auto_increment PRIMARY KEY,
	id_inmobiliaria INT NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	apellidos VARCHAR(30) NOT NULL,
	celular VARCHAR(15) NOT NULL,
	correo VARCHAR(30) NOT NULL UNIQUE,
	contrasena VARCHAR(30) NOT NULL,
	tipo_usuario VARCHAR(15) NOT NULL,
	eliminado BOOLEAN NOT NULL DEFAULT FALSE,
	fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	fecha_modificacion DATETIME,
	fecha_eliminacion DATETIME,
	FOREIGN KEY(id_inmobiliaria) REFERENCES inmobiliaria(id) ON UPDATE CASCADE
);

CREATE TABLE propiedad( 
	id int not null auto_increment primary key,
	id_domicilio int not null, 
	id_usuario int not null,
	descripcion text,
	mantenimiento float not null,
	antiguedad int not null,
	estatus varchar(12) not null,
	area_terreno varchar(30) not null,
	area_construccion varchar(30) not null,
	eliminado boolean not null default false,
	fecha_creacion datetime not null default current_timestamp,
	fecha_modificacion DATETIME,
	fecha_eliminacion datetime,
	foreign key(id_domicilio) references domicilio(id) ON UPDATE CASCADE,
	foreign key(id_usuario) references usuario(id) ON UPDATE CASCADE
);

CREATE TABLE cliente(
	id INT NOT NULL auto_increment PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	apellidos VARCHAR(30) NOT NULL,
	celular VARCHAR(15) NOT NULL,
	correo VARCHAR(30) NOT NULL UNIQUE,
	contrasena VARCHAR(30) NOT NULL,
	eliminado BOOLEAN NOT NULL DEFAULT FALSE,
	fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	fecha_modificacion DATETIME,
	fecha_eliminacion DATETIME
);

CREATE TABLE venta(
	id INT NOT NULL auto_increment PRIMARY KEY,
	id_propiedad INT NOT NULL,
	monto FLOAT NOT NULL,
	estatus VARCHAR(10) NOT NULL,
	eliminado BOOLEAN NOT NULL DEFAULT FALSE,
	fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	fecha_modificacion DATETIME,
	fecha_eliminacion DATETIME,
	FOREIGN KEY(id_propiedad) REFERENCES propiedad(id) ON UPDATE CASCADE
);

CREATE TABLE renta(
	id INT NOT NULL auto_increment PRIMARY KEY,
	id_propiedad INT NOT NULL,
	monto FLOAT NOT NULL,
	estatus VARCHAR(10) NOT NULL,
	eliminado BOOLEAN NOT NULL DEFAULT FALSE,
	fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	fecha_modificacion DATETIME,
	fecha_eliminacion DATETIME,
	FOREIGN KEY(id_propiedad) REFERENCES propiedad(id) ON UPDATE CASCADE
);

CREATE TABLE historial_visita(
	id INT NOT NULL auto_increment PRIMARY KEY,
	id_propiedad INT NOT NULL,
	id_cliente INT NOT NULL,
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY(id_propiedad) REFERENCES propiedad(id) ON UPDATE CASCADE,
	FOREIGN KEY(id_cliente) REFERENCES cliente(id) ON UPDATE CASCADE
);

CREATE TABLE casa(
	id int not null auto_increment primary key,
	id_propiedad int not null unique,
	recamara varchar(2) not null,
	bano varchar(2) not null,
	medio_bano varchar(2), 
	estacionamiento varchar(2),
	eliminado boolean not null default false,
	fecha_creacion datetime not null default current_timestamp,
	fecha_modificacion DATETIME,
	fecha_eliminacion datetime,
	foreign key (id_propiedad) references propiedad(id) ON UPDATE CASCADE
);

CREATE TABLE departamento(
	id int not null auto_increment primary key,
	id_propiedad int not null unique,
	recamara varchar(2) not null,
	bano varchar(2) not null,
	medio_bano varchar(2), 
	estacionamiento varchar(2),
	piso varchar(2) not null,
	elevador boolean default false,
	eliminado boolean not null default false,
	fecha_creacion datetime not null default current_timestamp,
	fecha_modificacion DATETIME,
	fecha_eliminacion datetime,
	foreign key (id_propiedad) references propiedad(id) ON UPDATE CASCADE
);

CREATE TABLE terreno(
	id int not null auto_increment primary key,
	id_propiedad int not null unique,
	luz boolean not null default false,
	agua boolean not null default false,
	eliminado boolean not null default false,
	fecha_creacion datetime not null default current_timestamp,
	fecha_modificacion DATETIME,
	fecha_eliminacion datetime,
	foreign key (id_propiedad) references propiedad(id) ON UPDATE CASCADE
);

CREATE TABLE caracteristicas(
	id int not null auto_increment primary key,
	id_propiedad int not null,
	chimenea boolean not null default false,
	acceso_discapacitados boolean not null default false,
	alberca boolean not null default false,
	amueblado boolean not null default false,
	mascotas boolean not null default false,
	jardin boolean not null default false,
	cocina_integral boolean not null default false,
	eliminado boolean not null default false,
	fecha_creacion datetime not null default current_timestamp,
	fecha_modificacion DATETIME,
	fecha_eliminacion datetime,
	foreign key (id_propiedad) references propiedad(id) ON UPDATE CASCADE
);

CREATE TABLE areas_compartidas(
	id int not null auto_increment primary key,
	id_propiedad int not null,
	alberca boolean not null default false,
	salon_usos_multiples boolean not null default false,
	estacionamiento_visita boolean not null default false,
	areas_recreativas boolean not null default false,
	eliminado boolean not null default false,
	fecha_creacion datetime not null default current_timestamp,
	fecha_modificacion DATETIME,
	fecha_eliminacion datetime,
	foreign key (id_propiedad) references propiedad(id) ON UPDATE CASCADE
);

CREATE TABLE servicios(
	id INT NOT NULL auto_increment PRIMARY KEY,
	id_propiedad INT NOT NULL,
	gas BOOLEAN NOT NULL DEFAULT FALSE,
	ac BOOLEAN NOT NULL DEFAULT FALSE,
	cisterna BOOLEAN NOT NULL DEFAULT FALSE,
	calefaccion BOOLEAN NOT NULL DEFAULT FALSE,
	gimnasio BOOLEAN NOT NULL DEFAULT FALSE,
	seguridad_privada BOOLEAN NOT NULL DEFAULT FALSE,
	calentador_agua BOOLEAN NOT NULL DEFAULT FALSE,
	eliminado BOOLEAN NOT NULL DEFAULT FALSE,
	fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	fecha_modificacion DATETIME,
	fecha_eliminacion DATETIME,
	FOREIGN KEY(id_propiedad) REFERENCES propiedad(id) ON UPDATE CASCADE	
);

CREATE TABLE fotos(
	id INT NOT NULL auto_increment PRIMARY KEY,
	id_propiedad INT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	url VARCHAR(255) NOT NULL,
	fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY(id_propiedad) REFERENCES propiedad(id) ON UPDATE CASCADE
);



INSERT INTO `domicilio` VALUES (1,'Ramon Corona',NULL,'2515','45019','Zapopan','Jalisco',0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `cliente` VALUES (1,'Juan','Perez','3332801574','juan@perez.com','ElBarbaro',0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `inmobiliaria` VALUES (1,1,'Generation','3336693000',0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `usuario` VALUES (1,1,"Pedro",'Perez','3334805460','pedro@perez.com','contra','superUsuario',0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `propiedad` VALUES (1,1,1,'una descripcion',300.50,50,'Disponible','400','500',0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `areas_compartidas` VALUES (1,1,1,1,1,1,0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `caracteristicas` VALUES (1,1,1,1,1,1,1,1,1,0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `casa` VALUES (1,1,'4','3','3','3',0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `departamento` VALUES (1,1,'4','3','3','3','3',0,0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `fotos` VALUES (1,1,'una foto','un url','2019-01-01 00:00:00');
INSERT INTO `historial_visita` VALUES (1,1,1,'2019-01-01 00:00:00');
INSERT INTO `renta` VALUES (1,1,150,"enventa",0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `servicios` VALUES (1,1,1,1,1,1,1,1,1,0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `terreno` VALUES (1,1,1,1,0,'2019-01-01 00:00:00',NULL,NULL);
INSERT INTO `venta` VALUES (1,1,150,"enventa",0,'2019-01-01 00:00:00',NULL,NULL);
