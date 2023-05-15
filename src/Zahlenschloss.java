import java.util.Scanner;

public class Zahlenschloss {


    public static void main(String[] args) {

        int geheimZahl = 374;

        Scanner eingabe = new Scanner(System.in);

        while (true) {
            System.out.print("Bitte Tipp für Geheimzahl eingeben: ");
            int zahl = eingabe.nextInt();

            if (zahl == 0) {
                System.out.println("Schade. Viel Erfolg beim nächsten Mal");
                break;
            }

            if (zahl == geheimZahl) {
                System.out.println("Super. Das ist die richtige Zahl!");
                break;
            }
            else {
                System.out.println("Leider falsch.");
            }
        }
    }


}
