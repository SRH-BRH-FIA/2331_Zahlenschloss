import java.util.Scanner;

public class Zahlenschloss {

    public static void main(String[] args) {

        int geheimZahl = findeZufälligeZahl();
        int anzahlVersuche = 0;

        Scanner eingabe = new Scanner(System.in);

        // Achtung, Spoiler, im fertigen Programm wieder entfernen!!
        System.out.println("GEHEIME ZAHL = " + geheimZahl);
        while (true) {
            System.out.print("Bitte Tipp für Geheimzahl eingeben (0 für Abbruch): ");
            int zahl = eingabe.nextInt();

            if (zahl == 0) {
                System.out.println("Schade. Die gesuchte Zahl war " + geheimZahl +
                        ". Viel Erfolg beim nächsten Mal");
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
                zeigeZiffernTips(geheimZahl, zahl);
            }
        }
    }

    private static void zeigeZiffernTips(int geheimZahl, int tipp) {
        int anzahlKorrekterZiffern = 0;
        int anzahlVorhandenerZiffern = 0;
        int kopieDerGeheimenZahl = geheimZahl;
        while (tipp > 0) {
            int zifferDerGeheimenZahl = geheimZahl % 10;
            int zifferVomTipp         = tipp % 10;
            if (zifferDerGeheimenZahl == zifferVomTipp)
                anzahlKorrekterZiffern++;
            else if ( zifferInGeheimerZahlVorhanden(zifferVomTipp, kopieDerGeheimenZahl) )
                anzahlVorhandenerZiffern++;
            geheimZahl /= 10;
            tipp /= 10;
        }
        System.out.println(anzahlKorrekterZiffern + " korrekte Ziffer(n)");
    }

    private static int findeZufälligeZahl() {
        return (int)(Math.random() * 900 + 100);
    }

    private static void meldeAnzahlVersuche(int anzahlVersuche) {
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }


}
