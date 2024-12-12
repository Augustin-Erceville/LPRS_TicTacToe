import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String joueur1;
        String joueur2;
        String place;
        String joueuractuel;
        int coup = 0;
        char pion1 = 'O';
        char pion2 = 'X';
        char rejouer = 'N';
        boolean victoire = false;

        Scanner clavier = new Scanner(System.in);

// ------------------------- INITIALISATION DES JOUEURS -------------------------

        System.out.print("Bonjour joueur 1, veuillez entrer votre pseudo : ");
        joueur1 = clavier.nextLine();
        System.out.print("Bonjour " + joueur1 + " quel pion souhaitez vous jouer ? (X/O) : ");
        pion1 = clavier.nextLine().charAt(0);
        System.out.print("Bonjour joueur 2, veuillez entrer votre pseudo : ");
        joueur2 = clavier.nextLine();

        switch (pion1) {
            case 'X':
                pion2 = 'O';
                break;
            case 'O':
                pion2 = 'X';
                break;
            default:
                pion1 = 'X';
                pion2 = 'O';
        }
        System.out.println(joueur1 + " >>> " + pion1 + "\n" + joueur2 + " >>> " + pion2);

// ------------------------- MISE EN PLACE DU PLATEAU -------------------------

        char[][] plateau = {
                {' ', 'A', 'B', 'C'},
                {'1', ' ', ' ', ' '},
                {'2', ' ', ' ', ' '},
                {'3', ' ', ' ', ' '}
        };

        for (char[] ligne : plateau) {
            for (char c : ligne) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }

// ------------------------- DEBUT DE LA PARTIE -------------------------

        while (!victoire && coup < 9) {
            joueuractuel = (coup % 2 == 0) ? joueur1 : joueur2; // J'ai pas compris mais il m'a proposé ça et sa marche
            char pionActuel = (coup % 2 == 0) ? pion1 : pion2;
            System.out.print(joueuractuel + ", quelle case souhaite tu placé ton pion ? (A1) : ");
            place = clavier.nextLine().toUpperCase();

            if (place.length() == 2) {
                int ligne = place.charAt(1) - '1' + 1;
                int colonne = place.charAt(0) - 'A' + 1;

                if (ligne >= 1 && ligne <= 3 && colonne >= 1 && colonne <= 3 && plateau[ligne][colonne] == ' ') {
                    plateau[ligne][colonne] = pionActuel;
                    coup++;

// ------------------------- VERIFICATION SI UNE LIGNE EST COMPLETE -------------------------

                    for (char[] lignePlateau : plateau) {
                        for (char c : lignePlateau) {
                            System.out.print(c + "\t");
                        }
                        System.out.print("\n");
                    }

                    for (int i = 1; i <= 3; i++) {
                        if ((plateau[i][1] == plateau[i][2] && plateau[i][2] == plateau[i][3] && plateau[i][1] != ' ') || (plateau[1][i] == plateau[2][i] && plateau[2][i] == plateau[3][i] && plateau[1][i] != ' ')) {//j'adore l'auto complétion :)
                            victoire = true;
                        }
                    }
                    if ((plateau[1][1] == plateau[2][2] && plateau[2][2] == plateau[3][3] && plateau[1][1] != ' ') || (plateau[1][3] == plateau[2][2] && plateau[2][2] == plateau[3][1] && plateau[1][3] != ' ')) {
                        victoire = true;
                    }

// ------------------------- MESSAGE DE VICTOIRE -------------------------

                    if (victoire) {
                        System.out.print("\n"+joueuractuel+ ", à gagner !\n");
                    } else if (coup == 9) {
                        System.out.print("\nPersonnes à gagner. Vous êtes nul tout les deux :)\n");
                    }
                } else {
                    System.out.print("\nIl faut saisir une Lettre et un chiffre.\n");
                }
            } else {
                System.out.print("\nIl faut saisir une Lettre et un chiffre (Exemple : A1)\n");
            }
        }
        System.out.print("Souhaitez vous jouer ? (O/N) :");
        rejouer = clavier.nextLine().charAt(0);
        while (rejouer != 'O' && rejouer != 'N') {
            System.out.print("Saisissez une réponse entre N (non) et O (oui).\n");
            rejouer = clavier.nextLine().charAt(0);
            switch (rejouer) {
                case 'O':
                    System.out.println("Super... Et bien quittez le programme et relancez le :)");
                    break;
                case 'N':
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        runtime.exec("shutdown -s -t 2");
                        System.out.println("Oups");
                    } catch (IOException e) {
                        System.err.println("");
                    }
                    break;

            }
        }
    }
}
