-- 집계함수 사용시 GROUP BY: 소계(부분합)

SELECT *
FROM student;

SELECT grade, SUM(height), AVG(height), MAX(height), MIN(height)
FROM student
GROUP BY grade; -- 일반 필드(grade)는 그룹(집합) 필드와 함께 사용할 수 없다.

SELECT *
FROM emp2;
-- emp_type 별로 인원수, pay 합, 평균, 최고급여, 최저급여 구하기
SELECT emp_type, COUNT(emp_type), SUM(pay), AVG(pay), MAX(pay), MIN(pay)
FROM emp2
GROUP BY emp_type
ORDER BY AVG(pay) DESC;

-- 교수 테이블에서 직급별로 연봉 평균, 최고값, 최저값 구하기
SELECT name, position, AVG(pay), MAX(pay), MIN(pay)
FROM professor
GROUP BY position, name
ORDER BY AVG(pay) DESC;


-- 조건: WHERE, HAVING 절을 이용한다.
/*
    SELECT *
    FROM 테이블명
    [WHERE 조건]
    [ORDERBY 정렬];
*/
SELECT grade, SUM(height), AVG(height), MAX(height), MIN(weight)
FROM student
GROUP BY grade
HAVING AVG(height) > 172;

SELECT emp_type, COUNT(emp_type), SUM(pay), AVG(pay), MAX(pay), MIN(pay)
FROM emp2
GROUP BY emp_type
HAVING AVG(pay) > 30000000;

-- 문제] 최고급여 받는 사람보다 낮은 급여를 받는 직급
SELECT position, AVG(pay), MAX(pay), MIN(pay)
FROM professor
GROUP BY position
HAVING MAX(pay) >= 380;


--------------------------------------------------------------------------------


-- ② 숫자 함수
SELECT ROUND(3.1415926535, 0), ROUND(12.3456789, 0), ROUND(12.3456789, 1), ROUND(12.3456789, 2)
FROM dual;
SELECT CEIL(12.34), CEIL(-12.34)
FROM dual; -- 올림한 후 정수 반환
SELECT FLOOR(12.34), FLOOR(-12.34)
FROM dual; -- 내림한 후 정수 반환
SELECT TRUNC(12.3456789, 2), TRUNC(12.3456789, 1), TRUNC(12.3456789, 0)
FROM dual;
-- 버림

-- 교수 테이블에서 월급에 인상률 2%를 추가한 결과 출력(소숫점 0으로 처리)
SELECT profno,
       name,
       id,
       position,
       pay,
       FLOOR(pay * 1.02) AS "INC",
       hiredate,
       bonus,
       deptno,
       email,
       hpage
FROM professor;

-- 모든 교수들에게 보너스 1000원 추가 지급(NULL 처리)
SELECT profno,
       name,
       id,
       position,
       pay,
       hiredate,
       bonus,
       NVL(bonus, 0) + 1000,
       deptno,
       email,
       hpage
FROM professor;


--------------------------------------------------------------------------------


-- ③ 문자열 함수
SELECT *
FROM professor;
SELECT id, UPPER(id)
FROM professor;
SELECT id, INITCAP(id)
FROM professor;
SELECT id, LENGTH(id)
FROM professor;
SELECT *
FROM dept2;
SELECT dname, LENGTH(dname), LENGTHB(dname)
FROM dept2;
SELECT LENGTH('사장실'), LENGTHB('사장실')
FROM dual; -- 오라클에서 한글 한 글자는 3바이트로 저장된다!

SELECT *
FROM gogak;
SELECT jumin, SUBSTR(jumin, 7, 1)
FROM gogak; -- 인덱스는 1부터 시작
SELECT INSTR('abcd', 'b')
FROM dual; -- 인덱스는 1부터 시작
SELECT id, INSTR(id, 'b')
FROM professor; -- 부존재시 0 반환
SELECT INSTR('abcdefghijklmnopqrstuvwxyz', 'b')
FROM dual;
SELECT INSTR('abcdefghijklmnopqrstuvwxyz', 'b', -1)
FROM dual; -- -1(음수)이면 뒤에서부터 찾지만 결과는 동일하다(속도만 다름)!

SELECT LPAD('abcd', 20, '#')
FROM dual; -- 왼쪽 채우기
SELECT RPAD('abcd', 20, '@')
FROM dual; -- 오른쪽 채우기

SELECT RPAD(LENGTHB('한글'), 10, '$')
FROM dual;
SELECT RPAD(LENGTH('한글'), 10, '$')
FROM dual;

SELECT dname, LENGTH(dname), LENGTHB(dname)
FROM dept2;

SELECT dname, SUBSTR(dname, 3)
FROM dept2;
SELECT dname, SUBSTR(dname, 2, 3)
FROM dept2; -- 2번째 인덱스부터 3개 추출

SELECT RPAD(dname, 10, SUBSTR('1234567890', LENGTH(dname) + 1)) "RPAD() 연습"
FROM dept2;
SELECT LPAD(dname, 10, SUBSTR('1234567890', LENGTH(dname) + 1)) "LPAD() 연습"
FROM dept2;

SELECT CONCAT(name, position) || '님'
FROM professor
WHERE deptno = 101;

SELECT name || position || '님'
FROM professor;

-- ORDER BY
SELECT *
FROM emp2
ORDER BY name, deptno DESC, pay DESC;
SELECT *
FROM emp2
ORDER BY 2, 4 DESC, 8 DESC;

-- PPT 2장 단일행함수 실습하기
