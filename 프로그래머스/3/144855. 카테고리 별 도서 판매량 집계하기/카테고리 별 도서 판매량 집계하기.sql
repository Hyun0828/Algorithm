select
    b.category,
    sum(sales) as total_sales
from book b
join book_sales s on b.book_id = s.book_id
where s.sales_date >= '2022-01-01' and s.sales_date < '2022-02-01'
group by b.category
order by b.category