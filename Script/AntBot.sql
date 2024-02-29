-- database: ../database/PADatabaseAntBot.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 28.feb.2k24
script: Creacion de la tabla AntBot 
*/
DROP TABLE IF EXISTS AntBot;

CREATE TABLE AntBot(
    IdAntBot            INTEGER     NOT NULL    PRIMARY KEY AUTOINCREMENT
    ,IdHormiga          INTEGER     NOT NULL    REFERENCES Hormiga(IdHormiga)
    ,IdIAMatriz         INTEGER     NOT NULL    REFERENCES IAMatriz(IdIAMatriz)
    ,IdExpertoIngles    INTEGER     NOT NULL    REFERENCES Persona(IdPersona)
    ,IdExpertoRuso      INTEGER     NOT NULL    REFERENCES Persona(IdPersona)
    ,Nombre             VARCHAR(20) NOT NULL    
    ,Estado             VARCHAR (1) NOT NULL DEFAULT ('A')
    ,FechaCrea          DATETIME    NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATETIME
);
