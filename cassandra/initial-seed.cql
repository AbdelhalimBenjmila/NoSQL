CREATE KEYSPACE IF NOT EXISTS "spring_boot_cassandra" WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor' : '1' };


CREATE TABLE spring_boot_cassandra.user (
   name TEXT,
   address TEXT,
   age  INT,
   phone TEXT,
   PRIMARY KEY (name, address, age, phone))
   WITH CLUSTERING ORDER BY (address ASC, age ASC, phone ASC);

INSERT INTO spring_boot_cassandra.user
(name,
address,
age,
phone)
VALUES ('halim', 'tunis', 28,'24788917');

INSERT INTO spring_boot_cassandra.user
(name,
address,
age,
phone)
VALUES ('jmila', 'tunis', 28,'24788917');
