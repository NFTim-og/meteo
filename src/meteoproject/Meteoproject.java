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
    Scanner scanner = new Scanner(System.in);
    System.out.print("Introduïu el codi de l'estació: ");
    String codiEstacio = scanner.nextLine();
    if (estacioExisteix(estacions, codiEstacio)) {
        System.out.println("L'estació amb aquest codi ja existeix.");
        return;
    }
    System.out.print("Introduïu el nom de l'estació: ");
    String nomEstacio = scanner.nextLine();
    System.out.print("Introduïu el nom del municipi: ");
    String nomMunicipi = scanner.nextLine();
    System.out.print("Introduïu el codi de la comarca: ");
    int codiComarca = scanner.nextInt();
    scanner.nextLine(); // consume the newline
    System.out.print("Introduïu el codi de la província: ");
    int codiProvincia = scanner.nextInt();
    scanner.nextLine(); // consume the newline
    System.out.print("Introduïu el nom de l'estat: ");
    String nomEstat = scanner.nextLine();
    System.out.print("Introduïu la data d'alta (dd/mm/yyyy): ");
    String dataAlta = scanner.nextLine();
    System.out.print("Introduïu la data de baixa (dd/mm/yyyy): ");
    String dataBaixa = scanner.nextLine();

    Estacio novaEstacio = new Estacio(codiEstacio, nomEstacio, nomMunicipi, codiComarca, codiProvincia, nomEstat, dataAlta, dataBaixa);
    estacions.add(novaEstacio);

    System.out.println("Estació afegida correctament.");
    }
    
    private static boolean estacioExisteix(ArrayList<Estacio> estacions, int codiEstacio) {
        for (Estacio estacio : estacions) {
            if (estacio.getCodiEstacio() == codiEstacio) {
                return true;
            }
        }
        return false;
    }

    private static void llistarEstacions(ArrayList<Estacio> estacions) {
        System.out.println("\tCODI\tNOM ESTACIÓ\tNOM COMARCA\tNOM PROVINCIA\tDATA ALTA");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        for (Estacio estacio : estacions) {
            System.out.println("\t" + estacio.getCodiEstacio() + "\t" + estacio.getNomEstacio() + "\t" + estacio.getNomComarca() + "\t" + estacio.getNomProvincia() + "\t" + estacio.getDataAlta());
        }
    }

    private static void llistarComarques(ArrayList<Comarca> comarques) {
        System.out.println("\tCODI\tNOM");
        System.out.println("-------------------");
        for (Comarca comarca : comarques) {
            System.out.println("\t" + comarca.getCodi() + "\t" + comarca.getNom());
        }
    }

    private static void llistarVariables(ArrayList<Variable> variables) {
        // Implementar la funció per llistar les variables
    }

    private static void dadesEstacio(ArrayList<Estacio> estacions) {
        System.out.println("\tCODI EST.\tNOM EST.\tNOM COMARCA\tCODI VAR\tNOM VARIABLE\tVALOR LECT.\tUNITATS VAR\tDATA LECT.");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        for (Estacio estacio : estacions) {
            System.out.println("\t" + estacio.getCodiEstacio() + "\t" + estacio.getNomEstacio() + "\t" + estacio.getNomComarca() + "\t" + estacio.getCodiVar() + "\t" + estacio.getCodiProvincia() + "\t" + estacio.getNomEstat() + "\t" + estacio.getDataAlta() + "\t" + estacio.getDataBaixa());
        }
    }

    private static void dadesComarca(ArrayList<Comarca> comarques) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduïu el codi de la comarca: ");
        int codiComarca = scanner.nextInt();
        Comarca comarca = null;
        for (Comarca c : comarques) {
            if (c.getCodi() == codiComarca) {
                comarca = c;
                break;
            }
        }
        if (comarca != null) {
            System.out.println("CODI\tNOM");
            System.out.println("-------------------");
            System.out.println(comarca.getCodi() + "\t" + comarca.getNom());
        } else {
            System.out.println("No s'ha trobat la comarca amb el codi " + codiComarca);
        }
    }
    
    public static void escriureAFitxer(ArrayList<Estacio> estacions, String nomFitxer) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(nomFitxer, "rw");
        for (Estacio e : estacions) {
            raf.writeInt(e.getCodi());
            raf.writeUTF(e.getNom());
            raf.writeUTF(e.getMunicipi());
            raf.writeInt(e.getCodiComarca());
            raf.writeInt(e.getCodiProvincia());
            raf.writeUTF(e.getEstat());
            raf.writeUTF(e.getDataAlta());
            raf.writeUTF(e.getDataBaixa());
        }
        raf.close();
    }

    public static ArrayList<Estacio> carregarEstacionsDesdeFitxer(String nomFitxer) throws IOException {
    }

    public static void escriureAFitxer(ArrayList<Comarca> comarques, String nomFitxer) throws IOException {
    }

    public static ArrayList<Comarca> carregarComarquesDesdeFitxer(String nomFitxer) throws IOException {
    }

    public static void escriureAFitxer(ArrayList<Variable> variables, String nomFitxer) throws IOException {
    }

    public static ArrayList<Variable> carregarVariablesDesdeFitxer(String nomFitxer) throws IOException {
    }
    }