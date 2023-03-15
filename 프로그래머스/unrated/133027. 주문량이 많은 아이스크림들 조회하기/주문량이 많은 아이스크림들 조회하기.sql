-- 코드를 입력하세요
select f.flavor
from FIRST_HALF f
join (select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER from july  group by FLAVOR ) as j

on f.FLAVOR = j.FLAVOR
group by f.FLAVOR
order by (f.TOTAL_ORDER + j.TOTAL_ORDER) desc
limit 3

