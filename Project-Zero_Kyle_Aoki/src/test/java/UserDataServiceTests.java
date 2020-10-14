import com.autos.service.UsersService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserDataServiceTests {

    UsersService uds;

    @Before
    public void setUp(){ uds = new UsersService(); }
    
    @Test
    public void doesUserExistTest(){
        boolean result1 = uds.doesUserExist("kyleaoki");
        boolean result2 = uds.doesUserExist("fake user");
        assertTrue(result1);
        assertFalse(result2);
    }
    
}
