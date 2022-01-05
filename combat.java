// Source code written in java.

import java.util.Scanner;
import java.util.Random;

public class combat{
    public static void main(String[] args){

        // System objects
        Scanner input = new Scanner(System.in); // Input variable
        Random rand = new Random();

        // Game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 75;
        int maxAttackDamage  = 25;

        // Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //Percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        GAME:
        while(running){
            System.out.println("---------------------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " Has appeared!" + "#\n");

            while(enemyHealth > 0){
                System.out.println("\t> Your HP: " + health);
                System.out.println("\t> " + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\t What would you like to do?");
                System.out.println("\t1. Attack ");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input1 = input.nextLine();
                if(input1.equals("1")) {
                	int damageDealt = rand.nextInt(attackDamage);
                	int damageTaken = rand.nextInt(maxAttackDamage);
                	
                	// Subtract enemyHealth depending on how much damage the player does.
                	enemyHealth -= damageDealt;
                	// Subtract damage from the player depending on how much damage the enemy does.
                	health -= damageTaken;
                	
                	System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " Damage");
                	System.out.println("\t> You recived " + damageTaken + " In health" );
                	
                	if(health < 1) {
                		System.out.println("\t You have taken too much damage... You are too weak to go on");
                		break;
                	}
                }
                else if(input1.equals("2")) {
                	if(numHealthPotions > 0) {
                		health += healthPotionHealAmount;
                		numHealthPotions--;
                		System.out.println("\t> You have drinked a health potion, Healing yourself for " + healthPotionHealAmount + " ." + "\n\t> You now have " + health + " HP." + "\n\t> You have " + numHealthPotions + " Health potions left");
                	}
                	else {
                		System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get a health potion!");
                	}
                }
                else if(input1.equals("3")) {
                	System.out.println("\t> You ran away from the " + enemy + "!");
                	continue GAME;
                }
                else {
                	System.out.println("\t> Invaild command!");
                }
            }
            
            if(health < 1) {
            	System.out.println("You limp out of the place weak from battle.");
            	break;
            }
            
            System.out.println("---------------------------------------------------------------------");
            System.out.println(" # " + enemy + " Was defeated! #");
            System.out.println(" # You have  " + health + " HP left.#");
            if(rand.nextInt(100) >  healthPotionDropChance) {
            	numHealthPotions++;
            	System.out.println("The enemy droped a health potion! #");
            	System.out.println("You now have " + numHealthPotions + " Healthpotion(s). #");
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");
            
            String input2 = input.nextLine();
            
            while(!input2.equals("1") && !input2.equals("2")){
            	System.out.println("Invaild command");
            	String input_vaild = input.nextLine();
            }
            
            if(input2.equals("1")) {
            	System.out.println("You continue on your adventure!");
            	
            }
            else if(input2.equals("2")) {
            	System.out.println("You exit the dungeon sucessfully from your adventures!");
            	break;
            }
            
        }
        
        System.out.println("######################");
        System.out.println("# THANKS FOR PLAYING #");
        System.out.println("######################");

    }
}