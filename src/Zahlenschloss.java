import java.util.Scanner;

public class Zahlenschloss {


    public static void main(String[] args) {

        int geheimZahl = 374;
        int anzahlVersuche = 0;

        Scanner eingabe = new Scanner(System.in);

        while (true) {
            System.out.print("Bitte Tipp für Geheimzahl eingeben (0 für Abbruch): ");
            int zahl = eingabe.nextInt();

            if (zahl == 0) {
                System.out.println("Schade. Viel Erfolg beim nächsten Mal");
                meldeAnzahlVersuche(anzahlVersuche);
                meldeAnzahlVersuche(anzahlVersuche);
                break;
            }

            anzahlVersuche++;
            if (zahl == geheimZahl) {
                System.out.println("Super. Das ist die richtige Zahl!");
                meldeAnzahlVersuche(anzahlVersuche);
                break;
            }
            else {
                System.out.println("Leider falsch.");
            }
        }
    }

    private static void meldeAnzahlVersuche(int anzahlVersuche) {
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
        anzahlVersuche += 10; // Faulenzer für: anzahlVersuche = anzahlVersuche + 10
        System.out.println("Das ist der neue Wert von anzahlVersuche: " + anzahlVersuche);
    }


}
