import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {



    public static void main(String[] args) {
        nactiZavazadlo();
    }
    public static void nactiZavazadlo(){
        String nazevSouboru = "vstup";
        List<Zavazadlo> seznam = new ArrayList<>();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("nazevSouboru")))){
            while(scanner.hasNextLine()){
                String radek = scanner.nextLine();
                String[] rozdelovac = radek.split("/");
                Integer identifikacniCislo = Integer.parseInt(rozdelovac[0]);
                Double hmotnost = Double.parseDouble(rozdelovac[1]);
                Zavazadlo zavazadlo = new Zavazadlo(identifikacniCislo,hmotnost);
                seznam.add(zavazadlo);
            }
        } catch (FileNotFoundException e) {

            throw new RuntimeException("Soubor nebyl nalezen: "+nazevSouboru+e.getLocalizedMessage());// nemůžeš tam dát vstup musíš tan dát atribut
        }
    }
}