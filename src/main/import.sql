CREATE SCHEMA IF NOT EXISTS procedimento;
SET SCHEMA procedimento;
CREATE TABLE IF NOT EXISTS PROCEDIMENTO(
	PROCEDIMENTO INT NOT NULL, IDADE INT NOT NULL, SEXO VARCHAR(1) NOT NULL, AUTORIZADO BOOLEAN NOT NULL,
	primary key(PROCEDIMENTO, IDADE, SEXO)
);



insert into procedimento (id, idade, sexo, autorizado) values (1234, 10, 'M', FALSE); 
insert into procedimento (id, idade, sexo, autorizado) values (4567, 20, 'M', TRUE);
insert into procedimento (id, idade, sexo, autorizado) values (6789, 10, 'F', FALSE);
insert into procedimento (id, idade, sexo, autorizado) values (6789, 10, 'M', TRUE);
insert into procedimento (id, idade, sexo, autorizado) values (1234, 20, 'M', TRUE);
insert into procedimento (id, idade, sexo, autorizado) values (4567, 30, 'F', TRUE);