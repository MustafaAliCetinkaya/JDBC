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

select * from bitnami_orocrm.orocrm_contact;
select * from bitnami_orocrm.orocrm_contact_email;
select id,first_name,last_name,email from bitnami_orocrm.orocrm_contact order by id asc ;

select id,first_name,last_name from bitnami_orocrm.orocrm_contact where first_name='Cherryl';
select * from bitnami_orocrm.orocrm_contact_email where email='cherrylarmstrong@yahoo.com';
select * from bitnami_orocrm.orocrm_contact_email where owner_id=82;

select c.first_name, c.last_name, e.email
from bitnami_orocrm.orocrm_contact c
    inner join bitnami_orocrm.orocrm_contact_email e
        on c.id = e.owner_id
where e.email='cherrylarmstrong@yahoo.com';