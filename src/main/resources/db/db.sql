DROP DATABASE IF EXISTS `online_courses`;
CREATE DATABASE IF   NOT EXISTS `online_courses`;




CREATE TABLE IF NOT EXISTS Course  (
   courseId  int NOT NULL,
   category  varchar(255) DEFAULT NULL,
   title  varchar(255) DEFAULT NULL UNIQUE,
  PRIMARY KEY ( courseId )
);


INSERT INTO  Course  ( courseId ,  category ,  title ) VALUES
	(1, 'category1', 'Course1'),
	(52, 'category2', 'Course2');


CREATE TABLE Role (
  roleId int NOT NULL,
  roleType varchar(255) DEFAULT NULL,
 PRIMARY KEY ( roleId )
);


CREATE TABLE User (
   userId  int NOT NULL,
   Role  varchar(255) DEFAULT NULL,
   email  varchar(255) DEFAULT NULL UNIQUE,
   password  varchar(255) DEFAULT NULL,
   pictureUrl  varchar(255) DEFAULT NULL,
   username  varchar(255) DEFAULT NULL UNIQUE,
   roles  varchar(255) DEFAULT NULL,
  PRIMARY KEY ( userId )
);

INSERT INTO  User  ( userId ,  Role ,  email ,  password ,  pictureUrl ,  username ,  roles ) VALUES
	(90, NULL, 'chavdarov.bobysda1@gmail.com', '{bcrypt}$2a$10$j/k4rjKPsM.GP34S4LBc4eXwjuksdww1tUsG0G.Cj2bjjg19kFQBi', 'https://i.ytimg.com/vi/yD_oR8G38Sg/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCvyrdPFcgb-MoXxUDpIGY_6Om6cg', 'user1', 'Student');

