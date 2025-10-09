select 
    animal_id,
    name
from animal_ins
where UPPER(name) like '%EL%' and animal_type = 'Dog'
order by UPPER(name)