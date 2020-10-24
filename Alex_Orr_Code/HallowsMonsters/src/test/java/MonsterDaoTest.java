
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Monster;
import com.web.repo.MonsterDao;


public class MonsterDaoTest {
	MonsterDao md;

	@Before
	public void setup() {
		md = new MonsterDao();
	}
	@Test
	public void findAllTest() {
		List<Monster> admins = md.findAll();
		System.out.println(admins.get(0).toString());
		assertFalse(admins.size()==0);
	}
}
