-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, date_format(PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
from BOOK b
    inner join AUTHOR a
    on CATEGORY like '경제'
where b.AUTHOR_ID = a.AUTHOR_ID
order by PUBLISHED_DATE;