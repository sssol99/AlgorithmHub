-- 코드를 입력하세요
SELECT p.PRODUCT_ID, p.PRODUCT_NAME, (p.price*o.amount) as TOTAL_SALES
from FOOD_PRODUCT p
join (select PRODUCT_ID, sum(amount) as amount from FOOD_ORDER where date_format(PRODUCE_DATE,'%Y-%m') = '2022-05' group by product_id)as o
on p.PRODUCT_ID = o.PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID

