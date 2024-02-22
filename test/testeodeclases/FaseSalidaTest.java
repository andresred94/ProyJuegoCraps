package testeodeclases;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import juegocraps.FaseSalida;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

class FaseSalidaTest {
    private static FaseSalida f;

    @BeforeAll
	static void init() {
        f = new FaseSalida ();
	}
    
    @ParameterizedTest
    @CsvSource({
            "2,4,1",
            "3,4,1"
    })
    
    public void testContPierdeFasePunto(int dados, int numApostado, int cantEsperada) {
    	f = new FaseSalida();
    	f.faseDeSalida(dados, numApostado);
    	int contPierdeFaseSalida = f.getContPierde();
    	assertEquals(cantEsperada,contPierdeFaseSalida);
    }    
    
    @ParameterizedTest
    @CsvSource({
            "7,7,1",// gana 1 vez
            "11,11,1",
            "4,4,0"
    })
    
    public void testContGanaFasePunto(int dados, int numApostado, int cantEsperada) {
    	f = new FaseSalida();
    	f.faseDeSalida(dados, numApostado);
    	int contGanaFaseSalida = f.getContFaseSalida();
    	assertEquals(cantEsperada,contGanaFaseSalida);
    }
    
    @ParameterizedTest
    @CsvSource ({
            "7,7,GANO ",// GANA EN LA FASE DE SALIDA
            "11,11,GANO",
            "7,11,GANO",//
            "2,2,PIERDE",// PIERDE EN LA FASE DE SALIDA
            "3,5,PIERDE",
            "12,5,PIERDE",
            "4,10,CONTINUA",
            "5,9,CONTINUA",
            "6,8,CONTINUA",
            "8,6,CONTINUA",
            "9,5,CONTINUA",
            "10,4,CONTINUA",
            "1,4,CONTINUA",
            "1,1,"
         	})// CONTINUA A LA FASE DE PPUNTO

    public void testFaseDeSalida (int dados , int numApostado , String resulEsperado) {
        f = new FaseSalida ();
        String resulFuncion = f.faseDeSalida ( dados, numApostado );
        assertEquals(resulEsperado,resulFuncion);
    }
    
    @AfterAll
	static void TearDown() {} 
}