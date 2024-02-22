package juegocraps;

public class Apuestas {
	// <-- [ Atributos ]-->
    private int[] apuestas;
    private int cantApuestas;
    // <-- [ Setters y Getters ]-->
    public int[] getApuestas () {
        return apuestas;
    }
    public void setApuestas ( int[] apuestas ) {
        this.apuestas = apuestas;
    }
    public void setCantApuestas ( int cantApuestas ) {
        this.cantApuestas = cantApuestas;
    }
    
    // <-- [ Constructores ]-->
    public Apuestas() {}
    
    public Apuestas(int numApostados){
        cantApuestas = numApostados;
        apuestas = new int[cantApuestas];
    }
    
    // <-- [ Metodos de la clase ]-->
    public int numerosApostados (int nUsr){
        int rps = 0;
        for ( int i = 0 ; i < apuestas.length ; i++ ) {
            if ( nUsr  <= 2 || nUsr == 3 || nUsr >= 12 ){
                rps = -1;
            }
        }// fin-fori
        return rps;
    }// fin numerosApostados
}// fin-class Apuestas
