DROP TABLE jobs CASCADE CONSTRAINTS;

DROP TABLE Applicant CASCADE CONSTRAINTS;

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence START WITH 1001 INCREMENT BY 1;

CREATE TABLE Jobs(
    JobCode varchar2(15)NOT NULL PRIMARY KEY,
    JobTitle varchar2(100) NOT NULL,
    SubJob varchar2(100),
    Joblevel varchar2(100) NOT NULL,
    ExpiryStatus varchar2(20) NOT NULL
);

insert into jobs values('JC101','Sales','JC109,JC110','1','No');
insert into jobs values('JC102','Fishing',null,'1','No');
insert into jobs values('JC103','Butcher',null,'1','No');
insert into jobs values('JC104','Bakery',null,'1','No');
insert into jobs values('JC105','Warehouse Staff',null,'1','No');
insert into jobs values('JC106','Cashier',null,'1','No');
insert into jobs values('JC107','Supervisor','JC109,JC110','1','No');
insert into jobs values('JC108','Manager','JC111,JC112','1','No');
insert into jobs values('JC109','Food',null,'2','No');
insert into jobs values('JC110','NonFood',null,'2','No');
insert into jobs values('JC111','Commercial','JC113,JC114,JC115,JC116,JC117,JC118','2','No');
insert into jobs values('JC112','Services','JC119,JC120,JC121,JC122,JC123','2','No');
insert into jobs values('JC113','DH Food',null,'3','No');
insert into jobs values('JC114','DH NonFood',null,'3','No');
insert into jobs values('JC115','Bakery Manager',null,'3','No');
insert into jobs values('JC116','Fishing Manager',null,'3','No');
insert into jobs values('JC117','Butcher Manager',null,'3','No');
insert into jobs values('JC118','F and B Manager','JC109,JC110','3','No');
insert into jobs values('JC119','CCO Manager','JC111,JC112','3','No');
insert into jobs values('JC120','Cash Sales',null,'3','No');
insert into jobs values('JC121','HC Manager',null,'3','No');
insert into jobs values('JC122','Security Manager',null,'3','No');
insert into jobs values('JC123','IT Manager',null,'3','No');




CREATE TABLE Applicant(
    ApplicantId varchar2(15)NOT NULL PRIMARY KEY,
    Name varchar2(100) NOT NULL,
    Job varchar2(100) NOT NULL,
    resume BLOB NOT NULL
);


COMMIT;