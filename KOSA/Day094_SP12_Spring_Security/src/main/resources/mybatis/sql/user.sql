select *
from users;
drop table users;

create table users
(
    userid    number not null primary key,
    name      varchar2(50) not null,
    passwd    varchar2(100) not null,
    enabled   number(1) default 1,
    authority varchar(30)
);

insert into users(userid, name, passwd, enabled, authority)
values (1, 'kingsmile', '1', default, '관리자');
commit;


CREATE TABLE roll
(
    userid    VARCHAR2(20),
    Role_name VARCHAR2(30)
);

-- ROLE_USER , ROLE_ADMIN
INSERT INTO roll
VALUES ('admin', 'ROLE_USER');
INSERT INTO roll
VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO roll
VALUES ('simson', 'ROLE_USER');
COMMIT;

select *
from roll;

----------------------------
CREATE TABLE USER
(
    no       int auto_increment primary key,
    id       varchar(30) not null,
    password varchar(30) not null,
    enabled  boolean     not null
);


CREATE TABLE USER_AUTH
(
    no        int         not null,
    authority varchar(30) not null
);
