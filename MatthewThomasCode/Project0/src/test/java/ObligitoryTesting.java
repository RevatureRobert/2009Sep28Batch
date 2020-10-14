

import org.junit.Test;

import com.car_dealership_cli.repo.DAOUtilities;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;


public class ObligitoryTesting {

	
	@Before
	public void setup() {
		
	}
	@Test
	public void connectionTest() {
		assertNotNull(DAOUtilities.getConnection());
	}
	
}
