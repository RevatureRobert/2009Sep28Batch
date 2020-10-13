package com.projec0.repo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.project0.enums.CarName;
import com.project0.models.Car;
import com.project0.repo.CarDao;

//works well
public class CarDaoTest {
 
	private CarDao cd;
	
	@Before
	public void setup() {
		cd = new CarDao();
		
		
	}
	
	@Test
	public void createTest() {
		Car cc = new Car(CarName.HyundaiElantra, 0);
		Car bb = cd.create(cc);
		assertEquals(bb.getCarID(), 2);
	}
	
	@Test
	public void deleteTest() {
		int aa = cd.delete(1);
		assertEquals(aa,1);
	}
}
