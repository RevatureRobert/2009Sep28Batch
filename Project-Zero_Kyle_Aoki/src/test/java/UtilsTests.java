import com.autos.utility.Utils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTests {
    private Utils u;
    @Before
    public void setup(){
        this.u = new Utils();
    }
    @Test
    public void addSpaceTest(){
        String spaces = Utils.addSpaces(5);
        assertEquals("     ", spaces);
    }
    @Test
    public void roundTest(){
        double roundedNumber1 = Utils.round(5.5555555, 2);
        assertEquals(5.56, roundedNumber1, 0);
        double roundedNumber2 = Utils.round(5.5444, 2);
        assertEquals(5.54, roundedNumber2, 0);
        double roundedNumber3 = Utils.round(5.5555555, 2);
        assertEquals(5.56, roundedNumber3, 0);
    }
}
