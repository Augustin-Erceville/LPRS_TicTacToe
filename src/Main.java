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
                }
            }
        }
    }
}
