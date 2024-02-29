-- database: ../database/PADatabaseAntBot.sqlite
/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| mateo.simbana@epn.edu.ec  PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       mateitopro  |
\---------------------------------------------------*/
DROP TABLE IF EXISTS IAMatriz;

CREATE TABLE IF NOT EXISTS   IAMatriz (
     IdIAMatriz         INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre             VARCHAR(20) NOT NULL    
    ,Estado             VARCHAR (1) NOT NULL DEFAULT ('A')
    ,FechaCrea          DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATETIME 
);

INSERT INTO IAMatriz (Nombre) VALUES
("IA-AntBot");

SELECT * FROM IAMatriz WHERE Estado = 'A';

SELECT IdIAMatriz, Nombre
FROM IAMatriz
WHERE Estado = 'A';

SELECT count (*)
FROM IAMatriz
WHERE Estado = 'A';