INSERT INTO ers_reimb_type VALUES (default, 'Lodging');
INSERT INTO ers_reimb_type VALUES (default, 'Travel');
INSERT INTO ers_reimb_type VALUES (default, 'Food');
INSERT INTO ers_reimb_type VALUES (default, 'Other');

INSERT INTO ers_reimb_stat VALUES (default, 'Pending');
INSERT INTO ers_reimb_stat VALUES (default, 'Approved');
INSERT INTO ers_reimb_stat VALUES (default, 'Denied');

INSERT INTO ers_usr_roles VALUES (default, 'Finance Manager');
INSERT INTO ers_usr_roles VALUES (default, 'Employee');

INSERT INTO ers_reimb VALUES (default, 34.56, default, default, "Reimbursement for business trip to Antarctica", "This is your receipt.", "Joe Chill", "Sam Steed", 1, 1)
INSERT INTO ers_reimb VALUES (default, 120.32, default, default, "Reimbursement for meal at Andres", "This is your receipt.", "Joe Chill", "Sam Steed", 1, 2)
INSERT INTO ers_reimb VALUES (default, 78.48, default, default, "Reimbursement for concert with client", "This is your receipt.", "Joe Chill", "Sam Steed", 2, 3)
INSERT INTO ers_reimb VALUES (default, 50.00 default, default, "Reimbursement for lunch at Olive Garden", "This is your receipt.", "Joe Chill", "Sam Steed", 3, 4)

INSERT INTO ers_usrs VALUES (default, 'employeebob@gmail.com', 'Qwijibo$123', 'Christopher', 'Distasio', 'employeebob@gmail.com', 2);
INSERT INTO ers_usrs VALUES (default, 'managerbob@gmail.com', 'Bobemployee$123', 'Bob', 'Bobson', 'managerbobe@gmail.com', 1);
INSERT INTO ers_usrs VALUES (default, 'employeebill@gmail.com', 'Bobstandard$123', 'Bob', 'Bobbington', 'employeebill@gmail.com', 2);
INSERT INTO ers_usrs VALUES (default, 'managerbill@gmail.com', 'Bobpremium$123', 'Bob', 'Bobbarillo', 'managerbill@gmail.com', 1);