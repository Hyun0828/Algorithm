with t as (
    select
        history_id,
        car_type,
        daily_fee,
        datediff(end_date, start_date) + 1 as total_date,
        case
            when datediff(end_date, start_date) + 1 < 7 then '7일 미만'
            when datediff(end_date, start_date) + 1 < 30 then '7일 이상'
            when datediff(end_date, start_date) + 1 < 90 then '30일 이상'
            else '90일 이상'
        end as duration_type
    from car_rental_company_car c
    join car_rental_company_rental_history h on c.car_id = h.car_id
    where c.car_type = '트럭'
)
select
    history_id,
    case
        when t.duration_type = '7일 미만' then daily_fee * total_date
        else round(daily_fee * (1 - discount_rate / 100) * total_date)
    end as fee
from t
left join car_rental_company_discount_plan d on t.car_type = d.car_type and t.duration_type = d.duration_type
order by fee desc, history_id desc
