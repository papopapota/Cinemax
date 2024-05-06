DROP DATABASE IF EXISTS cinemaxBD;
create database cinemaxBD ;
use cinemaxBD;

-- ////////Tablas
create table tipo_usuario(
id_tipo_usuario int,
descripcion_tipo_usuario varchar (20),
primary key (id_tipo_usuario)
);

create table Usuario(
id_usuario int auto_increment,
nombre_usuario varchar (50),
apellido_usuario varchar (50),
dni char(8) unique,
correo_usuario varchar (100) unique,
clave_usuario varchar (50),
id_tipo_usuario int,
primary key (id_usuario),
FOREIGN KEY(id_tipo_usuario) REFERENCES tipo_usuario(id_tipo_usuario)
);

-- Creación de la tabla genero
CREATE TABLE genero (
idgenero INT PRIMARY KEY,
nom_genero VARCHAR(100)
);

-- Creación de la tabla Peliculas
CREATE TABLE peliculas (
idpelicula INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(100),
descripcion TEXT,
imagen VARCHAR(255),
idgenero INT,
duracion TIME,
idioma VARCHAR(50),
enestreno BOOLEAN NOT NULL DEFAULT 0,
FOREIGN KEY (idgenero) REFERENCES genero(idgenero)
);

create table Sala( -- 3D , 2D , ETC
id_sala int,
descripcion_sala varchar (50),
precio double,
primary key (id_sala)
);

create table Funcion( -- se listara las funciones en la vista del detalle de la pelicula
id_funcion int,
id_pelicula int,
id_sala int,
fecha_funcion date,
hora_inicio time,
hora_fin time,
primary key (id_Funcion),
FOREIGN KEY(id_pelicula) REFERENCES peliculas(idpelicula),
FOREIGN KEY(id_sala) REFERENCES Sala(id_sala)
);

create table Asiento(
id_asiento int,
id_sala int,
estado_asiento boolean,
primary key (id_asiento),
FOREIGN KEY(id_sala) REFERENCES Sala(id_sala)
);

create table Boleto(
idBoleto int,
idFuncion int,
idUsuario int,
cantidad int,
Total double,
primary key (idBoleto),
FOREIGN KEY(idFuncion) REFERENCES Funcion(id_funcion),
FOREIGN KEY(idUsuario) REFERENCES Usuario(id_usuario)
);

create table DetalleBoleto(
idDetalle int,
idBoleto int,
idAsiento int,
primary key (idDetalle),
FOREIGN KEY(idBoleto) REFERENCES Boleto(idBoleto),
FOREIGN KEY(idAsiento) REFERENCES Asiento(id_asiento)
);

insert into tipo_usuario values(1,"Cliente");
insert into tipo_usuario values(2,"Administrador");

insert into Usuario values(null, "Miguel Antonio", "Ruiz Sierra", "72686871", "mars@mail.com", "12345", 1);

insert into genero values(1, "Accion");
insert into genero values(2, "Fantasia");
insert into genero values(3, "Romance");

insert into peliculas values(null, "Buscando a Nemo", "Marlin busca a su hijo Nemo", "", 2, "01:45:00", "Español", 1);

insert into Sala values(1, "2D", 20.5);

insert into Funcion values(1, 1, 1, "2024-05-05", "19:00", "20:45");

insert into Asiento values(1, 1, 1);

insert into Boleto values(1, 1, 1, 2, 100);

select * from usuario;

select * from peliculas;

select * from funcion;