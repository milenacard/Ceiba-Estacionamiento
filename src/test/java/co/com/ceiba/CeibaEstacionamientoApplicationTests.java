package co.com.ceiba;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CeibaEstacionamientoApplicationTests {

	@Test public void testSomeLibraryMethod() {
		CeibaEstacionamientoApplication classUnderTest = new CeibaEstacionamientoApplication();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

}
