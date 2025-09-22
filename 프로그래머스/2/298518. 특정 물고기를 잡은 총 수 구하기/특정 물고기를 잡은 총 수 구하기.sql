select count(*) as fish_count
from fish_info f
join fish_name_info n on f.fish_type = n.fish_type
where n.fish_name = 'BASS' or n.fish_name = 'SNAPPER'