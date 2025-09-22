select book_id, DATE_FORMAT(published_date, '%Y-%m-%d')
from book
where published_date >= '2021-01-01' and published_date < '2022-01-01' and category = '인문'
order by published_date 