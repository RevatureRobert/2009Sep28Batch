package project0;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;

import com.dao.EmployeeDao;
import com.driver.Driver;

public class DriverTest 
{
	private static final Driver drive = new Driver();
	private static final EmployeeDao ED = new EmployeeDao();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testFirstNameXavier()
	{
		assertEquals("\nHello Dawit!", ED.validateLogin(5, "Kobe"));
	}
}
