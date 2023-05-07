-- 문제1] 급여가 500 이상이고, 보너스가 60 이상인 교수는?
SELECT *
FROM professor
WHERE pay >= 500
  AND bonus >= 60;

-- 문제2] 이름이 '나한라'을 '너한라'으로 변경 (emp2)
UPDATE emp2
SET name = '너한라'
WHERE name = '나한라';

SELECT *
FROM emp2
WHERE name = '나한라'
   OR name = '너한라';

ROLLBACK;

-- 문제3] 취미가 등산인 사람들만 찾아서 '수영'으로 변경
UPDATE emp2
SET hobby = '수영'
WHERE hobby = '등산';

SELECT *
FROM emp2
WHERE hobby IN ('수영', '등산');

ROLLBACK;

-- 문제4] 계약직 직원 찾아서 삭제하기
DELETE
FROM emp2
WHERE emp_type = '계약직';

SELECT *
FROM emp2
WHERE emp_type = '계약직';

ROLLBACK;

-- 문제5] pay(or bonus)가 50이상인 사람만 출력 (professor)
SELECT *
FROM professor
WHERE pay >= 50
   OR bonus >= 50;

-- 문제6] ~세트가 아닌 상품들만 출력 (gift table)
SELECT *
FROM gift
WHERE gname NOT LIKE '%세트';

-- 문제7] gno가 10인 상품의 이름을 널처리(null) 하세요.
UPDATE gift
SET gname = NULL
WHERE gno = 10;

SELECT *
FROM gift
WHERE gno = 10;

ROLLBACK;

-- 문제8] gname 이름이 없고, g_start가 999인 값을 갖는 데이터 입력하세요.
INSERT INTO gift (gname,
                  g_start)
VALUES (NULL,
        999);

SELECT *
FROM gift
WHERE gname IS NULL
  AND g_start = 999;

COMMIT;

ROLLBACK;

-- 문제9] gname이 null이거나 ' ' 인 데이터를 제외하고 출력하시오.
SELECT *
FROM gift
WHERE gname IS NOT NULL
  AND gname != ' ';

-- 문제10] 키가 168인 사람은 몇 번째로 큰지 확인?
SELECT *
FROM student
ORDER BY height DESC;
SELECT RANK(168) WITHIN GROUP (ORDER BY height DESC)
FROM student;

-- 문제11] 몸무게가 58인 사람은 몇번째인지 등수 구하기
SELECT *
FROM student
ORDER BY weight DESC;
SELECT RANK(58) WITHIN GROUP ( ORDER BY weight DESC )
FROM student;

-- 문제12] g_end가 200000, 600000 보다 작은 값 출력 (any 이용)
SELECT *
FROM gift
WHERE g_end < ANY (200000, 600000);

-- 문제13] 학생들의 키의 합과 평균, 가장 키가 큰 친구, 작은 친구 출력하세요.
SELECT SUM(height), AVG(height), MAX(height), MIN(height)
FROM student;
SELECT *
FROM student
WHERE height IN ((SELECT MAX(height) FROM student), (SELECT MIN(height) FROM student))
ORDER BY height DESC;


--------------------------------------------------------------------------------


-- 문제1] 이름에서 '김영조' 사람들을 보여주세요.
SELECT *
FROM professor
WHERE name = '김영조';

-- 문제2] 이름에서 '김'씨 성을 가진 사람들을 보여주세요.
SELECT *
FROM professor
WHERE name LIKE '김%';

-- 문제3] 이름이 두 글자인 사람 보여주세요.
SELECT *
FROM professor
WHERE name LIKE '__';

-- 문제4] id에 s or a 글자가 들어가는 사람 찾기
SELECT *
FROM professor
WHERE id LIKE '%s%'
   OR id LIKE '%a%';

-- 문제5] 전임강사 찾아주세요
SELECT *
FROM professor
WHERE position = '전임강사';

-- 문제6] 학년이 3학년(grade)이고 키(height)가 165이상인 학과코드(deptno1)가 201인 학생 찾기
SELECT *
FROM student
WHERE grade = 3
  AND height >= 165
  AND deptno1 = 201;

-- 문제7] 생일이 77년 이전인 학생들 찾기
SELECT *
FROM student
-- WHERE birthday < '1977-01-01';
WHERE jumin < '770101';

-- 문제8] 부전공(deptno2)을 가진 학생들만 찾기
SELECT *
FROM student
WHERE deptno2 IS NOT NULL;

-- 문제9] 담당교수(profno)가 1000 ~ 2001 번 사이 학생들 찾기
SELECT *
FROM student
WHERE profno BETWEEN 1000 AND 2001;

-- Oracle SQL_PLSQL_PPT 3장 실습하기