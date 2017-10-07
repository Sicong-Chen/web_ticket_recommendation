package rpc;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	@Test
	public void testSubString(){
		// String str = new String("This is a unit test.");
		String str = StringTest.getString();
		assertEquals("unit", str.substring(10, 14));
	}

//	@Test  // annotation, another Test case, an independent unit
	
	private static String getString() {
		return new String("This is a unit test!");
	}
}
