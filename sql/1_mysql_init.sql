use mysql;
set password for "root"@"localhost"=password('lyf13750430998');
delete from user where user = "";
delete from user where host = "127.0.0.1";
delete from user where host = "::1";

create database vote character set utf8 collate utf8_general_ci;
create user vote@'localhost' identified by 'vote123';
grant all on vote.* to vote;