select i.item_id, i.item_name, i.rarity
from item_info i
join item_tree t on i.item_id = t.item_id
where i.item_id not in (select parent_item_id from item_tree where parent_item_id is not null)
order by i.item_id desc