-- database: ../database/PADatabaseAntBot.sqlite
DROP TABLE IF EXISTS PersonaSexo;
CREATE TABLE IF NOT EXISTS PersonaSexo (
     IdPersonaSexo      INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre             TEXT NOT NULL UNIQUE
    ,Estado             VARCHAR(1) NOT NULL DEFAULT 'A'
    ,FechaCrea          DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATE
);

INSERT INTO PersonaSexo (Nombre) VALUES 
('MASCULINO'),
('FEMENINO');