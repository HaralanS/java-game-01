package entities;

public class LeatherArmor extends Armor{
    String name = "Leather Armor";
    int sellingPrice = 7;
    public int armor = 2;
    String type = "armor";

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
    public int getArmor() {
        return armor;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
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
        return name + " - preco de venda: " + sellingPrice + " gold - protecao: " + armor;
    }
}
