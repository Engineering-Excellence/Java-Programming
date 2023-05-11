-- PL/SQL (Procedural Language)
/*
    Declare
        선언(선택)
    Begin
        실행(필수)
    End;
*/

DECLARE
    name VARCHAR2(10) := 'Kyle';
BEGIN
    -- 화면에 출력
    dbms_output.put_line('이름은 ' || name);
END;

SELECT
    *
FROM
    emp;

DECLARE
    -- DECLARE e_name varchar2(10); e_sal number(7, 2);
    e_name emp.ename%TYPE;
    e_sal  emp.sal%TYPE;
BEGIN
    SELECT
        sal,
        ename
    INTO
        e_sal,
        e_name
    FROM
        emp
    WHERE
        empno = '7788';

    dbms_output.put_line('7788님의 이름은 '
                         || e_name
                         || '이고 급여는 '
                         || e_sal);
END;

--------------------------------------------------------------------------------

-- 제어문: IF, FOR, WHILE

/*
    IF 조건식 THEN 실행문장;
    ELSIF 조건식 THEN 실행문장; ELSIF 조건식 THEN 실행문장;
    ....
    ELSE 실행문장;
    END IF;
*/

-- IF
DECLARE
    num1 NUMBER := 3;
    num2 NUMBER := 5;
    num  NUMBER;
BEGIN
    IF num1 >= num2 THEN
        num := num1;
    ELSE
        num := num2;
    END IF;

    dbms_output.put_line(num || '이(가) 큽니다.');
END;

-- 입력받기
DECLARE
    n_sales      NUMBER;
    n_commission NUMBER(10, 2) := 0;
BEGIN
    n_sales := &n_sales;
    IF n_sales < 200 THEN
        n_commission := n_sales * 0.1;
    ELSIF
        n_sales >= 200
        AND n_sales < 500
    THEN
        n_commission := n_sales * 0.05;
    ELSIF
        n_sales >= 500
        AND n_sales < 1000
    THEN
        n_commission := n_sales * 0.03;
    ELSE
        n_commission := n_sales * 0.02;
    END IF;

    dbms_output.put_line(n_sales
                         || ', '
                         || n_commission);
END;

CREATE PROCEDURE p_test IS
BEGIN
    dbms_output.put('Database');
    dbms_output.put_line('Kyle');
    dbms_output.put_line('Oracle');
END;

EXEC p_test;

CREATE PROCEDURE p_test2 (
    name IN VARCHAR2
) IS
BEGIN
    dbms_output.put_line(name || '님 합격입니다.');
END;

EXEC ptest2('Kyle');

SELECT
    *
FROM
    userlist;

DROP TABLE userlist;

CREATE TABLE userlist (
    id   VARCHAR2(10),
    name VARCHAR2(20),
    age  NUMBER,
    addr VARCHAR2(50)
);

DESC userlist;

CREATE OR REPLACE PROCEDURE p_userlist (
    id   IN userlist.id%TYPE := 'kyle',
    name IN userlist.name%TYPE DEFAULT 'kaiser',
    age  IN userlist.age%TYPE := 10,
    addr IN userlist.addr%TYPE := NULL
) IS
BEGIN
    INSERT INTO userlist VALUES (
        id,
        name,
        age,
        addr
    );

    dbms_output.put_line('INSERT 정보는 '
                         || id
                         || name
                         || age
                         || addr);

END;

SELECT
    *
FROM
    userlist;

EXEC p_userlist;
EXEC p_userlist('prophet', 'kyle', 34, seoul);

--------------------------------------------------------------------------------

-- 문제1]
SELECT
    sal,
    ROWNUM
FROM
    emp
WHERE
    ROWNUM = 1;

SELECT
    *
-- 인라인 뷰
FROM
    (
        SELECT
            *
        FROM
            emp
        ORDER BY
            sal
    )
WHERE
    ROWNUM = 1;

SELECT
    d.*
FROM
    emp   e,
    dept2 d;

-----문제 원인 찾기???-------------------------------------------------------
/*
CREATE OR REPLACE PROCEDURE p_empmaxsal(
    out p_empno emp.empno%TYPE,
    out p_ename emp.ename%TYPE,
    out p_sal emp.sal%TYPE
)
    IS
BEGIN
    SELECT
        p_empno,
        p_ename,
        p_sal
    FROM
        (
            SELECT
                *
            FROM
                emp
            ORDER BY
                sal DESC
        )
    WHERE
        ROWNUM <= 5;

END;
*/

------------------------------------------------------------

CREATE OR REPLACE PROCEDURE p_empmaxsal (
    p_empno                emp.empno%TYPE,
    p_ename                emp.ename%TYPE,
    p_sal                  emp.sal%TYPE,
    p_laststatementbalance OUT FLOAT
) IS
BEGIN
    SELECT
        empno,
        ename,
        sal,
        p_laststatementbalance
    FROM
        (
            SELECT
                empno,
                ename,
                sal
            FROM
                emp
            ORDER BY
                sal DESC
        )
    WHERE
        ROWNUM <= 5;

END;

---------------------------------------------------------------

EXEC p_empmaxsal;

