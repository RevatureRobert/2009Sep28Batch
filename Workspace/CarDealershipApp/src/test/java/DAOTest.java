import com.dealership.model.User;
import com.dealership.repo.*;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class DAOTest {

	private UserDAO dao;
	
	@Before
	public void setup()
	{
		dao = new UserDAO();
	}
	
	@Test
	public void testGetUser()
	{
		 User user = dao.getUser("gungy");
		assertNotNull(user);
	}
}
