-- database: ../database/PADatabaseAntBot.sqlite

DROP TABLE IF EXISTS PersonaTipo;
CREATE TABLE IF NOT EXISTS PersonaTipo (
     IdPersonaTipo      INTEGER PRIMARY KEY AUTOINCREMENT 
    ,Nombre             TEXT NOT NULL UNIQUE
    ,Estado             VARCHAR(1) NOT NULL DEFAULT 'A'
    ,FechaCrea          DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATE
);

INSERT INTO PersonaTipo (Nombre) VALUES
('Experto Inglés')
,('Experto Ruso');