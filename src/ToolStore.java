public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----- Mağazaya Hoşgeldiniz -----");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar\n" + "2 - Zırhlar\n" + "3 - Tekrar Bekleriz");
            System.out.print("Ne Bakmıştınız : ");
            int select = input.nextInt();
            while (select < 1 || select > 3) {
                System.out.println("Bende Bulunan Bir Ürün Seçiniz.");
                select = input.nextInt();
            }
            switch (select) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Para Biriktirip Tekrar Gel");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----- Silahlar -----");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " \t< Hasar : " + w.getDamage() + " " + " Fiyatı : " + w.getPrice() + " >");
        }
        System.out.println("0-Çıkış Yap");
    }

    public void buyWeapon() {
        System.out.print("Silahınızı Seçin : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Stoklarda Kalmadı Malesef . Elimde Bulunan Bir Ürün Seçiniz.");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız Bulunmamaktadır");
                } else {
                    System.out.println(selectedWeapon.getName() + "Silahını Satın Aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmor() {
        System.out.println("------ Zırhlar -----");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getName() + "\t  <Zırh : " + a.getBlock() + " " + " Ederi : " + a.getPrice() + " >");
        }
        System.out.println("0-Çıkış Yap");
    }

    public void buyArmor() {
        System.out.print("Zırhınızı Seçin : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Stoklarda Kalmadı Malesef . Elimde Bulunan Bir Ürün Seçiniz.");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız Bulunmamaktadır");
                } else {
                    System.out.println(selectedArmor.getName() + "Armoru Satın Aldınız.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}