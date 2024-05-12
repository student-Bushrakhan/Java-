import java.util.Scanner;
public class Fighter{
    private String name;
    private int health;
    private int attackPower;

    public Fighter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Fighter opponent) {
        opponent.health -= this.attackPower;
        System.out.println(this.name + " attacks " + opponent.name + " for " + this.attackPower + " damage!");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("Ali", 100, 20);
        Fighter fighter2 = new Fighter("Aisha", 120, 15);

        while (fighter1.isAlive() && fighter2.isAlive()) {
            fighter1.attack(fighter2);
            fighter2.attack(fighter1);
            System.out.println("Remaining HP: " + fighter1.name + ": " + fighter1.health + ", " + fighter2.name + ": " + fighter2.health);
        }
    
        if (fighter1.isAlive()) {
            System.out.println(fighter1.name + " wins!");
        } else {
            System.out.println(fighter2.name + " wins!");
        }
  }

}
