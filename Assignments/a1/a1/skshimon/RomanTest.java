/**
 * 
 */
package a1.skshimon;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author skshimon
 *
 */
public class RomanTest {

	private Roman testClassInstance;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testClassInstance = new Roman();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		testClassInstance = null;
	}

	/**
	 * Test method for {@link a1.skshimon.Roman#toDecimal(java.lang.String)}.
	 */
	@Test
	public void testToDecimal() {

		/**
		 * Branch Testing
		 */		
		
		try {
			/**
			 * covering branches M, D, C
			 */
			assertEquals(testClassInstance.toDecimal("MDC"),1600);
			assertEquals(testClassInstance.toDecimal("mdc"),1600);
			/**
			 * covering branches L, X, V, I
			 */
			assertEquals(testClassInstance.toDecimal("LXVI"),66);
			assertEquals(testClassInstance.toDecimal("lxvi"),66);			
			/**
			 * covering branches CM,XC,IX
			 */
			assertEquals(testClassInstance.toDecimal("CMXCIX"),999);
			assertEquals(testClassInstance.toDecimal("cmxcix"),999);
			/**
			 * covering branches CD,XL,IV
			 */
			assertEquals(testClassInstance.toDecimal("CDXLIV"),444);
			assertEquals(testClassInstance.toDecimal("cdxliv"),444);
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail(e.getMessage());
		}
		
		
		/**
		 * covering all branches for invalid roman numeral sequences
		 * CMD is invalid, MCD=1400 is valid
		 * CMC is invalid, M=1000 is valid
		 * DCD is invalid, CM = 900 is valid
		 * CDC is invalid, D = 500 is valid
		 * XCL is invalid, CXL = 140 is valid
		 * XCX is invalid, C = 100 is valid
		 * LXL is invalid, XC = 90 is valid
		 * XLX is invalid, L = 50 is valid
		 * IXV is invalid, XIV = 14 is valid
		 * IXI is invalid, X = 10 is valid
		 * VIV is invalid, IX = 9 is valid
		 * IVI is invalid, V = 5 is valid
		 * IIII is invalid, IV = 4 is valid
		 * VV is invalid, X = 10 is valid
		 * LL is invalid, C = 100 is valid
		 * DD is invalid, M = 1000 is valid
		 * XXXX is invalid, XL = 40 is valid
		 * CCCC is invalid, CD = 400 is valid 
		 */		
		String[] invalidInput = {"CMD","CMC","DCD","CDC","XCL","XCX","LXL","XLX","IXV","IXI","VIV","IVI","IIII","VV","LL","DD","XXXX","CCCC"};
		
		for(int input=0;input<invalidInput.length;input++){
			try {
				testClassInstance.toDecimal(invalidInput[input]);
				fail("InvalidNumberException not thrown for decimal input "+invalidInput[input]);
			} catch (InvalidNumberException e) {
			}			
		}
		
		
		try {
			/**
			 * Covering branches for invalid alphabet inputs
			 */				
			testClassInstance.toDecimal("XLA");
			fail("InvalidNumberException not thrown for decimal input XLA");
		} catch (InvalidNumberException e) {
		}	
		
		try {
			/**
			 * Covering branches for invalid alphabet inputs
			 */				
			testClassInstance.toDecimal("");
			fail("InvalidNumberException not thrown for decimal input XLA");
		} catch (InvalidNumberException e) {
		}	
		
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link a1.skshimon.Roman#toRoman(int)}.
	 * Doing branch coverage for the method
	 */
	@Test
	public void testToRoman() {

		/**
		 * Branch Testing
		 */		
		try {
			/**
			 * covering branches M, CM, XC, IX
			 */
			assertEquals(testClassInstance.toRoman(3999),"MMMCMXCIX");
			/**
			 * covering branches M, CM, XC, V, I
			 */
			assertEquals(testClassInstance.toRoman(3996),"MMMCMXCVI");
			/**
			 * covering branches M, CM, XC, IV
			 */
			assertEquals(testClassInstance.toRoman(3994),"MMMCMXCIV");
			/**
			 * covering branches CD, XL
			 */
			assertEquals(testClassInstance.toRoman(440),"CDXL");
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail(e.getMessage());
		}
		

		
		/**
		 * Boundary testing
		 */
	
		try {
			/**
			 * Valid Boundary Testing
			 */
			assertEquals(testClassInstance.toRoman(1),"I");
			assertEquals(testClassInstance.toRoman(4000),"MMMM");
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail(e.getMessage());
		}
		
		try {
			/**
			 * lower limit Boundary Testing
			 */
			testClassInstance.toRoman(0);
			fail("InvalidNumberException not thrown for decimal input 0");
		} catch (InvalidNumberException e) {

		}
		
		
		try {
			/**
			 * upper limit Boundary Testing
			 */
			testClassInstance.toRoman(4001);
			fail("InvalidNumberException not thrown for decimal input 4001");
		} catch (InvalidNumberException e) {
			e.printStackTrace();
		}
	}

}
