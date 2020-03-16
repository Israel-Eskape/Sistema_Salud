//Script de la DB SISA
drop database IF exists SISA;
create database SISA;

CREATE TABLE PERSONA(
    curp VARCHAR(18) not null PRIMARY KEY,
    nameP VARCHAR(50),
    surname VARCHAR(50),
    dateBirth DATE,
    sexo VARCHAR(6),
    bloodType VARCHAR(5),
    addressP VARCHAR(100),
    municipality VARCHAR(100),
    stateP VARCHAR(50),
    cp int,
    city VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(10) 

);
CREATE TABLE MEDICO(
    cedulaProfesional VARCHAR(30),
    tipo VARCHAR(10),
    puesto VARCHAR(20),
    especialidad VARCHAR(30),
    passwordP VARCHAR(20)
)INHERITS (PERSONA);

CREATE TABLE PACIENTE(
    ocupacion VARCHAR(50),
    alergias VARCHAR(100),
    probSalud VARCHAR(200),
    responsable VARCHAR(50)
)INHERITS (PERSONA);