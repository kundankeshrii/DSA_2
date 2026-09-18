select e.name 
from employee e
join employee b
on e.id=b.managerId
group by e.id,e.name
having count(b.id)>=5;
