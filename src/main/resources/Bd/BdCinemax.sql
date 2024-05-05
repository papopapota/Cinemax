 create database cinemaxBD ;
use cinemaxBD;

-- ////////Tablas SS
create table TipoUsuario(
idTipoUsuario int,
descripcionTipoUsuario varchar (20),
primary key (idTipoUsuario)
);

create table Usuario(
idUsuario int,
nombreUsuario varchar (50),
apellidoUsuario varchar (50),
correoUsuario varchar (100),
claveUsuario varchar (50),
idTipoUsuario int,
primary key (idUsuario),
FOREIGN KEY(idTipoUsuario) REFERENCES TipoUsuario(idTipoUsuario)
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
FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)
);

create table DetalleBoleto(
idDetalle int,
idBoleto int,
idAsiento int,
primary key (idDetalle),
FOREIGN KEY(idBoleto) REFERENCES Boleto(idBoleto),
FOREIGN KEY(idAsiento) REFERENCES Asiento(idAsiento)
);
