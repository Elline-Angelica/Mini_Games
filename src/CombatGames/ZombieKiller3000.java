package CombatGames;

import java.util.Random;
import java.util.Scanner;

public class ZombieKiller3000 {

    public static void main(String[] args) {


        String[] backpack ={"empty slot", "Shotgun", "Assault Rifle", "Sniper"};
        String[] zombies ={"Close-range", "Mid-range", "Long-range"};

        Random rand = new Random();
        int upperbound = 3;
        int rzombie = rand.nextInt(upperbound);

        Scanner scanner = new Scanner(System.in);

        //On screen display
        System.out.println();
        System.out.println("Welcome to our zombie killing program!");
        System.out.println("Press any key to play");
        String input2 = scanner.next();

        if(input2.equals(input2)){
            System.out.println();
            System.out.println("Look out! There's a zombie approaching!"+" A " + zombies[rzombie] + " zombie is in sight!");
            System.out.println("Remember...");
            System.out.println("To kill close-range zombies you must pick a shotgun");
            System.out.println("To kill mid-range zombies you must pick an assault rifle");
            System.out.println("To kill long-range zombies you must pick a sniper");
        }

        System.out.println();
        System.out.println("Are you ready? Press any key to continue");
        String input3 = scanner.next();


        //On screen options
        if(input3.equals(input3)) {

            System.out.println("Choose your weapon!");
            System.out.println("Press 1 for a shotgun, 2 for an assault rifle or 3 for a sniper");

            int input = scanner.nextInt();
            if(input == (rzombie+1)){
                System.out.println("Hooray you live!");
                System.out.println("You chose: " + backpack[input]);
                System.out.println(" *dead zombie sounds* ");
            } else {
                System.out.println("Wrong choice! Game over.");
                System.out.println("You chose: " + backpack[input] + ", in stead of " + backpack[rzombie+1]);
                System.out.println("You've been eaten by the zombie! Loser..");
            }
        }



    }

}
