select 
    b.title,
    b.board_id,
    r.reply_id,
    r.writer_id,
    r.contents,
    DATE_FORMAT(r.created_date, '%Y-%m-%d')
from used_goods_board b
join used_goods_reply r on b.board_id = r.board_id
where b.created_date >= '2022-10-01' and b.created_date < '2022-11-01'
order by r.created_date asc, b.title asc