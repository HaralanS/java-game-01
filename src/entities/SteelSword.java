package entities;

public class SteelSword extends Weapon{
    String name = "Steel Sword";
    int sellingPrice = 15;
    int attack = 5;
    String type = "weapon";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " - preco de venda: " + sellingPrice + "gold - attack: " + attack;
    }
}
