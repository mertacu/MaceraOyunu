import java.util.Scanner;

public class Game {
    private Scanner input;

    public Game() {
        this.input = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = this.input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Hoşgeldiniz !");
        System.out.println("Lütfen karakterinizi seçiniz");
        player.selectChar();
        Location location = null;

        while(true) {
            player.printInfo();
            System.out.println();
            System.out.println("#####Bölgeler#####");
            System.out.println();
            System.out.println("1 - Güvenli Ev -> Burası sizin için güvenli bir ev, etrafta düşman yok");
            System.out.println("2 - Eşya Dükkanı -> Silah veya Zırh satın alabilirsiniz.");
            System.out.println("3 - Mağara -> Mağaraya girdin, dikkatli ol !");
            System.out.println("4 - Orman -> Ormana girdin, dikkatli ol !");
            System.out.println("5 - Nehir -> Nehire girdin, dikkatli ol !");
            System.out.println("6 - Maden -> Madene girdin, dikkatli ol !");
            System.out.println("0 - Çıkış Yap ---> Oyunu Sonlandır");
            System.out.println("Lütfen gitmek istediğiniz bölgesi seçiniz");
            int selectLoc = this.input.nextInt();
            switch (selectLoc) {
                case 0 -> location = null;
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new ToolStore(player);
                case 3 -> location = new Cave(player);
                case 4 -> location = new Forest(player);
                case 5 -> location = new River(player);
                case 6 -> location = new Mine(player);
                default -> System.out.println("Lütfen geçerli bir bölge giriniz.");
            }

            if (location == null) {
                System.out.println("Oyun Bitti Görüşmek Üzere");
                break;
            }

            if (!((Location)location).onLocation()) {
                System.out.println("Gözlerim Kararıyor.. GAME OVER");
                break;
            }
        }

    }
}
