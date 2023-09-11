package tutorial;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JUnit5Sample1Test {
	@BeforeAll
	  static void beforeAll() {
	    System.out.println("**--- Ejecutado una vez antes que todos los métodos de prueba de esta clase. ---**");
	  }

	  @BeforeEach
	  void beforeEach() {
	    System.out.println("**--- Executed before each test method in this class ---**");
	  }

	  @Test
	  void testMethod1() {
	    System.out.println("**--- Método de prueba1 ejecutado ---**");
	  }

	  @DisplayName("Método de prueba2 con condición")
	  @Test
	  void testMethod2() {
	    System.out.println("**--- Método de prueba2 ejecutado ---**");
	  }

	  @Test
	  @Disabled("implementación pendiente")
	  void testMethod3() {
		  System.out.println("**--- Método de prueba3 ejecutado---**");
	  }

	  @AfterEach
	  void afterEach() {
	    System.out.println("**---Ejecutado después de cada método de prueba en esta clase. ---**");
	  }

	  @AfterAll
	  static void afterAll() {
	    System.out.println("**--- Ejecutado una vez después de todos los métodos de prueba en esta clase. ---**");
	  }


	@Test
	void test() {
		
	}
	@Test
	void testAssertEqual() {
		 assertEquals("ABC", "ABC");
		 assertEquals(20, 20, "optional assertion message");
		 assertEquals(2 + 2, 4);
	}

	@Test
	void testAssertFalse() {
		 assertFalse("FirstName".length() == 10);
		 assertFalse(10 > 20, "assertion message");
	}

	@Test
	void testAssertNull() {
	     String str1 = null;
		 String str2 = "abc";
		 assertNull(str1);
		 assertNotNull(str2);	
	}

	@Test
	void testAssertAll() {
		 String str1 = "abc";
		 String str2 = "pqr";
		 String str3 = "xyz";
		 assertAll("numbers",
		      () -> assertEquals(str1,"abc"),
			  () -> assertEquals(str2,"pqr"),
			  () -> assertEquals(str3,"xyz")
		 );
		 //uncomment below code and understand each assert execution
	     /*assertAll("numbers",
			  () -> assertEquals(str1,"abc"),
			  () -> assertEquals(str2,"pqr1"),
			  () -> assertEquals(str3,"xyz1")
		 );*/
	}

	/*@Test
	void testAssertTrue() {
		 assertTrue("FirstName".startsWith("F"));
		 // assertTrue(10{throw new IllegalArgumentException("Se produjo una excepción de argumento ilegal");});
		assertEquals("Se produjo una excepción de argumento ilegal", exception.getMessage());
	}*/
	@Test
	void testAssumeTrue() {
	     boolean b = 'A' == 'A';
	     assumeTrue(b);
	     assertEquals("Hello", "Hello");
	}

	@Test
	@DisplayName("test executes only on Saturday")
	public void testAssumeTrueSaturday() {
	     LocalDateTime dt = LocalDateTime.now();
	     assumeTrue(dt.getDayOfWeek().getValue() == 6);
	     System.out.println("further code will execute only if above assumption holds true");
	}
	
	

	@Test
	void testAssumeFalse() {
	     boolean b = 'A' != 'A';
	     assumeFalse(b);
	     assertEquals("Hello", "Hello");
	}

	@Test
	void testAssumeFalseEnvProp() {
	     System.setProperty("env", "prod");
	     assumeFalse("dev".equals(System.getProperty("env")));
	     System.out.println("further code will execute only if above assumption hold");
	}

	@Test
	void testAssumingThat() {
	     System.setProperty("env", "test");
	     assumingThat("test".equals(System.getProperty("env")),
	          () -> {
	               assertEquals(10, 10);
	               System.out.println("perform below assertions only on the test env");
	               });

	     assertEquals(20, 20);
	     System.out.println("perform below assertions on all env");
	}
	 @Nested
     class InnerClass {
 
          @BeforeEach
          void beforeEach() {
               System.out.println("**--- InnerClass :: beforeEach :: Executed before each test method ---**");
          }
 
          @AfterEach
          void afterEach() {
        	   System.out.println("**--- InnerClass :: afterEach :: Executed after each test method ---**");
          }
 
          @Test
          void testMethod1() {
        	   System.out.println("**--- InnerClass :: testMethod1 :: Executed test method1 ---**");
          }
 
          @Nested
          class InnerMostClass {
 
               @BeforeEach
               void beforeEach() {
                    System.out.println("**--- InnerMostClass :: beforeEach :: Executed before each test method ---**");
               }
 
               @AfterEach
               void afterEach() {
            	    System.out.println("**--- InnerMostClass :: afterEach :: Executed after each test method ---**");
               }
 
               @Test
               void testMethod2() {
            	    System.out.println("**--- InnerMostClass :: testMethod2 :: Executed test method2 ---**");
               }
        }
    }
	

}
  