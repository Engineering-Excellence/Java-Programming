-- 계정 생성 및 기본 권한 부여
CREATE
USER KOSA IDENTIFIED BY java;
ALTER
USER KOSA ACCOUNT UNLOCK;
GRANT CONNECT, RESOURCE TO KOSA;

-- 특정 권한 부여
GRANT
CREATE
SESSION,
CREATE TABLE, CREATE VIEW, CREATE SEQUENCE, CREATE PROCEDURE TO KOSA;

-- 접속
CONN
/ AS SYSDBA;

-- 현재 접속 유저
SHOW
USER;
--------------------------------------------------------------------------------

-- (관리자)계정 비밀번호 만료기간 해제 (기본 180일)
SELECT *
FROM DBA_PROFILES
WHERE PROFILE = 'DEFAULT'
  AND RESOURCE_NAME = 'PASSWORD_LIFE_TIME';

ALTER
PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;

--------------------------------------------------------------------------------

-- ★ 현재 스키마(쿼리 수행 유저 소유)의 모든 테이블 목록
SELECT *
FROM TAB;

-- 현재 스키마 테이블 정보
SELECT *
FROM TABS;

--------------------------------------------------------------------------------

CREATE TABLE TEST
(
    NO    NUMBER, -- 크기 생략시 기본 4 byte
    NAME  VARCHAR2(10),
    PHONE VARCHAR2(15)
);

SELECT *
FROM TEST
ORDER BY NO;

SELECT *
FROM PERSON;
INSERT INTO PERSON(NUM, COLUMN1, COLUMN2)
VALUES (1, '2', '3');

DESC TEST;

INSERT INTO TEST
VALUES (1, 'YUNA', '010-2222-4555');
INSERT INTO TEST
VALUES (21, 'KYLE', '010-1234-5678');
INSERT INTO TEST(NAME, NO)
VALUES ('BOSONG', 22);

DELETE
FROM TEST
WHERE NO = 22;

COMMIT;