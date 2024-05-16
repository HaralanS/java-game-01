package entities;

public class Orc extends Monster {
    private String name = "Orc";
    private int life = 70;
    private int experience = 30;

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
            return (int) Math.ceil(7 + Math.random() * 7);
        } else {
            System.out.println("GOLPE CRITICO!");
            return (int) Math.ceil(9 + Math.random() * 10);

        }
    }
    public int dropGold() {
        return 3 + (int) Math.ceil(Math.random() * 15);
    }
    public void takeDamage(int damage) {
        life = damage > life ? 0 : life - damage;
    }

}
