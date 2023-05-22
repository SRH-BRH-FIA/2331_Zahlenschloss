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

        int geheimZahl = findeZufälligeZahl();
        int anzahlVersuche = 0;

        Scanner eingabe = new Scanner(System.in);
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

    private static int findeZufälligeZahl() {
        int geheimeZahl;
        do {
            geheimeZahl = (int) (Math.random() * 900 + 100);
        } while ( ! geheimeZahlIstInOrdnung(geheimeZahl) );
        return geheimeZahl;
    }

    private static boolean geheimeZahlIstInOrdnung(int geheimeZahl) {
        int anzahlUnterschiedlicherZiffern = 0;
        for (int ziffer=0; ziffer<=9; ziffer++) {
            if ( zifferInGeheimerZahlVorhanden(ziffer, geheimeZahl) ) {
                anzahlUnterschiedlicherZiffern++;
            }
        }
        return (anzahlUnterschiedlicherZiffern == 3);
    }

    private static void meldeAnzahlVersuche(int anzahlVersuche) {
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }


}
