-- database: ../database/PADatabaseAntBot.sqlite

DROP TABLE IF  EXISTS Hormiga;

CREATE TABLE IF NOT  EXISTS Hormiga (
     IdHormiga          INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdHormigaTipo      INTEGER NOT NULL REFERENCES HormigaTipo(IdHormigaTipo)
    ,Codigo             INTEGER UNIQUE NOT NULL
    ,Nombre             TEXT NOT NULL
    ,Comio              TEXT NOT NULL DEFAULT "X"  -- "A" para no, 1 para sí
    ,Recogio            TEXT NOT NULL DEFAULT "X"  -- "A" para no, 1 para sí
    ,Estado             Varchar(1) NOT NULL DEFAULT "A"
    ,FechaCrea          DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATE

); 

INSERT INTO Hormiga (IdHormigaTipo, Codigo, Nombre) VALUES
   (5,'4325','Reina');

-- Crea las 40 Larvas

--Bucle para generar instrucciones INSERT
WITH RECURSIVE larvas AS (
  SELECT 1 AS i
  UNION ALL
  SELECT i + 1 FROM larvas WHERE i < 40
)
INSERT INTO Hormiga (IdHormigaTipo, Codigo, Nombre)
SELECT 4 AS IdHormigaTipo,
       ABS(RANDOM() % 10000) AS Codigo,
       'Larva' AS Nombre
FROM larvas;

