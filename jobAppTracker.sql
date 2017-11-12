-- Create database
DROP DATABASE IF EXISTS jobtrackerdb;
CREATE DATABASE jobtrackerdb;
USE jobtrackerdb;

-- Add user
-- Uncomment the lines below as needed
-- DROP USER 'jobtracker'@'localhost';
-- CREATE USER 'jobtracker'@'localhost' IDENTIFIED BY 'jobtracker';
-- GRANT ALL PRIVILEGES ON jobtrackerdb.* TO 'jobtracker'@'localhost';

--  Build tables
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `user` (email, password) VALUES ('bob@bob.com', 'bob');

DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `companyName` varchar(255) NOT NULL,
  `jobLocation` varchar(255) NOT NULL,
  `appliedVia` varchar(255) NOT NULL,
  `resume` varchar(255) NOT NULL,
  `coverLetter` varchar(255) NOT NULL,
  `notes` varchar(255),
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`userId`)
    REFERENCES `user` (`id`)
);

INSERT INTO `application` (companyName, jobLocation, appliedVia, resume, coverLetter, notes, userId)
    VALUES ('Company A', 'Denver', 'LinkedIn, http://www.job.com', 'bthomas2017.pdf', 'Java1CoverLetter.pdf', 'notes one', 1);
INSERT INTO `application` (companyName, jobLocation, appliedVia, resume, coverLetter, notes, userId)
    VALUES ('Company B', 'Davis, CA', 'boss@companyb.com', 'bthomas2017.pdf', 'ag1CoverLetter.pdf', 'notes two', 1);

DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) NOT NULL,
  `email` varchar(255),
  `phone` varchar(255),
  `interviewRequested` tinyint(1) DEFAULT 0 NOT NULL,
  `notes` varchar(255) NULL,
  `applicationId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`applicationId`)
    REFERENCES `application` (`id`)
);

INSERT INTO `response` (name, email, notes, applicationId)
    VALUES ('Bob Bobbers', 'bob@bobb.com', 'a polite decline', 1);
INSERT INTO `response` (date, name, email, phone, interviewRequested, notes, applicationId)
    VALUES ('2017-11-20', 'Jim Jimmers', 'jim@companyb.com', '555-123-4567', 1, 'interview next week', 2);

DROP TABLE IF EXISTS `interview`;
CREATE TABLE `interview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) NOT NULL,
  `email` varchar(255),
  `phone` varchar(255),
  `notes` varchar(255),
  `offerMade` tinyint(1) DEFAULT 0 NOT NULL,
  `offerSalary` varchar(255),
  `offerLocation` varchar(255),
  `offerDetails` varchar(255),
  `applicationId` int(11) NOT NULL,
  `responseId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`applicationId`)
    REFERENCES `application` (`id`),
  FOREIGN KEY (`responseId`)
    REFERENCES `response` (`id`)
);

INSERT INTO `interview` (date, name, email, phone, notes, applicationId, responseId)
    VALUES ('2017-12-01 13:00:00', 'Dick Dickers', 'dick@companyb.com', '555-458-9999', 'made a follow up interview', 2, 2);
INSERT INTO `interview` (date, name, email, phone, notes, offerMade, offerSalary, offerLocation, offerDetails, applicationId, responseId)
    VALUES ('2017-12-03 14:30:00', 'Frank Frankers', 'frankk@companyb.com', '555-458-0000', 'got an offer', 1, '65k/year', 'Aurora, CO', 'insurance included', 2, 2);
