import com.autos.repository.ConnectionSingleton;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Connection_Properties_Test {
    @Test
    public void testPropertiesFunction(){
        ConnectionSingleton cs = new ConnectionSingleton();
        String URL = cs.getURL();
        assertEquals("jdbc:postgresql://database-1.ciyas7xaksbp.us-west-1.rds.amazonaws.com:3000/postgres?user=postgres&password=kyleaoki", URL);
    }
}
