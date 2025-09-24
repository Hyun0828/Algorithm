with t as(
    select
        member_id,
        count(member_id) as count
    from rest_review
    group by member_id
)
, q as (
    select member_id
    from t 
    where count = (select max(count) from t)
)
select
    member_name,
    review_text,
    date_format(review_date, '%Y-%m-%d') as review_date
from member_profile m
join rest_review r on m.member_id = r.member_id
join q on q.member_id = m.member_id
order by review_date, review_text

