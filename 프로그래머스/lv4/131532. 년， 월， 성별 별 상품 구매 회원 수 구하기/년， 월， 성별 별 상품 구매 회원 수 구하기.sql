-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) 'YEAR', MONTH(SALES_DATE) 'MONTH', GENDER, COUNT(DISTINCT U.USER_ID) 'USERS'
FROM USER_INFO U JOIN ONLINE_SALE O ON U.USER_ID = O.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER
ORDER BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER;