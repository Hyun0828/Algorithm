select count(*) as count
from ecoli_data
where (genotype & 5 = 5 or genotype & 1 = 1 or genotype & 4 = 4) and genotype & 2 != 2