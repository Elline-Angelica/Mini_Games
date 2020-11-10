package CombatGames;

import java.util.Random;
import java.util.Scanner;

public class ZombieKiller3000 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        do {
            String[] backpack = {"Shotgun", "Assault Rifle", "Sniper"};
            String[] zombies = {"Close-range", "Mid-range", "Long-range"};

            Random rand = new Random();
            int upperbound = 3;
            int rzombie = rand.nextInt(upperbound);

            //On screen display
            System.out.println();
            System.out.println("Welcome to our zombie killing program!");
            System.out.println("Press any key to play");
            String inPlay = scanner.next();

            System.out.println();
            System.out.println("Look out! There's a zombie approaching!" + " A " + zombies[rzombie] + " zombie is in sight!");

            //zombie
            System.out.println("         ____ ");
            System.out.println("        (O  0) ");
            System.out.println("        _|  |_");
            //System.out.println(    /   |   |  \ ");
            //System.out.println("  / /  |   | \ \ ");
            //System.out.println(" ('')   | |  ('') ");
            //System.out.println("       /   \ ");
            System.out.println("       _|    |_ ");

            System.out.println();
            System.out.println("Remember...");
            System.out.println("To kill close-range zombies you must pick a shotgun");
            System.out.println("To kill mid-range zombies you must pick an assault rifle");
            System.out.println("To kill long-range zombies you must pick a sniper");

            //On screen options
            System.out.println();
            System.out.println("Quick! Choose your weapon!");
            System.out.println("Press 1 for a shotgun, 2 for an assault rifle or 3 for a sniper");

            int input = scanner.nextInt();
            while (input == 1 || input == 2 || input == 3){
                if ((input - 1) == rzombie) {
                    System.out.println("Hooray you live!");
                    System.out.println("You chose: " + backpack[input - 1]);
                    System.out.println("*dead zombie sounds* ");
                    System.out.println();
                    System.out.println("    _|    |_       (x  x)  ");
                    break;

                } else {
                    System.out.println("Wrong choice! Game over.");
                    System.out.println("You chose: " + backpack[input - 1] + ", in stead of " + backpack[rzombie]);
                    System.out.println("You've been eaten by the zombie!");
                    break;
                }
            }
            System.out.println();
            System.out.println("Replay the game? Enter 'yes' ");
            choice = scanner.next();

        }while(choice.equalsIgnoreCase("yes"));
        scanner.close();

    }
}


