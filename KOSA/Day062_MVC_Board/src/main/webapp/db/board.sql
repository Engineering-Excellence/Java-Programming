SELECT *
FROM DEPT2;

SELECT *
FROM BOARD;

SELECT ROWNUM, ROWID
FROM BOARD;

CREATE TABLE BOARD
(
    NUM       NUMBER(7) NOT NULL,
    WRITER    VARCHAR2(20) NOT NULL,
    EMAIL     VARCHAR2(30),
    SUBJECT   VARCHAR2(50) NOT NULL,
    PASSWD    VARCHAR2(12) NOT NULL,
    REG_DATE  DATE        NOT NULL,
    READCOUNT NUMBER(3) DEFAULT 0,
    REF       NUMBER      NOT NULL,
    RE_STEP   NUMBER      NOT NULL,
    RE_LEVEL  NUMBER      NOT NULL,
    CONTENT   NVARCHAR2(2000) NOT NULL,
    IP        VARCHAR(20) NOT NULL,
    CONSTRAINT BOARD_NUM_PK PRIMARY KEY (NUM)
);

CREATE SEQUENCE AUTONUM;

SELECT *
FROM BOARD;

---------------------------------------------

SELECT *
FROM BOARD
    COMMIT

DROP TABLE BOARD
    DESC BOARD

-- 1.
CREATE TABLE BOARD
(
    NUM       NUMBER NOT NULL PRIMARY KEY,
    WRITER    VARCHAR2(10) NOT NULL,
    EMAIL     VARCHAR2(20),
    SUBJECT   VARCHAR2(50) NOT NULL,
    PASSWD    VARCHAR2(12) NOT NULL,
    REG_DATE  DATE   NOT NULL,
    READCOUNT NUMBER DEFAULT 0,
    REF       NUMBER NOT NULL,
    RE_STEP   NUMBER NOT NULL,
    RE_LEVEL  NUMBER NOT NULL,
    CONTENT   VARCHAR2(4000) NOT NULL,
    IP        VARCHAR2(20) NOT NULL
);

-- 2. SEQUENCE(시퀀스)를 생성한다.
CREATE SEQUENCE BOARD_NUM;

/*
DROP SEQUENCE AUTONUM

CREATE SEQUENCE AUTONUM
    INCREMENT BY 1 -- 1씩 증가하라는거고요
    START WITH 1 -- 1부터 시작이고요 100 시작할려면 100 이라고 쓰시면 됩니다.
    NOMAXVALUE       -- 최대값 제한이 없다
     NOCYCLE
     NOCACHE;

ALTER SEQUENCE AUTONUM
    INCREMENT BY 1
    CYCLE;
*/

-------------------------------------------------
SELECT ROWNUM, WRITER, SUBJECT
FROM BOARD

SELECT ROWNUM, NUM, WRITER, SUBJECT
FROM (SELECT * FROM BOARD ORDER BY NUM DESC);

SELECT NUM,
       WRITER,
       EMAIL,
       SUBJECT,
       PASSWD,
       REG_DATE,
       REF,
       RE_STEP,
       RE_LEVEL,
       CONTENT,
       IP,
       READCOUNT,
       R
FROM (SELECT NUM,
             WRITER,
             EMAIL,
             SUBJECT,
             PASSWD,
             REG_DATE,
             REF,
             RE_STEP,
             RE_LEVEL,
             CONTENT,
             IP,
             READCOUNT,
             ROWNUM R
      FROM (SELECT NUM,
                   WRITER,
                   EMAIL,
                   SUBJECT,
                   PASSWD,
                   REG_DATE,
                   REF,
                   RE_STEP,
                   RE_LEVEL,
                   CONTENT,
                   IP,
                   READCOUNT
            FROM BOARD
            ORDER BY REF DESC, RE_STEP ASC)
      ORDER BY REF DESC, RE_STEP ASC)
WHERE R >= ?
  AND R <= ?;

SELECT NUM,
       WRITER,
       EMAIL,
       SUBJECT,
       PASSWD,
       REG_DATE,
       REF,
       RE_STEP,
       RE_LEVEL,
       CONTENT,
       IP,
       READCOUNT,
       R
FROM (SELECT NUM,
             WRITER,
             EMAIL,
             SUBJECT,
             PASSWD,
             REG_DATE,
             REF,
             RE_STEP,
             RE_LEVEL,
             CONTENT,
             IP,
             READCOUNT,
             ROWNUM R
      FROM (SELECT NUM,
                   WRITER,
                   EMAIL,
                   SUBJECT,
                   PASSWD,
                   REG_DATE,
                   REF,
                   RE_STEP,
                   RE_LEVEL,
                   CONTENT,
                   IP,
                   READCOUNT
            FROM BOARD
            ORDER BY REF DESC, RE_STEP ASC)
      ORDER BY REF DESC, RE_STEP ASC)
WHERE R >= 1
  AND R <= 7;


-- http://micropilot.tistory.com/entry/oracle-rownum-%ec%97%90-%eb%8c%80%ed%95%98%ec%97%ac

-- http://greatkim91.tistory.com/52

-----------------------------
CREATE
OR REPLACE PROCEDURE P_RESET_SEQ( SEQ_NAME IN VARCHAR2 )
IS
    L_VAL NUMBER;
BEGIN
EXECUTE IMMEDIATE 'SELECT ' || SEQ_NAME || '.NEXTVAL FROM DUAL' INTO L_VAL;

EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || SEQ_NAME || ' INCREMENT BY -' || L_VAL || ' MINVALUE 0';

EXECUTE IMMEDIATE 'SELECT ' || SEQ_NAME || '.NEXTVAL FROM DUAL' INTO L_VAL;

EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || SEQ_NAME || ' INCREMENT BY 1 MINVALUE 0';
END;


-- http://www.mungchung.com/xe/?mid=protip&comment_srl=15077&liststyle=list&sort_index=readed_count&order_type=desc&document_srl=3568
