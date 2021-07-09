USE ENCHERES 
GO

INSERT INTO UTILISATEURS VALUES 
('1', 'DUPOND', 'Tatiana', 'dupond.t44@gmail.com', '0612345678', '1 Allee des pondus', '44000', 'Nantes', 'azerty', 11550, 0),
 ('2', 'DURAND', 'Nicolas', 'durand.n44@gmail.com', '0698765432', '2 Route des randus', '44800', 'Saint-Herblain', 'azerty', 55103, 1), 
 ('3', 'TOTO', 'Jean-Marc', 'toto.jm44@gmail.com', '0623366545', '3 Rue du toto', '44360', 'Saint-Etienne de Montluc', 'azerty', 4148, 1);
 
 
INSERT INTO CATEGORIES VALUES('Informatique'), ('Ameublement'), ('Vêtements'), ('Sport & Loisirs');	


INSERT INTO ARTICLES_VENDUS VALUES
('Serveur Synology DS414', 'Quelques micro rayures sur le cache vertical, mais plutôt bon état général', '2021-06-14 00:00', '2021-08-05 00:00', 500, 500, 2, 1),
('Botte Cuir rouge', 'Superbe botte en vritable cuir noir. Taille 36 TBE', '2021-05-04 00:00', '2021-12-05 00:00', 150, 150, 1, 3),
('Chaise pour enfant', 'Chaise en bois maison TBE', '2021-04-10 00:00', '2021-8-10 00:00', 85, 85, 2, 2),
('Adidas Meteore année 2020','chaussure de football neuve taille 13, jamais portées','2021-06-29 00:00','2021-07-29 00:00', 340, 340, 3, 4);


INSERT INTO RETRAITS VALUES
(1, '85 Route de Vannes', '44800', 'Saint-Herblain'),
(2, '8 Rue des Coqueliquots ', '44240', 'La Chapelle sur Erdre');
