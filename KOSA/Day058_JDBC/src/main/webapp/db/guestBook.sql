SELECT *
FROM DEPT2;

DROP TABLE GUESTBOOK;

CREATE TABLE GUESTBOOK
(
    NUM      NUMBER,
    NAME     VARCHAR2(50) NOT NULL,
    EMAIL    VARCHAR2(50),
    HOME     VARCHAR2(50),
    CONTENTS VARCHAR2(2000) NOT NULL
) SEGMENT CREATION IMMEDIATE;

SELECT *
FROM GUESTBOOK;

DROP SEQUENCE BOOK_NUM;
CREATE SEQUENCE BOOK_NUM;

insert into guestBook(num, name, email, home, contents)
values (book_num.nextval, 'dd', 'aa@kosta.or.kr', 'homeaa', 'hello');

COMMIT;
--------------------------------------------------
SELECT NAME, EMAIL, HOME, CONTENTS
FROM GUESTBOOK
WHERE NUM > 6
  AND NUM <= 23
ORDER BY NUM DESC;

SELECT COUNT(*)
FROM GUESTBOOK
SELECT COUNT(NUM)
FROM GUESTBOOK;

DELETE
FROM GUESTBOOK
WHERE NUM = 12
-----------------------------------------------

update guestBook
set email='ii@i.kr',
    home='http://',
    contents='hi'
where num = 1;

UPDATE GUESTBOOK
SET EMAIL= ?,
    HOME= ?,
    CONTENTS= ?
WHERE NUM = ?;


