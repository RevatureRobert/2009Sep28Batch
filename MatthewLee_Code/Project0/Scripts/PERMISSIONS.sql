GRANT ALL ON TABLE dealership.car TO dealership_user;
GRANT ALL ON TABLE dealership.customer TO dealership_user;
GRANT ALL ON TABLE dealership.employee TO dealership_user;
GRANT ALL ON TABLE dealership.manager TO dealership_user;
GRANT ALL ON TABLE dealership.offer TO dealership_user;
GRANT ALL ON TABLE dealership.payment TO dealership_user;
GRANT ALL ON TABLE dealership.payments_with_offer TO dealership_user;

GRANT ALL ON SEQUENCE dealership.car_car_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.customer_customer_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.employee_employee_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.manager_manager_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.offer_offer_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.payment_payment_id_seq TO dealership_user;