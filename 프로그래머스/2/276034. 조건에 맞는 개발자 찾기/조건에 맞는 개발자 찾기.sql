-- 코드를 작성해주세요
WITH A AS (
    SELECT *
    FROM DEVELOPERS NATURAL JOIN SKILLCODES
    WHERE (NAME = 'Python' OR NAME = 'C#') AND (SKILL_CODE & CODE = CODE)
)

SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM A
ORDER BY ID;