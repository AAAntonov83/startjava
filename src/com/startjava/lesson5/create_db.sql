CREATE DATABASE lesson5;

\c lesson5;

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
	id        integer,
	modelname varchar(50),
	mark      varchar(50),
	height    real,
	weight    real,
	status    varchar(50),
	origin    varchar(50),
	launch    date,
	kaijukill integer
);

\ir init_db.sql;
\ir queries.sql;