-- 코드를 입력하세요
WITH A AS (
    SELECT C.CAR_ID, DAILY_FEE, CAR_TYPE, HISTORY_ID, CASE WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 90 THEN '90일 이상'
                                WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '30일 이상'
                                WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 7 THEN '7일 이상'
                                ELSE 'NONE' END 'D_TYPE', DATEDIFF(END_DATE, START_DATE)+1 'DAY'
    FROM CAR_RENTAL_COMPANY_CAR C JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID
)

SELECT HISTORY_ID, ROUND(((DAILY_FEE*DAY)/100)*(100-IFNULL(DISCOUNT_RATE, 0)), 0) FEE
FROM A LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON (A.CAR_TYPE = P.CAR_TYPE AND A.D_TYPE = DURATION_TYPE)
WHERE A.CAR_TYPE = '트럭'
ORDER BY FEE DESC, HISTORY_ID DESC;
























# WITH value AS (
#     SELECT car.daily_fee, car.car_type, his.history_id,
#            DATEDIFF(end_date, start_date) + 1 AS period,
#     CASE 
#       WHEN DATEDIFF(end_date, start_date) + 1 >= 90 THEN '90일 이상'
#       WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '30일 이상'
#       WHEN DATEDIFF(end_date, start_date) + 1 >= 7 THEN '7일 이상'
#       ELSE 'NONE' END AS duration_type
# FROM car_rental_company_rental_history AS his
# INNER JOIN car_rental_company_car AS car ON car.car_id = his.car_id
# WHERE car.car_type = '트럭')   



# SELECT value.history_id, 
#     ROUND(value.daily_fee * value.period * 
#           (100 - IFNULL(plan.discount_rate,0)) / 100) AS FEE
# FROM value
# LEFT JOIN car_rental_company_discount_plan AS plan 
#     ON plan.duration_type = value.duration_type 
#     AND plan.car_type = value.car_type
# ORDER BY 2 DESC, 1 DESC