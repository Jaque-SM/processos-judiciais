create table processo (
	numero char(25) not null,
	orgao varchar(30) not null,
	tribunal varchar(40) not null,
	unidade varchar(50) not null,
	data_abertura date not null,
	status varchar(9) not null,
	descricao varchar(255) not null,
	reu_rg varchar(20),
	primary key (numero),
	foreign key (reu_rg) references reu (rg)
);
