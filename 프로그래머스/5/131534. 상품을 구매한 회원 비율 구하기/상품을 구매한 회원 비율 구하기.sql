select 
    year(sales_date) as year,
    month(sales_date) as month,
    count(distinct(u.user_id)) as purchased_users,
    round(count(distinct(u.user_id)) / (select count(*) from user_info where year(joined)=2021), 1) as purchased_ratio
from user_info u
join online_sale o on u.user_id = o.user_id
where YEAR(u.joined) = 2021
group by year(sales_date), month(sales_date)
order by year, month