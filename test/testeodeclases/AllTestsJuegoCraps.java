package testeodeclases;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ 
	FasePuntoTest.class, 
	FaseSalidaTest.class,
	DadosTest.class,
	ApuestasTest.class,
	MenuTest.class
})
public class AllTestsJuegoCraps {

}
