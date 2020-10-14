


import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cardealer.console.AdminMenu;
import com.cardealer.model.Account;
import com.cardealer.service.UtilityFunctions;

/*
 * JUNIT
 * 
 * 		Unit testing is meant to test your code as independently as possible.
 * 		
 * 		There are other independent units of code that require other units,
 * 			they can cause the entire group to fail. So you want to test
 * 			them as independently as possible.
 * 
 * 		TDD
 * 			Test Driven Development is the ART of writing code to follow
 * 				a testing procedure.
 * 
 * 			phases
 * 				red, green, refactor
 * 
 * MOCKITO
 * 	
 * 		Used for mocking dependencies that our classes have on another.
 */
public class MenuTest {

	static AdminMenu admin;
	
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println("Initialize Classes");
		Scanner sc = new Scanner(System.in);
		Logger logmock = mock(Logger.class);
		Account accountMock = mock(Account.class);
		when(accountMock.getUserName()).thenReturn("colin");
		admin = new AdminMenu(logmock, sc, accountMock);
	}
	
	@Test
	public void addTest() {
		try {
			admin.adminMenu();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void confrimIntYes() {
		int test = UtilityFunctions.confirmINT(new Scanner(System.in));
		System.out.println(test);
		
	}
	
	
	
}
