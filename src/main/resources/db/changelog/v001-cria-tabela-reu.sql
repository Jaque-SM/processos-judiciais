create table reu (
	rg varchar(20) not null primary key,
	nome varchar(200) not null,
	data_nascimento date not null,
	estado char(2) not null,
	cidade varchar(50) not null,
	bairro varchar(50) not null,
	rua varchar(50) not null,
	logradouro varchar(200) not null
)