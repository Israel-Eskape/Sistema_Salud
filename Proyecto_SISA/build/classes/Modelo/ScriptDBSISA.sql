--Script de la DB SISA
drop database IF exists SISA;
create database SISA;


CREATE TABLE dbsisa.persona(
    curp VARCHAR(18) not null PRIMARY KEY,
    nameP VARCHAR(50),
    surname VARCHAR(50),
    dateBirth VARCHAR(100),
    sexo VARCHAR(6),
    bloodType VARCHAR(5),
    addressP VARCHAR(100),
    municipality VARCHAR(100),
    stateP VARCHAR(50),
    cp int,
    email VARCHAR(100),
    phone VARCHAR(100) 
);
CREATE TABLE dbsisa.medico(
    cedulaProfesional VARCHAR(30),
    tipo VARCHAR(100),
    puesto VARCHAR(20),
    especialidad VARCHAR(30),
    passwordP VARCHAR(20)
)INHERITS (dbsisa.persona);

CREATE TABLE dbsisa.paciente(
    ocupacion VARCHAR(50),
    alergias VARCHAR(100),
    probSalud VARCHAR(200),
    responsable VARCHAR(50)
)INHERITS (dbsisa.persona);

CREATE TABLE dbsisa.medicamento(
    codigo VARCHAR(7),-- SC-CLAVE
    nombreMed VARCHAR(20),
    registro DATE,
    vencimiento DATE,
    existencia INT,
    descripcion VARCHAR(100)
);
