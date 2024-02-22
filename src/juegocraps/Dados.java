package juegocraps;

public class Dados {
	// Atributos
    public int sumaDeDados;

    // constructores
    public Dados() {}

    /**
     * Función que devuelve un entero que es la suma de la cara de dos dados.
     * @return entero entree 1 y 12
     */
    public int tirarDados () {
        // Error lógico 2
        int dado1 = (int) (Math.random () * 6 + 1);
        int dado2 = (int) (Math.random () * 6 + 1);
        int suma = dado1 + dado2;
        sumaDeDados = suma;
        System.out.printf ( "El tirador lanza los dados y...%n" );
        System.out.printf ( "La suma de los dados es: %d + %d = %d%n" , dado1 , dado2 , suma );
        return suma;
    }
}
