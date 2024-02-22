package juegocraps;

public class FasePunto {
	// atributos
    private int contGanaFasePunto = 0;
    private int contPierdeFasePunto = 0;
    private int punto;
    private int dados;// commit
    // setters y getters
    public int getContPierdeFasePunto () {
        return contPierdeFasePunto;
    }
    public void setPunto ( int puntoUsr ) {
        punto = puntoUsr;
    }
    
    public void setDados ( int dadosUsr ) {
        dados = dadosUsr;
    }
        
    public int getContGanaFasePunto() {
		return contGanaFasePunto;
	}
	
	// contrusctores
    public FasePunto ( ) {}
    // metodos de la clase
    
    /**
     * Método que controla la fase de punto del juego
     */
    public void fasePunto () {
    	if ( dados == 7 ) {
            JuegoCraps.estadoJuego = "PIERDE";
            contPierdeFasePunto++;
        }else if ( dados != punto ) {
            JuegoCraps.estadoJuego = "CONTINUA";
        }else {
            JuegoCraps.estadoJuego = "GANO";
            contGanaFasePunto++;
        }
        
    }// fin fasePunto
}// fin-class FasePunto