package juegocraps;
public class Menu {
	// primer commit
	// atributos
    private int apuestas = 0;

    // setters y getters
    public void setApuestas (int numApu ){
    	if ( numApu <= 0 ) {
    		apuestas = -1;
    	} else {
    		apuestas = numApu;
    	}
    }

    public int getApuestas (){return apuestas;}
    // constructores    
    public Menu(){
    	System.out.printf ( "\u001B[35m¡Bienvenido al juego de Craps!%n\u001B[0m" );// Error de sintaxis 2
        System.out.printf ( "El objetivo es predecir el resultado de dos dados lanzados.%n" );
        System.out.printf ( "El juego se divide en dos fases principales: la fase de salida y la fase de punto.%n" );
        System.out.printf ( "\u001B[32mEn la fase de salida:%n\u001B[0m" );
        System.out.printf ( " * Si obtienes 7 o un 11, se considera una \"ganancia natural\", si apostaste por uno de estos números, ganas la apuesta.%n" );
        System.out.printf ( " * Si obtienes 2, 3 o 12, esto se llama \"craps\", por lo tanto pierdes automaticamente la apuesta.%n" );
        System.out.printf ( " * Si obtienes cualquier otro número (4, 5, 6, 8, 9, o 10) , ese número se convierte en el \"punto\" y pasa a ser tu número apostado.%n" );
        System.out.printf ( "\u001B[32mEn la fase de punto:%n\u001B[0m" );
        System.out.printf ( " * En esta fase el objetivo es que el tirador vuelva a obtener el número del punto antes de obtener un 7.%n" );
        System.out.printf ( " * Si al lanzar los dados obtienes el mismo número del punto, ganas el punto y la partida.%n" );
        System.out.printf ( " * Si al lanzar los dados obtienes el 7 antes que el número del punto, pierdes la partida.%n" );
        System.out.printf ( "\u001B[36mApuestas:%n\u001B[0m" );
        System.out.printf ( " * Cuantos más números apuestes más probabilidades tendrás de ganar.%n" );
        System.out.printf ( " * Apostar por un número cuesta 1€.%n" );
        System.out.printf ( " * Si ganas en la fase de salida, se cuentan la cantidad de veces que has ganado. Y se multiplica x 10.%n" );
        System.out.printf ( " * Si ganas en la fase de punto, se cuentan la cantidad de veces. Y se multiplica x 3.%n" );
           	
    }
    // metodos de la clase
    public int menu (int numApuestas){
        setApuestas (numApuestas);
        return apuestas;
    }
}//commit
