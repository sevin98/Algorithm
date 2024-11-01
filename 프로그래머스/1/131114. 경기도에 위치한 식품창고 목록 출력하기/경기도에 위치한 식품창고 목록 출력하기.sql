-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, coalesce(freezer_yn, 'N') AS FREEZER_YN
FROM food_warehouse
WHERE ADDRESS like '경기도%'
ORDER BY  warehouse_id;
