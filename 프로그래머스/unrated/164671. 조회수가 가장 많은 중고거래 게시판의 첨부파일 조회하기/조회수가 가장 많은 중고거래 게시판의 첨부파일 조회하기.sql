-- 코드를 입력하세요
SELECT CONCAT("/home/grep/src/", F.BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT) 'FILE_PATH'
FROM USED_GOODS_BOARD B JOIN USED_GOODS_FILE F ON B.BOARD_ID = F.BOARD_ID
WHERE VIEWS = (SELECT MAX(VIEWS)
                FROM USED_GOODS_BOARD)
ORDER BY FILE_ID DESC;

# SELECT *
# FROM USED_GOODS_BOARD
# ORDER BY VIEWS DESC;

# SELECT *
# FROM USED_GOODS_FILE
# WHERE BOARD_ID = 'B0008';