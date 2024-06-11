public class Inventory {
    private boolean water;
    private boolean food;
    private boolean wood;
    private Weapon weapon = new Weapon("Yumruk", -1, 0, 0);
    private Armor armor = new Armor(-1, "Paçavra", 0, 0);

    public Inventory() {
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isWater() {
        return this.water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return this.food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWood() {
        return this.wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }
}
