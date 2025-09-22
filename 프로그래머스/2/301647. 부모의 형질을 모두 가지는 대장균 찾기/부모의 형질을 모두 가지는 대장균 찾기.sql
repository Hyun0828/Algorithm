select 
    c.id,
    c.genotype,
    p.genotype as parent_genotype
from ecoli_data p
left join ecoli_data c on p.id = c.parent_id
where p.genotype & c.genotype = p.genotype
order by c.id
