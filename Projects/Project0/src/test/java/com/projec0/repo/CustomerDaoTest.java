package com.projec0.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.project0.models.Customer;
import com.project0.repo.CustomerDao;

//check with database for userids. 
//all works well

public class CustomerDaoTest {
	
	private CustomerDao cd;
	private Customer a,b;
	private ArrayList<Customer> ll;
	
	@Before
	public void setup() {
		cd = new CustomerDao();
		a = new Customer(0,"enochcho");
		b = new Customer(0,"ahramcho");
		ll = new ArrayList<Customer>();
		ll.add(a);
		ll.add(b);
	}
	
	@Test
	public void findAllTest() {
		ArrayList<Customer> test = (ArrayList<Customer>) cd.findAll();
		boolean same = true;
		for(int i =0; i <test.size();i++) {
			if(test.get(i).getUser().equals(ll.get(i).getUser())) {
			} else {
				same = false;
			}
		}
		assertTrue(same);
	}
	
	@Test
	public void findByIdTest() {
		Customer test = cd.findById(3);
		assertEquals(test.getUser(), "enochcho");
	}
	
	@Test
	public void updateTest() {
		Customer ab = new Customer(3,"Changed");
		Customer ddd = cd.update(ab);
		assertEquals(ddd.getUser(),"Changed");
	}
	
	@Test
	public void createTest() {
		Customer cc = cd.create(a);
		Customer bb = cd.create(b);
		assertEquals(cc.getUser(),a.getUser());
		assertEquals(bb.getUser(),b.getUser());
	}
	
	@Test
	public void deleteTest() {
		assertEquals(cd.delete(3),1);
	}

}
