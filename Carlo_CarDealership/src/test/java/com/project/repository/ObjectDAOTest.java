package com.project.repository;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.project.model.Car;
import com.project.model.Offer;
import com.project.model.User;

public class ObjectDAOTest {
	
	private CarDAO cd;
	private UserDAO ud;
	private MoneyDAO md;
	
	@Before
	public void setup() {
		cd = new CarDAO();
		ud = new UserDAO();
		md = new MoneyDAO();
	}

	@Test
	public void findAllCarsTest() {
		List<Car> cars = cd.findAll();
		System.out.println("There are "+cars.size()+" unowned cars in the database.");
		assertFalse(cars.size() == 0);
	}
	
	
	@Test
	public void findAllOwnedCarsTest() {
		List<Car> cars = cd.findAllOwned();
		System.out.println("There are "+cars.size()+" owned cars in the database.");
	}
	
	@Test
	public void userOwnedCarsTest() {
		List<Car> cars = cd.ownedCars(1);
		System.out.println("User with ID #1 owns "+cars.size()+" cars.");
	}

	@Test
	public void findAllUsersTest() {
		List<User> users = ud.findAll();
		System.out.println("There are "+users.size()+" employee(s) in the database.");
//		assertFalse(users.size() == 0);
	}
	
	@Test
	public void findAllOffersTest() {
		List<Offer> offers = md.findAll();
		System.out.println("There are "+offers.size()+" pending offers in the database.");
//		assertFalse(cars.size() == 0);
	}
	
	@Test
	public void findAllOwedOffersTest() {
		List<Offer> offers = md.findAllOwed();
		System.out.println("There are "+offers.size()+" cars that still require payment.");
//		assertFalse(cars.size() == 0);
	}
	
}
