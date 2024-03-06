package meteoproject;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import variables.Variable;
import variables.VariableIO;
import comarques.Comarca;
import comarques.ComarcaIO;
import estacions.Estacio;
import estacions.EstacioIO;
import dadesMeteo.DadaMeteo;
import dadesMeteo.DadaMeteoIO;

public class Meteoproject {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Estacio> estacions = new ArrayList<>();
        ArrayList<Comarca> comarques = new ArrayList<>();
        ArrayList<Variable> variables = new ArrayList<>();

        try {
            estacions = EstacioIO.carregarEstacions();
            comarques = ComarcaIO.carregarComarques();
            variables = VariableIO.carregarVariables();
        } catch (IOException e) {
            System.out.println("Error al carregar les dades: " + e.getMessage());
        }

        while (true) {
            mostrarOpcions();
            int opcio = llegeixOpcio();
            switch (opcio) {
                case 1 -> afegirNovaEstacio();
                case 2 -> llistarEstacions();
                case 3 -> llistarComarques();
                case 4 -> llistarVariables();
                case 5 -> dadesEstacio();
                case 6 -> dadesComarca();
                case 7 -> {}
            }
        }
    } 
    
    static void mostrarOpcions(){
        System.out.println("B I G - M E T E O - D A T A");
        System.out.println("");
        System.out.println("1. Afegir nova estació meteorològica.");
        System.out.println("2. Llistar estacions meteorològiques.");
        System.out.println("3. Llistar comarques.");
        System.out.println("4. Llistar variables.");
        System.out.println("5. Dades d'una estació.");
        System.out.println("6. Dades d'una comarca.");
        System.out.println("7. Sortir");
        }
    
    private static int llegeixOpcio() {
        int opcio = scanner.nextInt();
        scanner.nextLine(); // Esborra el salt de línia
        return opcio;
    }
    
    private static void afegirNovaEstacio(ArrayList<Estacio> estacions) {
        // Implementar la funció per afegir una nova estació meteorològica
    }

    private static void llistarEstacions(ArrayList<Estacio> estacions) {
        // Implementar la funció per llistar les estacions meteorològiques
    }

    private static void llistarComarques(ArrayList<Comarca> comarques) {
        // Implementar la funció per llistar les comarques
    }

    private static void llistarVariables(ArrayList<Variable> variables) {
        // Implementar la funció per llistar les variables
    }

    private static void dadesEstacio(ArrayList<Estacio> estacions) {
        // Implementar la funció per obtenir les dades d'una estació
    }

    private static void dadesComarca(ArrayList<Comarca> comarques) {
        // Implementar la funció per obtenir les dades d'una comarca
    }
}