CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  pass CHAR(60) NOT NULL
);

insert into users value(null,"わたなべ","$2a$08$i59kFVcTc0lznwZNI3StSemUo0vTEf5FlSRi2it/6JHeHJiL..kXy");

insert into users value(null,"うすい","$2a$08$/5uIBX1peHv/3g2QsU1svuJEqKhTeXiM2Ler7BE6U5UkQtzoJrggm");
