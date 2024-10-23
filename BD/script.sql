create database institucion;
use institucion;

create table tipodocumento(
	tipodocumento_id int auto_increment primary key, 
    tipodocumento_nombre varchar(60) not null, 
    tipodocumento_acronimo varchar(10) not null
);

create table grado (
    grado_id int auto_increment primary key, 
    grado_nombre varchar(50) not null
);

create table estudiante (
    estudiante_id int auto_increment primary key,
    tipodocumento_id int not null,
    estudiante_numerodoc varchar(20) not null, 
    estudiante_nombres varchar(50) not null,
    estudiante_apellidos varchar(50) not null,
    estudiante_edad int not null,
    estudiante_celular varchar(15) not null,
    estudiante_telefono varchar(15),
    email varchar(60) not null unique,
    grado_id int not null,
    foreign key (tipodocumento_id) references tipodocumento(tipodocumento_id),
    foreign key (grado_id) references grado(grado_id)
);

/*INSERTAR DATOS*/
INSERT INTO GRADO (grado_nombre) VALUES 
('Sexto'),
('Septimo'),
('Octavo'),
('Noveno'),
('Decimo'),
('Once');

INSERT INTO TIPODOCUMENTO (tipodocumento_nombre, tipodocumento_acronimo) VALUES 
('Cedula de ciudadania','CC'),
('Tarjeta de identidad','TI');


/*OBTENER TODA LA INFORMACIÓN DE LOS ESTUDIANTES QUE ESTAN EN ONCE*/
SELECT 
* FROM
ESTUDIANTE E
INNER JOIN GRADO G ON E.GRADO_ID = G.GRADO_ID 
INNER JOIN TIPODOCUMENTO T ON E.TIPODOCUMENTO_ID = T.TIPODOCUMENTO_ID
WHERE 
G.GRADO_NOMBRE LIKE '%Once%';



/*OBTENER LOS ESTUDIANTES ENTRE 15 Y 17 AÑOS*/
SELECT 
* FROM
ESTUDIANTE E
WHERE 
E.ESTUDIANTE_EDAD BETWEEN 15 AND 17;

