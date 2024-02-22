package testeodeclases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import juegocraps.Menu;

class MenuTest {

	private static Menu m1;
	
	@BeforeAll
	static void init() {
		m1 = new Menu();
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2,",
		"1,1",
		"0,-1",
		"-2,-1"
	})
	
	void testMenu( int cantApuestas , int esperado ){
		m1 = new Menu();
		int resulMenu = m1.menu(cantApuestas);
		resulMenu = m1.getApuestas();
		assertEquals(esperado , resulMenu);
		
	}
	
	@AfterAll
	static void TearDown() {} 

}
