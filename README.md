# Tamer

# mysql setting
# --platform linux/amd64 : only m1 mac
- docker pull mysql
- docker run  --platform linux/amd64 --name tamer-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=tamer12@@ -d mysql:8

# connect to mysql docker container and setting db env

- docker exec -it tamer-mysql /bin/bash
- mysql -u root -p
- tamer12@@

- create user 'tamer'@'%' identified by 'tamer12@@';

- create databases tamer;
- use tamer;
- create table xxxx(field type, field type.. , PRIMARY KEY(field)) ENGINE=InnoDB DEFAULT CHARSET=utf8

- grant all privileges on tamer.* to 'tamer'@'%';
- flush privileges;

