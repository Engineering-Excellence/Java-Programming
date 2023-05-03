DROP TABLE test;

CREATE TABLE test
(
    no        NUMBER       NOT NULL, -- PK, NUMBER: 4 BYTE (-9999~9999)
    name      VARCHAR2(10) NOT NULL,
    birthdate DATE,                  -- 생년월일: '년-월-일' or '년/월/일'
    age       NUMBER,
    CONSTRAINT test_no_pk PRIMARY KEY (no)
);

SELECT *
FROM test;

DESC TEST;

--------------------------------------------------------------------------------

CREATE TABLE userlist
(
    id   VARCHAR2(10)
        CONSTRAINT id_pk PRIMARY KEY,
    name varchar2(10) --not null
);

INSERT INTO userlist
VALUES ('kingsmile', 'aa');
INSERT INTO userlist
VALUES ('yuna2', '김연아');
INSERT INTO userlist(id)
VALUES ('ccc');

COMMIT;

SELECT *
FROM userlist;

-- ① 컬럼 추가
-- ALTER TABLE 테이블명 ADD
--      (컬럼명 자료형 [제약조건], 컬럼명 자료형 [제약조건], ...)
ALTER TABLE userlist
    ADD phone VARCHAR2(15);
ALTER TABLE userlist
    ADD (no NUMBER(2), gender CHAR(2));

-- UPDATE 테이블명 SET 변경내용;    -- 전체 레코드 변경
UPDATE userlist
SET no = 1;
-- UPDATE 테이블명 SET 변경내용 WHERE 조건;    -- 전체 레코드 변경
UPDATE userlist
SET no = 1
WHERE id = 'kingsmile';
UPDATE userlist
SET no     = 3,
    gender = 'f',
    name   = '강감찬'
WHERE id = 'ccc';
ROLLBACK;
-- DML(SELECT, INSERT, UPDATE, DELETE)

-- ② 컬럼 삭제
-- ALTER TABLE 테이블명 DROP COLUMN 컬럼명
ALTER TABLE userlist
    DROP
        COLUMN phone;
ALTER TABLE userlist
    DROP
        (no, gender);
SELECT *
FROM userlist;

-- ③ 자료형 변경
-- ALTER TABLE 테이블명 MODIFY 컬럼명 변경자료형
DESC USERLIST;
ALTER TABLE userlist
    MODIFY phone NUMBER; -- 컬럼에 데이터 없을 경우 자료형 변경 가능
ALTER TABLE userlist
    MODIFY no DATE; -- 기존 데이터 존재시 변경 불가, 방법은 null 처리하거나 비운 뒤 변경 가능

UPDATE userlist
SET no = '';
SELECT *
FROM userlist;

-- ④ 컬럼이름 변경
-- alter table 테이블이름 rename column 기존컬럼명 to 변경컬럼명
ALTER TABLE userlist RENAME COLUMN phone TO tel;
ALTER TABLE userlist RENAME COLUMN no TO num;
SELECT *
FROM userlist;

-- ⑤ 테이블 삭제
-- drop table 테이블이름
DELETE
FROM userlist;
DESC USERLIST;

ROLLBACK;
SELECT *
FROM userlist;

-- 삭제 테이블 목록 보기
SHOW RECYCLEBIN;
DESC RECYCLEBIN;

-- 복구 (삭제된 테이블)
FLASHBACK
    TABLE userlist TO BEFORE DROP;
SELECT *
FROM userlist;

-- 휴지통 비우기
PURGE
    RECYCLEBIN;
-- 휴지통에 안 남기고 완전 제거
DROP TABLE emp2 PURGE;

SELECT *
FROM emp2;
SELECT *
FROM tab;

--------------------------------------------------------------------------------

-- 레코드 삽입 / 수정 / 삭제
-- INSERT INTO 테이블명 (컬럼명1, 컬럼명2, ...) VALUES (값1, 값2, ...)
-- INSERT INTO 테이블이름 VALUES (값, 값, ...)
-- =>모든 컬럼에 모두 값을 넣을 때 사용

SELECT *
FROM gift;
DESC GIFT;

INSERT INTO gift
VALUES (100, '냉장고세트', 1000, 100000);
INSERT INTO gift (gname, g_end)
VALUES ('동화책', 30000);

-- UPDATE 테이블이름
-- SET 컬럼명=변경값 , 컬럼명=변경값 , 컬럼명=변경값 , .....
-- [ WHERE 조건식 ]
SELECT *
FROM professor;
SELECT name, position, pay, bonus
FROM professor
WHERE position = '정교수'
   OR position = '전임강사';
SELECT name, position, pay, pay * 1.2 AS "인 상 분", bonus
FROM professor
WHERE position = '정교수';

UPDATE professor
SET pay = pay * 1.2;
ROLLBACK;

--------------------------------------------------------------------------------

-- DELETE TABLE이름 [ WHERE 조건식 ]
-- TRUNCATE TABLE 테이블명; => 모든 레코드 삭제
SELECT *
FROM gift;
SELECT *
FROM gift
WHERE gname LIKE '%세트'; -- %: 모든, _: 한 문자(반드시 LIKE와 함께 사용)
DELETE
    gift
WHERE gname LIKE '%세트';
ROLLBACK;

TRUNCATE TABLE gift; -- WHERE 절 및 ROLLBACK 불가!
