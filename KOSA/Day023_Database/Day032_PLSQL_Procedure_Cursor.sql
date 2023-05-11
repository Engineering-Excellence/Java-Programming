-----------------------------------------------------
CREATE OR REPLACE PROCEDURE p_sal IS
    v_salary  NUMBER := 0;
    v_dept_id NUMBER := 0;
BEGIN
    v_dept_id := round(dbms_random.value(10, 40), -1);
    dbms_output.put_line('v_dept_id = ' || v_dept_id);
    SELECT
        sal
    INTO v_salary
    FROM
        emp
    WHERE
            deptno = v_dept_id
        AND ROWNUM = 1;

    dbms_output.put_line(v_salary);
    IF v_salary BETWEEN 1 AND 3000 THEN
        dbms_output.put_line('보수 적음');
    ELSIF v_salary BETWEEN 3001 AND 6000 THEN
        dbms_output.put_line('시세에 맞춰줌');
    ELSIF v_salary BETWEEN 6001 AND 9000 THEN
        dbms_output.put_line('보수 좋음');
    ELSE
        dbms_output.put_line('완전 좋음');
    END IF;

END;

-----------------------------------------------

EXEC p_sal;

-------------------------------------------------------------------
/*
ex) 사용자 입력(단수)를 받아 구구단 출력
[힌트] DECLARE vdan NUMBER(1) :=&dan;
*/
DECLARE
    dan NUMBER(1) := &inputdan;
BEGIN
    FOR i IN 1..9 LOOP
        dbms_output.put_line(dan
                             || '*'
                             || i
                             || '='
                             || i * dan);
    END LOOP;
END;
----------------------------------------------------
CREATE OR REPLACE PROCEDURE p_wantdan IS
    dan NUMBER(1) := &inputdan;
BEGIN
    FOR i IN 1..9 LOOP
        dbms_output.put_line(dan
                             || '*'
                             || i
                             || '='
                             || i * dan);
    END LOOP;
END;
-------------------------------------------
EXEC p_wantdan;
--------------------------------------------
CREATE OR REPLACE PROCEDURE p_wantdan (
    v_dan IN NUMBER
) IS
BEGIN
    FOR i IN 1..9 LOOP
        dbms_output.put_line(v_dan
                             || '*'
                             || i
                             || '='
                             || i * v_dan);
    END LOOP;
END;
-------------------------------------------
EXEC p_wantdan(&v_dan);
-- 실행부터 입력 받으면서~
----------------------------------------------------------

CREATE TABLE info (
    id   VARCHAR2(10),
    name VARCHAR2(20)
);

CREATE OR REPLACE PROCEDURE input_info (
    id   IN info.id%TYPE,
    name IN info.name%TYPE
) IS
BEGIN
    INSERT INTO info VALUES (
        id,
        name
    );

    dbms_output.put_line('id: '
                         || id
                         || ', name: '
                         || name);
END;

EXEC input_info('&id', '&name');

----------------------------------------------------------
CREATE OR REPLACE PROCEDURE p_outtest (
    name OUT VARCHAR2,
    age  OUT VARCHAR2
) IS
BEGIN
    name := '이나영';
    age := 33;
    dbms_output.put_line('out을 이용한 프로시저 완료');
END;
----------------------------------
VARIABLE v_name VARCHAR2(20);
VARIABLE v_age VARCHAR2(3);

EXEC p_outtest(:v_name, :v_age);
PRINT v_name;
PRINT v_age;

-- print(v_name, v_age);
-- ??
---------------------------------------------
CREATE OR REPLACE PROCEDURE p_out (
    x IN OUT NUMBER
) AS
BEGIN
    dbms_output.put_line('x = ' || x);
    x := &x;
END;
------------------------------------------------
VARIABLE x VARCHAR2(25);
EXEC p_out(:&x);
PRINT x;

EXEC p_out(:x);
PRINT x;

VARIABLE y VARCHAR2(25);
EXEC p_out(:y);

----------------------------------------------------------

-- 프로시저 CURSOR 활용
CREATE OR REPLACE PROCEDURE p_job_emp (
    e_job IN emp.job%TYPE
) IS
    name emp.ename%TYPE;
BEGIN
    SELECT
        ename
    INTO name
    FROM
        emp
    WHERE
        job = e_job;

    dbms_output.put_line(name
                         || '님 담당업무는 '
                         || e_job);
END;

SELECT
    *
FROM
    emp;

EXEC p_job_emp('PRESIDENT');
-- 결과가 2명 이상일 경우 오류 발생
EXEC p_job_emp('MANAGER');
EXEC p_job_emp('ANALYST');

----------------------------------------------------------

SELECT
    *
FROM
    emp;

-----------------------------------------------------

CREATE OR REPLACE PROCEDURE p_emp_job (
    v_job IN emp.job%TYPE
) IS

    name  emp.ename%TYPE;
    empno emp.empno%TYPE;
    sal   emp.sal%TYPE;
--    cursor c_name is select empno, ename, sal from emp where job = upper(v_job) or job = lower(v_job);
    -- 1. 커서 선언
    CURSOR c_name IS
    SELECT
        empno,
        ename,
        sal
    FROM
        emp
    WHERE
        job IN ( upper(v_job), lower(v_job) );

