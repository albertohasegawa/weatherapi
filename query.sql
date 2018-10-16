create schema weather;
create table weather.dados (
	temp_min varchar(10) not null,
	temp_max varchar(10)not null,
	pressao varchar(10) not null,
	umidade int not null,
	dataatual timestamp not null,
	descricao_main varchar(20) not null,
	icone varchar(10) not null,
	velocidade_vento varchar(10) not null,
	cidadehora varchar(100) not null,
	constraint pk_weather PRIMARY KEY (cidadehora))
drop table weather.dados

create table weather.cidades (
	id serial not null,
	nome varchar(100) not null,
	constraint pk_cidades PRIMARY KEY (id))