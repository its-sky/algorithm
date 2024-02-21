-- 코드를 입력하세요
SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
FROM MEMBER_PROFILE P JOIN REST_REVIEW R ON P.MEMBER_ID = R.MEMBER_ID
WHERE R.MEMBER_ID = (SELECT MEMBER_ID
                 FROM REST_REVIEW
                 GROUP BY MEMBER_ID
                 ORDER BY COUNT(*) DESC
                 LIMIT 1)
ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC;




















# SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d')
# FROM MEMBER_PROFILE P JOIN REST_REVIEW R ON P.MEMBER_ID = R.MEMBER_ID
# WHERE P.MEMBER_ID = (SELECT MEMBER_ID
#                   FROM REST_REVIEW
#                   GROUP BY MEMBER_ID
#                   ORDER BY COUNT(*) DESC
#                   LIMIT 1)
# ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC;