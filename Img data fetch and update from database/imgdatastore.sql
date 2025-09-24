show databases;
use emp;
show tables;
create table image_table(
image_id int auto_increment primary key,
image_data LONGBLOB not null,
upload_data timestamp default current_timestamp);
desc image_table;
select * from image_table;