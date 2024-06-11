public class Obstacle {
    private int id;
    private int damage;
    private int health;
    private String name;
    private int award;
    private int defHealth;

    public Obstacle(int id, int damage, int health, String name, int award) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.name = name;
        this.award = award;
        this.defHealth = health;
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

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }

        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return this.award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getDefHealth() {
        return this.defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
