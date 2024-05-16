package entities;

public class Goblin extends Monster {
    private String name = "Goblin";
    private int life = 50;
    private int experience = 20;

    public String getName() {
        return name;
    }

    public double getLife() {
        return life;
    }

    public int getExperience() {
        return experience;
    }

    public int attack() {
        double monsterLuck = Math.random() * 10;
        if (monsterLuck < 7){
            System.out.println("Golpe certeiro!");
            return (int) Math.ceil(5 + Math.random() * 5);
        } else {
            System.out.println("GOLPE CRITICO!");
            return (int) Math.ceil(7 + Math.random() * 8);
        }
    }
    public int dropGold() {
        return 2 + (int) Math.ceil(Math.random() * 8);
    }
    public void takeDamage(int damage) {
        life = damage > life ? 0 : life - damage;
    }

}
