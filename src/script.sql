create database if not exists dbbexam;
use dbbexam;

create table Rue
(
  code_rue int primary key auto_increment,
  nom_rue varchar(30)
);

create table Immeuble
(
  num_immeuble int primary key auto_increment,
  nb_etage_total int,
 code_rue int,
  FOREIGN KEY (code_rue) REFERENCES Rue(code_rue)
);
create table Etage
(
  num_etage int primary key auto_increment,
  nb_appartement_tot int,
 num_immeuble int,
  FOREIGN KEY (num_immeuble) REFERENCES Immeuble(num_immeuble)
);
create table Appartement
(
  lettre_appartement int primary key auto_increment,
  nb_pieces_total int,
 num_etage int,
  FOREIGN KEY (num_etage) REFERENCES Etage(num_etage));
-- insertion des rues
insert into Rue values (23,'rue1');
insert into Rue values (231,'rue2');
insert into Rue values (232,'rue3');
insert into Rue values (233,'rue4');
-- insertion des immeubles 

insert into Immeuble values (21,3,23);
insert into Immeuble values (22,5,231);
insert into Immeuble values (23,6,232);
insert into Immeuble values (24,5,233);

--  insertion des etages 

insert into Etage values (1,3,21);
insert into Etage values (2,4,22);
insert into Etage values (3,5,23);
insert into Etage values (4,6,24);
-- insertion des appartements 
insert into Appartement values (1,2,1);
insert into Appartement values (2,3,2);
insert into Appartement values (3,5,3);
insert into Appartement values (4,6,4);