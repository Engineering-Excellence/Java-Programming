-- VIEW

/*
    CREATE OR REPLACE VIEW 뷰명
    AS
    뷰내용

    DROP VIEW 뷰명
*/

SELECT *
FROM emp;

CREATE OR REPLACE VIEW v_emp AS
SELECT empno, ename, deptno
FROM emp;

SELECT *
FROM v_emp;
-- emp 테이블 제거시 v_emp 뷰 제거됨
-- v_emp 뷰 제거시 emp 테이블 유지됨
DROP VIEW v_emp;

CREATE OR REPLACE VIEW v_student_join AS
SELECT p.profno,
       p.name AS 교수명,
       p.position,
       s.studno,
       s.name    학생명,
       s.grade,
       d.dname,
       p.deptno
FROM professor p
         JOIN student s ON p.profno = s.profno
         JOIN department d ON s.deptno1 = d.deptno;

SELECT *
FROM v_student_join;


--------------------------------------------------------------------------------


--문제10] 30번 부서 사원들의 직위, 이름, 월급을 담은 view 테이블 만들기 (emp)
CREATE OR REPLACE VIEW v_prob_10 AS
SELECT job, ename, sal
FROM emp
WHERE deptno = 30;

--문제11] 30번 부서 사원들의 직위, 이름, 월급을 담은 view 테이블 만드는데,
--    컬럼명을 직위, 사원이름, 급여로 Alias를 주고 월급이 2000보다 많은 사원들만 추출한다
CREATE OR REPLACE VIEW v_prob_11 AS
SELECT job AS 직위, ename AS 사원명, sal AS 급여
FROM emp
WHERE deptno = 30
  AND sal > 2000;

--문제12] 부서별 최대급여, 최소급여, 평균급여를 갖는 view 만드시오
CREATE OR REPLACE VIEW v_prob_12 AS
SELECT deptno AS 부서번호, MAX(sal) AS 최대급여, MIN(sal) AS 최소급여, FLOOR(AVG(sal)) AS 평균급여
FROM emp
GROUP BY deptno
ORDER BY deptno;

--문제13] 부서별 평균급여를 갖는 view 만드는데, 평균급여가 2000이상인 부서만 출력하세요.
CREATE OR REPLACE VIEW v_prob_13 AS
SELECT *
FROM (SELECT deptno AS 부서번호, FLOOR(AVG(sal)) AS 평균급여 FROM emp GROUP BY deptno)
WHERE 평균급여 >= 2000;

--문제14]직위별 총급여를 구하는 view 테이블 만드는데, 직위(job)가 manager인 사원들은 제외하고
--    총급여가 3000 이상인 직원들만 저장한 테이블 만들기
CREATE OR REPLACE VIEW v_prob_14 AS
SELECT *
FROM (SELECT job AS 직위, SUM(sal) AS 총급여 FROM emp GROUP BY job)
WHERE 직위 <> 'MANAGER'
  AND 총급여 > 3000;

--문제15]학생 테이블에서 학년별 평균 키와 몸무게가 키는 165 이상이고,
--    몸무게는 60이상인 사람들만 출력하는 뷰 테이블 만들기
CREATE OR REPLACE VIEW v_prob_15 AS
SELECT *
FROM (SELECT grade AS 학년, AVG(height) AS 키, AVG(weight) AS 몸무게 FROM student GROUP BY grade)
WHERE 키 >= 165
  AND 몸무게 >= 60
ORDER BY 학년;
SELECT *
FROM student;

--문제16]교수테이블에서 전임강사 들만 있는 가상 테이블 만들기
CREATE OR REPLACE VIEW v_prob_16 AS
SELECT *
FROM professor
WHERE position = '전임강사';


--------------------------------------------------------------------------------


-- 제약조건 확인(테이블 & 컬럼) 및 제약조건 제거
SELECT *
-- 모든 계정의 모든 제약조건 확인
FROM all_constraints
-- 데이터 딕셔너리에는 대문자
-- WHERE table_name = 'EMP'
-- 제약조건은 복사되지 않는다!
WHERE table_name = 'c_emp_all';

-- 제약조건 제거
/*
    ALTER TABLE 테이블명
        DROP CONSTRAINT 제약조건명 CASCADE;
*/
-- ORA-02273: 고유/기본 키가 외부 키에 의해 참조되었습니다.
ALTER TABLE dept
    DROP CONSTRAINT pk_dept;
ALTER TABLE dept
    DROP CONSTRAINT pk_dept CASCADE;

-- PK 생성
/*
    ALTER TABLE 테이블명
        ADD CONSTRAINT 제약조건명 PRIMARY KEY (컬럼명1, 컬럼명2, ...)
*/
-- 테이블명_필드명_성격(PK, FK, UN, CK, ...)
ALTER TABLE dept
    ADD CONSTRAINT pk_dept PRIMARY KEY (deptno);

SELECT *
FROM cal;
SELECT *
FROM all_constraints
WHERE table_name = 'CAL';
-- num_day 필드에 PK 생성
ALTER TABLE cal
    ADD CONSTRAINT cal_num_day_pk PRIMARY KEY (num_day);


--------------------------------------------------------------------------------


-- 레코드 복사
/*

*/

CREATE TABLE c_emp_6 AS
SELECT ename, empno, hiredate
FROM emp
WHERE 1 = 0;

SELECT *
FROM c_emp_6;

INSERT INTO c_emp_6
-- 필드
SELECT emp_type, pay, birthday
FROM emp2;
