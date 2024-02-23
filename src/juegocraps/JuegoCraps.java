package juegocraps;
import java.util.Scanner;
/**
 * @author Andrés Bravo - Sayuri Reyes
 * @version Beta 1.0.1
 */
public class JuegoCraps {
	// <-- [ Atributos ]-->
	public static Scanner lector = new Scanner ( System.in );
    public static String estadoJuego = " ";
    private static Apuestas a1;
    private static Dados d1;
    private static Menu m1;
    private static FaseSalida fsalida;
    private static FasePunto fpunto;
    // <-- [ Constructores ]-->
    public JuegoCraps(){}
    /**
     * Función principal que ejecuta el juego
     * Pendiente de controlar errores y realizar más tests
     */
    public static void main ( String[] args ) {
        // inicializamos variables
    	d1 = new Dados ();
        char opEscogida;
        do {
            m1 = new Menu ();
            fsalida = new FaseSalida ();
            fpunto = new FasePunto ();
            int contGanaFasePunto = 0;
            int contPierdeFasePunto = 0;
            int contPierdeFaseSalida = 0;
            int contFaseSalida =0;
            int totalApostado = 0;
            int totalPerdido = 0;
            System.out.print ( "¿Cuantos números quieres apostar? = " );
            int apuLeidas = lector.nextInt();
            int errorApuesta = m1.menu(apuLeidas);
            while (errorApuesta == -1) {
            	System.out.println("Tienes que ingresar al menos 1 apuesta.");
            	System.out.print("Vuelve a ingresar una cantidad de apuestas válidas = ");
            	apuLeidas = lector.nextInt();
            	errorApuesta = m1.menu(apuLeidas);
            }
            int cantApuestas = m1.getApuestas ();
            a1 = new Apuestas (cantApuestas);
            a1.setCantApuestas ( m1.getApuestas () );
            for ( int i = 0 ; i < a1.getApuestas ().length ; i++ ) {
                System.out.print ( " Ingresa en número que quieres apostar = " );
                int n = lector.nextInt ();
                int flagErr = a1.numerosApostados ( n ) ;
                if (flagErr == 0) {
                	a1.getApuestas ()[i] = n;	
                } 
                while (flagErr == -1) {
                    System.out.println ("No puedes apostar por ese número.");
                    System.out.print("vuelve a ingresar otro = ");
                    int n2 = lector.nextInt ();
                	a1.getApuestas ()[i] = n2;	
                    flagErr = a1.numerosApostados ( n2 ) ;
                }
            }
            for ( int i = 0 ; i < a1.getApuestas ().length ; i++) {
                int numApostado = a1.getApuestas ()[i];
                // Fase de salida
                System.out.printf ( "--> Fase de Salida: Número apostado [%d] <--%n" , numApostado );
                int tiradaDados = d1.tirarDados ();// primera tirada de dados
                estadoJuego = fsalida.faseDeSalida ( tiradaDados , numApostado );
                if (( estadoJuego.equals ( "GANO" ) && (numApostado != tiradaDados ))){
                    System.out.printf ( "Como no apostaste por el %d, no te llevas la apuesta...%n" , tiradaDados );
                } else if ( estadoJuego.equals ( "GANO" )){
                    System.out.printf ( "\u001B[34m¡Enhorabuena, has ganAdo en la fase de salida!.\u001B[0m%n" );
                }
                
                if ( estadoJuego.equals ( "PIERDE" ) ){
                    System.out.printf ( "\u001B[31m¡Craaaaaaps! Has perdido en la fase de salida.\u001B[0m%n" );
                }
                while ( estadoJuego.equals ( "CONTINUA" ) ){
                    //f2.setDados ( d1.tirarDados () );
                	fpunto.setDados(d1.tirarDados());
                    fpunto.setPunto ( fsalida.getMiPunto () );
                    // fase de punto
                    fpunto.fasePunto ();
                    if ( estadoJuego.equals ( "PIERDE" ) ){
                        System.out.printf ( "\u001B[31mHas perdido en la fase de punto.%n\u001B[0m" );
                    }
                    if ( estadoJuego.equals ( "GANO" ) ){
                        System.out.printf ( "\u001B[33m¡Enhorabuena!, has ganado el punto.%n\u001B[0m" );
                    }

                    contPierdeFasePunto = fpunto.getContPierdeFasePunto ();
                    contGanaFasePunto = fpunto.getContGanaFasePunto();
                }
                contFaseSalida = fsalida.getContFaseSalida ();
                contPierdeFaseSalida = fsalida.getContPierde ();
            }// fin-for int apuestas[]
            totalApostado = (contFaseSalida * 10) + (contGanaFasePunto * 3);
            totalPerdido = contPierdeFasePunto + contPierdeFaseSalida;
            System.out.printf ( "Has apostado en total %d€.%n" , cantApuestas );
            if ( contFaseSalida == 1 ){
                System.out.printf ( "En la fase de salida has ganado %d vez.%n" , contFaseSalida );
            } else {
            	System.out.printf ( "En la fase de salida has ganado %d veces.%n" , contFaseSalida );
            }
            if ( contGanaFasePunto == 1 ){
                System.out.printf ( "En la fase de punto has ganado %d vez.%n" , contGanaFasePunto );
            } else {
                System.out.printf ( "En la fase de punto has ganado %d veces.%n" , contGanaFasePunto );
            }
            if (totalPerdido == 1 ){
                System.out.printf ( "Has perdido %d vez.%n" , totalPerdido );
            }else {
                System.out.printf ( "Has perdido %d veces.%n" , totalPerdido );
            }
            System.out.printf ( "total ganado = %d€.%n" , totalApostado );
            System.out.print( "¿Quieres seguir apostando? (s/n) = " );
            opEscogida = lector.next ().charAt ( 0 );
            opEscogida = Character.toLowerCase ( opEscogida );
        } while ( opEscogida == 's' );
    }// fin main
}// fin-class JuegoCraps
