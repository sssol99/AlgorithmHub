-- 코드를 입력하세요
# select count(MEMBER_ID) cnt
# from REST_REVIEW 
# group by MEMBER_ID
# order by cnt desc
# limit 1

-- 리뷰수가 3개인 테이블 만들기

select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE,'%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE m
join REST_REVIEW r
on m.MEMBER_ID = r.MEMBER_ID
where m.member_id in 

(select MEMBER_ID
from REST_REVIEW
group by MEMBER_ID
having count(MEMBER_ID) 
 = (select count(MEMBER_ID)
    from REST_REVIEW 
    group by MEMBER_ID
    order by count(MEMBER_ID) desc
    limit 1))
order by REVIEW_DATE, REVIEW_TEXT

-- 리뷰수 서브쿼리
    

