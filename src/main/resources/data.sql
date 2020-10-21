
DROP TABLE IF EXISTS users;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(250) DEFAULT NULL,
   `lastname` varchar(250) DEFAULT NULL,
    `email` varchar(250) DEFAULT NULL,
     `password` varchar(250) DEFAULT NULL,
     `phone` varchar(250) DEFAULT NULL,
      
  `position` varchar(250) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL
  
 
);



insert into users(firstname,lastname,email,password,phone,position,salary)values('Pepe','garcia','pepe','1234','65555','ADMINISTRADOR',3000);
insert into users(firstname,lastname,email,password,phone,position,salary)values('luis','garcia','pepe','1234','65555','ADMINISTRADOR',3000);

