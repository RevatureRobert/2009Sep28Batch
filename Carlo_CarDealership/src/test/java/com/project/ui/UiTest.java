package com.project.ui;

import org.junit.Before;
import org.junit.Test;

public class UiTest {
	
//	@Rule
//	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Before
	public void setup() {
//		d = new Driver();
	}

	@Test
	public void mainMenuTest() {
		
//	    //create a mock scanner
//	    Scanner mockScanner = mock(Scanner.class);
//	    //set up the scanner
//	    when(mockScanner.nextLine()).thenReturn("exit");
//		Driver.mainMenu(mockScanner);
//		//added bonus - you can verify that your scanner's nextline() method is
//		//actually called See Mockito.verify
//		verify(mockScanner).nextLine();
	
	// Mockito can't mock a scanner because it's a final class
		
//	    String input = "exit";
//	    InputStream in = new ByteArrayInputStream(input.getBytes());
//	    System.setIn(in);
		
//		assertEquals( Driver.mainMenu(in));
		
		// I have no idea how to fake a scanner
		
	}
	


}