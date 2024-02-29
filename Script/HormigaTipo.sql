-- database: ../database/PADatabaseAntBot.sqlite

/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| andreachicaiza11@gmail.com             |
|________________________________________|
-Autor: Andrea Chicaiza
-Fecha: 28/02/2024
*/

DROP TABLE IF EXISTS HormigaTipo;

CREATE TABLE IF NOT EXISTS HormigaTipo(
     IdHormigaTipo      INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre             TEXT NOT NULL UNIQUE
    ,Estado             VARCHAR(1) NOT NULL DEFAULT 'A'
    ,FechaCrea          DATETIME NOT NULL  DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATE 
);

INSERT INTO HormigaTipo (Nombre) VALUES
     ('Soldado')
    ,('Rastreadora')
    ,('Zangano')
    ,('Larva')
    ,('Reina');
