package testeodeclases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import juegocraps.Dados;

class DadosTest {
	private static Dados d;
	
	@BeforeAll
	static void init() {
		d = new Dados();
	}
	
	@ParameterizedTest
    @CsvSource ({
    	"100", 
    	"1000", 
    	"10000"})  // ejecuciones de dados
    public void testTirarDadosMultipleTimes(int ejecuciones) {
        for (int i = 0; i < ejecuciones; i++) {
            int resultado = d.tirarDados();
            assertTrue(resultado >= 2 && resultado <= 12, "La suma de los dados debe estar entre 2 y 12");
        }
    }
	
	@AfterAll
	static void TearDown() {} 
}
