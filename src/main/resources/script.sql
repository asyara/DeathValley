CREATE DATABASE user_bank_list;

USE user_bank_list;

CREATE TABLE `user` (
`userId` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `sureName` VARCHAR(45) NULL,
  PRIMARY KEY (`userId`));

CREATE TABLE `account` (
  `accountId` INT NOT NULL,
  `account` INT NULL,
  `userId` INT NULL,
  PRIMARY KEY (`accountId`), FOREIGN KEY (userId) REFERENCES user (userId));

INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('1', 'Bill', 'Gates');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('2', 'Bill', 'Clinton');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('3', 'Clint', 'Eastwood');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('4', 'Jonny', 'Depp');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('5', 'Tom', 'Cruise');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('6', 'Tony', 'Stark');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('7', 'Kate', 'Moss');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('8', 'Mike', 'Tyson');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('9', 'Li', 'Mao');
INSERT INTO `user_bank_list`.`user` (`userId`, `name`, `sureName`) VALUES ('10', 'John', 'Golt');

INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('1', '10000', '1');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('2', '5000', '2');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('3', '3000', '3');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('4', '4000', '4');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('5', '6500', '5');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('6', '1000', '6');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('7', '5500', '7');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('8', '11000', '8');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('9', '100', '9');
INSERT INTO `user_bank_list`.`account` (`accountId`, `account`, `userId`) VALUES ('10', '6500', '10');