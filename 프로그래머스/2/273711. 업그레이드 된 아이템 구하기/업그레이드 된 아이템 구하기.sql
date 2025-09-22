with tp as (
    select 
        t.item_id
    from item_tree t
    join item_info i on i.item_id = t.parent_item_id
    where i.rarity = 'RARE'
)
select 
    f.item_id,
    f.item_name,
    f.rarity
from item_info f
join tp on f.item_id = tp.item_id
order by f.item_id desc
