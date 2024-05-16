package entities;

public class GoblinChief extends Monster {
    private String name = "Chefe Goblin";
    private int life = 150;
    private int experience = 60;

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
            return (int) Math.ceil(10 + Math.random() * 12);
        }
    }
    public int dropGold() {
        return 6 + (int) Math.ceil(Math.random() * 24);
    }
    public void takeDamage(int damage) {
        life = damage > life ? 0 : life - damage;
    }

}
