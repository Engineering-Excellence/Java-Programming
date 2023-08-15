CREATE TABLE REST_BOARD
(
    SEQ     NUMBER,
    TITLE   VARCHAR2(50),
    WRITER  VARCHAR2(30),
    CONTENT VARCHAR2(200),
    REGDATE DATE,
    CNT     NUMBER,
    CONSTRAINT PK_BOARD_SEQ PRIMARY KEY (SEQ)
);

-- DROP SEQUENCE BOARD_SEQ;

CREATE SEQUENCE BOARD_SEQ;

SELECT *
FROM REST_BOARD;

-------------------------------------------------------------
/*
	테이블명 : REPLY

	댓글번호		RNO			PK
	게시글번호		BNO			FK
	댓글			REPLY
	댓글작성자		REPLYER
	댓글작성일		REPLYDATE
*/

CREATE TABLE REST_REPLY
(
    "RNO"       NUMBER(10,0),
    "BNO"       NUMBER(10,0) NOT NULL,
    "REPLY"     VARCHAR2(1000) NOT NULL,
    "REPLYER"   VARCHAR2(50) NOT NULL,
    "REPLYDATE" DATE DEFAULT SYSDATE,
    CONSTRAINT "PK_REPLY" PRIMARY KEY ("RNO"),
    CONSTRAINT "FK_REPLY_BOARD" FOREIGN KEY ("BNO") REFERENCES BOARD (SEQ)
);

CREATE SEQUENCE REPLY_SEQ;