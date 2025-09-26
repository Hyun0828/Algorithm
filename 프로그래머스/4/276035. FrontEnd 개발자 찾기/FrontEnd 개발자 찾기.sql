SELECT distinct
    d.id,
    d.email,
    d.first_name,
    d.last_name
FROM developers d
JOIN skillcodes s
    ON d.skill_code & s.code = s.code
WHERE s.category = 'Front End'
ORDER BY d.id;