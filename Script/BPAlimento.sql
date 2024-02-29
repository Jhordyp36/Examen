-- database: ../database/PADatabaseAntBot.sqlite
DROP TABLE IF EXISTS BPAlimento;

CREATE TABLE BPAlimento(
     IdBPAlimento       INTEGER     NOT NULL    PRIMARY KEY AUTOINCREMENT
    ,NombreAlimento     VARCHAR(30) NOT NULL
    ,IdHormigaTipo      INTEGER                 REFERENCES HormigaTipo(IdHormigaTipo)
    ,Codigo             INTEGER                 REFERENCES Hormiga(Codigo)
    ,IdHormiga          INTEGER                 REFERENCES Hormiga(IdHormiga)
    ,Estado             VARCHAR (1) NOT NULL    DEFAULT ('A')
    ,FechaCrea          DATETIME    NOT NULL    DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica      DATETIME
);

-- -- Ejemplo de INSERT INTO desde un archivo de texto
-- INSERT INTO BPAlimento (NombreAlimento) 
-- SELECT NombreAlimento FROM setAlimento.txt;



