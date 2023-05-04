-- 레코드 검색
-- SELECT 테이블명
-- [WHERE 조건식]
-- [ORDER BY 컬럼명 DESC|ASC, ...]

SELECT *
FROM emp2
-- ORDER BY NAME; -- ASC: 오름차순, 생략 가능
-- ORDER BY NAME DESC; -- DESC: 내림차순, 생략 불가
-- ORDER BY NAME, DEPTNO DESC, POSITION; -- NULL이 오라클에서 최우선순위이므로 처리 필요(MYSQL에서는 저순위)
ORDER BY 2,
         4 DESC,
         9; -- 컬럼명 대신 숫자 사용 가능, 단 0이 아닌 1부터 시작

SELECT *
FROM emp2;

SELECT name,
       empno,
       deptno,
       emp_type
FROM emp2; -- 원하는 필드의 레코드만 검색
SELECT name,
       empno,
       deptno,
       emp_type
FROM emp2
WHERE emp_type = '정규직';

SELECT name,
       empno,
       deptno,
       emp_type
FROM emp2
WHERE emp_type = '정규직'
ORDER BY name DESC; -- ASC : 생략가능

SELECT name,
       empno,
       deptno,
       emp_type
FROM emp2
WHERE emp_type = '정규직'
ORDER BY name DESC,
         deptno ASC;

SELECT DISTINCT emp_type
FROM emp2;
-- WHERE EMP_TYPE='정규직'

SELECT DISTINCT deptno
FROM emp2;

SELECT name,
       empno,
       deptno,
       emp_type,
       position
FROM emp2
WHERE position = '부장';

SELECT name     AS "성   명",
       empno       사원번호,
       deptno      "부    서",
       emp_type AS 근무타입,
       position    "직    급"
FROM emp2
WHERE position = '부장';

SELECT name     AS "성   명",
       empno       사원번호,
       deptno      "부    서",
       emp_type AS 근무타입,
       position    "직    급"
FROM emp2
WHERE position = '과장'
  AND name = '유관순';

SELECT name     AS "성   명",
       empno       사원번호,
       deptno      "부    서",
       emp_type AS 근무타입,
       position    "직    급"
FROM emp2
WHERE position = '부장'
   OR name = '유관순';

DESC EMP2;

SELECT *
FROM emp2
WHERE deptno = 1000;


--------------------------------------------------------------------------------


-- 연산자
SELECT MOD(7, 3)
FROM dual;

SELECT MOD(7, 3) AS "나머지 연산 결과"
FROM dual;

SELECT *
FROM professor;

SELECT *
FROM department;

SELECT name,
       bonus,
       position
FROM professor
/*WHERE
    bonus IS NULL;*/
WHERE bonus IS NOT NULL;

SELECT name,
       bonus,
       bonus + 100,
       position
FROM professor; -- ★ NULL과 숫자의 연산 결과는 항상 NULL!!
SELECT name,
       bonus,
       NVL(bonus, 0) + 100,
       position
FROM professor;

SELECT name,
       bonus,
       NVL(bonus, 50) + 300 AS "특별 보너스",
       position
FROM professor;

SELECT *
FROM professor
/*WHERE POSITION = '정교수'
   OR POSITION = '조교수';*/
WHERE position IN ('정교수', '조교수'); -- IN 연산자는 OR의 기능과 비슷하지만 우월한 성능

SELECT *
FROM student
/*WHERE
    grade = 3
    OR grade = 2
    OR grade = 1;*/
-- WHERE GRADE IN (3, 2, 1);
WHERE grade NOT IN (3, 2, 1);

SELECT *
FROM professor
WHERE deptno
--    BETWEEN 201 AND 103;
          BETWEEN 103 AND 201; -- BETWEEN 작은값 AND 큰값

SELECT *
FROM emp2
WHERE
--    name LIKE '김%'; -- %: 모든
name LIKE '%정%';

SELECT *
FROM professor
WHERE
--    name LIKE '__'; -- _: 한 글자
--    name LIKE '허_';
--    name LIKE '_슨';
--    name LIKE '나_%';
name LIKE '%원_';

-- 숫자
SELECT *
FROM professor
--    WHERE pay > 500;
--    WHERE pay < 300;
WHERE pay >= 250
   OR pay < 500;


--------------------------------------------------------------------------------


-- 정규직이면서 '백원만' 찾기
SELECT *
FROM emp2
WHERE name = '백원만'
  AND emp_type = '정규직';

-- 정규직이거나 '유도봉' 찾기
SELECT *
FROM emp2
WHERE name = '유도봉'
   OR emp_type = '정규직';

-- 수습직이거나 김씨성을 가진 사람 찾기
SELECT *
FROM emp2
WHERE name LIKE '김%'
   OR emp_type = '수습직';

-- 김씨가 아닌 수습직원 찾기
SELECT *
FROM emp2
WHERE name NOT LIKE '김%'
  AND emp_type = '수습직';


--------------------------------------------------------------------------------


/*
       > ANY : 최소값 보다 크면
        필드명(pay) >= ANY : 최소값보다 크거나 같으면   any( 300, 550, 400 )
         < ANY : 최대값보다 작으면
         <= ANY : 최대값보다 작거나 같으면
          = ANY : IN과 같은 효과
         != ANY : NOT IN과 같은 효과
*/
SELECT *
FROM professor
WHERE pay >= ANY (300, 550, 400); -- 최솟값 이상
SELECT *
FROM student
WHERE weight > ANY (70, 80); -- 최솟값 초과
SELECT *
FROM student
WHERE weight < ANY (60, 70); -- 최댓값 미만

/*
       ANY와는 반대되는 개념입니다.

         필드명(pay) > ALL : 최대값 보다 크면  all( 300, 550, 400 )
       >= ALL : 최대값보다 크거나 같으면
       < ALL : 최소값보다 작으면
       <= ALL : 최소값보다 작거나 같으면
       = ALL : SUBSELECT의 결과가 1건이면 상관없지만 여러 건이면 오류가 발생합니다.
       != ALL : 위와 마찬가지로 SUBSELECT의 결과가 여러 건이면 오류가 발생합니다
*/
SELECT *
FROM professor
WHERE pay >= ALL (300, 550, 400); -- 최댓값 이상
SELECT *
FROM student
WHERE weight > ALL (70, 80); -- 최댓값 초과
SELECT *
FROM student
WHERE weight < ALL (60, 70); -- 최솟값 미만