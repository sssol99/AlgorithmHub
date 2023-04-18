# -- 코드를 입력하세요
SELECT Date_format(T.sales_date, '%Y-%m-%d') as sales_date, 
    T.product_id, 
    T.user_id, 
    T.sales_amount 
FROM(
    SELECT DATE_FORMAT(N.SALES_DATE,'%Y-%m-%d') as SALES_DATE,
        N.PRODUCT_ID,
        N.USER_ID,
        N.SALES_AMOUNT
    FROM ONLINE_SALE N
    WHERE N.SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
        UNION ALL
     SELECT DATE_FORMAT(F.SALES_DATE,'%Y-%m-%d') as SALES_DATE,
        F.PRODUCT_ID,
        null AS USER_ID,
        F.SALES_AMOUNT
    FROM OFFLINE_SALE F
     WHERE F.SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
    ) T
ORDER BY sales_date, T.PRODUCT_ID, T.USER_ID;
