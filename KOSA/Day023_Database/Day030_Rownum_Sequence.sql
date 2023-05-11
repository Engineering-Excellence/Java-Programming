-- rownum: 검색할 때 자동 행 번호 추가
SELECT *
FROM emp;
SELECT ename, job, rownum
FROM emp;
SELECT rownum, ename, job
FROM emp;

-- rownum은 SELECT에만 적용, 삭제/수정에는 사용 불가
DELETE
FROM emp
WHERE rownum = 4;

/*
    dual: 테이블
    rownum: 번호 부여, 오라클 DB 이용한 게시판 만들 경우 페이징 처리에 사용. cf) 1 LIMIT 7: MySQL
    rowid
*/

SELECT rowid, ename, job, rownum
FROM emp;
SELECT ename, job, rownum
FROM emp
WHERE sal > 3000;

SELECT rownum, ename, sal
FROM (SELECT * FROM emp ORDER BY sal);


--------------------------------------------------------------------------------


-- SEQUENCE
/*
    CREATE SEQUENCE 시퀀스명    -- 1부터 시작
    [STRAT WITH 초기값]
    [INCREMENT BY 증가값]
    [MAXVALUSE] 최대값
    [MINVALUSE] 최소값
    [CYCLE | NOCYCLE]
    [CACHE | NOCACHE]
*/

DROP SEQUENCE autonum;
-- 1부터 시작해서 1씩 증가
CREATE SEQUENCE autonum;

-- 시퀀스 값 증가
SELECT autonum.nextval
FROM dual;
-- 현재 시퀀스 값 가져오기
SELECT autonum.currval
FROM dual;

CREATE TABLE kosa_t
(
    no   number,
    name varchar2(20)
);

SELECT *
FROM kosa_t;
INSERT INTO kosa_t
VALUES (autonum.nextval, 'aa');
INSERT INTO kosa_t
VALUES (autonum.nextval, 'bb');
INSERT INTO kosa_t
VALUES (autonum.nextval, 'cc');
INSERT INTO kosa_t
VALUES (autonum.nextval, 'dd');
COMMIT;

SELECT *
FROM kosa_t;

CREATE SEQUENCE seq_kosa;

DROP TABLE kosa;
CREATE TABLE kosa
(
    num  number,
    id   varchar2(20),
    name varchar2(20)
);

INSERT INTO kosa
VALUES (seq_kosa.nextval, 'dd', 'name');
INSERT INTO kosa
VALUES (seq_kosa.nextval, 'ee', 'name');
INSERT INTO kosa
VALUES (seq_kosa.nextval, 'ff', 'name');

SELECT *
FROM kosa;

DROP SEQUENCE seq_kosa;
CREATE SEQUENCE seq_kosa INCREMENT BY 100;

DROP SEQUENCE seq_kosa;
CREATE SEQUENCE seq_kosa MAXVALUE 5 CYCLE CACHE 2;

DROP TABLE kosa2;
CREATE TABLE kosa2
(
    num  number,
    id   varchar2(20),
    name varchar2(20)
);
DROP SEQUENCE seq_board;
CREATE SEQUENCE seq_board START WITH 10 INCREMENT BY 5;
INSERT INTO kosa2
VALUES (seq_board.nextval, 'dd', 'name');
INSERT INTO kosa2
VALUES (seq_board.nextval, 'ee', 'name');
INSERT INTO kosa2
VALUES (seq_board.nextval, 'ff', 'name');
SELECT *
FROM kosa2;

CREATE SEQUENCE seq_jumin_no START WITH 10 INCREMENT BY 10 MAXVALUE 150 MINVALUE 9 CYCLE CACHE 2;
CREATE TABLE jumin_t
(
    seq   number,
    name  varchar2(20),
    phone varchar2(15)
);
INSERT INTO jumin_t
VALUES (seq_jumin_no.nextval, 'aa', '1111');
INSERT INTO jumin_t
VALUES (seq_jumin_no.nextval, 'bb', '2222');
INSERT INTO jumin_t
VALUES (seq_jumin_no.nextval, 'cc', '3333');
INSERT INTO jumin_t
VALUES (seq_jumin_no.nextval, 'dd', '4444');
INSERT INTO jumin_t
VALUES (seq_jumin_no.nextval, 'ee', '5555');
INSERT INTO jumin_t
VALUES (seq_jumin_no.nextval, 'ff', '6666');
SELECT *
FROM jumin_t;
