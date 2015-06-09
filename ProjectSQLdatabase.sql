set foreign_key_checks = 0;

drop table if exists gebruiker;
create table if not exists gebruiker (
	gebruiker_id int not null auto_increment,
    voornaam varchar(45) not null,
    achternaam varchar(45) not null,
    email varchar(45) not null,
    gebruiker_naam varchar(45) not null unique,
    wachtwoord varchar(45) not null,
	primary key(gebruiker_id)
);

drop table if exists nieuwe_taak;
create table if not exists nieuwe_taak (
	nieuwe_taak_id int not null auto_increment,
    gebruiker_id int not null,
    taak_naam varchar(45) not null,
    omschrijving varchar(45) not null,
    datum varchar(10) not null,
    categorie varchar(45) not null,
    foreign key (gebruiker_id) references gebruiker(gebruiker_id),
    primary key(nieuwe_taak_id, gebruiker_id)    
);

drop table if exists register;
create table if not exists register (
    voornaam varchar(45) null,
    id varchar(45) null,
    wachtwoord varchar(45) null,
    dated varchar(45) null,
    address varchar(45) null,
	primary key(id)
);

drop table if exists result;
create table if not exists result (
    id varchar(45) null,
    register_id varchar(45) null,
    marks varchar(45) null,
    percent varchar(45) null,
    grade varchar(45) null,
    foreign key (register_id) references register(id),
	primary key(id)
);

set foreign_key_checks = 1;

