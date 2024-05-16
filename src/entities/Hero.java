package entities;

import java.util.ArrayList;

public class Hero {
//    ATRIBUTOS
    private final String name;
    private int life;
    private int mana;
    private int level;
    private int experience;
    private int gold;
    private int lifePotion;
    private int manaPotion;
    private int strength;
    private int maigcPower;
    private int maxLife;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Weapon equippedWeapon;
    private Armor equippedArmor;

//    CONSTRUTORES

    public Hero(String name ) {
        this.name = name;
        this.life = 100;
        this.mana = 50;
        this.level = 1;
        this.experience = 0;
        this.gold = 10;
        this.lifePotion = 1;
        this.manaPotion = 1;
        this.strength = 5;
        this.maigcPower = 3;
        this.maxLife = 100;
        this.equippedWeapon = new WoodenSword();
        this.equippedArmor = new LeatherArmor();
    }

//    GETTERS

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getMana() {
        return mana;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public int getLifePotion() {
        return lifePotion;
    }

    public int getManaPotion() {
        return manaPotion;
    }

    public int getStrength() {
        return strength;
    }

    public int getMaigcPower() {
        return maigcPower;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    //    METODOS
    public int attack(){
        double heroLuck = Math.random() * 10;
        if (heroLuck < 1) {
            System.out.println("Errou!");
            return 0;
        } else if (heroLuck < 7){
            System.out.println("Golpe certeiro!");
            return (int) Math.ceil((strength + equippedWeapon.getAttack()) + equippedWeapon.getAttack() * Math.random() * 1.5);
        } else {
            System.out.println("GOLPE CRITICO!");
            return (int) Math.ceil((strength + equippedWeapon.getAttack()) + equippedWeapon.getAttack() * Math.random() * 1.5) * 2;
        }

    }
    public int magicAttack(){
        double heroLuck = Math.random() * 10;

        mana -= 10;
        if (heroLuck < 7){
            return (int) (strength + maigcPower + Math.random() * (strength + maigcPower));
        } else {
            return (int) ((strength + maigcPower) * 1.5 + (strength + maigcPower) * Math.random() * 2);
        }

    }
    public void takeDamage(int damage) {
        life = damage > life ? 0 : life - damage;
    }
    public void lootGold(int gold) {
        this.gold += gold;
    }
    public void gainXp(int xp) {
        experience += xp;
        levelUp(xp);
    }
    public void levelUp(int xp) {
        if (experience >= 1300) {
            if(experience - xp < 1300) {
                System.out.println("Parabens! Voce subiu para o level 8");
                life = Math.min(life + 15, maxLife);

            }
            level = 8;
            strength = 19;
            maigcPower = 9;
            maxLife = 205;
        } else if (experience >= 1000) {
            if(experience - xp < 1000) {
                System.out.println("Parabens! Voce subiu para o level 7");
                life = Math.min(life + 15, maxLife);

            }
            level = 7;
            strength = 17;
            maigcPower = 8;
            maxLife = 190;
        } else if (experience >= 750) {
            if(experience - xp < 750) {
                System.out.println("Parabens! Voce subiu para o level 6");
                life = Math.min(life + 15, maxLife);

            }
            level = 6;
            strength = 15;
            maigcPower = 7;
            maxLife = 175;
        } else if (experience >= 540) {
            if(experience - xp < 540) {
                System.out.println("Parabens! Voce subiu para o level 5");
                life = Math.min(life + 15, maxLife);

            }
            level = 5;
            strength = 13;
            maigcPower = 6;
            maxLife = 160;
        } else if (experience >= 365) {
            if(experience - xp < 365) {
                System.out.println("Parabens! Voce subiu para o level 4");
                life = Math.min(life + 15, maxLife);
            }
            level = 4;
            strength = 11;
            maigcPower = 5;
            maxLife = 145;
        } else if (experience >= 220) {
            if(experience - xp < 220) {
                System.out.println("Parabens! Voce subiu para o level 3");
                life = Math.min(life + 15, maxLife);
            }
            level = 3;
            strength = 9;
            maigcPower = 4;
            maxLife = 130;
        } else if (experience >= 100) {
            if(experience - xp < 100) {
                System.out.println("Parabens! Voce subiu para o level 2");
                life = Math.min(life + 15, maxLife);
            }
            level = 2;
            strength = 7;
            maigcPower = 3;
            maxLife = 115;
        }
    }
    public void heal(int hp) {
//        life = life + hp > maxLife ? maxLife : life + hp;
        life = (Math.min(life + hp, maxLife));
    }
    public String drinkLifePotion() {
        if(lifePotion < 1) {
            return "Voce nao tem mais pocoes de vida";
        } else {
            heal(50);
            lifePotion--;
            return "Voce recuperou um pouco de vida com a pocao de cura";
        }
    }
    public String buyLifePotion(int quant) {
        if(gold >= quant * 10) {
            gold -= quant * 10;
            lifePotion += quant;
            return "Voce comprou " + quant + " pocoes de vida por " + (quant * 10) + " gold.";
        } else {
            return "Voce nao tem gold suficiente para comprar essa quantidade de pocoes.";
        }
    }
    public String buyManaPotion(int quant) {
        if(gold >= quant * 10) {
            gold -= quant * 10;
            manaPotion += quant;
            return "Voce comprou " + quant + " pocoes de mana por " + (quant * 10) + " gold.";
        } else {
            return "Voce nao tem gold suficiente para comprar essa quantidade de pocoes.";
        }
    }

}
