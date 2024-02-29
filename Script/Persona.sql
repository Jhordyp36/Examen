-- database: ../database/PADatabaseAntBot.sqlite

DROP TABLE IF EXISTS Persona;
CREATE TABLE IF NOT EXISTS Persona (
     IdPersona          INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdPersonaTipo      INTEGER NOT NULL REFERENCES  PersonaTipo (IdPersonaTipo)
    ,IdPersonaSexo      INTEGER NOT NULL REFERENCES   PersonaSexo (IdPersonaSexo)
    ,Nombre             TEXT NOT NULL UNIQUE
    ,Estado             VARCHAR(1) NOT NULL DEFAULT 'A'
    ,FechaCrea          DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATE
);