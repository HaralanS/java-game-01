package entities;

public class Monster {
    private String name;
    private double life;
    private int experience;

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
            return (int) Math.ceil(5 + Math.random() * 5);
        } else {
            return (int) Math.ceil(7 + Math.random() * 8);
        }
    }
    public int dropGold() {
        return 2 + (int) Math.ceil(Math.random() * 5);
    }
    public void takeDamage(int damage) {
        life = damage > life ? 0 : life - damage;
    }

}
