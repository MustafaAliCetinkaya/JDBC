select *  from books;
select count(*)  from books;
select name,count(name) from books  group by name desc ;

select (56*345)+234;
select sin(pi()/4);
select SQRT(144);

select 'ali' as name;

select version();
select now();

show databases ;
use information_schema;
use library1;

desc library1.books;
desc library1.books;

/*create table client(
name varchar(20) not null ,
surName varchar(20) not null ,
identityNumber char(11) primary key not null ,
age INTEGER ,
job varchar(20)
);*/

select author from books where book_category_id=3;
