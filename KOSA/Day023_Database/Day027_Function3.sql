-- ④ 날짜 함수

-- 현재 날짜
SELECT SYSDATE
FROM dual;

-- 지정 월과의 차이
SELECT MONTHS_BETWEEN(SYSDATE, '2023/12/31')
FROM dual;

-- 월 더하기
SELECT ADD_MONTHS(DATE '2023-05-01', 1)
FROM dual;
SELECT ADD_MONTHS(DATE '2023-05-01', 12)
FROM dual;

-- 당월 마지막 날
SELECT LAST_DAY(DATE '2023-05-01')
FROM dual;

-- 지정 요일 중 가장 빠른 날
SELECT NEXT_DAY(SYSDATE, '금') AS "NEXT_DAY"
FROM dual;
-- 일:1, 월:2, 화:3, ... 토:6
SELECT NEXT_DAY(SYSDATE, 6) AS "NEXT_DAY"
FROM dual;
-- 컬럼에서 이용
SELECT hiredate, NEXT_DAY(hiredate, 1)
FROM professor;


--------------------------------------------------------------------------------


-- ⑤ 형변환 함수

-- TO_CHAR(): 날짜 또는 숫자를 지정 형식으로 변환
SELECT hiredate, TO_CHAR(hiredate, 'YYYY/MM/DD')
FROM professor;
SELECT hiredate, TO_CHAR(hiredate, 'YYYY/MM/DD HH24:MI:SS')
FROM professor;

SELECT TO_CHAR(pay, '999,999,999,999')
FROM emp2;

SELECT TO_CHAR(2000, '999,999')
FROM dual;
-- 지역에 따른 화폐 표시
SELECT TO_CHAR(2000, 'L999,999')
FROM dual;
SELECT TO_CHAR(2000, '$999,999')
FROM dual;

SELECT TO_CHAR(NEXT_DAY(SYSDATE, '일'), 'yyyymmdd hh24:mi:ss') AS "NEXT_DAY"
FROM dual
UNION ALL
SELECT TO_CHAR(NEXT_DAY(SYSDATE, '월'), 'yyyymmdd hh24:mi:ss')
FROM dual
UNION ALL
SELECT TO_CHAR(NEXT_DAY(SYSDATE, '화'), 'yyyymmdd hh24:mi:ss')
FROM dual
UNION ALL
SELECT TO_CHAR(NEXT_DAY(SYSDATE, '수'), 'yyyymmdd hh24:mi:ss')
FROM dual
UNION ALL
SELECT TO_CHAR(NEXT_DAY(SYSDATE, '목'), 'yyyymmdd hh24:mi:ss')
FROM dual
UNION ALL
SELECT TO_CHAR(NEXT_DAY(SYSDATE, '금'), 'yyyymmdd hh24:mi:ss')
FROM dual
UNION ALL
SELECT TO_CHAR(NEXT_DAY(SYSDATE, '토'), 'yyyymmdd hh24:mi:ss')
FROM dual;

-- TO_DATE(): 문자열을 날짜로 변환
SELECT TO_DATE('20230501', 'YYYYMMDD')
FROM dual;
-- Error, 숫자 문자여야 함
/*SELECT TO_DATE('abcd', 'YYYY-MM-DD')
FROM dual;*/
SELECT TO_DATE('20230501213456', 'YYYYMMDD HH24:MI:SS')
FROM dual;

-- TO_NUMBER(): 문자열을 숫자로 변환
SELECT '1234' + 200, TO_NUMBER('1234'), TO_NUMBER('1234') + 100
FROM dual;

-- 지정한 형식만 확인
SELECT value
FROM nls_session_parameters
WHERE parameter = 'NLS_DATE_FORMAT';

-- 현재 시스템에서의 셋팅 상태 확인
SELECT *
FROM nls_session_parameters;

-- ALTER SESSION SET NLS_DATE_FORMAT = [변경할 포맷]
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
-- 날짜 형식 변경
-- 메뉴 : 도구 > 환경설정 > 데이터베이스 > NLS > 날짜형식
SELECT *
FROM nls_session_parameters
WHERE parameter = 'NLS_DATE_FORMAT';


--------------------------------------------------------------------------------


-- ⑥ 조건부 함수

-- 부서번호가 10이면 ACCOUNTING, 20이면 RESEARCH, 30이면 SALES, 나머지는 OPERATIONS를 출력하는 예제
SELECT deptno,
       DECODE(deptno, 10, 'ACCOUNTING',
              20, 'RESEARCH',
              30, 'SALES', 'OPERATIONS') AS name
FROM dept;

-- 10부서는 급여합계를, 20부서는 최대값을, 30부서는 최소값을 출력하는 예제
SELECT deptno,
       DECODE(deptno, 10, SUM(sal),
              20, MAX(sal),
              30, MIN(sal)) AS sal
FROM emp
GROUP BY deptno;

-- 부서별로 급여 합계를 출력한다.
SELECT deptno,
       NVL(SUM(DECODE(deptno, 10, sal)), 0) deptno10,
       NVL(SUM(DECODE(deptno, 20, sal)), 0) deptno20,
       NVL(SUM(DECODE(deptno, 30, sal)), 0) deptno30,
       NVL(SUM(DECODE(deptno, 40, sal)), 0) deptno40
FROM emp
GROUP BY deptno;

SELECT deptno,
       NVL(SUM(DECODE(deptno, 101, pay)), 0) deptno101,
       NVL(SUM(DECODE(deptno, 102, pay)), 0) deptno102,
       NVL(SUM(DECODE(deptno, 103, pay)), 0) deptno103,
       NVL(SUM(DECODE(deptno, 201, pay)), 0) deptno201,
       NVL(SUM(DECODE(deptno, 202, pay)), 0) deptno202,
       NVL(SUM(DECODE(deptno, 203, pay)), 0) deptno203,
       NVL(SUM(DECODE(deptno, 301, pay)), 0) deptno301
FROM professor
GROUP BY deptno
ORDER BY deptno;

--위의  DECODE예제를 CASE함수로 변환한 예이다.
SELECT deptno,
       CASE deptno
           WHEN 10 THEN 'ACCOUNTING'
           WHEN 20 THEN 'RESEARCH'
           WHEN 30 THEN 'SALES'
           ELSE 'OPERATIONS'
           END AS "Dept Name"
FROM dept;

SELECT ename, sal,
       CASE
           WHEN sal < 1000 THEN sal + (sal * 0.8)
           WHEN sal BETWEEN 1000 AND 2000 THEN sal + (sal * 0.5)
           WHEN sal BETWEEN 2001 AND 3000 THEN sal + (sal * 0.3)
           ELSE sal + (sal * 0.1)
           END AS sal
FROM emp;

-- 문제] pdept에 따른 지사명을 출력하세요. (decode, case 이용)
SELECT *
FROM dept2;
