import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tamaño de la fila: ");
        int n = scanner.nextInt();
        
        System.out.print("Tamaño de la columna: ");
        int col = scanner.nextInt();

        if(n != col){
            System.out.println("No es una matiz cuadrada, no se puede bro");
        } else {
            int[][] cuadro = new int[n][n];
            System.out.println("Ingresa los valores del cuadro mágico:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("Ingresa el valor de [" + (i) + "], [" + (j) + "]: ");
                    cuadro[i][j] = scanner.nextInt();
                }
            }
    
            int primerSuma = 0;
            for (int j = 0; j < n; j++) {
                primerSuma += cuadro[0][j];
            }
    
            boolean esCuadroMagico = true;
            for (int i = 0; i < n; i++) {
                int sumaFila = 0;
                int sumaColumna = 0;
                for (int j = 0; j < n; j++) {
                    sumaFila += cuadro[i][j];
                    sumaColumna += cuadro[j][i];
                }
                if (sumaFila != primerSuma || sumaColumna != primerSuma) {
                    esCuadroMagico = false;
                    break;
                }
            }

            int sumaDiagonalPrincipal = 0;
            for (int i = 0; i < n; i++) {
                sumaDiagonalPrincipal += cuadro[i][i];
            }
            if (sumaDiagonalPrincipal != primerSuma) {
                esCuadroMagico = false;
            }
    
            // Verificar la suma de la diagonal secundaria
            int sumaDiagonalSecundaria = 0;
            for (int i = 0; i < n; i++) {
                sumaDiagonalSecundaria += cuadro[i][n - 1 - i];
            }
            if (sumaDiagonalSecundaria != primerSuma) {
                esCuadroMagico = false;
            }

            
            System.out.println("------------------");
            System.out.println("La matriz: ");
            for (int i = 0; i < cuadro.length; i++) {
                for (int j = 0; j < cuadro[0].length; j++) {
                    System.out.print("["+ cuadro[i][j]+"]" + "   ");
                }
                System.out.println();
            }
            if (esCuadroMagico) {
                System.out.println("Es un cuadro mágico y su constante es: " + primerSuma);
            } else {
                System.out.println("No es un cuadro mágico.");
            }
    
            scanner.close();
        
    }
    }
}