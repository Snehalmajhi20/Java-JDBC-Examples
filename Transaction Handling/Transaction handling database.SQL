show databases;
use emp;
show tables;

create table accounts(
account_number varchar(10) primary key,
balance decimal(10,2) not null
);

desc accounts

insert into accounts(account_number, balance) values('account123', 500.00),
('account594', 1000.00),('account789', 750.50),('account987', 450.20);

select * from accounts;