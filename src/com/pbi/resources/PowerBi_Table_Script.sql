drop table PBILICENSE;

truncate table PBILICENSE;

CREATE TABLE PBILICENSE(
requestid int primary key,
aliasname varchar(10),
emailaddress varchar(50),
typeoflicense varchar(10),
requesteddate varchar(10)
);

select * from PBILICENSE;
