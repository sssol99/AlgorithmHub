-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) TOTAL_ORDER
FROM FIRST_HALF F JOIN ICECREAM_INFO I
ON F.FLAVOR = i.FLAVOR
GROUP BY I.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER;

