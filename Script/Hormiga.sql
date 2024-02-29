-- database: ../database/PADatabaseAntBot.sqlite

DROP TABLE IF  EXISTS Hormiga;

CREATE TABLE IF NOT  EXISTS Hormiga (
     IdHormiga          INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdHormigaTipo      INTEGER NOT NULL REFERENCES HormigaTipo(IdHormigaTipo)
    ,Codigo             INTEGER UNIQUE NOT NULL
    ,Nombre             TEXT NOT NULL
    ,Estado             Varchar(1) NOT NULL DEFAULT "A"
    ,FechaCrea          DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATE

); 

INSERT INTO Hormiga (IdHormiga, IdHormigaTipo, Codigo, Nombre) VALUES
   (1,1,'1254','Hormiga A');