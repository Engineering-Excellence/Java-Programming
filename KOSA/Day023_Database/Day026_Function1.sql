-- 함수
--------------------------------------------------------------------------------


-- ① 집계(그룹) 함수
SELECT *
FROM gift;
SELECT SUM(g_start), SUM(g_end)
FROM gift;
SELECT SUM(g_start) AS "최저가 합계", SUM(g_end) AS "상품 최고가의 총합"
FROM gift;
SELECT SUM(g_start), AVG(g_start), MAX(g_start), MIN(g_start), AVG(g_end)
FROM gift;

SELECT *
FROM gift,
     emp2,
     professor;

SELECT COUNT(name),
--        COUNT(bonus), -- 총 레코드 수(NULL 제외)
       COUNT(NVL(bonus, 0)),
       AVG(pay), -- 평균(NULL 제외)
--        AVG(bonus)
       AVG(NVL(bonus, 0))
FROM professor;

SELECT COUNT(*) -- NULL을 포함한 개수
FROM professor;
SELECT COUNT(hpage) -- NULL 제외
FROM professor;

SELECT name, pay, bonus
FROM professor;

SELECT *
FROM gift;
SELECT COUNT(*)
FROM gift;
SELECT COUNT(gname)
FROM gift;

-- ORACLE은 NULL 우선순위가 높고 MySQL은 NULL 우선순위 낮음
SELECT RANK(600000) WITHIN GROUP ( ORDER BY g_end DESC )
FROM gift
WHERE g_end IS NOT NULL; -- NULL이 1등
