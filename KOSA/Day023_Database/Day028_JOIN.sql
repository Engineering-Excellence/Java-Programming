-- JOIN
-- 2개 이상의 테이블을 하나의 테이블로 만들어 한 번의 검색으로 여러 컬럼의 정보를 확인할 때 사용함.
/*
    select 컬럼명 , .....
    from 테이블이름 별칭 [Inner] join 테이블이름 별칭 on 별칭.컬럼명 = 별칭.컬럼명
*/

-- 14
SELECT *
FROM emp;
--4
SELECT *
FROM dept;

--
SELECT empno, ename, job, d.deptno, loc
FROM emp e,
     dept d
WHERE e.deptno = d.deptno;

--------------------------------------------------------------------------------

-- LEFT OUTER JOIN: 왼쪽에 있는 데이터 전부, 오른쪽은 일치 데이터만
SELECT empno, ename, job, d.deptno, loc
FROM emp e
         LEFT OUTER JOIN dept d ON e.deptno = d.deptno;

SELECT empno, ename, job, d.deptno, loc
FROM dept d
         LEFT OUTER JOIN emp e ON d.deptno = e.deptno;

--------------------------------------------------------------------------------

-- RIGHT OUTER JOIN: 오른쪽에 있는 데이터 전부, 왼쪽은 일치 데이터만
SELECT empno, ename, job, d.deptno, loc
FROM dept d
         RIGHT OUTER JOIN emp e ON d.deptno = e.deptno;

INSERT INTO emp(empno, ename, sal)
VALUES (100, '김연아', 1000);
ROLLBACK;

--------------------------------------------------------------------------------

/*
    문제] professor / student
    교수이름, 직위, 학과코드, 교수코드, 학생이름, 학번, 학년, 주전공 학과
 */
SELECT *
FROM professor;
SELECT *
FROM student;

-- INNER JOIN 1
SELECT p.name   "교수명",
       position "직위",
       deptno   "학과코드",
       p.profno "교수코드",
       s.name   "학생명",
       studno   "학번",
       grade    "학년",
       deptno1  "주전공"
FROM professor p,
     student s
WHERE p.profno = s.profno;

-- INNER JOIN 2
SELECT p.name   "교수명",
       position "직위",
       deptno   "학과코드",
       p.profno "교수코드",
       s.name   "학생명",
       studno   "학번",
       grade    "학년",
       deptno1  "주전공"
FROM professor p
         INNER JOIN student s ON p.profno = s.profno;

-- LEFT OUTER JOIN
SELECT p.name   "교수명",
       position "직위",
       deptno   "학과코드",
       p.profno "교수코드",
       s.name   "학생명",
       studno   "학번",
       grade    "학년",
       deptno1  "주전공"
FROM professor p
         LEFT OUTER JOIN student s ON p.profno = s.profno;

-- RIGHT OUTER JOIN
SELECT p.name   "교수명",
       position "직위",
       deptno   "학과코드",
       p.profno "교수코드",
       s.name   "학생명",
       studno   "학번",
       grade    "학년",
       deptno1  "주전공"
FROM professor p
         RIGHT OUTER JOIN student s ON p.profno = s.profno;

--------------------------------------------------------------------------------

/*
    3개 이상 테이블 조인
    select 컬럼명 , .....
    from 테이블이름 별칭 [Inner] join 테이블이름 별칭
    on 별칭.컬럼명 = 별칭.컬럼명 [Inner] join 테이블이름 별칭 on 별칭.컬럼명 = 별칭.컬럼명 ...
*/
SELECT p.profno, p.name "교수명", studno, s.name "학생명", grade, d.dname
FROM professor p
         INNER JOIN student s ON p.profno = s.profno
         INNER JOIN department d ON s.deptno1 = d.deptno;

-- 사원명, 부서명, 직책, 매니저번호 출력: emp / dept
SELECT *
FROM emp;
SELECT *
FROM dept;
SELECT e.ename "사원명", d.dname "부서명", e.job "직책", e.mgr "매니저번호"
FROM emp e,
     dept d
WHERE e.deptno = d.deptno;

--------------------------------------------------------------------------------

-- SELF JOIN
SELECT e.empno "사번", e.ename "사원명", e.job "직책", em.mgr "관리자번호", em.ename "관리자명"
FROM emp e
         JOIN emp em ON e.mgr = em.empno;

--------------------------------------------------------------------------------

-- 테이블 복사
/*
    CREATE TABLE 테이블명
    AS SELECT 필드명, ... FROM 테이블명
*/
SELECT *
FROM emp;
CREATE TABLE c_emp_all AS
SELECT *
FROM emp;
SELECT *
FROM c_emp_all;

-- KOSA 사용자가 갖고 있는 전체 제약조건 추출
SELECT *
FROM all_constraints
-- 조건에 따른 테이블의 제약조건만 확인(테이블명 대소문자 구분!) → 데이터 딕셔너리에는 대부분 대문자로 저장됨
WHERE table_name = 'EMP';

