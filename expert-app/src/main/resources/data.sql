Insert into EMPLOYEE (id,name) values ('JLC','Jonathan Lechien');
Insert into EMPLOYEE (id,name) values ('ARO','Anne Rousseau');

Insert into SKILL (id,name,description) values (1,'Administrateur réseaux', 'Acquérir les compétences professionnelles nécessaires pour assurer l’installation, la configuration et la maintenance d’un ou plusieurs réseaux dans leur dimension physique.');
Insert into SKILL (id,name,description) values (2,'Administrateur système Microsoft certifié', 'Acquérir les connaissances et les compétences du métier d’administrateur réseaux requises pour gérer un environnement de serveurs Windows 2008.');
Insert into SKILL (id,name,description) values (3,'Consultant junior SAP orienté finance', 'Prépare les participants à exercer la fonction de consultant junior avec un programme varié et complet.');
Insert into SKILL (id,name,description) values (4,'Consultant junior SAP orienté logistique', 'Apprendre à implémenter et paramétrer le logiciel.');
Insert into SKILL (id,name,description) values (5,'Contrôleur de gestion SAP', 'Se familiariser avec l’utilisation d’un ERP, en l’occurrence SAP.');

Insert into SKILL (id,name,description) values (6,'Développeur .Net certifié', 'Acquérir les bases en technologie orienté objet et analyse UML, ainsi que développer avec le langage C# et ASP sous plate-forme .net.');
Insert into SKILL (id,name,description) values (7,'Développeur d’applications mobiles iOS-Androïd', 'Acquérir les compétences fondamentales pour pouvoir exercer une fonction de développeur d’applications mobiles pour les environnements Androïd et IOS.');
Insert into SKILL (id,name,description) values (8,'Développeur Java EE certifié', 'Acquérir les compétences fondamentales pour pouvoir exercer une fonction de développeur Java dans une entreprise, à savoir maîtriser le langage Java.');
Insert into SKILL (id,name,description) values (9,'Initiation à la programmation', '’Acquérir les principes fondamentaux de la programmation et de l’analyse du développement d’applications.');
Insert into SKILL (id,name,description) values (10,'Essentiel des systèmes et réseaux', 'Acquérir une vue globale des composants systèmes, réseaux, services et matériels d’un environnement IT.');

Insert into SKILL (id,name,description) values (11,'Laboratoire de programmation Java', 'Acquérir les compétences pratiques de développement d’applications JAVA.');
Insert into SKILL (id,name,description) values (12,'Laboratoire d’administration système', 'Acquérir les compétences professionnelles nécessaires pour assurer l’installation, la configuration et la maintenance d’une infrastructure de serveurs dans une entreprise.');
Insert into SKILL (id,name,description) values (13,'Laboratoire Web PHP et JavaScript', 'Acquérir des compétences pratiques de développement d’applications web, côté serveur avec le framework PHP Symfony 3 et côté client avec JavaScript et jQuery.');

alter sequence skill_seq restart with 100;

Insert into TRAINING (id,employee_id,skill_id,scheduled) values (1, 'JLC', 1, '2018-06-01');
Insert into TRAINING (id,employee_id,skill_id,scheduled) values (2, 'JLC', 3, '2023-08-21');
Insert into TRAINING (id,employee_id,skill_id,scheduled) values (3, 'JLC', 5, '2024-11-18');
Insert into TRAINING (id,employee_id,skill_id,scheduled) values (4, 'JLC', 8, '2023-12-15');
Insert into TRAINING (id,employee_id,skill_id,scheduled) values (5, 'JLC', 9, '2023-09-22');

Insert into TRAINING (id,employee_id,skill_id,scheduled) values (6, 'ARO', 7, '2022-04-16');
Insert into TRAINING (id,employee_id,skill_id,scheduled) values (7, 'ARO', 11, '2019-08-03');
Insert into TRAINING (id,employee_id,skill_id,scheduled) values (8, 'ARO', 4, '2023-09-12');
Insert into TRAINING (id,employee_id,skill_id,scheduled) values (9, 'ARO', 6, '2023-11-06');
Insert into TRAINING (id,employee_id,skill_id,scheduled) values (10, 'ARO', 10, '2023-10-07');

alter sequence training_seq restart with 100;