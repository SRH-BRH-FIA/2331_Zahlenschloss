import java.util.Scanner;

public class Zahlenschloss {

    public static void main(String[] args) {

        /*
         Testfälle für die Methode zum Überprüfen der geheimen Zahl

        System.out.println("Ausnahmeszenario - Testen einer Methode");
        System.out.println( geheimeZahlIstInOrdnung(123) );
        System.out.println( geheimeZahlIstInOrdnung(465) );
        System.out.println( geheimeZahlIstInOrdnung(663) );
        System.out.println( geheimeZahlIstInOrdnung(120) );
        */

        Scanner eingabe = new Scanner(System.in);

        char schwierigkeitsgrad = 'L';
        System.out.println("Mastermind mit Zahlen! v1.0");
        do {
            System.out.print("Bitte wählen Sie Ihren Schwierigkeitsgrad (L, M, S): ");
            schwierigkeitsgrad = eingabe.nextLine().toUpperCase().charAt(0);
        } while (schwierigkeitsgrad != 'L' & schwierigkeitsgrad != 'M' & schwierigkeitsgrad != 'S');

        int anzahlZiffern = 3;
        if (schwierigkeitsgrad == 'L') {
            anzahlZiffern = 3;
        }
        else if (schwierigkeitsgrad == 'M') {
            anzahlZiffern = 5;
        }
        else {
            anzahlZiffern = 7;
        }

        int anzahlVersuche = 0;
        int geheimZahl = findeZufälligeZahl(anzahlZiffern);

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
        System.out.println(anzahlVorhandenerZiffern + " vorhandene Ziffer(n)");
    }

    private static boolean zifferInGeheimerZahlVorhanden(int ziffer, int geheimeZahl) {
        while (geheimeZahl > 0) {
            int zifferDerGeheimenZahl = geheimeZahl % 10;
            if (ziffer == zifferDerGeheimenZahl) {
                return true;
            }
            geheimeZahl /= 10;
        }
        return false;
    }

    private static int findeZufälligeZahl(int anzahlZiffern) {
        int geheimeZahl;
        int startwert    = (int)Math.pow(10, anzahlZiffern-1);
        int wertebereich = (int)Math.pow(10, anzahlZiffern) - startwert;
        do {
            geheimeZahl = (int) (Math.random() * wertebereich + startwert);
        } while ( ! geheimeZahlIstInOrdnung(geheimeZahl, anzahlZiffern) );
        return geheimeZahl;
    }

    private static boolean geheimeZahlIstInOrdnung(int geheimeZahl, int anzahlZiffern) {
        int anzahlUnterschiedlicherZiffern = 0;
        for (int ziffer=0; ziffer<=9; ziffer++) {
            if ( zifferInGeheimerZahlVorhanden(ziffer, geheimeZahl) ) {
                anzahlUnterschiedlicherZiffern++;
            }
        }
        return (anzahlUnterschiedlicherZiffern == anzahlZiffern);
    }

    private static void meldeAnzahlVersuche(int anzahlVersuche) {
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }


}