-----방법1. ---------------------------------------------------
DROP PROCEDURE p_empmaxsal;

CREATE OR REPLACE PROCEDURE p_empmaxsal IS
    v_emprow emp%rowtype;
BEGIN
    FOR i IN 1..5 LOOP
        SELECT
            *
        INTO v_emprow
        FROM
            (
                SELECT
                    *
                FROM
                    (
                        SELECT
                            *
                        FROM
                            emp
                        ORDER BY
                            sal DESC
                    )
                WHERE
                    ROWNUM <= i
            )
        WHERE
            ROWNUM <= 5;

        dbms_output.put_line(v_emprow.empno
                             || ' '
                             || v_emprow.ename
                             || ' '
                             || v_emprow.sal);

    END LOOP;
END;

------------------------------------------------------------------------------------------

EXEC p_empmaxsal;

----방법2. ----------------------------------------------------
CREATE OR REPLACE PROCEDURE emp_top5 IS
    v_emprow emp%rowtype;
BEGIN
    FOR i IN 1..5 LOOP
        SELECT
            *
        INTO v_emprow
        FROM
            (
                SELECT
                    *
                FROM
                    (
                        SELECT
                            *
                        FROM
                            emp
                        ORDER BY
                            sal DESC
                    )
                WHERE
                    ROWNUM <= i
                ORDER BY
                    sal,
                    ename
            )
        WHERE
            ROWNUM = 1
        ORDER BY
            sal ASC;

        dbms_output.put_line(v_emprow.empno
                             || ' '
                             || v_emprow.ename
                             || ' '
                             || v_emprow.sal);

    END LOOP;
END;

------------------------------------------------

EXEC emp_top5;

-------------------------------------------

SELECT
    ROWNUM,
    ename,
    sal
FROM
    emp
WHERE
    ROWNUM <= 5
ORDER BY
    sal DESC;

------------------------------------------------------------

SELECT
    *
FROM
    emp;

------------------------------------------------------------  

-- 1~10 중 짝수만 출력
BEGIN
    FOR i IN 1..10 LOOP
            --        dbms_output.put_line(MOD(i, 2));
        IF ( MOD(i, 2) = 0 ) THEN
            dbms_output.put_line(i);
        END IF;
    END LOOP;
END;

-- 원하는 단 입력 받아서 출력
DECLARE
    p_dan NUMBER(1) := &dan;
    total NUMBER(2) := 0;
BEGIN
    FOR i IN 1..9 LOOP
        total := p_dan * i;
        dbms_output.put_line(p_dan
                             || ' * '
                             || i
                             || ' = '
                             || total);

    END LOOP;
END;

------------------------------------------------------------

DECLARE
    i INT := 1;
BEGIN
    LOOP
        dbms_output.put_line(i);
        i := i + 1;
        EXIT WHEN ( i > 10 );
    END LOOP;
END;

------------------------------------------------------------

--while loop
DECLARE
    i INT := 1;
BEGIN
    WHILE ( i <= 10 ) LOOP
        dbms_output.put_line(i);
        i := i + 1;
    END LOOP;
END;

-------------------------------------

-- 2단 출력하기
-- BASIC LOOP로 구구단(2단 출력하기)
DECLARE -- 선언(선택)
    dan NUMBER := 2;
    i   NUMBER := 1;
BEGIN
    -- 필수
    LOOP
        dbms_output.put_line(dan
                             || '*'
                             || i
                             || '='
                             ||(dan * i));
        -- 2 * i = 2
        i := i + 1;
        IF i > 9 THEN
            EXIT;
        END IF;
    END LOOP;
END;
-- 필수

-------------------------------------------------------------------

-- FOR LOOP로 구구단(2단) 출력하기
DECLARE
    dan NUMBER := 2;
    i   NUMBER := 1;
BEGIN
    FOR i IN 1..9 LOOP
        dbms_output.put_line(dan
                             || '*'
                             || i
                             || '='
                             ||(dan * i));
    END LOOP;
END;

---------------------------------------------------------------------

-- WHILE LOOP로 구구단 (2단) 출력하기
DECLARE
    dan NUMBER := 2;
    i   NUMBER := 1;
BEGIN
    WHILE i <= 9 LOOP
        dbms_output.put_line(dan
                             || '*'
                             || i
                             || '='
                             ||(dan * i));

        i := i + 1;
    END LOOP;
END;

--------------------------------------------------------

-- 사용자 입력(단수)를 받아 구구단 출력
-- &는 사용자입력값을 받을때 상요하는 키워드 . &공간이름
DECLARE
    vdan NUMBER(1) := &dan;
BEGIN
    FOR i IN 1..9 LOOP
        dbms_output.put_line(vdan
                             || ' * '
                             || i
                             || '='
                             ||(vdan * i));
    END LOOP;
END;

-----------------------------------------------------------

--구구단 전체 출력 ( 2중 반복문 )
BEGIN
    FOR i IN 1..9 LOOP
        FOR j IN 2..9 LOOP
            dbms_output.put(j
                            || ' * '
                            || i
                            || '='
                            ||(i * j)
                            || '    ');
        END LOOP;

        dbms_output.put_line(' ');
    END LOOP;
END;