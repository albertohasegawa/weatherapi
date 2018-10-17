create schema weather;
create table weather.dados (
	temp_min varchar(100) not null,
	temp_max varchar(100)not null,
	pressao varchar(100) not null,
	umidade int not null,
	dataatual timestamp not null,
	descricao_main varchar(200) not null,
	icone varchar(100) not null,
	velocidade_vento varchar(100) not null,
	cidadehora varchar(100) not null,
	cidade varchar(100) not null,
	constraint pk_weather PRIMARY KEY (cidadehora))
drop table weather.dados

create table weather.cidades (
	id serial not null,
	nome varchar(100) not null,
	constraint pk_cidades PRIMARY KEY (id))