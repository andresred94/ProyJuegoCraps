package testeodeclases;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import juegocraps.Apuestas;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

class ApuestasTest {

	private static Apuestas a1;
	
	@BeforeAll
	static void init() {
		a1 = new Apuestas ();
	}
	
    @ParameterizedTest
    @CsvSource({
            "1,1,-1",
            "2,1,-1",
            "3,1,-1",
            "12,1,-1",
            "7,1,0",
            "4,1,0"})
    void testNumerosApostados ( int numIngresado , int cantApu ,  int flagResultado ) {
    	a1 = new Apuestas (cantApu);
        int flagEsperado = a1.numerosApostados ( numIngresado );
        int [] arrEsperado = {numIngresado};
        a1.setApuestas ( arrEsperado );
        a1.setCantApuestas ( 3 );
        System.out.println ( Arrays.toString ( a1.getApuestas () ) );
        assertEquals(flagEsperado, flagResultado);
    }
    @AfterAll
	static void TearDown() {} 

}
