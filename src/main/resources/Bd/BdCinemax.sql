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
idSala int,
descripcionSala varchar (50),
precio double,
primary key (idSala)
);

create table Funcion( -- se listara las funciones en la vista del detalle de la pelicula
idFuncion int,
idpelicula int,
idSala int,
fechaFuncion date,
horaInicio time,
horaFin time,
primary key (idFuncion),
FOREIGN KEY(idpelicula) REFERENCES peliculas(idpelicula),
FOREIGN KEY(idSala) REFERENCES Sala(idSala)
);

create table Asiento(
idAsiento int,
idSala int,
estadoAsiento boolean,
primary key (idAsiento),
FOREIGN KEY(idSala) REFERENCES Sala(idSala)
);

create table Boleto(
idBoleto int,
idFuncion int,
idUsuario int,
cantidad int,
Total double,
primary key (idBoleto),
FOREIGN KEY(idFuncion) REFERENCES Funcion(idFuncion),
FOREIGN KEY(idUsuario) REFERENCES Usuario(id_usuario)
);

create table DetalleBoleto(
idDetalle int,
idBoleto int,
idAsiento int,
primary key (idDetalle),
FOREIGN KEY(idBoleto) REFERENCES Boleto(idBoleto),
FOREIGN KEY(idAsiento) REFERENCES Asiento(idAsiento)
);
insert into tipo_usuario values(1,"Cliente");
insert into tipo_usuario values(2,"Admin");
select * from Usuario;
