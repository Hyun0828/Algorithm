select
    animal_type,
    count(animal_id) as count
from animal_ins
group by animal_type
having animal_type in ('Cat', 'Dog')
order by animal_type