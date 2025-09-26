select i.animal_id, i.animal_type, i.name
from animal_ins i
join animal_outs o on i.animal_id = o.animal_id
where (i.sex_upon_intake = 'Intact Male' and (o.sex_upon_outcome = 'Spayed Male' or o.sex_upon_outcome = 'Neutered Male')) or (i.sex_upon_intake = 'Intact Female' and (o.sex_upon_outcome = 'Spayed Female' or o.sex_upon_outcome = 'Neutered Female'))
order by i.animal_id