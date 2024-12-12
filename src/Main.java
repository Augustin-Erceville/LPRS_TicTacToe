import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String joueur1;
        String joueur2;
        char  pion1 = 'O';
        char pion2 = 'X';

        Scanner clavier = new Scanner(System.in);
        System.out.print("Bonjour joueur 1, veuillez entrer votre pseudo : ");
        joueur1 = clavier.nextLine();
        System.out.print("Bonjour "+joueur1+" quel pion souhaitez vous jouer ? (X/O) : ");
        pion1 = clavier.nextLine().charAt(0);
        System.out.print("Bonjour joueur 2, veuillez entrer votre pseudo : ");
        joueur2 = clavier.nextLine();

        switch (pion1) {
            case 'X':
                pion1 = 'X';
                pion2 = 'O';
                break;
            case 'O':
                pion1 = 'O';
                pion2 = 'X';
                break;
            default:
                pion1 = 'X';
                pion2 = 'O';
        }
        System.out.print(joueur1+" >>> "+pion1+"\n"+joueur2+" >>> "+pion2+"\n");

        String[][] plateau = new String[3][3];

        plateau = new String[][]{
                {" ", "A", "B", "C"},
                {"1", " ", " ", " "},
                {"2", " ", " ", " "},
                {"3", " ", " ", " "},
        };

        for (String[] tab: plateau) {
            for (String s: tab) {
                System.out.print(s + "\t");
            }
            System.out.println("\n");
        }
    }
}