-- 테이블 복사는 제약조건을 복사하지 않음!
SELECT *
FROM all_constraints
WHERE table_name = 'C_EMP_ALL';

-- 조건부 복사 가능
SELECT *
FROM emp
WHERE deptno = 20;
CREATE TABLE c_emp_20 AS
SELECT *
FROM emp
WHERE deptno = 20;
SELECT *
FROM c_emp_20;

SELECT *
FROM emp
WHERE deptno = 30;
CREATE TABLE c_emp_30 AS
SELECT empno 사번, ename 사원명, job 직책, sal 급여
FROM emp
WHERE deptno = 30;
SELECT *
FROM c_emp_30;

-- 문제1] 교수 테이블에서 전임강사만 뽑아서 테이블 생성하기
SELECT *
FROM professor
WHERE position = '전임강사';
CREATE TABLE c_professor_full AS
SELECT *
FROM professor
WHERE position = '전임강사';
SELECT *
FROM c_professor_full;

-- 문제2] emp 테이블에서 mgr이 7566번인 사람만 추출해서 새로운 테이블 생성하기
SELECT *
FROM emp
WHERE mgr = 7566;
CREATE TABLE c_emp_mgr_7566 AS
SELECT *
FROM emp
WHERE mgr = 7566;
SELECT *
FROM c_emp_mgr_7566;

/*
    구조만 복사하기
    CREATE 테이블명
    AS SELECT 필드명, ... FROM 테이블명
    WHERE 1 = 0;    -- 거짓 조건 추가
*/
CREATE TABLE c_emp_empty AS
SELECT *
FROM emp
-- 거짓 조건
WHERE 1 = 0;
SELECT *
FROM c_emp_empty;

CREATE TABLE c_emp_col AS
SELECT empno, ename, job, sal
FROM emp;
SELECT *
FROM c_emp_col;

-- 전체 복사
SELECT *
FROM c_emp_all;
-- 조건부 복사
SELECT *
FROM c_emp_20;
SELECT *
FROM c_emp_30;
-- 구조만 복사
SELECT *
FROM c_emp_empty;
-- 일부 필드 복사
SELECT *
FROM c_emp_col;


--------------------------------------------------------------------------------


-- UNION: PK, FK 관계 아닌 상태의 테이블 합치기
-- 중복 레코드 제외
SELECT *
FROM emp
UNION
SELECT *
FROM c_emp_all;
-- 중복 레코드 포함
SELECT *
FROM emp
UNION ALL
SELECT *
FROM c_emp_all;

INSERT INTO c_emp_all
VALUES (7788, 'kingsmile', 'manager', 7566, '2202/01/17', 5000, 1000, 30);

SELECT empno,
       ename,
       job,
       sal
-- 필드 개수가 맞아야 함
-- SELECT *
-- 데이터 타입이 일치해야 함
-- SELECT empno, ename, job, hiredate
FROM emp
UNION
SELECT *
FROM c_emp_col;

-- 검색!! 쿼리문은 대소문자 구분 X. 단, 레코드는 대소문자 구분 O
SELECT *
FROM c_emp_all;
SELECT *
FROM c_emp_all
WHERE job = 'MANAGER'
   OR job = 'manager';
SELECT *
FROM c_emp_all
WHERE job != 'MANAGER'
  AND job != 'manager';
SELECT *
FROM c_emp_all
WHERE job <> 'MANAGER'
  AND job <> 'manager';

SELECT *
FROM c_emp_all
WHERE job IN ('MANAGER', 'manager');
SELECT *
FROM c_emp_all
WHERE job NOT IN ('MANAGER', 'manager');

SELECT empno 사원번호, ename 이름, sal 급여
FROM emp
WHERE ename = 'FORD'
-- 별칭은 조건으로 사용 불가
-- WHERE 이름 = 'FORD'
-- ORDER BY sal DESC;
-- 별칭으로 정렬 가능
ORDER BY 급여 DESC;

-- 문제1] c_emp_20, c_emp_empty UNION 결과
SELECT *
FROM c_emp_20
UNION
SELECT *
FROM c_emp_empty;

-- 문제2]
SELECT empno, ename, CAST(sal AS int) AS sal, CAST(sal * 1.15 AS int) AS "New Salary"
FROM emp;

-- 문제3]
SELECT empno,
       ename,
       CAST(sal AS int)        AS sal,
       CAST(sal * 1.15 AS int) AS "New Salary",
       CAST(sal * 0.15 AS int) AS "Increase"
FROM emp;

-- 문제4]
SELECT ename, hiredate, FLOOR(MONTHS_BETWEEN(SYSDATE, hiredate)) AS "Months_Works"
FROM emp
ORDER BY "Months_Works" DESC;

-- 문제5]
SELECT ename,
       DECODE(comm, NULL, 'no commission', comm) AS comm
FROM emp;
SELECT ename,
       NVL(TO_CHAR(comm), 'no commission') AS comm
FROM emp;


-- Oracle SQL_PLSQL_PPT 3, 4, 8장 실습
