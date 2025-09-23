with dis as (
    select car_type, discount_rate
    from car_rental_company_discount_plan
    where car_type in ('SUV', '세단') and duration_type = '30일 이상'
)
select
    c.car_id, 
    c.car_type, 
    round(c.daily_fee * ((100 - d.discount_rate) / 100) * 30, 0) as fee
from car_rental_company_car c
join dis d on c.car_type = d.car_type
where c.car_id not in (
    select car_id 
    from car_rental_company_rental_history 
    where start_date <= '2022-11-30' 
      and end_date >= '2022-11-01'
)
and c.daily_fee * ((100 - d.discount_rate) / 100) * 30 >= 500000
and c.daily_fee * ((100 - d.discount_rate) / 100) * 30 < 2000000
order by fee desc, c.car_type asc, c.car_id desc