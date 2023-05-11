-- 정규 표현식
-- ORACLE 10g부터 적용
--https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D
--https://cheezred.tistory.com/35

SELECT *
FROM reg_test;

SELECT *
FROM reg_test
WHERE
    -- REGEXP_LIKE(문자열 또는 필드명, '패턴', '옵션[imsnx]');
    REGEXP_LIKE(text,
                '([aeiou])\1',
                'i');

SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[abc]'); -- [ 와 ] 사이에 있는 문자들 중 하나

SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[a-z] [0-9]'); -- 소문자 a~z 공백 숫자

SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[a-z][0-9]'); -- 위의 것과 차이 비교

INSERT INTO reg_test
VALUES ('789ABC');

INSERT INTO reg_test
VALUES ('789 ABC');

INSERT INTO reg_test
VALUES ('123kbs');

INSERT INTO reg_test
VALUES ('mbc567');

INSERT INTO reg_test
VALUES ('sbs 567');

-- 소문자나 공백이나 숫자가 들어가는 것    
SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[a-z]?[0-9]'); -- 대소문자 구분 없음. ?
SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[0-9]?[a-z]');

SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[A-Z]*[0-9]'); -- 대소문자 구분 없음. *
SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[A-Z]?[0-9]');

SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[0-9]?[A-Z]');

SELECT *
FROM reg_test
WHERE REGEXP_LIKE(text,
                  '[0-9]*[A-Z]');

SELECT *
FROM professor;
-- a를 포함하고 숫자가 포함되어 있는 ID를 정규식으로 찾기
SELECT id
FROM professor
WHERE REGEXP_LIKE(id, 'a.*[0-9]+');

UPDATE professor
SET id = 'b10a'
WHERE profno = 4007;

ROLLBACK;