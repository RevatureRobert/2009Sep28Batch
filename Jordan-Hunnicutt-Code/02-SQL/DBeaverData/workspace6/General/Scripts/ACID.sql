--ACID
----the properties of a transaction
----atomic, consistent, isolated, durable

----atomic = all or nothing
----consistent = all constraints are being followed, the state of the database properly changes after a commit.
----isolated = transactions will not conflict with each other. (there are different levels we can achieve)
----durable = information will persist in the event of drastic circumstances (power goes down, info still there when get back)

----transactions have to follow all these rules, they are not mutually exclusive