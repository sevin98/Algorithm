-- 코드를 입력하세요
SELECT ROUND (SUM(daily_fee) / COUNT(daily_fee),0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE car_type ='SUV'