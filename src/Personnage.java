import java.util.Scanner;

public class Personnage {
    String type;
    String name;
    int life;
    int attackStrength;
    EquipementOffensif equipmentOffensive;
    EquipementDefensif equipmentDefensif;

    /* * SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        switch (type) {
            case "warrior":
                this.type = "warrior";
                this.life = 10;
                this.attackStrength = 10;
                this.equipmentOffensive = new EquipementOffensif("weapon");
                this.equipmentDefensif = new EquipementDefensif("shield");
                break;

            case "wizard":
                this.type = "wizard";
                this.life = 6;
                this.attackStrength = 15;
                this.equipmentOffensive = new EquipementOffensif("spell");
                this.equipmentDefensif = new EquipementDefensif("potion");
                break;

            default:
                System.out.println("[Unknown class]");
                this.type = "warrior";
                this.life = 10;
                this.attackStrength = 10;
                this.equipmentOffensive = new EquipementOffensif("weapon");
                this.equipmentDefensif = new EquipementDefensif("shield");
                break;
        }
    }

    /* ! CONSTRUCTORS: */
    public Personnage() {
        this("Player");
    }
    public Personnage(String name) {
        this(name, "warrior");
    }
    public Personnage(String name, String type) {
        setName(name);
        setType(type);
    }

}
