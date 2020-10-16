create or replace procedure accept_offer(offer_offer_id int) language plpgsql as $$
	declare 
		offer_customer_id integer;
		offer_car_id integer;
	begin	
		select offer.customer_id into offer_customer_id from offer where offer.offer_id = offer_offer_id;
		select offer.car_id into offer_car_id from offer where offer.offer_id = offer_offer_id;
		update car set customer_id = offer_customer_id where car_id = offer_car_id;
		update offer set accepted = 1 where offer.customer_id = offer_customer_id and offer.car_id = offer_car_id;
		update offer set accepted = -1 where car_id = offer_car_id and customer_id != offer_customer_id;
		insert into payment values (default, 0, offer_customer_id, offer_car_id);
	end
$$;

select * from offer;
call accept_offer(1);
update offer set accepted = 0 where offer_id = 1;