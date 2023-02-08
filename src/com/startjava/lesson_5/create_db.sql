DROP TABLE IF EXISTS jaegers;

CREATE DATABASE lesson5;

\c lesson5;

CREATE TABLE jaegers (
    id        SERIAL,
    modelname VARCHAR(50),
    mark      VARCHAR(50),
    height    REAL,
    weight    REAL,
    status    VARCHAR(50),
    origin    VARCHAR(50),
    launch    DATE,
    kaijukill INTEGER
);

\ir init_db.sql;
\ir queries.sql;