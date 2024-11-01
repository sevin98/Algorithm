-- 코드를 입력하세요
SELECT PRODUCT_CODE, SUM(p.price * f.SALES_AMOUNT) AS SALES
FROM PRODUCT p
JOIN OFFLINE_SALE f ON p.PRODUCT_ID = f.PRODUCT_ID
GROUP BY 
    p.PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE asc
