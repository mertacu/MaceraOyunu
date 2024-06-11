import java.util.Random;

public class BattleLoc extends Location {
    Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private Random random = new Random();

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şu an buradasınız " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " Yaşıyor !");
        System.out.print("<S>avaş veya <K>aç");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && this.combat(obsNumber)) {
            switch (this.award) {
                case "Yemek" -> this.getPlayer().getInventory().setFood(true);
                case "Odun" -> this.getPlayer().getInventory().setWood(true);
                case "Su" -> this.getPlayer().getInventory().setWater(true);
            }

            System.out.println(this.getName() + " tüm düşmanları yendiniz");
            return true;
        } else if (this.getPlayer().getHealth() <= 0) {
            System.out.println("ÖLDÜNÜZ!");
            return false;
        } else {
            return true;
        }
    }

    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; ++i) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            this.playerStats();
            this.obstacleStats(i);
            boolean playerTurn = this.random.nextBoolean();

            int randomNumber;
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                if (playerTurn) {
                    System.out.print("S-Saldır veya K-Kaç : ");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (!selectCombat.equals("S")) {
                        return false;
                    }

                    System.out.println("Siz Vurdunuz");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    this.afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        playerTurn = false;
                    }
                } else {
                    System.out.println();
                    System.out.println("Canavar Size Vurdu");
                    randomNumber = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (randomNumber < 0) {
                        randomNumber = 0;
                    }

                    this.getPlayer().setHealth(this.getPlayer().getHealth() - randomNumber);
                    this.afterHit();
                    if (this.getPlayer().getHealth() > 0) {
                        playerTurn = true;
                    }
                }
            }

            if (this.getObstacle().getHealth() >= this.getPlayer().getHealth()) {
                return false;
            }

            System.out.println("Düşmanı Yendiniz");
            System.out.println(this.getObstacle().getAward() + " para kazandınız");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
            System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
            if (!this.obstacle.getName().equals("Yılan")) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.obstacle.getAward());
            } else {
                randomNumber = this.random.nextInt(100) + 1;
                int randomMoney;
                if (randomNumber <= 15) {
                    randomMoney = this.random.nextInt(100) + 1;
                    Weapon kilic;
                    if (randomMoney <= 20) {
                        System.out.println("Tüfek Düşürdünüz");
                        kilic = Weapon.weapons()[3];
                        this.getPlayer().getInventory().setWeapon(kilic);
                    } else if (randomMoney <= 50) {
                        System.out.println("Kılıç Düşürdünüz");
                        kilic = Weapon.weapons()[2];
                        this.getPlayer().getInventory().setWeapon(kilic);
                    } else {
                        System.out.println("Tabanca Düşürdünüz");
                        kilic = Weapon.weapons()[1];
                        this.getPlayer().getInventory().setWeapon(kilic);
                    }
                } else if (randomNumber <= 30) {
                    randomMoney = this.random.nextInt(100) + 1;
                    Armor mediumArmor;
                    if (randomMoney <= 20) {
                        System.out.println("Ağır Düşürdünüz");
                        mediumArmor = Armor.armors()[3];
                        this.getPlayer().getInventory().setArmor(mediumArmor);
                    } else if (randomMoney <= 50) {
                        System.out.println("Orta Düşürdünüz");
                        mediumArmor = Armor.armors()[2];
                        this.getPlayer().getInventory().setArmor(mediumArmor);
                    } else {
                        System.out.println("Hafif Düşürdünüz");
                        mediumArmor = Armor.armors()[1];
                        this.getPlayer().getInventory().setArmor(mediumArmor);
                    }
                } else if (randomNumber <= 55) {
                    randomMoney = this.random.nextInt(100) + 1;
                    if (randomMoney <= 20) {
                        System.out.println("10 Para Düşürdünüz");
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                    } else if (randomMoney <= 50) {
                        System.out.println("5 Para Düşürdünüz");
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                    } else {
                        System.out.println("İtem Düşüremediniz");
                    }
                }
            }
        }

        return true;
    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("-----------");
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("----------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
        if (this.getPlayer().getInventory().getWeapon().getDamage() > 0) {
            System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        }

        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println("" + i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("------------------------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return this.obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return this.award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return this.maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
