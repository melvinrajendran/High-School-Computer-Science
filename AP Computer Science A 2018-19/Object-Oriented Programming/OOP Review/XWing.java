public class XWing {

    private int shieldStrength;
    private String pilotName;
    private LaserCannon weaponType;

    public XWing(int shieldStrength, String pilotName, int powerLevel) {
        this.shieldStrength = shieldStrength;
        this.pilotName = pilotName;
        this.weaponType = new LaserCannon(powerLevel);
    }

    public XWing(int powerLevel) {
        this.weaponType = new LaserCannon(powerLevel);
    }

    public void fireCannon() {
        System.out.println("Firing lasers at " + weaponType.getPowerLevel() + "% power!");
    }

}