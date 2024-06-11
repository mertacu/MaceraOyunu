public class NormalLocation extends Location {
    public NormalLocation(Player player, String name) {
        super(player, name);
    }

    public boolean onLocation() {
        return true;
    }
}
