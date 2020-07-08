drop database if exists supersightingsdb;

create database supersightingsdb;

use supersightingsdb;

create table powers (
	powerId int primary key auto_increment,
    powerName varchar(20) not null,
    powerDescription varchar(300)
);

create table supers (
	superId int primary key auto_increment,
    superName varchar(30) not null,
    superDescription varchar(300),
    powerId int not null,
    foreign key fk_powerfk(powerId)
		references powers(powerId)
);

create table organizations (
	orgId int primary key auto_increment,
    orgName varchar(30) not null,
    orgDescription varchar(100),
    orgAddress varchar(50) not null,
    orgCity varchar(50) not null,
    orgState char(2) not null,
    orgZip char(5) not null,
    phone char(12) not null
);

create table organizations_supers (
	orgId int not null,
    superId int not null,
	primary key pk_orgId_supId(orgId, superId),
    foreign key fk_orgfk(orgId)
		references organizations(orgId),
	foreign key fk_supfk(superId)
		references supers(superId)
);

create table locations (
	locId int primary key auto_increment,
	locName varchar(50) not null,
    locDescription varchar(100),
    locAddress varchar(50),
    locCity varchar(50) not null,
    locState char(2) not null,
    locZip char(5) not null,
    locLatitude decimal(8, 6) not null,
    locLongitude decimal(9, 6) not null
);

create table sightings (
	sightingId int primary key auto_increment,
	superId int not null,
    locId int not null,
    sightingDate date not null,
    foreign key fk_sup_sighting(superId)
		references supers(superId),
	foreign key fk_sighting_loc(locId)
		references locations(locId)
);
    
    SET GLOBAL FOREIGN_KEY_CHECKS=1;