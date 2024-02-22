package juegocraps;

public class FaseSalida {
	// primer commit
	// segundo commit
	// atributos
    private int contFaseSalida = 0;
    private int contPierde = 0;
    private int miPunto;
    private String estado;// commit
    // setters y Getters
    public int getMiPunto () {
        return miPunto;
    }
    

    public void setMiPunto(int miPunto) {
		this.miPunto = miPunto;
	}

	public int getContPierde () {
        return contPierde;
    }

    public int getContFaseSalida () {
        return contFaseSalida;
    }

    // constructores
    public FaseSalida(){ }
    
    // metodos de la clase
    public String faseDeSalida (int sumCaraDados , int numFaseSalida){
        if ( sumCaraDados == 7 || sumCaraDados == 11 ) {// Si gana en la fase de salida
            estado = "GANO";
            JuegoCraps.estadoJuego = estado;
            if ( numFaseSalida == sumCaraDados ) {
                contFaseSalida++;
            }

        } else if ( sumCaraDados == 2 || sumCaraDados == 3 || sumCaraDados == 12 ) {
            estado = "PIERDE";
            JuegoCraps.estadoJuego = estado;
            contPierde++;
        } else if ( (sumCaraDados == 4 || sumCaraDados == 5 || sumCaraDados == 6 || sumCaraDados == 8 || sumCaraDados == 9 || sumCaraDados == 10) || numFaseSalida != sumCaraDados ) {
            estado = "CONTINUA";
            JuegoCraps.estadoJuego = estado;
            miPunto = sumCaraDados;
            //numFaseSalida = sumCaraDados;
            System.out.printf ( "Fase de punto: nuevo número apostado [%d].%n" , sumCaraDados );
            System.out.println ( "El punto es " + sumCaraDados );
        }
        return estado;
    }
}
