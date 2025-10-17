with A as (
    select d.id, d.email
    from developers d
    join skillcodes s on d.skill_code & s.code = s.code
    where s.category = 'Front End'
        and d.id in (
            select d2.id
            from developers d2
            join skillcodes s2 on d2.skill_code & s2.code = s2.code
            where s2.name = 'Python'
        )
),
B as (
    select d.id, d.email
    from developers d
    join skillcodes s on d.skill_code & s.code = s.code
    where s.name = 'C#' and d.id not in (select id from A)
),
C as (
    select d.id, d.email
    from developers d
    join skillcodes s on d.skill_code & s.code = s.code
    where d.id not in (select id from A) and d.id not in (select id from B) and s.category = 'Front End'
)
select 'A' as grade, id, email from A
union
select 'B' as grade, id, email from B
union
select 'C' as grade, id, email from C
order by grade, id
