-- database: ../database/PADatabaseAntBot.sqlite

DROP TABLE IF  EXISTS "Hormiga";

CREATE TABLE IF NOT  EXISTS "Hormiga" (
    IdHormiga           INTEGER PRIMARY KEY AUTOINCREMENT
    , IdHormigaTipo     INTEGER NOT NULL REFERENCES HormigaTipo(IdHormigaTipo)
    , Nombre            TEXT NOT NULL
    , Estado            Varchar(1) NOT NULL DEFAULT "A"
    ,FechaCrea          DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATE

); 