with t as (
    select
        history_id,
        daily_fee,
        datediff(end_date, start_date) + 1 as days,
        case 
            when datediff(end_date, start_date) + 1 < 7 then '7일 미만'
            when datediff(end_date, start_date) + 1 < 30 then '7일 이상'
            when datediff(end_date, start_date) + 1 < 90 then '30일 이상'
            else '90일 이상'
        end as duration
    from car_rental_company_rental_history h
    join car_rental_company_car c on h.car_id = c.car_id
    where c.car_type = '트럭'
),
k as (
    select 
        duration_type,
        discount_rate
    from car_rental_company_discount_plan p
    where p.car_type = '트럭'
)
select  
    history_id,
    case
        when t.duration = '7일 미만' then daily_fee * days
        else round(daily_fee * (1 - discount_rate / 100), 0) * days
    end as fee
from t
left join k on t.duration = k.duration_type
order by fee desc, history_id desc

