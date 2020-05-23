CREATE DATABASE comercios;
USE comercios;



CREATE TABLE tienda
        (
        idt INT(10) NOT NULL,
        calle VARCHAR(50) NOT NULL,
        numero VARCHAR(50) NOT NULL,
        distrito VARCHAR(50) NOT NULL,
        cp VARCHAR(50) NOT NULL,
        PRIMARY KEY(idt)

        );
       
     insert into tienda (idt, calle, numero, distrito, cp) VALUES (1,'rio','674','urgel','25068');



