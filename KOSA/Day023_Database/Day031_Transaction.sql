-- TRANSACTION

CREATE TABLE c_emp_ta AS
SELECT *
FROM emp
WHERE 1 = 0;

BEGIN
    FOR i IN 1..10000
        LOOP
            INSERT INTO c_emp_ta SELECT * FROM emp;
        END LOOP;
END;

SELECT *
FROM c_emp_ta;

ROLLBACK;
COMMIT;

UPDATE c_emp_ta
SET sal = 1000;
DELETE
FROM c_emp_ta
WHERE deptno = 20;
ROLLBACK;

UPDATE c_emp_ta
SET sal = 800
WHERE deptno = 10;
-- SAVEPOINT 식별자
SAVEPOINT update_sal;

UPDATE c_emp_ta
SET sal = 900
WHERE deptno = 10;
SAVEPOINT update_sal2;

SELECT sal
FROM c_emp_ta
WHERE deptno = 10;

-- ROLLBACK TO SAVEPOINT 식별자
ROLLBACK TO SAVEPOINT update_sal;
ROLLBACK TO SAVEPOINT update_sal2;

SAVEPOINT create_tt;

DROP TABLE tt;
CREATE TABLE tt
(
    id number
);

INSERT INTO tt (id)
VALUES (1);

INSERT INTO tt
VALUES (2);
INSERT INTO tt
VALUES (3);
INSERT INTO tt
VALUES (4);

COMMIT;

SELECT *
FROM tt;

-- ROLLBACK은 DML에만 사용 가능
ROLLBACK TO SAVEPOINT create_tt;

DROP TABLE tt;


--------------------------------------------------------------------------------


-- 다른 계정에 있는 테이블에 접근하기
/*
    SELECT *
    FROM 사용자.테이블명;
*/
SELECT *
FROM emp;
SELECT *
FROM kosa.emp;

-- 권한 부여/박탈
GRANT INSERT, SELECT, UPDATE, DELETE ON kosa.emp TO scott;
REVOKE ALL ON kosa.emp FROM scott;

-- 제약조건까지 제거
DROP TABLE tt CASCADE CONSTRAINTS;