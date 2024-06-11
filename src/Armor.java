public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[]{new Armor(1, "Hafif", 1, 15), new Armor(2, "Orta", 3, 15), new Armor(3, "Ağır", 5, 15)};
        return armorList;
    }

    public static Armor getArmorObjByID(int id) {
        Armor[] var1 = armors();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Armor a = var1[var3];
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return this.block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
