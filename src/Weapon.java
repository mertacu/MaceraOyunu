public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[]{new Weapon("Tabanca", 1, 2, 15),
                new Weapon("Kılıç", 2, 3, 35),
                new Weapon("Tüfek", 3, 7, 45)};
        return weaponList;
    }

    public static Weapon getWeaponObjByID(int id) {
        Weapon[] var1 = weapons();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Weapon w = var1[var3];
            if (w.getId() == id) {
                return w;
            }
        }

        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
