package entities;

public class Dragon extends Monster {
    private String name = "Dragao";
    private int life = 250;
    private int experience = 100;

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
        if (monsterLuck < 6){
            System.out.println("Golpe certeiro!");
            return (int) Math.ceil(12 + Math.random() * 12);
        } else if (monsterLuck < 8) {
            System.out.println("GOLPE CRITICO!");
            return (int) Math.ceil(18 + Math.random() * 19);
        } else {
            System.out.println("--> FOGO DO DRAGAO! <--");
            return (int) Math.ceil(40 + Math.random() * 30);
        }
    }
    public int dropGold() {
        return 15 + (int) Math.ceil(Math.random() * 40);
    }
    public void takeDamage(int damage) {
        life = damage > life ? 0 : life - damage;
    }

}
