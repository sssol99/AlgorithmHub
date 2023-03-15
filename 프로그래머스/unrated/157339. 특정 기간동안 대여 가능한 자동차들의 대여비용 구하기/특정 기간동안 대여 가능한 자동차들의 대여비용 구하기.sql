-- 코드를 입력하세요

SELECT sedanT.car_id as CAR_ID, sedanT.CAR_TYPE as CAR_TYPE, round(sedanT.DAILY_FEE * 30 * (100 - DISCOUNT_RATE) / 100)as FEE
    from  CAR_RENTAL_COMPANY_CAR  as sedanT 
    join (select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE like '30%') as disT
    on sedanT.CAR_TYPE = disT.CAR_TYPE

where (sedanT.DAILY_FEE * 30 * (100 - disT.DISCOUNT_RATE) / 100) Between 500000 and 2000000 
 
    and
    sedanT.car_id not in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where END_DATE >= '2022-11-01')
    and
    (sedanT.CAR_TYPE like '세단' or sedanT.CAR_TYPE like 'SUV')
group by sedanT.car_id 
order by FEE desc, sedanT.CAR_TYPE, sedanT.car_id desc
