package testeodeclases;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import juegocraps.FasePunto;
import juegocraps.FaseSalida;
import juegocraps.JuegoCraps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

class FasePuntoTest {

	private static FasePunto fpunto;
	private static FaseSalida fsalida;
	
	@BeforeAll
	static void init() {
        fpunto = new FasePunto ();
        fsalida = new FaseSalida();
	}

    
    @ParameterizedTest
    @CsvSource({
            "7,4,1",// pierdo 1 vez
            "4,4,0"// no pierdo
    })
    public void testContPierdeFasePunto(int dados , int puntoFase, int cantEsperada) {
        fpunto = new FasePunto ();
        fsalida.setMiPunto(puntoFase);
    	fpunto.setDados(dados);
    	fpunto.fasePunto();
    	fpunto.setPunto(puntoFase);
    	int contPierdeFasePunto = fpunto.getContPierdeFasePunto();
    	assertEquals( cantEsperada , contPierdeFasePunto );
    	
    }
    @ParameterizedTest
    @CsvSource({
            "4,4,1",//gana 1 vez
            "7,5,0"// no gano
    })
    public void testContGanaFasePunto(int dados , int puntoFase, int cantEsperada) {
        fpunto = new FasePunto ();
        fpunto.setPunto(puntoFase);
    	fpunto.setDados(dados);
    	fpunto.fasePunto();
    	int contGanaFasePunto = fpunto.getContGanaFasePunto();
    	assertEquals( cantEsperada , contGanaFasePunto );
    }
    
    @ParameterizedTest
    @CsvSource({
            "PIERDE,7,4",
            "GANO,4,4",
            "CONTINUA,4,5"
    })

    public void testFasePunto (String estadoEsperado , int dados, int mipunto) {
    	fsalida.setMiPunto(mipunto);
        fpunto.setPunto(fsalida.getMiPunto());
        fpunto.setDados ( dados );
        fpunto.fasePunto ();
        String resulFuncion = JuegoCraps.estadoJuego;
        assertEquals ( estadoEsperado , resulFuncion );
    }
    
    
    
    @AfterAll
	static void TearDown() {} 
}