BEGIN
    -- 2. 커서 열기
    OPEN c_name;
    dbms_output.put_line('-----------------------------------------------');
    LOOP
        -- 3. 커서로부터 데이터 읽기
        FETCH c_name INTO
            empno,
            name,
            sal;
        EXIT WHEN c_name%notfound; -- 찾을 데이터가 없으면 반복문 탈출
        dbms_output.put_line(name
                             || '님의 사번은 '
                             || empno
                             || '고 급여는 '
                             || sal
                             || '고 직급은 '
                             || v_job);

    END LOOP;

    dbms_output.put_line('result recode count = ' || c_name%rowcount);
--    dbms_output.put_line(c_name%isopen);
    -- 4. 커서 닫기
    CLOSE c_name;
--    dbms_output.put_line(c_name%isopen);
END;
-----------------------------------------------------------------
exec p_emp_job('SALESMAN'); --CLERK, SALESMAN, ANALYST, PRESIDENT
exec p_emp_job('PRESIDENT');
exec p_emp_job('ANALYST');
-----------------------------------------------------------------

-- 학생 테이블에서 키가 제일 큰 순서로 3명 출력하는 프로시저 만들기

SELECT
    *
FROM
    student;

CREATE OR REPLACE PROCEDURE p_studmaxheight IS
    v_stdrow student%rowtype;
BEGIN
    FOR i IN 1..3 LOOP
        SELECT
            *
        INTO v_stdrow
        FROM
            (
                SELECT
                    *
                FROM
                    (
                        SELECT
                            *
                        FROM
                            student
                        ORDER BY
                            height DESC
                    )
                WHERE
                    ROWNUM <= i
                ORDER BY
                    height,
                    name DESC
            )
        WHERE
            ROWNUM = 1
        ORDER BY
            height DESC;

        dbms_output.put_line(v_stdrow.studno
                             || ' '
                             || v_stdrow.name
                             || ' '
                             || v_stdrow.height);

    END LOOP;
END;

exec p_studmaxheight;

---------------------------------------------------------
SELECT
    *
FROM
    professor;  -- 10개 필드
SELECT
    *
FROM
    student;  -- 12 개 필드
SELECT
    *
FROM
    department; -- 4개 필드

------------------------------------------------------------
CREATE VIEW v_join AS
    SELECT
        p.profno   교수번호,
        p.name     교수이름,
        p.position 직위,
        s.studno   학번,
        s.name     학생이름,
        s.grade    학년,
        d.dname    학과명
    FROM
             professor p
        JOIN student    s ON p.profno = s.profno
        JOIN department d ON s.deptno1 = d.deptno;

SELECT
    *
FROM
    v_join;
-------------------------------------------------------------------------
-- 조인으로 되어 있는 구문은 뷰로 새로 만들어서 저장 프로시저로 생성함. (조인, 프로시저, 커서 이용함)
CREATE OR REPLACE PROCEDURE p_join IS
    hapname v_join%rowtype;
    -- 1. 커서 선언
    CURSOR c_name IS
    SELECT
        *
    FROM
        v_join;

BEGIN
    -- 2. 커서 열기
    OPEN c_name;
    LOOP
        -- 3. 커서로부터 데이터 읽기
        FETCH c_name INTO hapname;
        EXIT WHEN c_name%notfound;   -- 찾을 데이터가 없으면 반복문 탈출
        dbms_output.put_line(hapname.교수이름
                             || ', '
                             || hapname.학생이름
                             || ', '
                             || hapname.학과명);

    END LOOP;
--     dbms_output.put_line('result recode count ==> ' || c_name%rowcount );
    -- 4. 커서 닫기
    CLOSE c_name;
END;
----------------------------------------------------------------
exec p_join;
-----------------------------------------------------------------

-- 참고 사이트
--https://docs.oracle.com/en/database/oracle/oracle-database/19/lnpls/overview.html#GUID-14ABA325-6475-4F86-95ED-1C0632F30459


CREATE OR REPLACE PROCEDURE usp_emplist (
    p_sal    IN NUMBER,
    p_cursor OUT SYS_REFCURSOR --APP 사용하기 위한 타입
) IS
BEGIN
    OPEN p_cursor FOR SELECT
                                            empno,
                                            ename,
                                            sal
                                        FROM
                                            emp
                      WHERE
                          sal > p_sal;

END;

exec usp_EmpList(3000);

------ 저장프로시저 찾기 -------------------------------
SELECT
    *
FROM
    user_objects
WHERE
    -- DD에는 대문자로 저장
    lower(object_type) = 'procedure';
------- 저장프로시저가 작성된 SQL문 보기 -------------------
SELECT
    text
FROM
    user_source
WHERE
--    lower(name) = '보고자하는 프로시저명';
    lower(name) = 'p_join';
    
SELECT
    text
FROM
    user_source
WHERE
    lower(name) = 'p_test';
---------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE p_outtest (
    name OUT VARCHAR2,
    age  OUT NUMBER
) IS
BEGIN
    name := '이나영';
    age := 20;
    dbms_output.put_line('out을 이용한 프로시저 작성');
END;
------------------------------------------------------------
variable v_name varchar2(30);
variable v_age number;    -- 이부분 수정함

exec p_outTest( :v_name, :v_age );
print v_name;
print v_age;
--------------------------------------------------------------