## Use to run mysql db docker image, optional if you're not using a local mysqldb
#  docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql
# The way connecting to myusql container:
#  mysql -h 172.17.0.2 -P 3306 -u root -p
#
# connect to mysql and run as root user
# mysql -h 127.0.0.1 -P 3306 -u root -ptian
#Create Databases
CREATE DATABASE recipe_dev;
CREATE DATABASE recipe_prod;

#Create database service accounts
CREATE USER 'dev_user'@'localhost' IDENTIFIED BY 'tian';
CREATE USER 'prod_user'@'localhost' IDENTIFIED BY 'tian';


#Database grants
GRANT SELECT ON recipe_dev.* to 'dev_user'@'localhost';
GRANT INSERT ON recipe_dev.* to 'dev_user'@'localhost';
GRANT DELETE ON recipe_dev.* to 'dev_user'@'localhost';
GRANT UPDATE ON recipe_dev.* to 'dev_user'@'localhost';
GRANT SELECT ON recipe_prod.* to 'prod_user'@'localhost';
GRANT INSERT ON recipe_prod.* to 'prod_user'@'localhost';
GRANT DELETE ON recipe_prod.* to 'prod_user'@'localhost';
GRANT UPDATE ON recipe_prod.* to 'prod_user'@'localhost';