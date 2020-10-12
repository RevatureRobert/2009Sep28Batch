-- creates view of customers total payments for each car and their original offer
drop view payments_with_offer;

create view payments_with_offer as
select p.customer_id, p.car_id, sum(monthly_payment) as paid, avg(o.amount) as offer, avg(o.months) as months from payment p
join offer o on p.car_id = o.car_id and o.accepted = 1
group by p.customer_id, p.car_id
order by p.customer_id, p.car_id;

select * from payments_with_offer;

select * from payment;
